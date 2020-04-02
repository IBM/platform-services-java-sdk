#!/bin/bash

# We'll publish javadocs ONLY for a tagged release build.
if [ -n "$TRAVIS_TAG" ]; then

    printf "\n>>>>> Publishing javadoc for release build: repo=%s branch=%s build_num=%s job_num=%s\n" ${TRAVIS_REPO_SLUG} ${TRAVIS_BRANCH} ${TRAVIS_BUILD_NUMBER} ${TRAVIS_JOB_NUMBER} 

    git config --global user.email "devxsdk@us.ibm.com"
    git config --global user.name "IBM Cloud SDK Developement"

    printf "\n>>>>> Cloning repository's gh-pages branch into directory 'gh-pages'"
    git clone --quiet --branch=gh-pages https://${GH_TOKEN}@github.com/IBM/platform-services-java-sdk.git gh-pages

    printf "\n>>>>> Finished cloning..."

    
    pushd gh-pages
    
    # Create a new directory for this tagged release and copy the aggregated javadocs there.
    printf "\n>>>>> Copying aggregated javadocs to new tagged-release directory: %s\n" ${TRAVIS_TAG}
    rm -rf docs/${TRAVIS_BRANCH}
    mkdir -p docs/${TRAVIS_BRANCH}
    cp -rf ../target/site/apidocs/* docs/${TRAVIS_BRANCH}

    printf "\n>>>>> Generating gh-pages index.html...\n"
    ../build/generate-index-html.sh > index.html

    # Update the latest symlink to point to this new tag
    pushd docs
    rm latest
    ln -s ./${TRAVIS_TAG} latest
    printf "\n>>>>> Updated 'docs/latest' symlink:\n"
    ls -l latest
    popd

    printf "\n>>>>> Committing new javadoc...\n"
    git add -f .
    git commit -m "Javadoc for release ${TRAVIS_TAG} (${TRAVIS_COMMIT})"
    git push -fq origin gh-pages

    popd

    printf "\n>>>>> Published javadoc for release build: repo=%s branch=%s build_num=%s job_num=%s\n"  ${TRAVIS_REPO_SLUG} ${TRAVIS_BRANCH} ${TRAVIS_BUILD_NUMBER} ${TRAVIS_JOB_NUMBER} 

else

    printf "\n>>>>> Javadoc publishing bypassed for non-release build: repo=%s branch=%s build_num=%s job_num=%s\n" ${TRAVIS_REPO_SLUG} ${TRAVIS_BRANCH} ${TRAVIS_BUILD_NUMBER} ${TRAVIS_JOB_NUMBER} 

fi
