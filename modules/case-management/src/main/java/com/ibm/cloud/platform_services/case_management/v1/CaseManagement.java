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

/*
 * IBM OpenAPI SDK Code Generator Version: 99-SNAPSHOT-629bbb97-20201207-171303
 */

package com.ibm.cloud.platform_services.case_management.v1;

import com.google.gson.JsonObject;
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
import com.ibm.cloud.platform_services.case_management.v1.model.Resource;
import com.ibm.cloud.platform_services.case_management.v1.model.UpdateCaseStatusOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.UploadFileOptions;
import com.ibm.cloud.platform_services.case_management.v1.model.Watchlist;
import com.ibm.cloud.platform_services.case_management.v1.model.WatchlistAddResponse;
import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import okhttp3.MultipartBody;

/**
 * Case management API for creating cases, getting case statuses, adding comments to a case, adding and removing users
 * from a case watchlist, downloading and adding attachments, and more.
 *
 * @version v1
 */
public class CaseManagement extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "case_management";

  public static final String DEFAULT_SERVICE_URL = "https://support-center.cloud.ibm.com/case-management/v1";

 /**
   * Class method which constructs an instance of the `CaseManagement` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `CaseManagement` client using external configuration
   */
  public static CaseManagement newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `CaseManagement` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `CaseManagement` client using external configuration
   */
  public static CaseManagement newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    CaseManagement service = new CaseManagement(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `CaseManagement` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public CaseManagement(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * Get cases in account.
   *
   * Get cases in the account which is specified by the content of the IAM token.
   *
   * @param getCasesOptions the {@link GetCasesOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CaseList}
   */
  public ServiceCall<CaseList> getCases(GetCasesOptions getCasesOptions) {
    if (getCasesOptions == null) {
      getCasesOptions = new GetCasesOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/cases"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("case_management", "v1", "getCases");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getCasesOptions.offset() != null) {
      builder.query("offset", String.valueOf(getCasesOptions.offset()));
    }
    if (getCasesOptions.limit() != null) {
      builder.query("limit", String.valueOf(getCasesOptions.limit()));
    }
    if (getCasesOptions.search() != null) {
      builder.query("search", String.valueOf(getCasesOptions.search()));
    }
    if (getCasesOptions.sort() != null) {
      builder.query("sort", String.valueOf(getCasesOptions.sort()));
    }
    if (getCasesOptions.status() != null) {
      builder.query("status", RequestUtils.join(getCasesOptions.status(), ","));
    }
    if (getCasesOptions.fields() != null) {
      builder.query("fields", RequestUtils.join(getCasesOptions.fields(), ","));
    }
    ResponseConverter<CaseList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CaseList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get cases in account.
   *
   * Get cases in the account which is specified by the content of the IAM token.
   *
   * @return a {@link ServiceCall} with a result of type {@link CaseList}
   */
  public ServiceCall<CaseList> getCases() {
    return getCases(null);
  }

  /**
   * Create a case.
   *
   * Create a case in the account.
   *
   * @param createCaseOptions the {@link CreateCaseOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Case}
   */
  public ServiceCall<Case> createCase(CreateCaseOptions createCaseOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createCaseOptions,
      "createCaseOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/cases"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("case_management", "v1", "createCase");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("type", createCaseOptions.type());
    contentJson.addProperty("subject", createCaseOptions.subject());
    contentJson.addProperty("description", createCaseOptions.description());
    if (createCaseOptions.severity() != null) {
      contentJson.addProperty("severity", createCaseOptions.severity());
    }
    if (createCaseOptions.eu() != null) {
      contentJson.add("eu", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createCaseOptions.eu()));
    }
    if (createCaseOptions.offering() != null) {
      contentJson.add("offering", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createCaseOptions.offering()));
    }
    if (createCaseOptions.resources() != null) {
      contentJson.add("resources", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createCaseOptions.resources()));
    }
    if (createCaseOptions.watchlist() != null) {
      contentJson.add("watchlist", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createCaseOptions.watchlist()));
    }
    if (createCaseOptions.invoiceNumber() != null) {
      contentJson.addProperty("invoice_number", createCaseOptions.invoiceNumber());
    }
    if (createCaseOptions.slaCreditRequest() != null) {
      contentJson.addProperty("sla_credit_request", createCaseOptions.slaCreditRequest());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Case> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Case>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get a case in account.
   *
   * Get a case in the account that is specified by the case number.
   *
   * @param getCaseOptions the {@link GetCaseOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Case}
   */
  public ServiceCall<Case> getCase(GetCaseOptions getCaseOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(getCaseOptions,
      "getCaseOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("case_number", getCaseOptions.caseNumber());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/cases/{case_number}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("case_management", "v1", "getCase");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (getCaseOptions.fields() != null) {
      builder.query("fields", RequestUtils.join(getCaseOptions.fields(), ","));
    }
    ResponseConverter<Case> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Case>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Update case status.
   *
   * Mark the case as resolved or unresolved, or accept the provided resolution.
   *
   * @param updateCaseStatusOptions the {@link UpdateCaseStatusOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Case}
   */
  public ServiceCall<Case> updateCaseStatus(UpdateCaseStatusOptions updateCaseStatusOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(updateCaseStatusOptions,
      "updateCaseStatusOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("case_number", updateCaseStatusOptions.caseNumber());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/cases/{case_number}/status", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("case_management", "v1", "updateCaseStatus");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    builder.bodyContent(com.ibm.cloud.sdk.core.util.GsonSingleton.getGsonWithoutPrettyPrinting().toJson(updateCaseStatusOptions.statusPayload()), "application/json");
    ResponseConverter<Case> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Case>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add comment to case.
   *
   * Add a comment to a case.
   *
   * @param addCommentOptions the {@link AddCommentOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Comment}
   */
  public ServiceCall<Comment> addComment(AddCommentOptions addCommentOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(addCommentOptions,
      "addCommentOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("case_number", addCommentOptions.caseNumber());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/cases/{case_number}/comments", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("case_management", "v1", "addComment");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    contentJson.addProperty("comment", addCommentOptions.comment());
    builder.bodyJson(contentJson);
    ResponseConverter<Comment> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Comment>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add users to watchlist of case.
   *
   * Add users to the watchlist of case. By adding a user to the watchlist of the case, you are granting them read and
   * write permissions, so the user can view the case, receive updates, and make updates to the case. Note that the user
   * must be in the account to be added to the watchlist.
   *
   * @param addWatchlistOptions the {@link AddWatchlistOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link WatchlistAddResponse}
   */
  public ServiceCall<WatchlistAddResponse> addWatchlist(AddWatchlistOptions addWatchlistOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(addWatchlistOptions,
      "addWatchlistOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("case_number", addWatchlistOptions.caseNumber());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/cases/{case_number}/watchlist", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("case_management", "v1", "addWatchlist");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (addWatchlistOptions.watchlist() != null) {
      contentJson.add("watchlist", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(addWatchlistOptions.watchlist()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<WatchlistAddResponse> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<WatchlistAddResponse>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Remove users from watchlist of case.
   *
   * Remove users from the watchlist of a case.
   *
   * @param removeWatchlistOptions the {@link RemoveWatchlistOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Watchlist}
   */
  public ServiceCall<Watchlist> removeWatchlist(RemoveWatchlistOptions removeWatchlistOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(removeWatchlistOptions,
      "removeWatchlistOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("case_number", removeWatchlistOptions.caseNumber());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/cases/{case_number}/watchlist", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("case_management", "v1", "removeWatchlist");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (removeWatchlistOptions.watchlist() != null) {
      contentJson.add("watchlist", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(removeWatchlistOptions.watchlist()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Watchlist> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Watchlist>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add a resource to case.
   *
   * Add a resource to case by specifying the Cloud Resource Name (CRN), or id and type if attaching a class iaaS
   * resource.
   *
   * @param addResourceOptions the {@link AddResourceOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Resource}
   */
  public ServiceCall<Resource> addResource(AddResourceOptions addResourceOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(addResourceOptions,
      "addResourceOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("case_number", addResourceOptions.caseNumber());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/cases/{case_number}/resources", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("case_management", "v1", "addResource");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    final JsonObject contentJson = new JsonObject();
    if (addResourceOptions.crn() != null) {
      contentJson.addProperty("crn", addResourceOptions.crn());
    }
    if (addResourceOptions.type() != null) {
      contentJson.addProperty("type", addResourceOptions.type());
    }
    if (addResourceOptions.id() != null) {
      contentJson.addProperty("id", addResourceOptions.id());
    }
    if (addResourceOptions.note() != null) {
      contentJson.addProperty("note", addResourceOptions.note());
    }
    builder.bodyJson(contentJson);
    ResponseConverter<Resource> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Resource>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Add attachment(s) to case.
   *
   * You can add attachments to a case to provide more information for the support team about the issue that you're
   * experiencing.
   *
   * @param uploadFileOptions the {@link UploadFileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link Attachment}
   */
  public ServiceCall<Attachment> uploadFile(UploadFileOptions uploadFileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(uploadFileOptions,
      "uploadFileOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("case_number", uploadFileOptions.caseNumber());
    RequestBuilder builder = RequestBuilder.put(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/cases/{case_number}/attachments", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("case_management", "v1", "uploadFile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    MultipartBody.Builder multipartBuilder = new MultipartBody.Builder();
    multipartBuilder.setType(MultipartBody.FORM);
    for (FileWithMetadata item : uploadFileOptions.file()) {
      okhttp3.RequestBody itemBody = RequestUtils.inputStreamBody(item.data(), item.contentType());
      multipartBuilder.addFormDataPart("file", item.filename(), itemBody);
    }
    builder.body(multipartBuilder.build());
    ResponseConverter<Attachment> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<Attachment>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Download an attachment.
   *
   * Download an attachment from a case.
   *
   * @param downloadFileOptions the {@link DownloadFileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link InputStream}
   */
  public ServiceCall<InputStream> downloadFile(DownloadFileOptions downloadFileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(downloadFileOptions,
      "downloadFileOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("case_number", downloadFileOptions.caseNumber());
    pathParamsMap.put("file_id", downloadFileOptions.fileId());
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/cases/{case_number}/attachments/{file_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("case_management", "v1", "downloadFile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/octet-stream");
    ResponseConverter<InputStream> responseConverter = ResponseConverterUtils.getInputStream();
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Remove attachment from case.
   *
   * Remove an attachment from a case.
   *
   * @param deleteFileOptions the {@link DeleteFileOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link AttachmentList}
   */
  public ServiceCall<AttachmentList> deleteFile(DeleteFileOptions deleteFileOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteFileOptions,
      "deleteFileOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("case_number", deleteFileOptions.caseNumber());
    pathParamsMap.put("file_id", deleteFileOptions.fileId());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/cases/{case_number}/attachments/{file_id}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("case_management", "v1", "deleteFile");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    ResponseConverter<AttachmentList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<AttachmentList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}
