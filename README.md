[![Build Status](https://travis-ci.com/IBM/platform-services-node-sdk.svg?branch=master)](https://travis-ci.com/IBM/platform-services-node-sdk)
[![Release](https://img.shields.io/github/v/release/IBM/platform-services-node-sdk)](https://github.com/IBM/platform-services-node-sdk/releases/latest)
[![npm](https://img.shields.io/npm/v/ibm-platform-services)](https://www.npmjs.com/package/ibm-platform-services)
![npm](https://img.shields.io/npm/dm/ibm-platform-services)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![codecov](https://codecov.io/gh/IBM/platform-services-node-sdk/branch/master/graph/badge.svg)](https://codecov.io/gh/IBM/platform-services-node-sdk)
[![semantic-release](https://img.shields.io/badge/%20%20%F0%9F%93%A6%F0%9F%9A%80-semantic--release-e10079.svg)](https://github.com/semantic-release/semantic-release)

# IBM Cloud Platform Services Node.js SDK

Node.js client library to interact with various 
[IBM Cloud Platform Service APIs](https://cloud.ibm.com/docs?tab=api-docs&category=platform_services).

Disclaimer: this SDK is being released initially as a **pre-release** version.
Changes might occur which impact applications that use this SDK.

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
[Case Management](https://cloud.ibm.com/apidocs/case-management) | ibm-platform-services/case-management/v1
[Global Catalog](https://cloud.ibm.com/apidocs/resource-catalog/global-catalog) | ibm-platform-services/global-catalog/v1
[Global Search](https://cloud.ibm.com/apidocs/search) | ibm-platform-services/global-search/v2
[Global Tagging](https://cloud.ibm.com/apidocs/tagging) | ibm-platform-services/global-tagging/v1
[IAM Access Groups](https://cloud.ibm.com/apidocs/iam-access-groups) | ibm-platform-services/iam-access-groups/v2
[Resource Manager](https://cloud.ibm.com/apidocs/iam-access-groups) | ibm-platform-services/resource-manager/v2

## Prerequisites
* You need an [IBM Cloud][ibm-cloud-onboarding] account.
* **Node.js >=10**: This SDK is tested with Node.js versions 10 and up. It may work on previous versions but this is not officially supported.

[ibm-cloud-onboarding]: http://cloud.ibm.com/registration

## Installation

```sh
npm install ibm-platform-services
```

## Using the SDK
For general SDK usage information, please see [this link](https://github.com/IBM/ibm-cloud-sdk-common/blob/master/README.md)

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
