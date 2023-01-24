/*
 * (C) Copyright IBM Corp. 2023.
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
 * IBM OpenAPI SDK Code Generator Version: 3.64.0-959a5845-20230112-195144
 */

package com.ibm.cloud.platform_services.global_tagging.v1;

import com.google.gson.JsonObject;
import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.platform_services.global_tagging.v1.model.AttachTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.CreateTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.CreateTagResults;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagAllOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagResults;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagsResult;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DetachTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.ListTagsOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.TagList;
import com.ibm.cloud.platform_services.global_tagging.v1.model.TagResults;
import com.ibm.cloud.sdk.core.http.RequestBuilder;
import com.ibm.cloud.sdk.core.http.ResponseConverter;
import com.ibm.cloud.sdk.core.http.ServiceCall;
import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.ConfigBasedAuthenticatorFactory;
import com.ibm.cloud.sdk.core.service.BaseService;
import com.ibm.cloud.sdk.core.util.RequestUtils;
import com.ibm.cloud.sdk.core.util.ResponseConverterUtils;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Manage your tags with the Tagging API in IBM Cloud. You can attach, detach, delete, or list all of the tags in your
 * billing account with the Tagging API. The tag name must be unique within a billing account. You can create tags in
 * two formats: `key:value` or `label`. The tagging API supports three types of tag: `user` `service`, and `access`
 * tags. `service` tags cannot be attached to IMS resources. `service` tags must be in the form
 * `service_prefix:tag_label` where `service_prefix` identifies the Service owning the tag. `access` tags cannot be
 * attached to IMS and Cloud Foundry resources. They must be in the form `key:value`.
 *
 * API Version: 1.2.0
 */
public class GlobalTagging extends BaseService {

  /**
   * Default service name used when configuring the `GlobalTagging` client.
   */
  public static final String DEFAULT_SERVICE_NAME = "global_tagging";

  /**
   * Default service endpoint URL.
   */
  public static final String DEFAULT_SERVICE_URL = "https://tags.global-search-tagging.cloud.ibm.com";

 /**
   * Class method which constructs an instance of the `GlobalTagging` client.
   * The default service name is used to configure the client instance.
   *
   * @return an instance of the `GlobalTagging` client using external configuration
   */
  public static GlobalTagging newInstance() {
    return newInstance(DEFAULT_SERVICE_NAME);
  }

  /**
   * Class method which constructs an instance of the `GlobalTagging` client.
   * The specified service name is used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @return an instance of the `GlobalTagging` client using external configuration
   */
  public static GlobalTagging newInstance(String serviceName) {
    Authenticator authenticator = ConfigBasedAuthenticatorFactory.getAuthenticator(serviceName);
    GlobalTagging service = new GlobalTagging(serviceName, authenticator);
    service.configureService(serviceName);
    return service;
  }

  /**
   * Constructs an instance of the `GlobalTagging` client.
   * The specified service name and authenticator are used to configure the client instance.
   *
   * @param serviceName the service name to be used when configuring the client instance
   * @param authenticator the {@link Authenticator} instance to be configured for this client
   */
  public GlobalTagging(String serviceName, Authenticator authenticator) {
    super(serviceName, authenticator);
    setServiceUrl(DEFAULT_SERVICE_URL);
  }

  /**
   * Get all tags.
   *
   * Lists all tags that are in a billing account. Use the `attached_to` parameter to return the list of tags that are
   * attached to the specified resource.
   *
   * @param listTagsOptions the {@link ListTagsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link TagList}
   */
  public ServiceCall<TagList> listTags(ListTagsOptions listTagsOptions) {
    if (listTagsOptions == null) {
      listTagsOptions = new ListTagsOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/tags"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_tagging", "v1", "listTags");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listTagsOptions.transactionId() != null) {
      builder.header("transaction-id", listTagsOptions.transactionId());
    }
    if (listTagsOptions.impersonateUser() != null) {
      builder.query("impersonate_user", String.valueOf(listTagsOptions.impersonateUser()));
    }
    if (listTagsOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(listTagsOptions.accountId()));
    }
    if (listTagsOptions.tagType() != null) {
      builder.query("tag_type", String.valueOf(listTagsOptions.tagType()));
    }
    if (listTagsOptions.fullData() != null) {
      builder.query("full_data", String.valueOf(listTagsOptions.fullData()));
    }
    if (listTagsOptions.providers() != null) {
      builder.query("providers", RequestUtils.join(listTagsOptions.providers(), ","));
    }
    if (listTagsOptions.attachedTo() != null) {
      builder.query("attached_to", String.valueOf(listTagsOptions.attachedTo()));
    }
    if (listTagsOptions.offset() != null) {
      builder.query("offset", String.valueOf(listTagsOptions.offset()));
    }
    if (listTagsOptions.limit() != null) {
      builder.query("limit", String.valueOf(listTagsOptions.limit()));
    }
    if (listTagsOptions.timeout() != null) {
      builder.query("timeout", String.valueOf(listTagsOptions.timeout()));
    }
    if (listTagsOptions.orderByName() != null) {
      builder.query("order_by_name", String.valueOf(listTagsOptions.orderByName()));
    }
    if (listTagsOptions.attachedOnly() != null) {
      builder.query("attached_only", String.valueOf(listTagsOptions.attachedOnly()));
    }
    ResponseConverter<TagList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<TagList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get all tags.
   *
   * Lists all tags that are in a billing account. Use the `attached_to` parameter to return the list of tags that are
   * attached to the specified resource.
   *
   * @return a {@link ServiceCall} with a result of type {@link TagList}
   */
  public ServiceCall<TagList> listTags() {
    return listTags(null);
  }

  /**
   * Create an access management tag.
   *
   * Create an access management tag. To create an `access` tag, you must have the access listed in the [Granting users
   * access to tag resources](https://cloud.ibm.com/docs/account?topic=account-access) documentation. `service` and
   * `user` tags cannot be created upfront. They are created when they are attached for the first time to a resource.
   *
   * @param createTagOptions the {@link CreateTagOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link CreateTagResults}
   */
  public ServiceCall<CreateTagResults> createTag(CreateTagOptions createTagOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(createTagOptions,
      "createTagOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/tags"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_tagging", "v1", "createTag");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (createTagOptions.transactionId() != null) {
      builder.header("transaction-id", createTagOptions.transactionId());
    }
    if (createTagOptions.impersonateUser() != null) {
      builder.query("impersonate_user", String.valueOf(createTagOptions.impersonateUser()));
    }
    if (createTagOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(createTagOptions.accountId()));
    }
    if (createTagOptions.tagType() != null) {
      builder.query("tag_type", String.valueOf(createTagOptions.tagType()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.add("tag_names", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(createTagOptions.tagNames()));
    builder.bodyJson(contentJson);
    ResponseConverter<CreateTagResults> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<CreateTagResults>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete all unused tags.
   *
   * Delete the tags that are not attached to any resource.
   *
   * @param deleteTagAllOptions the {@link DeleteTagAllOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DeleteTagsResult}
   */
  public ServiceCall<DeleteTagsResult> deleteTagAll(DeleteTagAllOptions deleteTagAllOptions) {
    if (deleteTagAllOptions == null) {
      deleteTagAllOptions = new DeleteTagAllOptions.Builder().build();
    }
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/tags"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_tagging", "v1", "deleteTagAll");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteTagAllOptions.transactionId() != null) {
      builder.header("transaction-id", deleteTagAllOptions.transactionId());
    }
    if (deleteTagAllOptions.providers() != null) {
      builder.query("providers", String.valueOf(deleteTagAllOptions.providers()));
    }
    if (deleteTagAllOptions.impersonateUser() != null) {
      builder.query("impersonate_user", String.valueOf(deleteTagAllOptions.impersonateUser()));
    }
    if (deleteTagAllOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(deleteTagAllOptions.accountId()));
    }
    if (deleteTagAllOptions.tagType() != null) {
      builder.query("tag_type", String.valueOf(deleteTagAllOptions.tagType()));
    }
    ResponseConverter<DeleteTagsResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DeleteTagsResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete all unused tags.
   *
   * Delete the tags that are not attached to any resource.
   *
   * @return a {@link ServiceCall} with a result of type {@link DeleteTagsResult}
   */
  public ServiceCall<DeleteTagsResult> deleteTagAll() {
    return deleteTagAll(null);
  }

  /**
   * Delete an unused tag.
   *
   * Delete an existing tag. A tag can be deleted only if it is not attached to any resource.
   *
   * @param deleteTagOptions the {@link DeleteTagOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DeleteTagResults}
   */
  public ServiceCall<DeleteTagResults> deleteTag(DeleteTagOptions deleteTagOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteTagOptions,
      "deleteTagOptions cannot be null");
    Map<String, String> pathParamsMap = new HashMap<String, String>();
    pathParamsMap.put("tag_name", deleteTagOptions.tagName());
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/tags/{tag_name}", pathParamsMap));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_tagging", "v1", "deleteTag");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteTagOptions.transactionId() != null) {
      builder.header("transaction-id", deleteTagOptions.transactionId());
    }
    if (deleteTagOptions.providers() != null) {
      builder.query("providers", RequestUtils.join(deleteTagOptions.providers(), ","));
    }
    if (deleteTagOptions.impersonateUser() != null) {
      builder.query("impersonate_user", String.valueOf(deleteTagOptions.impersonateUser()));
    }
    if (deleteTagOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(deleteTagOptions.accountId()));
    }
    if (deleteTagOptions.tagType() != null) {
      builder.query("tag_type", String.valueOf(deleteTagOptions.tagType()));
    }
    ResponseConverter<DeleteTagResults> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DeleteTagResults>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Attach tags.
   *
   * Attaches one or more tags to one or more resources. Each resource can have no more than 1000 tags per each 'user'
   * and 'service' type, and no more than 250 'access' tags (which is the account limit).
   *
   * @param attachTagOptions the {@link AttachTagOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link TagResults}
   */
  public ServiceCall<TagResults> attachTag(AttachTagOptions attachTagOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(attachTagOptions,
      "attachTagOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/tags/attach"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_tagging", "v1", "attachTag");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (attachTagOptions.transactionId() != null) {
      builder.header("transaction-id", attachTagOptions.transactionId());
    }
    if (attachTagOptions.impersonateUser() != null) {
      builder.query("impersonate_user", String.valueOf(attachTagOptions.impersonateUser()));
    }
    if (attachTagOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(attachTagOptions.accountId()));
    }
    if (attachTagOptions.tagType() != null) {
      builder.query("tag_type", String.valueOf(attachTagOptions.tagType()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.add("resources", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(attachTagOptions.resources()));
    if (attachTagOptions.tagName() != null) {
      contentJson.addProperty("tag_name", attachTagOptions.tagName());
    }
    if (attachTagOptions.tagNames() != null) {
      contentJson.add("tag_names", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(attachTagOptions.tagNames()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<TagResults> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<TagResults>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Detach tags.
   *
   * Detaches one or more tags from one or more resources.
   *
   * @param detachTagOptions the {@link DetachTagOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link TagResults}
   */
  public ServiceCall<TagResults> detachTag(DetachTagOptions detachTagOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(detachTagOptions,
      "detachTagOptions cannot be null");
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.resolveRequestUrl(getServiceUrl(), "/v3/tags/detach"));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_tagging", "v1", "detachTag");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (detachTagOptions.transactionId() != null) {
      builder.header("transaction-id", detachTagOptions.transactionId());
    }
    if (detachTagOptions.impersonateUser() != null) {
      builder.query("impersonate_user", String.valueOf(detachTagOptions.impersonateUser()));
    }
    if (detachTagOptions.accountId() != null) {
      builder.query("account_id", String.valueOf(detachTagOptions.accountId()));
    }
    if (detachTagOptions.tagType() != null) {
      builder.query("tag_type", String.valueOf(detachTagOptions.tagType()));
    }
    final JsonObject contentJson = new JsonObject();
    contentJson.add("resources", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(detachTagOptions.resources()));
    if (detachTagOptions.tagName() != null) {
      contentJson.addProperty("tag_name", detachTagOptions.tagName());
    }
    if (detachTagOptions.tagNames() != null) {
      contentJson.add("tag_names", com.ibm.cloud.sdk.core.util.GsonSingleton.getGson().toJsonTree(detachTagOptions.tagNames()));
    }
    builder.bodyJson(contentJson);
    ResponseConverter<TagResults> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<TagResults>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

}
