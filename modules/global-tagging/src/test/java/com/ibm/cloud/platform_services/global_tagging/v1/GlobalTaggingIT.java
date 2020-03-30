/*
 * (C) Copyright IBM Corp. 2020.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.ibm.cloud.platform_services.global_tagging.v1;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.sdk.core.security.JsonWebToken;
import com.ibm.cloud.platform_services.global_tagging.v1.GlobalTagging;
import com.ibm.cloud.platform_services.global_tagging.v1.model.AttachTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.AttachTagOptions.Builder;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DetachTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagResults;
import com.ibm.cloud.platform_services.global_tagging.v1.model.ListTagsOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.Resource;
import com.ibm.cloud.platform_services.global_tagging.v1.model.TagList;
import com.ibm.cloud.platform_services.global_tagging.v1.model.TagResults;
import com.ibm.cloud.platform_services.global_tagging.v1.model.TagResultsItem;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagResultsItem;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.cloud.sdk.core.service.exception.RequestTooLargeException;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Random;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Integration test class for the GlobalTagging service.
 */
public class GlobalTaggingIT {

	Properties prop = null;
	GlobalTagging globalTagging = null;

    private final static String TAG_NAME_PREFIX = "java-sdk-";
    private String TAG_NAME_SUFFIX = "100";

    @Test
    public void test_1_GetAllTag() throws Exception, InterruptedException {
        System.out.println("START 1 GlobalTaggingITest.testGetAllTag method");

        try {
            // Test 1 - GetAll Tag
        	Response<TagList> response = globalTagging.listTags().execute();
        	System.out.println("testGetAllTag status code= " + response.getStatusCode());
        	assertEquals(response.getStatusCode(), 200);
        	assertNotNull(response);
        	TagList result = response.getResult();
            assertNotNull(result);

        } catch (NotFoundException e) {
            // Handle Not Found (404) exception
            System.out.println("Service returned status code " + e.getStatusCode() + ": " + e.getMessage());
        } catch (RequestTooLargeException e) {
            // Handle Request Too Large (413) exception
            System.out.println("Service returned status code " + e.getStatusCode() + ": " + e.getMessage());
        } catch (ServiceResponseException e) {
            // Base class for all exceptions caused by error responses from the service
            System.out.println("Service returned status code " + e.getStatusCode() + ": " + e.getMessage());
            System.out.println("Error details: " + e.getDebuggingInfo());
        }
     }

    @Test
    public void test_2_AttachTag() throws Exception, InterruptedException {
        System.out.println("START 2 GlobalTaggingITest.testAttachTag method");

        try {
            // Test 2 - Attach Tag
        	Builder builder = new AttachTagOptions.Builder();
        	String tagName = this.TAG_NAME_PREFIX + this.TAG_NAME_SUFFIX;
        	System.out.println("testAttachTag tagName = " + tagName);
        	com.ibm.cloud.platform_services.global_tagging.v1.model.Resource.Builder rBuilder = new Resource.Builder();
        	rBuilder.resourceId(this.prop.getProperty("GST_RESOURCE_CRN"));
        	rBuilder.resourceType("cf-application");
        	Resource resource= rBuilder.build();

        	builder.addTagNames(tagName);
        	builder.addResources(resource);
        	AttachTagOptions ato = builder.build();

        	Response<TagResults> response = globalTagging.attachTag(ato).execute();
        	System.out.println("testAttachTag status code= " + response.getStatusCode());
        	assertEquals(response.getStatusCode(), 200);
        	assertNotNull(response);
        	TagResults result = response.getResult();
        	System.out.println("testAttachTag result= " + result);
            assertNotNull(result);
            assertFalse( ((TagResultsItem)(result.getResults().get(0))).isIsError().booleanValue() );


            // Test 2 - call GetAll with attached-to parameter true in order to find the tag just created
            com.ibm.cloud.platform_services.global_tagging.v1.model.ListTagsOptions.Builder ltoBuilder = new ListTagsOptions.Builder();
            ltoBuilder.attachedTo(this.prop.getProperty("GST_RESOURCE_CRN"));
            ListTagsOptions lto = ltoBuilder.build();

            Response<TagList> tlResponse =globalTagging.listTags(lto).execute();
            assertEquals(tlResponse.getStatusCode(), 200);
        	assertNotNull(tlResponse);
        	TagList tlResult = tlResponse.getResult();
            assertNotNull(tlResult);

        } catch (NotFoundException e) {
            // Handle Not Found (404) exception
            System.out.println("Service returned status code " + e.getStatusCode() + ": " + e.getMessage());
        } catch (RequestTooLargeException e) {
            // Handle Request Too Large (413) exception
            System.out.println("Service returned status code " + e.getStatusCode() + ": " + e.getMessage());
        } catch (ServiceResponseException e) {
            // Base class for all exceptions caused by error responses from the service
            System.out.println("Service returned status code " + e.getStatusCode() + ": " + e.getMessage());
            System.out.println("Error details: " + e.getDebuggingInfo());
        }
     }

    @Test
    public void test_3_DetachTag() throws Exception, InterruptedException {
        System.out.println("START 3 GlobalTaggingITest.testDetachTag method");

        try {
            // Test 3 - Detach Tag
        	com.ibm.cloud.platform_services.global_tagging.v1.model.DetachTagOptions.Builder builder = new DetachTagOptions.Builder();
        	String tagName = this.TAG_NAME_PREFIX + this.TAG_NAME_SUFFIX;
        	System.out.println("testDetachTag tagName = " + tagName);

        	com.ibm.cloud.platform_services.global_tagging.v1.model.Resource.Builder rBuilder = new Resource.Builder();
        	rBuilder.resourceId(this.prop.getProperty("GST_RESOURCE_CRN"));
        	rBuilder.resourceType("cf-application");
        	Resource resource= rBuilder.build();

        	builder.addTagNames(tagName);
        	builder.addResources(resource);
        	DetachTagOptions dto = builder.build();

        	Response<TagResults> response = globalTagging.detachTag(dto).execute();
        	System.out.println("testDetachTag status code= " + response.getStatusCode());
        	assertEquals(response.getStatusCode(), 200);
        	assertNotNull(response);
        	TagResults result = response.getResult();
        	assertNotNull(result);
        	System.out.println("testDetachTag result= " + result);
        	assertFalse( ((TagResultsItem)(result.getResults().get(0))).isIsError().booleanValue() );

        } catch (NotFoundException e) {
            // Handle Not Found (404) exception
            System.out.println("Service returned status code " + e.getStatusCode() + ": " + e.getMessage());
        } catch (RequestTooLargeException e) {
            // Handle Request Too Large (413) exception
            System.out.println("Service returned status code " + e.getStatusCode() + ": " + e.getMessage());
        } catch (ServiceResponseException e) {
            // Base class for all exceptions caused by error responses from the service
            System.out.println("Service returned status code " + e.getStatusCode() + ": " + e.getMessage());
            System.out.println("Error details: " + e.getDebuggingInfo());
        }
     }

    @Test
    public void test_4_DeleteTag() throws Exception, InterruptedException {
        System.out.println("START 4 GlobalTaggingITest.testDeleteTag method");

        try {
            // Test 4 - Delete Tag
        	String tagName = this.TAG_NAME_PREFIX + this.TAG_NAME_SUFFIX;
        	System.out.println("testDeleteTag tagName = " + tagName);
        	com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagOptions.Builder dto = new DeleteTagOptions.Builder(tagName);

        	Response<DeleteTagResults> response = globalTagging.deleteTag(dto.build()).execute();
        	assertEquals(response.getStatusCode(), 200);
        	assertNotNull(response);
        	DeleteTagResults result = response.getResult();
        	System.out.println("testDeleteTag result= " + result);
            assertNotNull(result);
            assertFalse( ((DeleteTagResultsItem)(result.getResults().get(0))).isIsError().booleanValue() );


        } catch (NotFoundException e) {
            // Handle Not Found (404) exception
            System.out.println("Service returned status code " + e.getStatusCode() + ": " + e.getMessage());
        } catch (RequestTooLargeException e) {
            // Handle Request Too Large (413) exception
            System.out.println("Service returned status code " + e.getStatusCode() + ": " + e.getMessage());
        } catch (ServiceResponseException e) {
            // Base class for all exceptions caused by error responses from the service
            System.out.println("Service returned status code " + e.getStatusCode() + ": " + e.getMessage());
            System.out.println("Error details: " + e.getDebuggingInfo());
        }
     }

    @BeforeSuite
    public void setUp() throws Exception, InterruptedException {
    	System.out.println("Working Directory = " + System.getProperty("user.dir"));
        //load file proerties
        try {
          InputStream input = new FileInputStream(System.getProperty("user.dir") + "/../../.ghostenv");
          this.prop = new Properties();
          this.prop.load(input);
        } catch (IOException ex) {
          ex.printStackTrace();
        }
        //Create the IAM authenticator.
        IamAuthenticator authenticator = new IamAuthenticator(this.prop.getProperty("GST_IINTERNA_APIKEY"));
        authenticator.setURL(this.prop.getProperty("GST_IAM_URL"));
        this.globalTagging = new GlobalTagging("global_tagging", authenticator);
        this.globalTagging.setEndPoint(this.prop.getProperty("GST_TAGS_URL"));

        //generate tag name suffix
        Random rand = new Random(); //instance of random class
        int upperbound = 1000000;
        int int_random = rand.nextInt(upperbound);
        this.TAG_NAME_SUFFIX = "" + int_random;
        System.out.println("Name TAG test = " + this.TAG_NAME_PREFIX + this.TAG_NAME_SUFFIX);
    }
}
