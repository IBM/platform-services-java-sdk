/*
 * (C) Copyright IBM Corp. 2021.
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
import com.ibm.cloud.platform_services.case_management.v1.model.RemoveWatchlistOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.ResolvePayload;
import com.ibm.cloud.platform_services.case_management.v1.model.Resource;
import com.ibm.cloud.platform_services.case_management.v1.model.UpdateCaseStatusOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.UploadFileOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.User;
import com.ibm.cloud.platform_services.case_management.v1.model.Watchlist;
import com.ibm.cloud.platform_services.case_management.v1.model.WatchlistAddResponse;
import com.ibm.cloud.platform_services.usage_reports.v4.model.Offer;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CaseManagementExamples {
  private static final Logger logger = LoggerFactory.getLogger(CaseManagementExamples.class);
  protected CaseManagementExamples() { }

  private static String caseNumber;
  private static String attachmentId;
  private static String resourceCrn;

  static {
    System.setProperty("IBM_CREDENTIALS_FILE", "../../case_management.env");
  }

  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    CaseManagement service = CaseManagement.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(CaseManagement.DEFAULT_SERVICE_NAME);
    resourceCrn = config.get("REOURCE_CRN");

    try {
      // begin-createCase
      OfferingType offeringType = new OfferingType.Builder()
        .group("crn_service_name")
        .key("cloud-object-storage")
        .build();
      Offering offeringPayload = new Offering.Builder()
        .name("Cloud Object Storage")
        .type(offeringType)
        .build();
      CreateCaseOptions createCaseOptions = new CreateCaseOptions.Builder()
        .type("technical")
        .subject("Example technical case")
        .description("This is an example case description. This is where the problem would be described.")
        .offering(offeringPayload)
        .severity(4)
        .build();

      Response<Case> response = service.createCase(createCaseOptions).execute();
      Case xCase = response.getResult();

      System.out.println(xCase);
      // end-createCase

      caseNumber = xCase.getNumber();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-getCase
      List<String> fieldsToReturn = new ArrayList<String>();
      fieldsToReturn.add(GetCaseOptions.Fields.DESCRIPTION);
      fieldsToReturn.add(GetCaseOptions.Fields.STATUS);
      fieldsToReturn.add(GetCaseOptions.Fields.SEVERITY);
      fieldsToReturn.add(GetCaseOptions.Fields.CREATED_BY);

      GetCaseOptions getCaseOptions = new GetCaseOptions.Builder()
        .caseNumber(caseNumber)
        .fields(fieldsToReturn)
        .build();

      Response<Case> response = service.getCase(getCaseOptions).execute();
      Case xCase = response.getResult();

      System.out.println(xCase);
      // end-getCase
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-getCases
      GetCasesOptions getCasesOptions = new GetCasesOptions.Builder()
        .offset(0)
        .limit(100)
        .search("blocker")
        .sort(GetCasesOptions.Fields.UPDATED_AT)
        .build();

      Response<CaseList> response = service.getCases(getCasesOptions).execute();
      CaseList caseList = response.getResult();

      System.out.println(caseList);
      // end-getCases
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-addComment
      AddCommentOptions addCommentOptions = new AddCommentOptions.Builder()
        .caseNumber(caseNumber)
        .comment("This is an example comment.")
        .build();

      Response<Comment> response = service.addComment(addCommentOptions).execute();
      Comment comment = response.getResult();

      System.out.println(comment);
      // end-addComment
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-addWatchlist
      List<User> wathcListUsers = new ArrayList<User>();
      wathcListUsers.add(
        new User.Builder().realm("IBMid").userId("abc@ibm.com").build()
      );
      AddWatchlistOptions addWatchlistOptions = new AddWatchlistOptions.Builder()
        .caseNumber(caseNumber)
        .watchlist(wathcListUsers)
        .build();

      Response<WatchlistAddResponse> response = service.addWatchlist(addWatchlistOptions).execute();
      WatchlistAddResponse watchlistAddResponse = response.getResult();

      System.out.println(watchlistAddResponse);
      // end-addWatchlist
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-removeWatchlist
      List<User> wathcListUsers = new ArrayList<User>();
      wathcListUsers.add(
        new User.Builder().realm("IBMid").userId("abc@ibm.com").build()
      );
      RemoveWatchlistOptions removeWatchlistOptions = new RemoveWatchlistOptions.Builder()
        .caseNumber(caseNumber)
        .watchlist(wathcListUsers)
        .build();

      Response<Watchlist> response = service.removeWatchlist(removeWatchlistOptions).execute();
      Watchlist watchlist = response.getResult();

      System.out.println(watchlist);
      // end-removeWatchlist
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-addResource
      AddResourceOptions addResourceOptions = new AddResourceOptions.Builder()
        .caseNumber(caseNumber)
        .crn(resourceCrn)
        .note("This resource is the service that is having the problem.")
        .build();

      Response<Resource> response = service.addResource(addResourceOptions).execute();
      Resource resource = response.getResult();

      System.out.println(resource);
      // end-addResource
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-uploadFile
      InputStream exampleFileContent = new ByteArrayInputStream("This is the content of the file to upload.".getBytes());

      FileWithMetadata fileWithMetadata = new FileWithMetadata.Builder()
          .filename("example.log")
          .data(exampleFileContent)
          .contentType("application/octet-stream")
          .build();

      List<FileWithMetadata> filesToUpload = new ArrayList<FileWithMetadata>();
      filesToUpload.add(fileWithMetadata);

      UploadFileOptions uploadFileOptions = new UploadFileOptions.Builder()
        .caseNumber(caseNumber)
        .file(filesToUpload)
        .build();

      Response<Attachment> response = service.uploadFile(uploadFileOptions).execute();
      Attachment attachment = response.getResult();

      System.out.println(attachment);
      // end-uploadFile

      attachmentId = attachment.getId();
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-downloadFile
      DownloadFileOptions downloadFileOptions = new DownloadFileOptions.Builder()
        .caseNumber(caseNumber)
        .fileId(attachmentId)
        .build();

      Response<InputStream> response = service.downloadFile(downloadFileOptions).execute();
      InputStream inputStream = response.getResult();

      System.out.println("Attachment content-type: " + response.getHeaders().values("Content-type"));
      System.out.println("Attachment contents: " + new String(inputStream.readAllBytes()));
      // end-downloadFile
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-deleteFile
      DeleteFileOptions deleteFileOptions = new DeleteFileOptions.Builder()
        .caseNumber(caseNumber)
        .fileId(attachmentId)
        .build();

      Response<AttachmentList> response = service.deleteFile(deleteFileOptions).execute();
      AttachmentList attachmentList = response.getResult();

      System.out.println(attachmentList);
      // end-deleteFile
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-updateCaseStatus
      ResolvePayload statusPayloadModel = new ResolvePayload.Builder()
        .action("resolve")
        .comment("The problem has been resolved.")
        .resolutionCode(1)
        .build();
      UpdateCaseStatusOptions updateCaseStatusOptions = new UpdateCaseStatusOptions.Builder()
        .caseNumber(caseNumber)
        .statusPayload(statusPayloadModel)
        .build();

      Response<Case> response = service.updateCaseStatus(updateCaseStatusOptions).execute();
      Case xCase = response.getResult();

      System.out.println(xCase);
      // end-updateCaseStatus
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

  }
}
