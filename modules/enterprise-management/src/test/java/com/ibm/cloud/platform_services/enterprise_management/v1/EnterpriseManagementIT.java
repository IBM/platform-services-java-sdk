package com.ibm.cloud.platform_services.enterprise_management.v1;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.cloudant.client.api.ClientBuilder;
import com.cloudant.client.api.CloudantClient;
import com.cloudant.client.api.Database;
import com.cloudant.client.api.views.Key;
import com.cloudant.client.api.views.ViewResponse;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.Account;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.AccountGroup;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.CreateAccountGroupOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.CreateAccountGroupResponse;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.CreateAccountOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.CreateAccountResponse;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.CreateEnterpriseOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.CreateEnterpriseResponse;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.GetAccountGroupOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.GetAccountOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.ImportAccountToEnterpriseOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.ListAccountGroupsOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.ListAccountGroupsResponse;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.ListAccountsOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.ListAccountsResponse;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.UpdateAccountGroupOptions;
import com.ibm.cloud.platform_services.enterprise_management.v1.model.UpdateAccountOptions;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

/**
 * This class contains integration tests for the Enterprise Management.
 * <p>
 * Notes: 1. By providing the name of our config file
 * ("enterprise-management.env") via the getConfigFilename() method below, the
 * base class (SdkIntegrationTestBase) will be able to mock up the getenv()
 * method to cause the Java core's CredentialUtils class to "see" the config
 * file via the mocked value of the IBM_CREDENTIALS_FILE env var.
 * <p>
 * 2. The base class will automatically set the "skipTests" flag to true if it
 * can't find the config file.
 * <p>
 * 3. The base class contains a "before method" function that will automatically
 * skip each test method if the "skipTests" flag is true. This means that this
 * subclass doesn't need to concern itself with skipping tests in the event that
 * the config file is not available.
 * <p>
 * 4. This testcase uses the "dependsOnMethods" attribute of the @Test
 * annotation to ensure that the test methods are executed in the the order they
 * appear in this file. Without this, there's no guaranteed ordering imposed by
 * TestNG.
 */
public class EnterpriseManagementIT extends SdkIntegrationTestBase {

    // Example service v1 integration
    public static EnterpriseManagement service = null;
    public static AccountManagementHelper accountManagementService = new AccountManagementHelper();
    public static Map<String, String> config = null;
    String accountGroupId = null;
    String accountId = null;
    String subsAccountId = null;
    String token = null;
    String parent = null;
    String enterpriseId = null;
    String email = "aminttest+" + new Date().getTime() + "_" + Math.floor(Math.random() * 100000) + "@mail.test.ibm.com";
    String verificationCode = null;
    String activationToken = null;
    String subscriptionEmail = "amIntTest+" + new Date().getTime() + "_" + Math.floor(Math.random() * 100000) + "@mail.test.ibm.com";
    String subscriptionId = null;
    String ownerIamId = null;
    String enterpriseAccountId = null;
    String accountGroupId2 = null;
    String crn = null;
    String crn2 = null;
    String newAccountId = null;


    /**
     * This method provides our config filename to the base class.
     */
    public String getConfigFilename() {
        return "../../enterprise-management.env";
    }

    /**
     * This method is invoked before any of the @Test-annotated methods, and is
     * responsible for creating the instance of the service that will be used by the
     * rest of the test methods, as well as any other required initialization.
     */
    @BeforeClass
    public void constructService() {
        // Ask super if we should skip the tests.
        if (skipTests()) {
            return;
        }

        service = EnterpriseManagement.newInstance();
        assertNotNull(service);
        assertNotNull(service.getServiceUrl());

        // Load up our test-specific config properties.
        // We'll use a special service name so as not to interfere with the official
        // properties used to configure
        // the service.
        config = CredentialUtils.getServiceProperties("EMTEST_CONFIG");
        assertNotNull(config);
        assertEquals(config.size(), 8);
    }

    @Test
    public void testConfig() {
        assertNotNull(service);
        assertNotNull(config);
        assertNotNull(config.get("AM_HOST"));
        assertNotNull(config.get("DB_URL"));
        assertNotNull(config.get("DB_USER"));
        assertNotNull(config.get("DB_PASS"));
        assertNotNull(config.get("ACTIVATION_DB_NAME"));
        assertNotNull(config.get("IAM_HOST"));
        assertNotNull(config.get("IAM_BASIC_AUTH"));
        assertNotNull(config.get("IAM_API_KEY"));
    }

    @Test
    public void generateIamServiceToken() throws Throwable {
        String response = accountManagementService.generateIamServiceToken(config.get("IAM_API_KEY"), config.get("IAM_HOST"));
        JSONObject obj = new JSONObject(response);
        token = obj.getString("token_type") + " " + obj.getString("access_token");
        assertNotNull(response);
    }

    @Test
    public void test01_CreateVerificationCode() throws Throwable {
        accountManagementService.createVerificationCode(subscriptionEmail, token, config.get("AM_HOST"));
    }

    @Test
    public void test02_GetVerificationCode() throws Throwable {
        String response = accountManagementService.getVerificationCode(subscriptionEmail, token, config.get("AM_HOST"));
        JSONObject obj = new JSONObject(response);
        JSONArray arr = obj.getJSONArray("resources");
        verificationCode = arr.getJSONObject(0).getString("code");
    }

    @Test
    public void test03_PutConfirmVerificationCode() throws Throwable {
        accountManagementService.confirmVerificationCode(subscriptionEmail, verificationCode, token, config.get("AM_HOST"));
    }

    @Test
    public void test04_CreateStandardAccount() throws Throwable {
        String response = accountManagementService.createStandardAccount(subscriptionEmail, verificationCode, token, config.get("AM_HOST"));
        JSONObject obj = new JSONObject(response);
        subsAccountId = obj.getString("id");
    }

    @Test
    public void test05_GetAccountByAccountIdLastOperation() throws Throwable {
        accountManagementService.getAccountByAccountIdLastOperation(subsAccountId, token, config.get("AM_HOST"));
    }

    @Test
    public void test06_GetAccountActivationToken() throws Throwable {
        URL url = null;
        try {
            url = new URL(config.get("DB_URL"));
        } catch (MalformedURLException e) {
            System.out.println("The url is not well formed: " + url);
        }
        CloudantClient client = ClientBuilder.url(url)
                .username(config.get("DB_USER"))
                .password(config.get("DB_PASS"))
                .build();

        Database db = client.database("activation", false);
        Thread.sleep(35000);
        List<ViewResponse.Row<String, String>> result = db.getViewRequestBuilder("v1_green", "by_email").newRequest(Key
                .Type.STRING, String.class).reduce(false).keys(subscriptionEmail).includeDocs(true).build().getResponse().getRows();
        for (ViewResponse.Row<String, String> row : result) {
            assertNotNull(row.getDocument());
            activationToken = row.getId();
        }
    }

    @Test
    public void test07_VerifyAMAccount() throws Throwable {
        accountManagementService.verifyAMAccount(subscriptionEmail, activationToken, token, config.get("AM_HOST"));
        Thread.sleep(35000);
        String response2 = accountManagementService.getAccountByAccountId(subsAccountId, token, config.get("AM_HOST"));
        JSONObject obj = new JSONObject(response2);
        JSONObject obj2 = obj.getJSONObject("entity");
        subscriptionId = obj2.getString("subscription_id");
        ownerIamId = obj2.getString("owner_iam_id");
    }

    @Test
    public void test08_PatchAccountSubscription() throws Throwable {
        accountManagementService.patchAccountSubscription(token, subsAccountId, subscriptionId, config.get("AM_HOST"));
    }

    @Test
    public void test09_CreateEnterpriseUsingSubscriptionAccount() throws Throwable {
        CreateEnterpriseOptions createEnterpriseOptions = new CreateEnterpriseOptions.Builder()
                .name("IBM-" + new Date().getTime()).sourceAccountId(subsAccountId).primaryContactIamId(ownerIamId).domain("IBM-" + new Date().getTime() + ".com").build();
        Response<CreateEnterpriseResponse> response = service.createEnterprise(createEnterpriseOptions).execute();
        CreateEnterpriseResponse responseObj = response.getResult();
        assertNotNull(responseObj);
        enterpriseId = responseObj.getEnterpriseId();
        enterpriseAccountId = responseObj.getEnterpriseAccountId();
    }

    @Test
    public void test10_GetAccountById() throws Throwable {
        String response2 = accountManagementService.getAccountByAccountId(subsAccountId, token, config.get("AM_HOST"));
        JSONObject obj = new JSONObject(response2);
        JSONObject obj2 = obj.getJSONObject("entity");
        parent = obj2.getString("parent");
    }

    @Test
    public void test11_GetAccountByIdUsingEnterprise() throws Throwable {
        Thread.sleep(35000);
        GetAccountOptions getAccountByIdOptions = new GetAccountOptions.Builder().accountId(enterpriseAccountId).build();
        Response<Account> response = service.getAccount(getAccountByIdOptions).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);
        Account responseObj = response.getResult();
        assertNotNull(responseObj);
    }


    @Test
    public void test12_CreateAccountGroupWOptions() throws Throwable {
        CreateAccountGroupOptions createAccountGroupOptionsModel = new CreateAccountGroupOptions.Builder().parent(
                parent)
                .name("testString").primaryContactIamId(ownerIamId).build();

        Response<CreateAccountGroupResponse> response = service.createAccountGroup(createAccountGroupOptionsModel)
                .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 201);
        CreateAccountGroupResponse responseObj = response.getResult();
        assertNotNull(responseObj);
        accountGroupId = responseObj.getAccountGroupId();
    }


    @Test
    public void test13_ListAccountGroupsWOptions() throws Throwable {
        ListAccountGroupsOptions listAccountGroupsOptions = new ListAccountGroupsOptions.Builder().parent(
                parent)
                .enterpriseId(enterpriseId).parentAccountGroupId(accountGroupId).limit(100)
                .build();

        Response<ListAccountGroupsResponse> response = service.listAccountGroups(listAccountGroupsOptions).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);
        ListAccountGroupsResponse responseObj = response.getResult();
        assertNotNull(responseObj);
    }

    @Test
    public void test14_GetAccountGroupByIdWOptions() throws Throwable {
        GetAccountGroupOptions getAccountGroupByIdOptions = new GetAccountGroupOptions.Builder()
                .accountGroupId(accountGroupId).build();

        Response<AccountGroup> response = service.getAccountGroup(getAccountGroupByIdOptions).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);
        AccountGroup responseObj = response.getResult();
        assertNotNull(responseObj);
        crn = responseObj.getCrn();
    }

    @Test
    public void test15_UpdateAccountGroupWOptions() throws Throwable {
        UpdateAccountGroupOptions updateAccountGroupOptions = new UpdateAccountGroupOptions.Builder()
                .accountGroupId(accountGroupId).name("testString").build();

        Response<Void> response = service.updateAccountGroup(updateAccountGroupOptions).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 204);
    }

    @Test
    public void test17_CreateVerificationCode() throws Throwable {
        accountManagementService.createVerificationCode(email, token, config.get("AM_HOST"));
    }

    @Test
    public void test18_GetVerificationCode() throws Throwable {
        String response = accountManagementService.getVerificationCode(email, token, config.get("AM_HOST"));
        JSONObject obj = new JSONObject(response);
        JSONArray arr = obj.getJSONArray("resources");
        verificationCode = arr.getJSONObject(0).getString("code");
    }

    @Test
    public void test19_PutConfirmVerificationCode() throws Throwable {
        accountManagementService.confirmVerificationCode(email, verificationCode, token, config.get("AM_HOST"));
    }

    @Test
    public void test20_CreateStandardAccount() throws Throwable {
        String response = accountManagementService.createStandardAccount(email, verificationCode, token, config.get("AM_HOST"));
        JSONObject obj = new JSONObject(response);
        accountId = obj.getString("id");
    }

    @Test
    public void test21_GetAccountByAccountIdLastOperation() throws Throwable {
        accountManagementService.getAccountByAccountIdLastOperation(accountId, token, config.get("AM_HOST"));
    }

    @Test
    public void test22_GetAccountActivationToken() throws Throwable {
        URL url = null;
        try {
            url = new URL(config.get("DB_URL"));
        } catch (MalformedURLException e) {
            System.out.println("The url is not well formed: " + url);
        }
        CloudantClient client = ClientBuilder.url(url)
                .username(config.get("DB_USER"))
                .password(config.get("DB_PASS"))
                .build();

        Database db = client.database("activation", false);
        Thread.sleep(35000);
        List<ViewResponse.Row<String, String>> result = db.getViewRequestBuilder("v1_green", "by_email").newRequest(Key
                .Type.STRING, String.class).reduce(false).keys(email).includeDocs(true).build().getResponse().getRows();
        for (ViewResponse.Row<String, String> row : result) {
            assertNotNull(row.getDocument());
            activationToken = row.getId();
        }
    }

    @Test
    public void test23_VerifyAMAccount() throws Throwable {
        accountManagementService.verifyAMAccount(email, activationToken, token, config.get("AM_HOST"));
        Thread.sleep(35000);
        accountManagementService.getAccountByAccountId(accountId, token, config.get("AM_HOST"));
    }

    @Test
    public void test24_ImportAccountToEnterprise() throws Throwable {
        ImportAccountToEnterpriseOptions importAccountToEnterpriseOptions = new ImportAccountToEnterpriseOptions.Builder()
                .enterpriseId(enterpriseId).accountId(accountId).build();
        Response<Void> response = service.importAccountToEnterprise(importAccountToEnterpriseOptions).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 202);
    }

    @Test
    public void test25_GetAccountById() throws Throwable {
        accountManagementService.getAccountByAccountId(accountId, token, config.get("AM_HOST"));
    }

    @Test
    public void test26_CreateNewAccountInEnterprise() throws Throwable {
        CreateAccountOptions createAccountOptions = new CreateAccountOptions.Builder()
                .parent(parent).name("IBM-" + new Date().getTime()).ownerIamId("IBMid-550006JKXX").build();
        Response<CreateAccountResponse> response = service.createAccount(createAccountOptions).execute();
        CreateAccountResponse responseObj = response.getResult();
        newAccountId = responseObj.getAccountId();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 202);
    }

    @Test
    public void test27_GetAccountsByQueryParameter() throws Throwable {
        ListAccountsOptions listAccountsOptions = new ListAccountsOptions.Builder()
                .enterpriseId(enterpriseId).accountGroupId(accountGroupId).parent(parent).limit(100).build();
        Response<ListAccountsResponse> response = service.listAccounts(listAccountsOptions).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);
    }

    @Test
    public void test28_CreateAccountGroupWOptions() throws Throwable {
        CreateAccountGroupOptions createAccountGroupOptionsModel = new CreateAccountGroupOptions.Builder().parent(
                parent)
                .name("testString").primaryContactIamId(ownerIamId).build();

        Response<CreateAccountGroupResponse> response = service.createAccountGroup(createAccountGroupOptionsModel)
                .execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 201);
        CreateAccountGroupResponse responseObj = response.getResult();
        assertNotNull(responseObj);
        accountGroupId2 = responseObj.getAccountGroupId();
    }


    @Test
    public void test29_GetAccountGroupByIdWOptions() throws Throwable {
        GetAccountGroupOptions getAccountGroupByIdOptions = new GetAccountGroupOptions.Builder()
                .accountGroupId(accountGroupId).build();

        Response<AccountGroup> response = service.getAccountGroup(getAccountGroupByIdOptions).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 200);
        AccountGroup responseObj = response.getResult();
        assertNotNull(responseObj);
        crn2 = responseObj.getCrn();
    }

    @Test
    public void test30_MoveAccountWithEnterprise() throws Throwable {
        UpdateAccountOptions updateAccountOptions = new UpdateAccountOptions.Builder()
                .parent(crn).accountId(newAccountId).build();
        Response<Void> response = service.updateAccount(updateAccountOptions).execute();
        assertNotNull(response);
        assertEquals(response.getStatusCode(), 202);

    }
}
