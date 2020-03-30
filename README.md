# IBM Cloud Platform Node.js SDK
[![Build Status](https://travis.ibm.com/ibmcloud/platform-services-node-sdk.svg?token=eW5FVD71iyte6tTby8gr&branch=master)](https://travis.ibm.com/ibmcloud/platform-services-node-sdk)

Node.js client library to interact with various [IBM Cloud Platform Service APIs](https://cloud.ibm.com/apidocs?category=platform_services).

## Table of Contents

<!--
  The TOC below is generated using the `markdown-toc` node package.

      https://github.com/jonschlinkert/markdown-toc

  You should regenerate the TOC after making changes to this file.

      npx markdown-toc -i README.md
  -->

<!-- toc -->

- [Overview](#overview)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Using the SDK](#using-the-sdk)
- [Questions](#questions)
- [Issues](#issues)
- [Open source @ IBM](#open-source--ibm)
- [Contributing](#contributing)
- [License](#license)

<!-- tocstop -->

<!-- --------------------------------------------------------------- -->
## Overview

The IBM Cloud Platform Services Node.js SDK allows developers to programmatically interact with the following 
IBM Cloud services:

Service Name | Import Path
--- | --- 
[Case Management](https://cloud.ibm.com/apidocs/case-management) | ibm-cloud-platform/case-management/v1
[Enterprise Billing Units](https://cloud.ibm.com/apidocs/enterprise-apis/billing-unit) | ibm-cloud-platform/enterprise-billing-units/v1
[Enterprise Management](https://cloud.ibm.com/apidocs/enterprise-apis/enterprise) | ibm-cloud-platform/enterprise-management/v1
[Enterprise Usage Reports](https://cloud.ibm.com/apidocs/enterprise-apis/resource-usage-reports) | ibm-cloud-platform/enterprise-usage-reports/v1
[Global Resource Catalog](https://cloud.ibm.com/apidocs/globalcatalog) | ibm-cloud-platform/global-catalog/v1
[Global Search](https://cloud.ibm.com/apidocs/search) | ibm-cloud-platform/global-search/v2
[Global Tagging](https://cloud.ibm.com/apidocs/tagging) | ibm-cloud-platform/global-tagging/v1
[IAM Access Groups](https://cloud.ibm.com/apidocs/iam-access-groups) | ibm-cloud-platform/iam-access-groups/v2
[IAM Identity Services](https://cloud.ibm.com/apidocs/iam-identity-token-api) | ibm-cloud-platform/iam-identity-services/v1
[IAM Policy Management](https://cloud.ibm.com/apidocs/iam-policy-management) | ibm-cloud-platform/iam-policy-management/v1
[Open Services Broker](https://cloud.ibm.com/apidocs/resource-controller/ibm-cloud-osb-api) | ibm-cloud-platform/open-service-broker/v1
[Resource Controller](https://cloud.ibm.com/apidocs/resource-controller) | ibm-cloud-platform/resource-controller/v2
[Resource Manager](https://cloud.ibm.com/apidocs/resource-controller/resource-manager) | ibm-cloud-platform/resource-manager/v2
[Usage Metering](https://cloud.ibm.com/apidocs/usage-metering) | ibm-cloud-platform/usage-metering/v4
[Usage Reports](https://cloud.ibm.com/apidocs/usage-metering) | ibm-cloud-platform/usage-reports/v1
[User Management](https://cloud.ibm.com/apidocs/user-management) | ibm-cloud-platform/user-management/v1

## Prerequisites
* You need an [IBM Cloud][ibm-cloud-onboarding] account.
* **Node.js >=10**: This SDK is tested with Node.js versions 10 and up. It may work on previous versions but this is not officially supported.

[ibm-cloud-onboarding]: http://cloud.ibm.com/registration

## Installation

```sh
npm install ibm-cloud-platform
```

## Using the SDK
For general SDK usage information, please see [this link](https://github.com/IBM/ibm-cloud-sdk-common/blob/master/README.md)

## Questions

If you are having difficulties using this SDK or have a question about the IBM Cloud services,
please ask a question at [dW Answers](https://developer.ibm.com/answers/questions/ask/?topics=ibm-cloud) or
[Stack Overflow](http://stackoverflow.com/questions/ask?tags=ibm-cloud).

## Issues
If you encounter an issue with the SDK, you are welcome to submit
a [bug report](https://github.ibm.com/ibmcloud/platform-services-node-sdk/issues).
Before that, please search for similar issues. It's possible someone has
already encountered this issue.

## Open source @ IBM
Find more open source projects on the [IBM Github Page](http://ibm.github.io/)

## Contributing
See [CONTRIBUTING](CONTRIBUTING.md).

## License

The IBM Cloud Platform Services Node.js SDK is released under the Apache 2.0 license.
The license's full text can be found in
[LICENSE](LICENSE).
