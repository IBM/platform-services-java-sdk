package com.ibm.cloud.platform_services.enterprise_management.v1;

import okhttp3.FormBody;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import okhttp3.ResponseBody;
import okhttp3.RequestBody;
import com.ibm.cloud.sdk.core.http.HttpHeaders;
import com.ibm.cloud.sdk.core.http.HttpMediaType;
import com.ibm.cloud.sdk.core.http.HttpClientSingleton;
import okhttp3.Call;
import okhttp3.Request;
import okhttp3.MediaType;
import org.json.JSONObject;
import org.json.JSONArray;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.text.SimpleDateFormat;

public class AccountManagementHelper {
    //public static final String defaultServiceUrl = "https://accounts.test.cloud.ibm.com";
    // private static final String defaultIamUrl = "https://iam.stage1.bluemix.net/oidc/token";
    private static final String GRANT_TYPE = "grant_type";
    private static final String REQUEST_GRANT_TYPE = "urn:ibm:params:oauth:grant-type:apikey";
    private static final String API_KEY = "apikey";


    public String generateIamServiceToken(String apiKey, String defaultIamUrl) {
        RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(defaultIamUrl + "/oidc/token", new String[0]));
        builder.header(HttpHeaders.CONTENT_TYPE, HttpMediaType.APPLICATION_FORM_URLENCODED);

        FormBody formBody = new FormBody.Builder().add(GRANT_TYPE, REQUEST_GRANT_TYPE)
                .add(API_KEY, apiKey).build();
        builder.body(formBody);
        String tokenData = callIamApi(builder.build());
        return tokenData;
    }

    private String callIamApi(Request request) {
        String res = null;
        Call call = HttpClientSingleton.getInstance().createHttpClient().newCall(request);
        try {
            okhttp3.Response response = call.execute();
            final int code = response.code();
            final ResponseBody body = response.body();
            res = body.string();
            body.close();
            return res;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public String createVerificationCode(String email, String token, String defaultServiceUrl) {
        String jsonString = new JSONObject()
                .put("email_address", email)
                .toString();

        okhttp3.MediaType mediaType = MediaType.parse("application/json");
        okhttp3.RequestBody body = RequestBody.create(mediaType, jsonString);
        String[] pathSegments = {"v1/verification-codes"};
        RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(defaultServiceUrl, pathSegments));
        builder.header("Content-Type", "application/json");
        builder.header("Authorization", token);
        builder.body(body);
        String responseData = callIamApi(builder.build());
        return responseData;
    }

    public String getVerificationCode(String email, String token, String defaultServiceUrl) {
        String[] pathSegments = {"v1/verification-codes"};
        String[] pathParameters = {email};
        RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(defaultServiceUrl, pathSegments, pathParameters));
        builder.header("Content-Type", "application/json");
        builder.header("Authorization", token);
        String responseData = callIamApi(builder.build());
        return responseData;
    }

    public String confirmVerificationCode(String email, String code, String token, String defaultServiceUrl) {
        String[] pathSegments = {"v1/verification-codes/confirm"};
        RequestBuilder builder = RequestBuilder.put(RequestBuilder.constructHttpUrl(defaultServiceUrl, pathSegments));
        builder.header("Content-Type", "application/json");
        builder.header("Authorization", token);
        builder.query("code", code);
        builder.query("email", email);
        String responseData = callIamApi(builder.build());
        return responseData;
    }

    public String createStandardAccount(String email, String code, String token, String defaultServiceUrl) {
        Map<String, Object> bodyMap = new HashMap<>();
        bodyMap.put("password", "password");
        bodyMap.put("question", "question");
        bodyMap.put("answer", "answer");

        Map<String, Object> subscriptionsMap = new HashMap<>();
        subscriptionsMap.put("type", "TRIAL");
        subscriptionsMap.put("state", "ACTIVE");
        subscriptionsMap.put("part_number", "COE-Trial");

        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        list.add(subscriptionsMap);

        String jsonString = new JSONObject()
                .put("owner_user_id", email)
                .put("owner_email", email)
                .put("owner_first_name", "AB")
                .put("owner_last_name", "AB")
                .put("owner_phone", "0000000000")
                .put("owner_company", "IBM")
                .put("country_code", "USA")
                .put("ibmid", new JSONObject(bodyMap))
                .put("bluemix_subscriptions", new JSONArray(list))
                .put("verification_code", code)
                .toString();

        okhttp3.MediaType mediaType = MediaType.parse("application/json");
        okhttp3.RequestBody body = RequestBody.create(mediaType, jsonString);
        String[] pathSegments = {"/coe/v2/accounts"};
        RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(defaultServiceUrl, pathSegments));
        builder.header("Content-Type", "application/json");
        builder.header("Authorization", token);
        builder.body(body);
        String responseData = callIamApi(builder.build());
        return responseData;
    }

    public String getAccountByAccountId(String accountId, String token, String defaultServiceUrl) {

        String[] pathSegments = {"/coe/v2/accounts"};
        String[] pathParameters = {accountId};
        RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(defaultServiceUrl, pathSegments, pathParameters));
        builder.header("Content-Type", "application/json");
        builder.header("Authorization", token);
        String responseData = callIamApi(builder.build());
        return responseData;
    }

    public String getAccountByAccountIdLastOperation(String accountId, String token, String defaultServiceUrl) {
        String[] pathSegments = {"coe/v2/accounts", "last_operation"};
        String[] pathParameters = {accountId};
        RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(defaultServiceUrl, pathSegments, pathParameters));
        builder.header("Content-Type", "application/json");
        builder.header("Authorization", token);
        String responseData = callIamApi(builder.build());
        return responseData;
    }

    public String verifyAMAccount(String email, String activationToken, String token, String defaultServiceUrl) {
        String[] pathSegments = {"coe/v2/accounts/verify"};
        RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(defaultServiceUrl, pathSegments));
        builder.header("Content-Type", "application/json");
        builder.header("Authorization", token);
        builder.query("token", activationToken);
        builder.query("email", email);
        String responseData = callIamApi(builder.build());
        return responseData;
    }

    public String patchAccountSubscription(String token, String accountId, String subscriptionId, String defaultServiceUrl) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
            Date startDate = inputFormat.parse("2020-05-07T07:00:00.000Z");
            Date endDate = inputFormat.parse("2020-09-07T07:00:00.000Z");


            Map<String, Date> paymentMethod = new HashMap<>();
            paymentMethod.put("start_date", startDate);
            paymentMethod.put("end_date", endDate);

            Map<String, Object> subscriptionsMap = new HashMap<>();
            subscriptionsMap.put("type", "TRIAL");
            subscriptionsMap.put("state", "ACTIVE");
            subscriptionsMap.put("part_number", "COE-Trial");

            List<String> list = new ArrayList<String>();
            list.add("TEST_ACCOUNT");

            String jsonString = new JSONObject()
                    .put("type", "SUBSCRIPTION")
                    .put("state", "ACTIVE")
                    .put("subscription_amount", 100)
                    .put("quantity", 10)
                    .put("billing_frequency", "M")
                    .put("charge_agreement_number", "0099342614")
                    .put("partner_customer_number", "0003615466")
                    .put("configuration_id", "5900A5D20190517")
                    .put("part_number", "D019JZX")
                    .put("order_id_number", "150418156")
                    .put("sales_doc_type_code", "")
                    .put("renewal_mode_code", "T")
                    .put("renewal_date", "")
                    .put("terminate_renewal", false)
                    .put("softlayer_account_id", "111111")
                    .put("line_item_id", 10)
                    .put("payment_method", paymentMethod)
                    .put("tags", new JSONArray(list))
                    .toString();

            okhttp3.MediaType mediaType = MediaType.parse("application/json");
            okhttp3.RequestBody body = RequestBody.create(mediaType, jsonString);
            String[] pathSegments = {"/coe/v2/accounts", "bluemix_subscriptions"};
            String[] pathParameters = {accountId, subscriptionId};
            RequestBuilder builder = RequestBuilder.patch(RequestBuilder.constructHttpUrl(defaultServiceUrl, pathSegments, pathParameters));
            builder.header("Content-Type", "application/json");
            builder.header("Authorization", token);
            builder.body(body);
            String responseData = callIamApi(builder.build());
            return responseData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
