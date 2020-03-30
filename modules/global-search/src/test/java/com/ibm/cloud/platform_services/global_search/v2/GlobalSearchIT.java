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

package com.ibm.cloud.platform_services.global_search.v2;

import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.cloud.platform_services.global_search.v2.model.ScanResult;
import com.ibm.cloud.platform_services.global_search.v2.model.SearchOptions;
import com.ibm.cloud.platform_services.global_search.v2.model.SearchOptions.Builder;
import com.ibm.cloud.platform_services.global_search.v2.model.SupportedTypesList;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.cloud.sdk.core.service.exception.RequestTooLargeException;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Integration test class for the GlobalSearch service.
 */
public class GlobalSearchIT {
	
	Properties prop = null;
	GlobalSearch globalSearch = null;
	
    @Test
    public void testSearch() throws Exception, InterruptedException {
        System.out.println("START GlobalSearchIT.testSearch method");
        
        try {
            // Test 1 - search all resource
            Builder builder = new SearchOptions.Builder().query("name:gst-sdk*");
            SearchOptions searchOpt = builder.build();
            Response<ScanResult> response = this.globalSearch.search(searchOpt).execute();
            assertNotNull(response);
            ScanResult result = response.getResult();
            System.out.println("response search: " + result.getItems());
            assertNotNull(result);
            assertEquals(result.getItems().size(), 2);
 
            // Test 2 - search all resource and set limit = 1
            Builder builder2 = new SearchOptions.Builder()
                .query(this.prop.getProperty("GST_QUERY"))
                .limit(1)
                .addFields("crn")
                .addFields("name");
            SearchOptions searchOpt2 = builder2.build();
            Response<ScanResult> response2 = this.globalSearch.search(searchOpt2).execute();
            assertNotNull(response2);
            ScanResult result2 = response2.getResult();
            assertNotNull(result2);
            assertEquals(result2.getItems().size(), 1);
            System.out.println("response search 2: " + result2.getItems());
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
    public void testGetSupportedTypes() throws Exception, InterruptedException {
   	   // Test 3 - getSupportedTypes operation
       Response<SupportedTypesList> responseSTL = this.globalSearch.getSupportedTypes().execute();
       assertNotNull(responseSTL);
       SupportedTypesList resultSTL = responseSTL.getResult();
       assertNotNull(resultSTL);
       System.out.println("response SupportedTypesList: " + resultSTL.getSupportedTypes());
       
   	
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
        this.globalSearch = new GlobalSearch("global_search", authenticator);
        this.globalSearch.setEndPoint(this.prop.getProperty("GST_API_URL"));
    }
}
