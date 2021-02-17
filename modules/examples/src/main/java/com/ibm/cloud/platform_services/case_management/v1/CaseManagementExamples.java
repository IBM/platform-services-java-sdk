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
import com.ibm.cloud.platform_services.case_management.v1.model.RemoveWatchlistOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.ResolvePayload;
import com.ibm.cloud.platform_services.case_management.v1.model.Resource;
import com.ibm.cloud.platform_services.case_management.v1.model.UpdateCaseStatusOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.UploadFileOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.Watchlist;
import com.ibm.cloud.platform_services.case_management.v1.model.WatchlistAddResponse;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import java.io.InputStream;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CaseManagementExamples {
  private static final Logger logger = LoggerFactory.getLogger(CaseManagementExamples.class);
  protected CaseManagementExamples() { }

  @SuppressWarnings("checkstyle:methodlength")
  public static void main(String[] args) throws Exception {
    CaseManagement service = CaseManagement.newInstance();

    // Load up our test-specific config properties.
    Map<String, String> config = CredentialUtils.getServiceProperties(CaseManagement.DEFAULT_SERVICE_NAME);

    try {
      // begin-getCases
      GetCasesOptions getCasesOptions = new GetCasesOptions.Builder()
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
      // begin-createCase
      CreateCaseOptions createCaseOptions = new CreateCaseOptions.Builder()
        .type("technical")
        .subject("testString")
        .description("testString")
        .build();

      Response<Case> response = service.createCase(createCaseOptions).execute();
      Case xCase = response.getResult();

      System.out.println(xCase);
      // end-createCase
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-getCase
      GetCaseOptions getCaseOptions = new GetCaseOptions.Builder()
        .caseNumber("testString")
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
      // begin-updateCaseStatus
      ResolvePayload statusPayloadModel = new ResolvePayload.Builder()
        .action("resolve")
        .comment("It was actually a mistake")
        .resolutionCode(Long.valueOf("1"))
        .build();
      UpdateCaseStatusOptions updateCaseStatusOptions = new UpdateCaseStatusOptions.Builder()
        .caseNumber("testString")
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

    try {
      // begin-addComment
      AddCommentOptions addCommentOptions = new AddCommentOptions.Builder()
        .caseNumber("testString")
        .comment("This is a test comment")
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
      AddWatchlistOptions addWatchlistOptions = new AddWatchlistOptions.Builder()
        .caseNumber("testString")
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
      // begin-addResource
      AddResourceOptions addResourceOptions = new AddResourceOptions.Builder()
        .caseNumber("testString")
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
      UploadFileOptions uploadFileOptions = new UploadFileOptions.Builder()
        .caseNumber("testString")
        .file(new java.util.ArrayList<FileWithMetadata>())
        .build();

      Response<Attachment> response = service.uploadFile(uploadFileOptions).execute();
      Attachment attachment = response.getResult();

      System.out.println(attachment);
      // end-uploadFile
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-downloadFile
      DownloadFileOptions downloadFileOptions = new DownloadFileOptions.Builder()
        .caseNumber("testString")
        .fileId("testString")
        .build();

      Response<InputStream> response = service.downloadFile(downloadFileOptions).execute();
      InputStream inputStream = response.getResult();

      System.out.println(inputStream);
      // end-downloadFile
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

    try {
      // begin-removeWatchlist
      RemoveWatchlistOptions removeWatchlistOptions = new RemoveWatchlistOptions.Builder()
        .caseNumber("testString")
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
      // begin-deleteFile
      DeleteFileOptions deleteFileOptions = new DeleteFileOptions.Builder()
        .caseNumber("testString")
        .fileId("testString")
        .build();

      Response<AttachmentList> response = service.deleteFile(deleteFileOptions).execute();
      AttachmentList attachmentList = response.getResult();

      System.out.println(attachmentList);
      // end-deleteFile
    } catch (ServiceResponseException e) {
        logger.error(String.format("Service returned status code %s: %s\nError details: %s",
          e.getStatusCode(), e.getMessage(), e.getDebuggingInfo()), e);
    }

  }
}
