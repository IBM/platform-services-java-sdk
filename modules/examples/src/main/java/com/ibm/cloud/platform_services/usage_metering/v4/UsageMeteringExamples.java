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

package com.ibm.cloud.platform_services.usage_metering.v4;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.cloud.platform_services.usage_metering.v4.model.MeasureAndQuantity;
import com.ibm.cloud.platform_services.usage_metering.v4.model.ReportResourceUsageOptions;
import com.ibm.cloud.platform_services.usage_metering.v4.model.ResourceInstanceUsage;
import com.ibm.cloud.platform_services.usage_metering.v4.model.ResponseAccepted;
import com.ibm.cloud.sdk.core.http.Response;
import com.ibm.cloud.sdk.core.service.exception.ServiceResponseException;

//
// This file provides an example of how to use the Usage Metering service.
//
// The following configuration properties are assumed to be defined:
//
// USAGE_METERING_URL=<service url>
// USAGE_METERING_AUTHTYPE=iam
// USAGE_METERING_APIKEY=<IAM api key of user with authority to create rules>
// USAGE_METERING_AUTH_URL=<IAM token service URL - omit this if using the production environment>
//
// These configuration properties can be exported as environment variables, or stored
// in a configuration file and then:
// export IBM_CREDENTIALS_FILE=<name of configuration file>
//
public class UsageMeteringExamples {
    private static final Logger logger = LoggerFactory.getLogger(UsageMeteringExamples.class);

    protected UsageMeteringExamples() {
    }

    static {
        System.setProperty("IBM_CREDENTIALS_FILE", "../../usage_metering.env");
    }

    public static void main(String[] args) throws Exception {
        UsageMetering service = UsageMetering.newInstance();

        try {
            // We'll use the same start and end time since we're reporting events.
            long startTime = System.currentTimeMillis();
            long endTime = startTime;

            String resourceId = "cloudant";
            String resourceInstanceId = "crn:v1:staging:public:cloudantnosqldb:us-south:a/f5086e3df886495991303628d21da513:3aafbbee-88e2-4d29-b144-9d267d97064c::";
            String planId = "cloudant-standard";
            String region = "us-south";

            // begin-report_resource_usage

            // Report usage for a mythical resource.
            // Use zero for quantities since this is only an example.
            MeasureAndQuantity lookupMeasure = new MeasureAndQuantity.Builder()
                    .measure("LOOKUP")
                    .quantity(Long.valueOf(0))
                    .build();
            MeasureAndQuantity writeMeasure = new MeasureAndQuantity.Builder()
                    .measure("WRITE")
                    .quantity(Long.valueOf(0))
                    .build();
            MeasureAndQuantity queryMeasure = new MeasureAndQuantity.Builder()
                    .measure("QUERY")
                    .quantity(Long.valueOf(0))
                    .build();
            MeasureAndQuantity gbMeasure = new MeasureAndQuantity.Builder()
                    .measure("GIGABYTE")
                    .quantity(Long.valueOf(0))
                    .build();
            List<MeasureAndQuantity> measures = new ArrayList<>();
            measures.add(lookupMeasure);
            measures.add(writeMeasure);
            measures.add(queryMeasure);
            measures.add(gbMeasure);

            ResourceInstanceUsage resourceInstanceUsageModel = new ResourceInstanceUsage.Builder()
                    .resourceInstanceId(resourceInstanceId)
                    .planId(planId)
                    .region(region)
                    .start(startTime)
                    .end(endTime)
                    .measuredUsage(measures)
                    .build();

            ReportResourceUsageOptions reportResourceUsageOptions = new ReportResourceUsageOptions.Builder()
                    .resourceId(resourceId)
                    .resourceUsage(new java.util.ArrayList<ResourceInstanceUsage>(
                            java.util.Arrays.asList(resourceInstanceUsageModel)))
                    .build();

            Response<ResponseAccepted> response = service.reportResourceUsage(reportResourceUsageOptions).execute();
            ResponseAccepted responseAccepted = response.getResult();

            System.out.printf("reportResourceUsage() result: %n %s %n", responseAccepted.toString());
            // end-report_resource_usage
        } catch (ServiceResponseException e) {
            logger.error(String.format("Service returned status code %s: %s\nError details: %s", e.getStatusCode(),
                    e.getMessage(), e.getDebuggingInfo()), e);
        }
    }
}
