module.exports = {
  'root': true,
  'overrides': [
    {
      'env': {
        'node': true,
      },
      'files': ['**/*.js', '**/*.jsx'],
      'plugins': ['node', 'jest', 'prettier'],
      'extends': ['airbnb-base', 'plugin:jest/recommended', 'plugin:jest/style', 'prettier'],
      'rules': {
        'import/extensions': 'off',
        'no-underscore-dangle': 'off',
        'prefer-const': 'error',
        'prettier/prettier': 'error',
      },
    },
    {
      'files': ['examples/*.js', 'examples/*.jsx'],
      'rules': {
        'no-undef': 'off',
      },
    },
    {
      'files': ['*.test.js', '*.test.jsx'],
      'rules': {
        'jest/no-commented-out-tests': 'off',
        'jest/no-conditional-expect': 'off',
        'jest/no-done-callback': 'off',
        'jest/no-standalone-expect': 'off',
        'jest/no-try-expect': 'off',
        'no-await-in-loop': 'off',
        'no-plusplus': 'off',
        'no-prototype-builtins': 'off',
        'no-restricted-syntax': 'off',
        'no-shadow': 'off',
        'no-use-before-define': 'off',
      },
    },
    {
      'files': ['**/*.ts', '**/*.tsx'],
      'env': {
        'node': true,
      },
      'extends': ['airbnb-typescript/base', 'prettier'],
      'parser': '@typescript-eslint/parser',
      'parserOptions': {
        'project': 'tsconfig.json',
        'sourceType': 'module',
      },
      'plugins': ['eslint-plugin-jsdoc', 'eslint-plugin-import', '@typescript-eslint', 'prettier'],
      'rules': {
        '@typescript-eslint/naming-convention': 'off',
        '@typescript-eslint/no-unused-vars': 'off',
        'max-len': 'off',
        'no-param-reassign': 'off',
        'no-underscore-dangle': 'off',
        'prettier/prettier': 'error',
        'spaced-comment': ['error', 'always', { 'exceptions': ['*'] }],
      },
    },
  ],
};
