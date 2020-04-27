package com.ibm.cloud.platform_services.enterprise_management.v1;

import static org.testng.Assert.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

import java.util.Map;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

/**
 * This class contains integration tests for the Enterprise Management.
 *
 * Notes:
 * 1. By providing the name of our config file ("enterprise-management.env") via the
 *    getConfigFilename() method below, the base class (SdkIntegrationTestBase) will be able to
 *    mock up the getenv() method to cause the Java core's CredentialUtils class to "see" the
 *    config file via the mocked value of the IBM_CREDENTIALS_FILE env var.
 *
 * 2. The base class will automatically set the "skipTests" flag to true if it can't find the config file.
 *
 * 3. The base class contains a "before method" function that will automatically skip each test method if
 *    the "skipTests" flag is true.   This means that this subclass doesn't need to concern
 *    itself with skipping tests in the event that the config file is not available.
 *
 * 4. This testcase uses the "dependsOnMethods" attribute of the @Test annotation to ensure that the test
 *    methods are executed in the the order they appear in this file.  Without this, there's no guaranteed ordering
 *    imposed by TestNG.
 */
public class EnterpriseManagementIT extends SdkIntegrationTestBase {

    // Example service v1 integration
    public static EnterpriseManagement service = null;
    public static Map<String, String> config = null;

    /**
     * This method provides our config filename to the base class.
     */
    public String getConfigFilename() {
        return "../../enterprise-management.env";
    }

    /**
     * This method is invoked before any of the @Test-annotated methods, and is responsible for
     * creating the instance of the service that will be used by the rest of the test methods,
     * as well as any other required initialization.
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
        // We'll use a special service name so as not to interfere with the official properties used to configure
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

//
// The test methods below are left commented out so as to provide examples of how to test individual service operations.
//
//    @Test
//    public void testListResources() {
//        assertNotNull(service);
//
//        try {
//            Response<Resources> response = service.listResources().execute();
//            assertNotNull(response);
//            assertEquals(response.getStatusCode(), 200);
//
//            Resources result = response.getResult();
//            assertNotNull(result);
//            assertNotNull(result.getResources());
//            assertEquals(result.getResources().size(), 2);
//
//            Resource firstResource = result.getResources().get(0);
//            assertEquals(firstResource.resourceId(), "1");
//            assertEquals(firstResource.name(), "The Great Gatsby");
//            assertEquals(firstResource.tag(), "Book");
//
//            Resource secondResource = result.getResources().get(1);
//            assertEquals(secondResource.resourceId(), "2");
//            assertEquals(secondResource.name(), "Pride and Prejudice");
//            assertEquals(secondResource.tag(), "Book");
//        } catch (ServiceResponseException e) {
//            fail(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
//                    e.getMessage(), e.getDebuggingInfo()));
//        }
//    }
//
//    @Test(dependsOnMethods = {"testListResources"})
//    public void testGetResource() {
//        try {
//            GetResourceOptions options = new GetResourceOptions.Builder()
//                    .resourceId("1")
//                    .build();
//            Response<Resource> response = service.getResource(options).execute();
//            assertNotNull(response);
//            assertEquals(response.getStatusCode(), 200);
//
//            Resource resourceObj = response.getResult();
//            assertNotNull(resourceObj);
//            assertEquals(resourceObj.resourceId(), "1");
//            assertEquals(resourceObj.name(), "The Great Gatsby");
//            assertEquals(resourceObj.tag(), "Book");
//        } catch (ServiceResponseException e) {
//            fail(String.format("Service returned status code %s: %s\nError details: %s",
//                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
//        }
//    }
//
//    @Test(dependsOnMethods = { "testGetResource" }, expectedExceptions = { NotFoundException.class })
//    public void testGetResourceNotFound() {
//        try {
//            GetResourceOptions options = new GetResourceOptions.Builder()
//                    .resourceId("BAD_RESOURCE_ID")
//                    .build();
//            service.getResource(options).execute().getResult();
//        } catch (ServiceResponseException e) {
//            assertEquals(e.getMessage(), "resource not found");
//            assertEquals(e.getStatusCode(), 404);
//            System.out.println(String.format("Service returned status code %s: %s\nError details: %s",
//                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
//            throw e;
//        }
//    }
//
//    @Test(dependsOnMethods = { "testGetResourceNotFound" })
//    public void testCreateResource() {
//        try {
//            CreateResourceOptions options = new CreateResourceOptions.Builder()
//                    .resourceId("3")
//                    .name("To Kill a Mockingbird")
//                    .tag("Book")
//                    .build();
//            Response<Resource> response = service.createResource(options).execute();
//            assertEquals(response.getStatusCode(), 201);
//
//            Resource resourceObj = response.getResult();
//            assertEquals(resourceObj.resourceId(), "3");
//            assertEquals(resourceObj.name(), "To Kill a Mockingbird");
//            assertEquals(resourceObj.tag(), "Book");
//        } catch (ServiceResponseException e) {
//            fail(String.format("Service returned status code %s: %s\nError details: %s",
//                    e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()));
//        }
//    }
}
