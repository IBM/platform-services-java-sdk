#!/usr/bin/env bash
set -x

echo "Importing signing key..."
openssl aes-256-cbc -K $encrypted_4c2ca4326cdc_key -iv $encrypted_4c2ca4326cdc_iv -in build/signing.key.enc -out build/signing.key -d
gpg --version
gpg --fast-import build/signing.key
rm build/signing.key
echo "Signing key import finished!"
