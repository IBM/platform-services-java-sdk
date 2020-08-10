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
package com.ibm.cloud.platform_services.case_management.v1;

import com.ibm.cloud.platform_services.case_management.v1.model.AddCommentOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.AddResourceOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.AddWatchlistOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.Attachment;
import com.ibm.cloud.platform_services.case_management.v1.model.AttachmentList;
import com.ibm.cloud.platform_services.case_management.v1.model.Case;
import com.ibm.cloud.platform_services.case_management.v1.model.CaseList;
import com.ibm.cloud.platform_services.case_management.v1.model.Comment;
import com.ibm.cloud.platform_services.case_management.v1.model.CreateCaseOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.DeleteFileOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.DownloadFileOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.GetCaseOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.GetCasesOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.Offering;
import com.ibm.cloud.platform_services.case_management.v1.model.OfferingType;
import com.ibm.cloud.platform_services.case_management.v1.model.ResolvePayload;
import com.ibm.cloud.platform_services.case_management.v1.model.UpdateCaseStatusOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.UploadFileOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.User;
import com.ibm.cloud.platform_services.case_management.v1.model.WatchlistAddResponse;
import com.ibm.cloud.platform_services.test.SdkIntegrationTestBase;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.BadRequestException;
import com.ibm.cloud.sdk.core.service.exception.InternalServerErrorException;
import com.ibm.cloud.sdk.core.service.exception.NotFoundException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Integration test class for the Case Management service
 */
public class CaseManagementIT extends SdkIntegrationTestBase {

    protected CaseManagement service;

    protected String newCaseNumber;
    protected String fileAttachmentId;

    /**
     * This method provides our config filename to the base class.
     */
    @Override
    public String getConfigFilename() {
        return "../../case_management.env";
    }

    /**
     * This method is invoked before any @Test-annotated methods, and is responsible for
     * creating the instance of the service that will be used by the rest of the test methods,
     * as well as any other required initialization.
     */
    @BeforeClass
    public void constructService() {

        // Ask super if we should skip the tests.
        if (skipTests()) {
            return;
        }

        service = CaseManagement.newInstance();

        assertNotNull(service);
        assertNotNull(service.getServiceUrl());

        System.out.println("Using Service URL: " + service.getServiceUrl());
    }

    @Test (expectedExceptions = {BadRequestException.class})
    public void testCreateCaseWithEmptyOffering() {

        CreateCaseOptions createCaseOptionsModel = new CreateCaseOptions.Builder()
            .type("technical")
            .subject("test case")
            .description("test case description")
            .build();

        service.createCase(createCaseOptionsModel).execute();
    }

    @Test (expectedExceptions = {BadRequestException.class})
    public void testCreateCaseWithEmptySubjectAndDescription() {

        OfferingType offeringTypeModel = new OfferingType.Builder()
            .group("crn_service_name")
            .key("cloud-object-storage")
            .id("dff97f5c-bc5e-4455-b470-411c3edbe49c")
            .build();

        Offering offeringModel = new Offering.Builder()
            .name("Cloud Object Storage")
            .type(offeringTypeModel)
            .build();

        // Subject and description are required
        CreateCaseOptions createCaseOptionsModel = new CreateCaseOptions.Builder()
            .type("technical")
            .subject("")
            .description("")
            .offering(offeringModel)
            .build();

        service.createCase(createCaseOptionsModel).execute();
    }

    @Test
    public void testCreateCase() {

        String caseSubject = "Java - Integration test";
        String description = "Please -ignore this is a test case.";

        // Offering info can be retrieved via /case-management/utilities/v1/offerings/technical
        OfferingType offeringTypeModel = new OfferingType.Builder()
            .group("crn_service_name")
            .key("cloud-object-storage")
            .id("dff97f5c-bc5e-4455-b470-411c3edbe49c")
            .build();

        Offering offeringModel = new Offering.Builder()
            .name("Cloud Object Storage")
            .type(offeringTypeModel)
            .build();

        CreateCaseOptions createCaseOptionsModel = new CreateCaseOptions.Builder()
            .type("technical")
            .subject(caseSubject)
            .description(description)
            .offering(offeringModel)
            .severity(Long.valueOf("4"))
            .build();

        Response<Case> response = service.createCase(createCaseOptionsModel).execute();

        Case responseObj = response.getResult();

        assertEquals(caseSubject, responseObj.getShortDescription());
        assertEquals(description, responseObj.getDescription());

        // Storing the new case number for subsequent test cases
        this.newCaseNumber = responseObj.getNumber();

        System.out.println("New case number: " + responseObj.getNumber());
    }

    @Test (dependsOnMethods = {"testCreateCase"})
    public void testGetCases() {

        String[] fields = new String[] {"number", "description"};

        GetCasesOptions getCasesOptionsModel = new GetCasesOptions.Builder()
            .offset(Long.valueOf("0"))
            .limit(Long.valueOf("2"))
            .sort("number")
            .status(new ArrayList<String>(Arrays.asList("new")))
            .fields(new ArrayList<String>(Arrays.asList(fields)))
            .build();

        Response<CaseList> response = service.getCases(getCasesOptionsModel).execute();
        assertNotNull(response);
        CaseList responseObj = response.getResult();

        assertTrue(0 < responseObj.getTotalCount());
        assertTrue(0 < responseObj.getCases().size());
    }

    @Test (dependsOnMethods = {"testCreateCase"})
    public void testGetCase() {

        String[] fields = new String[] {"number", "description"};

        GetCaseOptions getCaseOptionsModel = new GetCaseOptions.Builder()
            .caseNumber(newCaseNumber)
            .fields(new ArrayList<String>(Arrays.asList(fields)))
            .build();

        Response<Case> response = service.getCase(getCaseOptionsModel).execute();
        assertNotNull(response);

        Case responseObj = response.getResult();
        assertEquals(newCaseNumber, responseObj.getNumber());
        assertNotNull(responseObj.getDescription());
    }

    @Test (dependsOnMethods = {"testCreateCase"}, expectedExceptions = {BadRequestException.class})
    public void testGetCasewithInvalidField() {

        String[] fields = new String[] {"number", "description", "invalid_field"};

        GetCaseOptions getCaseOptionsModel = new GetCaseOptions.Builder()
            .caseNumber(newCaseNumber)
            .fields(new ArrayList<String>(Arrays.asList(fields)))
            .build();

        service.getCase(getCaseOptionsModel).execute();
    }

    @Test (dependsOnMethods = {"testCreateCase"})
    public void testAddComment() {

        String comment = "This is a test comment!";

        AddCommentOptions addCommentOptionsModel = new AddCommentOptions.Builder()
            .caseNumber(newCaseNumber)
            .comment(comment)
            .build();

        Response<Comment> response = service.addComment(addCommentOptionsModel).execute();

        Comment responseObj = response.getResult();
        assertEquals(comment, responseObj.getValue());
    }

    @Test (expectedExceptions = {NotFoundException.class})
    public void testAddCommentToNonExistingCase() {

        String comment = "This is a test comment!";

        AddCommentOptions addCommentOptionsModel = new AddCommentOptions.Builder()
            .caseNumber("invalid-case-num")
            .comment(comment)
            .build();

        service.addComment(addCommentOptionsModel).execute();
    }

    @Test (dependsOnMethods = {"testCreateCase"})
    public void testAddWatchListMember() {

        // Users can be retrieved via the User Management API.
        User testUser = getWatchListModel();

        AddWatchlistOptions watchlistOptionsModel = new AddWatchlistOptions.Builder()
            .caseNumber(newCaseNumber)
            .watchlist(new ArrayList<User>(Arrays.asList(testUser)))
            .build();

        Response<WatchlistAddResponse> response = service.addWatchlist(watchlistOptionsModel).execute();
        WatchlistAddResponse responseObj = response.getResult();
        assertNotNull(responseObj);

        // Non-account member cannot be added to the watch-list, therefore the response will include a "failed" list
        List<User> users = responseObj.getFailed();

        // Loop over all returned users and find the matching one by user id
        Boolean foundMatchingUser = false;
        for (User user : users) {
            if (user.userId().contentEquals(testUser.userId())) {
                foundMatchingUser = true;
                break;
            }
        }

        assertTrue(foundMatchingUser);
    }

    @Test (dependsOnMethods = {"testCreateCase"})
    public void testFileUpload() {

        String fileName = "test_file.txt";

        List<FileWithMetadata> list = new ArrayList<FileWithMetadata>();
        byte[] fileBytes = {(byte) 0xde, (byte) 0xad, (byte) 0xbe, (byte) 0xef};
        InputStream inputStream = new ByteArrayInputStream(fileBytes);
        FileWithMetadata.Builder builder = new FileWithMetadata.Builder()
            .filename(fileName)
            .data(inputStream);
        FileWithMetadata fileWithMetadata = builder.build();
        list.add(fileWithMetadata);

        UploadFileOptions uploadFileOptionsModel = new UploadFileOptions.Builder()
            .caseNumber(newCaseNumber)
            .file(list)
            .build();

        Response<Attachment> response = service.uploadFile(uploadFileOptionsModel).execute();
        Attachment responseObj = response.getResult();

        this.fileAttachmentId = responseObj.getId();
        assertEquals(fileName, responseObj.getFilename());
    }

    @Test (dependsOnMethods = {"testCreateCase", "testFileUpload"})
    public void testDownloadFile() {

        DownloadFileOptions downloadFileOptionsModel = new DownloadFileOptions.Builder()
            .caseNumber(newCaseNumber)
            .fileId(fileAttachmentId)
            .build();

        Response<InputStream> response = service.downloadFile(downloadFileOptionsModel).execute();
        InputStream responseObj = response.getResult();

        assertNotNull(responseObj);
    }

    @Test (dependsOnMethods = {"testCreateCase", "testFileUpload", "testDownloadFile"})
    public void testDeleteFile() {

        DeleteFileOptions deleteFileOptionsModel = new DeleteFileOptions.Builder()
            .caseNumber(newCaseNumber)
            .fileId(fileAttachmentId)
            .build();

        Response<AttachmentList> response = service.deleteFile(deleteFileOptionsModel).execute();

        AttachmentList responseObj = response.getResult();

        // Assert the file attachment list is empty
        assertEquals(0, responseObj.getAttachments().size());
    }

    @Test (dependsOnMethods = {"testCreateCase"}, expectedExceptions = {InternalServerErrorException.class})
    public void testAddResource() {

        // Adding a resource requires a valid CRN (Cloud Resource Name)
        // CRN's can be retrieved via the Search and Tagging API
        String invalidCrn = "invalid:crn";
        AddResourceOptions addResourceOptionsModel = new AddResourceOptions.Builder()
            .caseNumber(newCaseNumber)
            .crn(invalidCrn)
            .note("Test resource")
            .build();

        service.addResource(addResourceOptionsModel).execute();
    }

    @Test (dependsOnMethods = {"testDeleteFile", "testAddResource"})
    public void testResolveCase() {

        ResolvePayload statusPayloadModel = new ResolvePayload.Builder()
            .action("resolve")
            .comment("testString")
            .resolutionCode(Long.valueOf("1"))
            .build();

        UpdateCaseStatusOptions updateCaseStatusOptionsModel = new UpdateCaseStatusOptions.Builder()
            .caseNumber(newCaseNumber)
            .statusPayload(statusPayloadModel)
            .build();

        Response<Case> response = service.updateCaseStatus(updateCaseStatusOptionsModel).execute();
        assertNotNull(response);
        Case responseObj = response.getResult();
        assertNotNull(responseObj);
    }

    /**
     * Returns a test user for testing watch-list functionality
     *
     * @return UserIdAndRealm
     */
    protected User getWatchListModel() {
        User userModel = new User.Builder()
            .realm("IBMid").userId("abc@ibm.com").build();

        return userModel;
    }
}
