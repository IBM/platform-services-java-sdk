#!/usr/bin/env bash
set -x

echo "Importing signing key..."
openssl aes-256-cbc -K $encrypted_4b7d603e7466_key -iv $encrypted_4b7d603e7466_iv -in build/signing.key.enc -out build/signing.key -d

gpg --version
gpg --batch --import build/signing.key
rm build/signing.key

echo "Signing key import finished!"
