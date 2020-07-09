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

import com.google.gson.JsonObject;
import com.ibm.cloud.platform_services.common.SdkCommon;
import com.ibm.cloud.platform_services.global_tagging.v1.model.AttachTagOptions;
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
import java.util.Map;
import java.util.Map.Entry;

/**
 * Manage your tags with the Tagging API in IBM Cloud. You can attach, detach, delete a tag or list all tags in your
 * billing account with the Tagging API. The tag name must be unique within a billing account. You can create tags in
 * two formats: `key:value` or `label`.
 *
 * @version v1
 */
public class GlobalTagging extends BaseService {

  public static final String DEFAULT_SERVICE_NAME = "global_tagging";

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
   * Lists all tags in a billing account. Use the `attached_to` parameter to return the list of tags attached to the
   * specified resource.
   *
   * @param listTagsOptions the {@link ListTagsOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link TagList}
   */
  public ServiceCall<TagList> listTags(ListTagsOptions listTagsOptions) {
    String[] pathSegments = { "v3/tags" };
    RequestBuilder builder = RequestBuilder.get(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_tagging", "v1", "listTags");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (listTagsOptions != null) {
      if (listTagsOptions.providers() != null) {
        builder.query("providers", RequestUtils.join(listTagsOptions.providers(), ","));
      }
      if (listTagsOptions.attachedTo() != null) {
        builder.query("attached_to", listTagsOptions.attachedTo());
      }
      if (listTagsOptions.fullData() != null) {
        builder.query("full_data", String.valueOf(listTagsOptions.fullData()));
      }
      if (listTagsOptions.offset() != null) {
        builder.query("offset", String.valueOf(listTagsOptions.offset()));
      }
      if (listTagsOptions.limit() != null) {
        builder.query("limit", String.valueOf(listTagsOptions.limit()));
      }
      if (listTagsOptions.orderByName() != null) {
        builder.query("order_by_name", listTagsOptions.orderByName());
      }
      if (listTagsOptions.timeout() != null) {
        builder.query("timeout", String.valueOf(listTagsOptions.timeout()));
      }
      if (listTagsOptions.attachedOnly() != null) {
        builder.query("attached_only", String.valueOf(listTagsOptions.attachedOnly()));
      }
    }
    ResponseConverter<TagList> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<TagList>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Get all tags.
   *
   * Lists all tags in a billing account. Use the `attached_to` parameter to return the list of tags attached to the
   * specified resource.
   *
   * @return a {@link ServiceCall} with a result of type {@link TagList}
   */
  public ServiceCall<TagList> listTags() {
    return listTags(null);
  }

  /**
   * Delete unused tags.
   *
   * Delete the tags that are not attatched to any resource.
   *
   * @param deleteTagAllOptions the {@link DeleteTagAllOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DeleteTagsResult}
   */
  public ServiceCall<DeleteTagsResult> deleteTagAll(DeleteTagAllOptions deleteTagAllOptions) {
    String[] pathSegments = { "v3/tags" };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_tagging", "v1", "deleteTagAll");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteTagAllOptions != null) {
      if (deleteTagAllOptions.providers() != null) {
        builder.query("providers", deleteTagAllOptions.providers());
      }
    }
    ResponseConverter<DeleteTagsResult> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DeleteTagsResult>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Delete unused tags.
   *
   * Delete the tags that are not attatched to any resource.
   *
   * @return a {@link ServiceCall} with a result of type {@link DeleteTagsResult}
   */
  public ServiceCall<DeleteTagsResult> deleteTagAll() {
    return deleteTagAll(null);
  }

  /**
   * Delete a tag.
   *
   * Delete an existing tag. A tag can be deleted only if it is not attached to any resource.
   *
   * @param deleteTagOptions the {@link DeleteTagOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link DeleteTagResults}
   */
  public ServiceCall<DeleteTagResults> deleteTag(DeleteTagOptions deleteTagOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(deleteTagOptions,
      "deleteTagOptions cannot be null");
    String[] pathSegments = { "v3/tags" };
    String[] pathParameters = { deleteTagOptions.tagName() };
    RequestBuilder builder = RequestBuilder.delete(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments, pathParameters));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_tagging", "v1", "deleteTag");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
    if (deleteTagOptions.providers() != null) {
      builder.query("providers", RequestUtils.join(deleteTagOptions.providers(), ","));
    }
    ResponseConverter<DeleteTagResults> responseConverter =
      ResponseConverterUtils.getValue(new com.google.gson.reflect.TypeToken<DeleteTagResults>() { }.getType());
    return createServiceCall(builder.build(), responseConverter);
  }

  /**
   * Attach one or more tags.
   *
   * Attaches one or more tags to one or more resources. To attach a tag to a resource managed by the Resource
   * Controller, you must be an editor on the resource. To attach a tag to a Cloud Foundry resource, you must have space
   * developer role. To attach a tag to IMS resources, depending on the resource, you need either `view hardware
   * details`, `view virtual server details` or `manage storage` permission.
   *
   * @param attachTagOptions the {@link AttachTagOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link TagResults}
   */
  public ServiceCall<TagResults> attachTag(AttachTagOptions attachTagOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(attachTagOptions,
      "attachTagOptions cannot be null");
    String[] pathSegments = { "v3/tags/attach" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_tagging", "v1", "attachTag");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
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
   * Detach one or more tags.
   *
   * Detach one or more tags from one or more resources. To detach a tag from a Resource Controller managed resource,
   * you must be an editor on the resource. To detach a tag to a Cloud Foundry resource, you must have `space developer`
   * role.
   *   To detach a tag to IMS resources, depending on the resource, you need either `view hardware details`, `view
   * virtual server details` or `storage manage` permission.
   *
   * @param detachTagOptions the {@link DetachTagOptions} containing the options for the call
   * @return a {@link ServiceCall} with a result of type {@link TagResults}
   */
  public ServiceCall<TagResults> detachTag(DetachTagOptions detachTagOptions) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(detachTagOptions,
      "detachTagOptions cannot be null");
    String[] pathSegments = { "v3/tags/detach" };
    RequestBuilder builder = RequestBuilder.post(RequestBuilder.constructHttpUrl(getServiceUrl(), pathSegments));
    Map<String, String> sdkHeaders = SdkCommon.getSdkHeaders("global_tagging", "v1", "detachTag");
    for (Entry<String, String> header : sdkHeaders.entrySet()) {
      builder.header(header.getKey(), header.getValue());
    }
    builder.header("Accept", "application/json");
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
