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

import com.ibm.cloud.platform_services.global_tagging.v1.model.AttachTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.CreateTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.CreateTagResults;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagAllOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagResults;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DeleteTagsResult;
import com.ibm.cloud.platform_services.global_tagging.v1.model.DetachTagOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.ListTagsOptions;
import com.ibm.cloud.platform_services.global_tagging.v1.model.Resource;
import com.ibm.cloud.platform_services.global_tagging.v1.model.TagList;
import com.ibm.cloud.platform_services.global_tagging.v1.model.TagResults;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;
import com.ibm.cloud.sdk.core.util.CredentialUtils;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//
// This file provides an example of how to use the Global Tagging service.
//
// The following configuration properties are assumed to be defined:
//
// GLOBAL_TAGGING_URL=<service url>
// GLOBAL_TAGGING_AUTHTYPE=iam
// GLOBAL_TAGGING_APIKEY=<IAM api key>
// GLOBAL_TAGGING_AUTH_URL=<IAM token service URL - omit this if using the production environment>
// GLOBAL_TAGGING_RESOURCE_CRN=<the crn of the resource to be used in the examples>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
public class GlobalTaggingExamples {
    private static final Logger logger = LoggerFactory.getLogger(GlobalTaggingExamples.class);

    protected GlobalTaggingExamples() {
    }

    static {
        System.setProperty("IBM_CREDENTIALS_FILE", "../../global_tagging.env");
    }

    public static void main(String[] args) throws Exception {
        GlobalTagging service = GlobalTagging.newInstance();

        // Load up our test-specific config properties.
        Map<String, String> config = CredentialUtils.getServiceProperties(GlobalTagging.DEFAULT_SERVICE_NAME);
        String resourceCRN = config.get("RESOURCE_CRN");

        try {
            // begin-create_tag
            CreateTagOptions createTagOptions = new CreateTagOptions.Builder()
                    .addTagNames("env:example-access-tag")
                    .tagType("access")
                    .build();

            Response<CreateTagResults> response = service.createTag(createTagOptions).execute();
            CreateTagResults createTagResults = response.getResult();
            System.out.println(createTagResults);
            // end-create_tag
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            // begin-list_tags
            ListTagsOptions listTagsOptions = new ListTagsOptions.Builder()
                    .tagType("user")
                    .attachedOnly(true)
                    .fullData(true)
                    .addProviders("ghost")
                    .orderByName("asc")
                    .build();

            Response<TagList> response = service.listTags(listTagsOptions).execute();
            TagList tagList = response.getResult();
            System.out.println(tagList.toString());
            // end-list_tags
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            // begin-attach_tag
            Resource resourceModel = new Resource.Builder().resourceId(resourceCRN).build();
            AttachTagOptions attachTagOptions = new AttachTagOptions.Builder()
                    .addResources(resourceModel)
                    .addTagNames("tag_test_1")
                    .addTagNames("tag_test_2")
                    .build();

            Response<TagResults> response = service.attachTag(attachTagOptions).execute();
            TagResults tagResults = response.getResult();
            System.out.println(tagResults.toString());
            // end-attach_tag
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            // begin-detach_tag
            Resource resourceModel = new Resource.Builder().resourceId(resourceCRN).build();
            DetachTagOptions detachTagOptions = new DetachTagOptions.Builder()
                    .addResources(resourceModel)
                    .addTagNames("tag_test_1")
                    .addTagNames("tag_test_2")
                    .tagType("user")
                    .build();

            Response<TagResults> response = service.detachTag(detachTagOptions).execute();
            TagResults tagResults = response.getResult();
            System.out.println(tagResults.toString());
            // end-detach_tag
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            // begin-delete_tag
            DeleteTagOptions deleteTagOptions = new DeleteTagOptions.Builder()
                    .tagName("env:example-access-tag")
                    .tagType("access")
                    .build();

            Response<DeleteTagResults> response = service.deleteTag(deleteTagOptions).execute();
            DeleteTagResults deleteTagResults = response.getResult();
            System.out.println(deleteTagResults.toString());
            // end-delete_tag
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }

        try {
            // begin-delete_tag_all
            DeleteTagAllOptions deleteTagAllOptions = new DeleteTagAllOptions.Builder()
                    .tagType("user")
                    .build();

            Response<DeleteTagsResult> response = service.deleteTagAll(deleteTagAllOptions).execute();
            DeleteTagsResult deleteTagsResult = response.getResult();

            System.out.println(deleteTagsResult.toString());
            // end-delete_tag_all
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }
    }
}
