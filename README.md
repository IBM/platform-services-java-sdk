[![Build Status](https://travis-ci.com/IBM/platform-services-java-sdk.svg?branch=master)](https://travis-ci.com/IBM/platform-services-java-sdk)
[![Javadoc](https://img.shields.io/static/v1?label=javadoc&message=latest&color=blue)](https://ibm.github.io/platform-services-java-sdk/docs/latest)
[![Release](https://img.shields.io/github/v/release/IBM/platform-services-java-sdk)](https://github.com/IBM/platform-services-java-sdk/releases/latest)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![codecov](https://codecov.io/gh/IBM/platform-services-java-sdk/branch/master/graph/badge.svg)](https://codecov.io/gh/IBM/platform-services-java-sdk)
[![semantic-release](https://img.shields.io/badge/%20%20%F0%9F%93%A6%F0%9F%9A%80-semantic--release-e10079.svg)](https://github.com/semantic-release/semantic-release)


# IBM Cloud Platform Services Java SDK Version 0.7.0

Java client library to interact with various 
[IBM Cloud Platform Service APIs](https://cloud.ibm.com/docs?tab=api-docs&category=platform_services).

Disclaimer: this SDK is being released initially as a **pre-release** version.
Changes might occur which impact applications that use this SDK.

## Table of Contents

<!--
  The TOC below is generated using the `markdown-toc` node package.

      https://github.com/jonschlinkert/markdown-toc

  You should regenerate the TOC after making changes to this file.

      npx markdown-toc --maxdepth 4 -i README.md
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

## Overview

The IBM Cloud Platform Services Java SDK allows developers to programmatically interact with the following IBM Cloud services:

Service Name | Artifact Coordinates
--- | --- 
[Case Management](https://cloud.ibm.com/apidocs/case-management) | com.ibm.com:case-management:0.7.0
[Catalog Management](https://cloud.ibm.com/apidocs/resource-catalog/private-catalog) | com.ibm.com:catalog-management:0.7.0
[Enterprise Management](https://cloud.ibm.com/apidocs/enterprise-apis/enterprise) | com.ibm.com:enterprise-management:0.7.0
[Global Catalog](https://cloud.ibm.com/apidocs/resource-catalog/global-catalog) | com.ibm.com:global-catalog:0.7.0
[Global Search](https://cloud.ibm.com/apidocs/search) | com.ibm.com:global-search:0.7.0
[Global Tagging](https://cloud.ibm.com/apidocs/tagging) | com.ibm.com:global-tagging:0.7.0
[IAM Access Groups](https://cloud.ibm.com/apidocs/iam-access-groups) | com.ibm.com:iam-access-groups:0.7.0
[IAM Policy Management](https://cloud.ibm.com/apidocs/iam-policy-management) | com.ibm.com:iam-policy-management:0.7.0
[Resource Manager](https://cloud.ibm.com/apidocs/resource-controller/resource-manager) | com.ibm.com:resource-manager:0.7.0

## Prerequisites

[ibm-cloud-onboarding]: https://cloud.ibm.com/registration

* An [IBM Cloud][ibm-cloud-onboarding] account.
* An IAM API key to allow the SDK to access your account. Create one [here](https://cloud.ibm.com/iam/apikeys).
* Java 8 or above.

## Installation
The current version of this SDK is: 0.7.0

Each service's artifact coordinates are listed in the table above.

The project artifacts are published on the following public maven repositories:
- [JCenter](https://bintray.com/bintray/jcenter) - For information on how to use the
public JCenter maven repository, open [this link](https://bintray.com/bintray/jcenter)
then click the `Set Me Up!` button.
- [Maven Central](https://repo1.maven.org/maven2/) - This is the default public repository
used by maven when searching for dependencies.  To use this repository within your
gradle build, please see
[this link](https://docs.gradle.org/current/userguide/declaring_repositories.html).

To use a particular service, define a dependency that contains the
artifact coordinates (group id, artifact id and version) for the service, like this:

##### Maven

```xml
<dependency>
    <groupId>com.ibm.cloud</groupId>
    <artifactId>case-management</artifactId>
    <version>0.7.0</version>
</dependency>
```

##### Gradle
```gradle
'com.ibm.cloud:case-management:0.7.0'
```

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
