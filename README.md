[![Build Status](https://travis-ci.com/IBM/platform-services-node-sdk.svg?branch=main)](https://travis-ci.com/IBM/platform-services-node-sdk)
[![Release](https://img.shields.io/github/v/release/IBM/platform-services-node-sdk)](https://github.com/IBM/platform-services-node-sdk/releases/latest)
[![npm](https://img.shields.io/npm/v/@ibm-cloud/platform-services)](https://www.npmjs.com/package/@ibm-cloud/platform-services)
![npm](https://img.shields.io/npm/dm/@ibm-cloud/platform-services)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![codecov](https://codecov.io/gh/IBM/platform-services-node-sdk/branch/main/graph/badge.svg)](https://codecov.io/gh/IBM/platform-services-node-sdk)
[![semantic-release](https://img.shields.io/badge/%20%20%F0%9F%93%A6%F0%9F%9A%80-semantic--release-e10079.svg)](https://github.com/semantic-release/semantic-release)
[![CLA assistant](https://cla-assistant.io/readme/badge/IBM/platform-services-node-sdk)](https://cla-assistant.io/IBM/platform-services-node-sdk)


# IBM Cloud Platform Services Node.js SDK

Node.js client library to interact with various 
[IBM Cloud Platform Service APIs](https://cloud.ibm.com/docs?tab=api-docs&category=platform_services).

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
## Migration

`ibm-platform-services` package has been deprecated! 
The Platform Services Node SDK is now available as `@ibm-cloud/platform-services`.

To migrate to the new package, you can use the commands listed below:

```
npm uninstall ibm-platform-services
npm install @ibm-cloud/platform-services
```

You will also need to modify any references to the old package `ibm-platform-services` within import/require statements so they reflect the new package `@ibm-cloud/platform-services`.  Here is an example:

```javascript

// A 'require' statement that reflects the old package name:
const UserManagementV1 = require('ibm-platform-services/user-management/v1');

// Modify this to reflect the new package name:
const UserManagementV1 = require('@ibm-cloud/platform-services/user-management/v1');

```

## Overview

The IBM Cloud Platform Services Node.js SDK allows developers to programmatically interact with the following 
IBM Cloud services:

Service Name | Import Path
--- | --- 
[Case Management](https://cloud.ibm.com/apidocs/case-management?code=node) | @ibm-cloud/platform-services/case-management/v1
[Catalog Management](https://cloud.ibm.com/apidocs/resource-catalog/private-catalog?code=node) | @ibm-cloud/platform-services/catalog-management/v1
[Configuration Governance](https://cloud.ibm.com/apidocs/security-compliance/config?code=node) | @ibm-cloud/platform-services/configuration-governance/v1
[Enterprise Billing Units](https://cloud.ibm.com/apidocs/enterprise-apis/billing-unit?code=node) | @ibm-cloud/platform-services/enterprise-billing-units/v1
[Enterprise Management](https://cloud.ibm.com/apidocs/enterprise-apis/enterprise?code=node) | @ibm-cloud/platform-services/enterprise-management/v1
[Enterprise Usage Reports](https://cloud.ibm.com/apidocs/enterprise-apis/resource-usage-reports?code=node) | @ibm-cloud/platform-services/enterprise-usage-reports/v1
[Global Catalog](https://cloud.ibm.com/apidocs/resource-catalog/global-catalog?code=node) | @ibm-cloud/platform-services/global-catalog/v1
[Global Search](https://cloud.ibm.com/apidocs/search?code=node) | @ibm-cloud/platform-services/global-search/v2
[Global Tagging](https://cloud.ibm.com/apidocs/tagging?code=node) | @ibm-cloud/platform-services/global-tagging/v1
[IAM Access Groups](https://cloud.ibm.com/apidocs/iam-access-groups?code=node) | @ibm-cloud/platform-services/iam-access-groups/v2
[IAM Identity Service](https://cloud.ibm.com/apidocs/iam-identity-token-api?code=node) | @ibm-cloud/platform-services/iam-identity/v1
[IAM Policy Management](https://cloud.ibm.com/apidocs/iam-policy-management?code=node) | @ibm-cloud/platform-services/iam-policy-management/v1
[IBM Cloud Shell](https://cloud.ibm.com/apidocs/cloudshell?code=node) | @ibm-cloud/platform-services/ibm-cloud-shell/v1
[Open Service Broker](https://cloud.ibm.com/apidocs/resource-controller/ibm-cloud-osb-api?code=node) | @ibm-cloud/platform-services/open-service-broker/v1
[Posture Management](https://cloud.ibm.com/apidocs/security-compliance/posture?code=node) | @ibm-cloud/platform-services/posture-management/v1
[Resource Controller](https://cloud.ibm.com/apidocs/resource-controller/resource-controller?code=node) | @ibm-cloud/platform-services/resource-controller/v2
[Resource Manager](https://cloud.ibm.com/apidocs/resource-controller/resource-manager?code=node) | @ibm-cloud/platform-services/resource-manager/v2
[Usage Metering](https://cloud.ibm.com/apidocs/usage-metering?code=node) | @ibm-cloud/platform-services/usage-metering/v4
[Usage Reports](https://cloud.ibm.com/apidocs/metering-reporting?code=node) | @ibm-cloud/platform-services/usage-reports/v4
[User Management](https://cloud.ibm.com/apidocs/user-management?code=node) | @ibm-cloud/platform-services/user-management/v1

## Prerequisites
* You need an [IBM Cloud][ibm-cloud-onboarding] account.
* **Node.js >=12**: This SDK is tested with Node.js versions 12 and up. It may work on previous versions but this is not officially supported.

[ibm-cloud-onboarding]: http://cloud.ibm.com/registration

## Installation

```sh
npm install @ibm-cloud/platform-services
```

## Using the SDK
For general SDK usage information, please see [this link](https://github.com/IBM/ibm-cloud-sdk-common/blob/main/README.md)

## Questions

If you are having difficulties using this SDK or have a question about the IBM Cloud services,
please ask a question at
[Stack Overflow](http://stackoverflow.com/questions/ask?tags=ibm-cloud).

## Issues
If you encounter an issue with the SDK, you are welcome to submit
a [bug report](https://github.com/IBM/platform-services-node-sdk/issues).
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
