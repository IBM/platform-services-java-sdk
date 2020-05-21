const request = require('request');
const Pouchdb = require('pouchdb');

const first_name = 'TEST';
const last_name = 'BLUEMIX';
const password = 'bluemixbss';
const phone_number = '0987654321';
const company = 'IBM';
const country_code = 'USA';
const question = 'question';
const answer = 'answer';

const IAM_GRANT_TYPE = {
  API_KEY: 'urn:ibm:params:oauth:grant-type:apikey',
};

function get_account_payload(email, account_type, account_state) {
  const payload = {
    'owner_user_id': email,
    'owner_email': email,
    'owner_first_name': first_name,
    'owner_last_name': last_name,
    'owner_phone': phone_number,
    'owner_company': company,
    'country_code': country_code,
    'bluemix_subscriptions': [
      {
        'type': account_type,
        'state': account_state,
        'part_number': 'COE-Trial',
      },
    ],
    'ibmid': {
      'password': password,
      'question': question,
      'answer': answer,
    },
  };
  return payload;
}

function fetch_db_activation_token(db_url, activation_db_name, db_user, db_pass, email) {
  const activation_db = new Pouchdb(`${db_url}/${activation_db_name}`, {
    auth: {
      username: db_user,
      password: db_pass,
    },
  });
  return function(cb) {
    let token;
    activation_db.query(
      'v1_green/by_email',
      {
        limit: 20,
        reduce: false,
        key: email.toLowerCase(),
        include_docs: true,
      },
      (e, r) => {
        if (e) {
          return cb(e);
        }
        if (
          r &&
          r.rows &&
          r.rows.some(row => {
            if (row && row.doc && row.doc.state === 'CREATED') {
              token = row.doc._id;
              return true;
            }
            return false;
          })
        ) {
          return cb(null, token);
        }
        return cb('No Activation token found');
      }
    );
  };
}

function get_default_account_info(params) {
  if (!params) {
    params = {};
  }
  const payload = {
    'type': params.type || 'STANDARD',
    'state': params.state || 'INACTIVE',
    'country_code': 'USA',
    'currency_code': 'USD',
    'billing_country_code': 'USA',
    'traits': {
      'mfa': '',
      'eu_supported': false,
      'poc': false,
    },
    'linkages': {
      'origin': params.origin || 'IMS',
      'state': 'LINKABLE',
    },
    'subscription': {
      'type': params.type || 'STANDARD',
      'state': 'INACTIVE',
      'payment_method_type': 'TRIAL_CREDIT',
      'part_number': 'COE-Trial',
      'billing_system': 'DSW',
      'category': 'PUBLIC_PLATFORM',
    },
    'history': [],
  };
  return payload;
}

function generate_iam_service_token(iam_host, iam_basic_auth, iam_api_key, cb) {
  const options = {
    method: 'POST',
    url: `${iam_host}/identity/token`,
    headers: {
      accept: 'application/json',
      'content-type': 'application/x-www-form-urlencoded',
      'authorization': iam_basic_auth,
    },
    form: {
      grant_type: IAM_GRANT_TYPE.API_KEY,
      apikey: iam_api_key,
    },
    json: true,
  };
  request(options, (e, r, b) => {
    return cb(e, b.access_token);
  });
}

function get_activate_subscription_payload(start_date, end_date, line_item_id) {
  const payload = {
    'type': 'SUBSCRIPTION',
    'state': 'ACTIVE',
    'payment_method': {
      'start_date': start_date,
      'end_date': end_date,
    },
    'subscription_amount': 100,
    'quantity': 10,
    'billing_frequency': 'M',
    'charge_agreement_number': '0099342614',
    'partner_customer_number': '0003615466',
    'configuration_id': '5900A5D20190517',
    'part_number': 'D019JZX',
    'order_id_number': '150418156',
    'sales_doc_type_code': '',
    'renewal_mode_code': 'T',
    'renewal_date': '',
    'terminate_renewal': false,
    'softlayer_account_id': '111111',
    'line_item_id': line_item_id || 10,
    'tags': ['TEST_ACCOUNT'],
  };

  return payload;
}

function post_am_coe_v2_accounts(am_host, payload, token, cb) {
  const options = {
    method: 'POST',
    url: `${am_host}/coe/v2/accounts`,
    headers: {
      authorization: token,
      'content-type': 'application/json',
    },
    body: payload,
    json: true,
  };

  request(options, (e, r, b) => {
    return cb(e, b);
  });
}

function get_am_coe_v2_account_by_id(am_host, account_id, token, cb) {
  const options = {
    method: 'GET',
    url: `${am_host}/coe/v2/accounts/${account_id}`,
    headers: { authorization: token },
    json: true,
  };
  request(options, cb);
}

function patch_am_coe_v2_account_subscription(am_host, account_id, subscription_id, payload, token, user_token, cb) {
  const options = {
    method: 'PATCH',
    url: `${am_host}/coe/v2/accounts/${account_id}/bluemix_subscriptions/${subscription_id}`,
    headers: {
      'content-type': 'application/json',
      'authorization': token,
    },
    body: payload,
    json: true,
  };

  if (user_token) {
    options.headers['user-authorization'] = user_token;
  }
  request(options, cb);
}

function get_am_coe_v2_accounts_verify(am_host, email, token, cb) {
  const options = {
    method: 'GET',
    url: `${am_host}/coe/v2/accounts/verify`,
    qs: {
      token: token,
      email: email,
    },
    json: true,
  };
  request(options, cb);
}

module.exports.get_am_coe_v2_account_by_id = get_am_coe_v2_account_by_id;
module.exports.get_am_coe_v2_accounts_verify = get_am_coe_v2_accounts_verify;
module.exports.get_account_payload = get_account_payload;
module.exports.fetch_db_activation_token = fetch_db_activation_token;
module.exports.get_default_account_info = get_default_account_info;
module.exports.get_activate_subscription_payload = get_activate_subscription_payload;
module.exports.generate_iam_service_token = generate_iam_service_token;

module.exports.post_am_coe_v2_accounts = post_am_coe_v2_accounts;
module.exports.patch_am_coe_v2_account_subscription = patch_am_coe_v2_account_subscription;
