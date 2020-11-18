#!/bin/bash

if [ $# -lt 5 ]
then
    echo "
 Syntax:  
      $0 <bintray-user> <bintray-apikey> <bintray-repo-owner> <bintray-reponame> <bintray-packageversion>>
 Example:
      $0 btuser1 btapikey1 bintray-org1 bintray-repo1 0.0.1
"

 exit 1
fi

user=$1
apikey=$2
subject=$3
reponame=$4
pkgversion=$5

package_names="
com.ibm.cloud:platform-services
com.ibm.cloud:platform-services-common
com.ibm.cloud:case-management
com.ibm.cloud:catalog-management
com.ibm.cloud:configuration-governance
com.ibm.cloud:enterprise-management
com.ibm.cloud:enterprise-usage-reports
com.ibm.cloud:global-catalog
com.ibm.cloud:global-search
com.ibm.cloud:global-tagging
com.ibm.cloud:iam-access-groups
com.ibm.cloud:iam-identity
com.ibm.cloud:iam-policy-management
com.ibm.cloud:open-service-broker
com.ibm.cloud:resource-controller
com.ibm.cloud:resource-manager
com.ibm.cloud:usage-reports
com.ibm.cloud:user-management"

this_dir=`dirname "$0"`

for pkg in ${package_names}
do
    $this_dir/sync2MC.sh $user $apikey $subject $reponame $pkg $pkgversion 
done
	   
