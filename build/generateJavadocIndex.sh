#!/bin/sh

# based on https://odoepner.wordpress.com/2012/02/17/shell-script-to-generate-simple-index-html/

echo '<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>IBM Cloud Platform Services</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="page-header">
        <h1>IBM Cloud Platform Services Java SDK Documentation</h1>
    </div>

    <p><a href="https://cloud.ibm.com/apidocs?category=platform_services">Platform Services Info</a>
        | <a href="https://github.com/IBM/platform-services-java-sdk">GitHub</a>
    </p>

    <p>Javadoc by release:</p>
    <ul>'
echo ${TRAVIS_BRANCH} | sed 's/^.*/        <li><a href="docs\/&">Latest release<\/a><\/li>/'
ls docs | grep --invert-match index.html | sed 's/^.*/        <li><a href="docs\/&">&<\/a><\/li>/'
echo '    </ul>
</div>
</body>
</html>'
