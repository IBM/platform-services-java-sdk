
# For each service belonging to your project, add a reference to its
# generated source file to the command below.
./node_modules/.bin/typedoc --mode file --theme ./scripts/typedoc/theme --excludeExternals --excludePrivate --excludeProtected \
    --out ./doc \
    ./case-management/v1.ts \
    ./catalog-management/v1.ts \
    ./configuration-governance/v1.ts \
    ./enterprise-management/v1.ts \
    ./enterprise-usage-reports/v1.ts \
    ./global-catalog/v1.ts \
    ./global-search/v2.ts \
    ./global-tagging/v1.ts \
    ./iam-access-groups/v2.ts \
    ./iam-identity/v1.ts \
    ./iam-policy-management/v1.ts \
    ./open-service-broker/v1.ts \
    ./resource-controller/v2 \
    ./resource-manager/v2 \
    ./usage-reports/v4 \
    ./user-management/v1 \
    --target "ES5"
