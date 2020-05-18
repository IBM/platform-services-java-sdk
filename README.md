[![Build Status](https://travis-ci.com/IBM/platform-services-java-sdk.svg?branch=master)](https://travis-ci.com/IBM/platform-services-java-sdk)
[![Javadoc](https://img.shields.io/static/v1?label=javadoc&message=latest&color=blue)](https://ibm.github.io/platform-services-java-sdk/docs/latest)
[![Release](https://img.shields.io/github/v/release/IBM/platform-services-java-sdk)](https://github.com/IBM/platform-services-java-sdk/releases/latest)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![codecov](https://codecov.io/gh/IBM/platform-services-java-sdk/branch/master/graph/badge.svg)](https://codecov.io/gh/IBM/platform-services-java-sdk)
[![semantic-release](https://img.shields.io/badge/%20%20%F0%9F%93%A6%F0%9F%9A%80-semantic--release-e10079.svg)](https://github.com/semantic-release/semantic-release)


# IBM Cloud Platform Services Java SDK Version 0.4.1

Java client library to interact with various 
[IBM Cloud Platform Service APIs](https://cloud.ibm.com/docs?tab=api-docs&category=platform_services).

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
    + [All the services](#all-the-services)
    + [A single service](#a-single-service)
- [Using the SDK](#using-the-sdk)
- [Questions](#questions)
- [Open source @ IBM](#open-source--ibm)
- [Contributing](#contributing)
- [License](#license)

<!-- tocstop -->

## Overview

The IBM Cloud Platform Services Java SDK allows developers to programmatically interact with the following IBM Cloud services:

Disclaimer: this SDK is being released initially as a **pre-release** version.
Changes might occur which impact applications that use this SDK.

Service Name | Artifact Id 
--- | --- 
[Case Management](https://cloud.ibm.com/apidocs/case-management) | case-management
[Global Catalog](https://cloud.ibm.com/apidocs/resource-catalog/global-catalog) | global-catalog
[Global Search](https://cloud.ibm.com/apidocs/search) | global-search
[Global Tagging](https://cloud.ibm.com/apidocs/tagging) | global-tagging
[IAM Access Groups](https://cloud.ibm.com/apidocs/iam-access-groups) | iam-access-groups
[Resource Manager](https://cloud.ibm.com/apidocs/resource-controller/resource-manager) | resource-manager

## Prerequisites

[ibm-cloud-onboarding]: https://cloud.ibm.com/registration

* An [IBM Cloud][ibm-cloud-onboarding] account.
* An IAM API key to allow the SDK to access your account. Create one [here](https://cloud.ibm.com/iam/apikeys).
* Java 8 or above.

## Installation
The current version of this SDK is: 0.4.1

#### All the services
To define a dependency on the entire set of services contained in the project, use a dependency like these:

##### Maven

```xml
<dependency>
	<groupId>com.ibm.cloud</groupId>
	<artifactId>platform-services</artifactId>
	<version>0.4.1</version>
</dependency>
```

##### Gradle

```gradle
'com.ibm.cloud:platform-services:0.4.1'
```

#### A single service
To define a dependency on a single service, use a dependency that contains the artifact id for the service, like this:

##### Maven

```xml
<dependency>
    <groupId>com.ibm.cloud</groupId>
    <artifactId>global-search</artifactId>
    <version>0.4.1</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.cloud:global-search:0.4.1'
```
Each service's artifact id is listed in the table above.

## Using the SDK
For general SDK usage information, please see [this link](https://github.com/IBM/ibm-cloud-sdk-common/blob/master/README.md)

## Questions

If you are having difficulties using this SDK or have a question about the IBM Cloud services,
please ask a question at
[Stack Overflow](http://stackoverflow.com/questions/ask?tags=ibm-cloud).

## Issues
If you encounter an issue with the project, you are welcome to submit a
[bug report](https://github.com/IBM/platform-services-java-sdk/issues).
Before that, please search for similar issues. It's possible that someone has already reported the problem.

## Open source @ IBM
Find more open source projects on the [IBM Github Page](http://ibm.github.io/)

## Contributing
See [CONTRIBUTING](CONTRIBUTING.md).

## License

The IBM Cloud Platform Services Java SDK is released under the Apache 2.0 license.
The license's full text can be found in
[LICENSE](LICENSE).
