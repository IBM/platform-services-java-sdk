/* eslint-disable no-console */
/**
 * (C) Copyright IBM Corp. 2020.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
'use strict';

const CaseManagementV1 = require('../../dist/case-management/v1');
const authHelper = require('../resources/auth-helper.js');

// testcase timeout value (120s).
const timeout = 120000;

// Location of our config file.
const configFile = 'case_management.env';

// Use authHelper to skip tests if our configFile is not available.
const describe = authHelper.prepareTests(configFile);

describe('CaseManagementV1_integration', () => {
  jest.setTimeout(timeout);

  // global values used in various test cases
  let service;
  let caseNumber;
  let attachmentId;

  // Test payload
  const commentValue = 'Test comment';
  const offeringPayload = {
    name: 'Cloud Object Storage',
    type: {
      group: 'crn_service_name',
      key: 'cloud-object-storage',
    },
  };

  const resourceCrn = 'crn:v1:staging:public:cloud-object-storage:global:a/19c52e57800c4d8bb9aefc66b3e49755:61848e72-6ba6-415e-84e2-91f3915e194d::';

  const watchlistPayload = [
    {
      realm: 'IBMid',
      user_id: 'abc@ibm.com',
    },
  ];

  const attachmentPayload = {
    filename: 'NodeJS SDK test file.png',
    data: Buffer.from('This is a mock file.', 'utf8'),
    contentType: 'image/png',
  };

  test('should successfully complete initialization', done => {
    // Initialize the service client.
    service = CaseManagementV1.newInstance();
    expect(service).not.toBeNull();
    done();
  });

  describe('Create a case', () => {
    let params;
    let response;

    beforeEach(() => {
      params = {
        type: 'technical',
        subject: 'Test case for NodeJS SDK',
        description: 'Test case for NodeJS SDK',
        severity: 4,
        offering: offeringPayload,
      };
      response = undefined;
    });

    test('Successfully created a technical case', async done => {
      try {
        response = await service.createCase(params);
        expect(response).toBeDefined();
        expect(response.status).toEqual(200);
        const { result } = response || {};

        expect(result).toBeDefined();
        expect(result.number).toBeDefined();
        expect(result.short_description).toEqual(params.subject);
        expect(result.description).toEqual(params.description);

        caseNumber = result.number;
        console.log('\nCase number: ', caseNumber);

        done();
      } catch (err) {
        done(err);
      }
    });

    test('Bad payload used to create a case', async done => {
      params.type = 'invalid_type';
      params.severity = null;
      params.offering = null;

      try {
        response = await service.createCase(params);
      } catch (err) {
        expect(err.status).toEqual(400);
        done();
      }

      done();
    });
  });

  describe('Get cases', () => {
    let params;
    let response;

    beforeEach(() => {
      response = undefined;
      params = {};
    });

    test('Successfully got cases with default params', async done => {
      try {
        response = await service.getCases();
        expect(response).toBeDefined();
        expect(response.status).toEqual(200);
        const { result } = response || {};

        expect(result.total_count).toBeDefined();
        expect(result.first).toBeDefined();
        expect(result.last).toBeDefined();
        expect(result.cases).toBeDefined();

        done();
      } catch (err) {
        done(err);
      }
    });

    test('Successful got cases with non-default params', async done => {
      params = {
        offset: 10,
        limit: 20,
        fields: [CaseManagementV1.GetCaseConstants.Fields.NUMBER, CaseManagementV1.GetCaseConstants.Fields.SHORT_DESCRIPTION, CaseManagementV1.GetCaseConstants.Fields.SEVERITY],
      };

      try {
        response = await service.getCases(params);
        expect(response).toBeDefined();
        expect(response.status).toEqual(200);
        const { result } = response || {};

        expect(result.total_count).toBeDefined();
        expect(result.first).toBeDefined();
        expect(result.last).toBeDefined();
        expect(result.cases).toBeDefined();

        const testCase = result.cases[0];
        expect(testCase).toBeDefined();
        expect(testCase.number).toBeDefined();
        expect(testCase.short_description).toBeDefined();
        expect(testCase.severity).toBeDefined();
        expect(testCase.comments).not.toBeDefined();

        done();
      } catch (err) {
        done(err);
      }
    });

    test('Failed to get cases with bad params', async done => {
      params.fields = ['invalid_field'];

      try {
        response = await service.getCases(params);
      } catch (err) {
        expect(err).toBeDefined();
        expect(err.status).toEqual(400);
        done();
        return;
      }

      done('Expected error response');
    });
  });

  describe('Get a specific case', () => {
    let params;
    let response;

    beforeEach(() => {
      response = undefined;
      params = {
        caseNumber,
      };
    });

    test('Successfully got a case with default params', async done => {
      try {
        response = await service.getCase(params);
        expect(response).toBeDefined();
        expect(response.status).toEqual(200);
        const { result } = response || {};

        expect(result.number).toEqual(caseNumber);

        done();
      } catch (err) {
        done(err);
      }
    });

    test('Successfully got a case with field filtering', async done => {
      params.fields = [CaseManagementV1.GetCaseConstants.Fields.NUMBER, CaseManagementV1.GetCaseConstants.Fields.SEVERITY];

      try {
        response = await service.getCase(params);
        expect(response).toBeDefined();
        expect(response.status).toEqual(200);
        const { result } = response || {};

        expect(result.number).toEqual(caseNumber);
        expect(result.severity).toBeDefined();
        expect(result.contact).not.toBeDefined();

        done();
      } catch (err) {
        done(err);
      }
    });

    test('Failed to get a case with bad params', async done => {
      params.fields = ['invalid_field'];

      try {
        response = await service.getCase(params);
      } catch (err) {
        expect(err).toBeDefined();
        expect(err.status).toEqual(400);
        done();
        return;
      }

      done('Expected error response');
    });
  });

  describe('Add comment', () => {
    let params;
    let response;

    beforeEach(() => {
      params = {
        caseNumber,
        comment: commentValue,
      };

      response = undefined;
    });

    test('Successfully added a comment to a case', async done => {
      try {
        response = await service.addComment(params);
        expect(response).toBeDefined();
        expect(response.status).toEqual(200);

        const { result } = response || {};
        expect(result.value).toEqual(commentValue);
        done();
      } catch (err) {
        done(err);
      }
    });
  });

  describe('Modify watchlist', () => {
    let params;
    let response;

    beforeEach(() => {
      params = {
        caseNumber,
        watchlist: watchlistPayload,
      };
      response = undefined;
    });

    test('Successfully added user to case watchlist', async done => {
      try {
        response = await service.addWatchlist(params);
        expect(response).toBeDefined();
        expect(response.status).toEqual(200);

        const { result } = response || {};

        // We expect the call to fail because the fake user is not associated with the account.
        expect(result.failed.length).toEqual(params.watchlist.length);
        done();
      } catch (err) {
        done(err);
      }
    });

    test('Successfully removed users from case watchlist', async done => {
      try {
        response = await service.removeWatchlist(params);
        expect(response).toBeDefined();
        expect(response.status).toEqual(200);

        done();
      } catch (err) {
        done(err);
      }
    });
  });

  describe('Update status', () => {
    let params;
    let response;

    test('Succefully resolve a case', async done => {
      params = {
        caseNumber,
        statusPayload: {
          action: 'resolve',
          resolution_code: 2,
          comment: 'Test resolve',
        },
      };

      try {
        response = await service.updateCaseStatus(params);
        expect(response).toBeDefined();
        expect(response.status).toEqual(200);

        const { result } = response || {};
        expect(result.status).toEqual('Resolved');

        done();
      } catch (err) {
        done(err);
      }
    });

    test('Succefully unresolve a case', async done => {
      params = {
        caseNumber,
        statusPayload: {
          action: 'unresolve',
          comment: 'Test unresolve',
        },
      };

      try {
        response = await service.updateCaseStatus(params);
        expect(response).toBeDefined();
        expect(response.status).toEqual(200);

        const { result } = response || {};
        expect(result.status).toEqual('In Progress');

        done();
      } catch (err) {
        done(err);
      }
    });
  });

  describe('Working with attachments', () => {
    let params;
    let response;

    beforeEach(() => {
      response = undefined;
    });

    test('Successfully uploaded file', async done => {
      params = {
        caseNumber,
        file: attachmentPayload,
      };

      try {
        response = await service.uploadFile(params);
        expect(response).toBeDefined();
        expect(response.status).toEqual(200);

        const { result } = response || {};
        expect(result.id).toBeDefined();
        expect(result.filename).toEqual(params.file.filename);

        attachmentId = result.id;
        done();
      } catch (err) {
        done(err);
      }
    });

    test('Successfully downloaded a file', async done => {
      params = {
        caseNumber,
        fileId: attachmentId,
      };

      try {
        response = await service.downloadFile(params);
        expect(response).toBeDefined();
        expect(response.status).toEqual(200);

        const { result } = response || {};
        expect(result).toBeDefined();

        done();
      } catch (err) {
        done(err);
      }
    });

    test('Successfully deleted file', async done => {
      params = {
        caseNumber,
        fileId: attachmentId,
      };

      try {
        response = await service.deleteFile(params);
        expect(response).toBeDefined();
        expect(response.status).toEqual(200);

        done();
      } catch (err) {
        done(err);
      }
    });
  });

  describe('Add resource', () => {
    let params;
    let response;

    beforeEach(() => {
      params = {
        caseNumber,
        crn: resourceCrn,
      };
      response = undefined;
    });

    test('Successfully added a resource', async done => {
      try {
        response = await service.addResource(params);

        expect(response).toBeDefined();
        expect(response.status).toEqual(200);

        const { result } = response || {};
        expect(result.crn).toEqual(params.crn);

        done();
      } catch (err) {
        done(err);
      }
    });
  });
});
