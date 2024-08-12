#!/bin/bash
#
# * Copyright 2017 - 2024 IBM Corporation.
# * SPDX-License-Identifier: Apache2.0
#

#
# The purpose of this script is to revert changes to generated files where the file changed
# only in the copyright statement (i.e. no other differences in the file contents).
#
# Run this script in a git repo containing uncommitted changes produced from SDK generation.
#
# Usage:
#    <project-root>/scripts/fix-copyrights.sh
#

git diff --name-only | while read f; do
    # Must be only one line added and one deleted
    git diff --shortstat "$f" | grep "1 insertion(+), 1 deletion(-)" > /dev/null
    if [ $? == 0 ]; then
        git diff "$f" | grep "(C) Copyright IBM Corp\. 20[0-9][0-9]." > /dev/null
        if [ $? == 0 ]; then
            echo "Reverting copyright change in $f"
            git checkout -- "$f"
        fi
    fi
done
