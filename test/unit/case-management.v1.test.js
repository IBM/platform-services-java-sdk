/**
 * (C) Copyright IBM Corp. 2020.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
'use strict';

// need to import the whole package to mock getAuthenticatorFromEnvironment
const core = require('ibm-cloud-sdk-core');
const { NoAuthAuthenticator, unitTestUtils } = core;

const CaseManagementV1 = require('../../dist/case-management/v1');

const {
  getOptions,
  checkUrlAndMethod,
  checkMediaHeaders,
  expectToBePromise,
  checkForSuccessfulExecution,
} = unitTestUtils;

const service = {
  authenticator: new NoAuthAuthenticator(),
  url: 'https://support-center.cloud.ibm.com/case-management/v1',
};

const caseManagement = new CaseManagementV1(service);

// dont actually create a request
const createRequestMock = jest.spyOn(caseManagement, 'createRequest');
createRequestMock.mockImplementation(() => Promise.resolve());

// dont actually construct an authenticator
const getAuthenticatorMock = jest.spyOn(core, 'getAuthenticatorFromEnvironment');
getAuthenticatorMock.mockImplementation(() => new NoAuthAuthenticator());

afterEach(() => {
  createRequestMock.mockClear();
  getAuthenticatorMock.mockClear();
});

describe('CaseManagementV1', () => {
  describe('the newInstance method', () => {
    test('should use defaults when options not provided', () => {
      const testInstance = CaseManagementV1.newInstance();

      expect(getAuthenticatorMock).toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceName).toBe(CaseManagementV1.DEFAULT_SERVICE_NAME);
      expect(testInstance.baseOptions.serviceUrl).toBe(CaseManagementV1.DEFAULT_SERVICE_URL);
      expect(testInstance).toBeInstanceOf(CaseManagementV1);
    });

    test('should set serviceName, serviceUrl, and authenticator when provided', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
        serviceName: 'my-service',
      };

      const testInstance = CaseManagementV1.newInstance(options);

      expect(getAuthenticatorMock).not.toHaveBeenCalled();
      expect(testInstance.baseOptions.authenticator).toBeInstanceOf(NoAuthAuthenticator);
      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
      expect(testInstance.baseOptions.serviceName).toBe('my-service');
      expect(testInstance).toBeInstanceOf(CaseManagementV1);
    });
  });
  describe('the constructor', () => {
    test('use user-given service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
        serviceUrl: 'custom.com',
      };

      const testInstance = new CaseManagementV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe('custom.com');
    });

    test('use default service url', () => {
      const options = {
        authenticator: new NoAuthAuthenticator(),
      };

      const testInstance = new CaseManagementV1(options);

      expect(testInstance.baseOptions.serviceUrl).toBe(CaseManagementV1.DEFAULT_SERVICE_URL);
    });
  });
  describe('getCases', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getCases
        const offset = 38;
        const limit = 38;
        const search = 'testString';
        const sort = 'number';
        const status = ['new'];
        const fields = ['number'];
        const params = {
          offset: offset,
          limit: limit,
          search: search,
          sort: sort,
          status: status,
          fields: fields,
        };

        const getCasesResult = caseManagement.getCases(params);

        // all methods should return a Promise
        expectToBePromise(getCasesResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/cases', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['offset']).toEqual(offset);
        expect(options.qs['limit']).toEqual(limit);
        expect(options.qs['search']).toEqual(search);
        expect(options.qs['sort']).toEqual(sort);
        expect(options.qs['status']).toEqual(status);
        expect(options.qs['fields']).toEqual(fields);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        caseManagement.getCases(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });

      test('should not have any problems when no parameters are passed in', () => {
        // invoke the method with no parameters
        caseManagement.getCases({});
        checkForSuccessfulExecution(createRequestMock);
      });
    });
  });
  describe('createCase', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // CasePayloadEu
      const casePayloadEuModel = {
        supported: true,
        data_center: 38,
      };

      // OfferingType
      const offeringTypeModel = {
        group: 'crn_service_name',
        key: 'testString',
        kind: 'testString',
        id: 'testString',
      };

      // Offering
      const offeringModel = {
        name: 'testString',
        type: offeringTypeModel,
      };

      // ResourcePayload
      const resourcePayloadModel = {
        crn: 'testString',
        type: 'testString',
        id: 72.5,
        note: 'testString',
      };

      // User
      const userModel = {
        realm: 'IBMid',
        user_id: 'abc@ibm.com',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation createCase
        const type = 'technical';
        const subject = 'testString';
        const description = 'testString';
        const severity = 1;
        const eu = casePayloadEuModel;
        const offering = offeringModel;
        const resources = [resourcePayloadModel];
        const watchlist = [userModel];
        const invoiceNumber = 'testString';
        const slaCreditRequest = true;
        const params = {
          type: type,
          subject: subject,
          description: description,
          severity: severity,
          eu: eu,
          offering: offering,
          resources: resources,
          watchlist: watchlist,
          invoiceNumber: invoiceNumber,
          slaCreditRequest: slaCreditRequest,
        };

        const createCaseResult = caseManagement.createCase(params);

        // all methods should return a Promise
        expectToBePromise(createCaseResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/cases', 'POST');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['type']).toEqual(type);
        expect(options.body['subject']).toEqual(subject);
        expect(options.body['description']).toEqual(description);
        expect(options.body['severity']).toEqual(severity);
        expect(options.body['eu']).toEqual(eu);
        expect(options.body['offering']).toEqual(offering);
        expect(options.body['resources']).toEqual(resources);
        expect(options.body['watchlist']).toEqual(watchlist);
        expect(options.body['invoice_number']).toEqual(invoiceNumber);
        expect(options.body['sla_credit_request']).toEqual(slaCreditRequest);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const type = 'technical';
        const subject = 'testString';
        const description = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          type,
          subject,
          description,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        caseManagement.createCase(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await caseManagement.createCase({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const createCasePromise = caseManagement.createCase();
        expectToBePromise(createCasePromise);

        createCasePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('getCase', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation getCase
        const caseNumber = 'testString';
        const fields = ['number'];
        const params = {
          caseNumber: caseNumber,
          fields: fields,
        };

        const getCaseResult = caseManagement.getCase(params);

        // all methods should return a Promise
        expectToBePromise(getCaseResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/cases/{case_number}', 'GET');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.qs['fields']).toEqual(fields);
        expect(options.path['case_number']).toEqual(caseNumber);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const caseNumber = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          caseNumber,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        caseManagement.getCase(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await caseManagement.getCase({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const getCasePromise = caseManagement.getCase();
        expectToBePromise(getCasePromise);

        getCasePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('updateCaseStatus', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // ResolvePayload
      const statusPayloadModel = {
        action: 'resolve',
        comment: 'testString',
        resolution_code: 1,
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation updateCaseStatus
        const caseNumber = 'testString';
        const statusPayload = { action: 'resolve', comment: 'It was actually a mistake', resolution_code: 1 };
        const params = {
          caseNumber: caseNumber,
          statusPayload: statusPayload,
        };

        const updateCaseStatusResult = caseManagement.updateCaseStatus(params);

        // all methods should return a Promise
        expectToBePromise(updateCaseStatusResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/cases/{case_number}/status', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body).toEqual(statusPayload);
        expect(options.path['case_number']).toEqual(caseNumber);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const caseNumber = 'testString';
        const statusPayload = { action: 'resolve', comment: 'It was actually a mistake', resolution_code: 1 };
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          caseNumber,
          statusPayload,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        caseManagement.updateCaseStatus(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await caseManagement.updateCaseStatus({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const updateCaseStatusPromise = caseManagement.updateCaseStatus();
        expectToBePromise(updateCaseStatusPromise);

        updateCaseStatusPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('addComment', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation addComment
        const caseNumber = 'testString';
        const comment = 'This is a test comment';
        const params = {
          caseNumber: caseNumber,
          comment: comment,
        };

        const addCommentResult = caseManagement.addComment(params);

        // all methods should return a Promise
        expectToBePromise(addCommentResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/cases/{case_number}/comments', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['comment']).toEqual(comment);
        expect(options.path['case_number']).toEqual(caseNumber);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const caseNumber = 'testString';
        const comment = 'This is a test comment';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          caseNumber,
          comment,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        caseManagement.addComment(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await caseManagement.addComment({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const addCommentPromise = caseManagement.addComment();
        expectToBePromise(addCommentPromise);

        addCommentPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('addWatchlist', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // User
      const userModel = {
        realm: 'IBMid',
        user_id: 'abc@ibm.com',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation addWatchlist
        const caseNumber = 'testString';
        const watchlist = [userModel];
        const params = {
          caseNumber: caseNumber,
          watchlist: watchlist,
        };

        const addWatchlistResult = caseManagement.addWatchlist(params);

        // all methods should return a Promise
        expectToBePromise(addWatchlistResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/cases/{case_number}/watchlist', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['watchlist']).toEqual(watchlist);
        expect(options.path['case_number']).toEqual(caseNumber);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const caseNumber = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          caseNumber,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        caseManagement.addWatchlist(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await caseManagement.addWatchlist({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const addWatchlistPromise = caseManagement.addWatchlist();
        expectToBePromise(addWatchlistPromise);

        addWatchlistPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('removeWatchlist', () => {
    describe('positive tests', () => {
      // Request models needed by this operation.

      // User
      const userModel = {
        realm: 'IBMid',
        user_id: 'abc@ibm.com',
      };

      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation removeWatchlist
        const caseNumber = 'testString';
        const watchlist = [userModel];
        const params = {
          caseNumber: caseNumber,
          watchlist: watchlist,
        };

        const removeWatchlistResult = caseManagement.removeWatchlist(params);

        // all methods should return a Promise
        expectToBePromise(removeWatchlistResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/cases/{case_number}/watchlist', 'DELETE');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['watchlist']).toEqual(watchlist);
        expect(options.path['case_number']).toEqual(caseNumber);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const caseNumber = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          caseNumber,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        caseManagement.removeWatchlist(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await caseManagement.removeWatchlist({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const removeWatchlistPromise = caseManagement.removeWatchlist();
        expectToBePromise(removeWatchlistPromise);

        removeWatchlistPromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('addResource', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation addResource
        const caseNumber = 'testString';
        const crn = 'testString';
        const type = 'testString';
        const id = 72.5;
        const note = 'testString';
        const params = {
          caseNumber: caseNumber,
          crn: crn,
          type: type,
          id: id,
          note: note,
        };

        const addResourceResult = caseManagement.addResource(params);

        // all methods should return a Promise
        expectToBePromise(addResourceResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/cases/{case_number}/resources', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'application/json';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.body['crn']).toEqual(crn);
        expect(options.body['type']).toEqual(type);
        expect(options.body['id']).toEqual(id);
        expect(options.body['note']).toEqual(note);
        expect(options.path['case_number']).toEqual(caseNumber);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const caseNumber = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          caseNumber,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        caseManagement.addResource(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await caseManagement.addResource({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const addResourcePromise = caseManagement.addResource();
        expectToBePromise(addResourcePromise);

        addResourcePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('uploadFile', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation uploadFile
        const caseNumber = 'testString';
        const file = [Buffer.from('This is a mock file.')];
        const params = {
          caseNumber: caseNumber,
          file: file,
        };

        const uploadFileResult = caseManagement.uploadFile(params);

        // all methods should return a Promise
        expectToBePromise(uploadFileResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/cases/{case_number}/attachments', 'PUT');
        const expectedAccept = 'application/json';
        const expectedContentType = 'multipart/form-data';
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.formData['file']).toEqual(file);
        expect(options.path['case_number']).toEqual(caseNumber);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const caseNumber = 'testString';
        const file = [Buffer.from('This is a mock file.')];
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          caseNumber,
          file,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        caseManagement.uploadFile(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await caseManagement.uploadFile({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const uploadFilePromise = caseManagement.uploadFile();
        expectToBePromise(uploadFilePromise);

        uploadFilePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('downloadFile', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation downloadFile
        const caseNumber = 'testString';
        const fileId = 'testString';
        const params = {
          caseNumber: caseNumber,
          fileId: fileId,
        };

        const downloadFileResult = caseManagement.downloadFile(params);

        // all methods should return a Promise
        expectToBePromise(downloadFileResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/cases/{case_number}/attachments/{file_id}', 'GET');
        const expectedAccept = 'application/octet-stream';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['case_number']).toEqual(caseNumber);
        expect(options.path['file_id']).toEqual(fileId);
        expect(options.responseType).toBe('stream');
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const caseNumber = 'testString';
        const fileId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          caseNumber,
          fileId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        caseManagement.downloadFile(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await caseManagement.downloadFile({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const downloadFilePromise = caseManagement.downloadFile();
        expectToBePromise(downloadFilePromise);

        downloadFilePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
  describe('deleteFile', () => {
    describe('positive tests', () => {
      test('should pass the right params to createRequest', () => {
        // Construct the params object for operation deleteFile
        const caseNumber = 'testString';
        const fileId = 'testString';
        const params = {
          caseNumber: caseNumber,
          fileId: fileId,
        };

        const deleteFileResult = caseManagement.deleteFile(params);

        // all methods should return a Promise
        expectToBePromise(deleteFileResult);

        // assert that create request was called
        expect(createRequestMock).toHaveBeenCalledTimes(1);

        const options = getOptions(createRequestMock);

        checkUrlAndMethod(options, '/cases/{case_number}/attachments/{file_id}', 'DELETE');
        const expectedAccept = 'application/json';
        const expectedContentType = undefined;
        checkMediaHeaders(createRequestMock, expectedAccept, expectedContentType);
        expect(options.path['case_number']).toEqual(caseNumber);
        expect(options.path['file_id']).toEqual(fileId);
      });

      test('should prioritize user-given headers', () => {
        // parameters
        const caseNumber = 'testString';
        const fileId = 'testString';
        const userAccept = 'fake/accept';
        const userContentType = 'fake/contentType';
        const params = {
          caseNumber,
          fileId,
          headers: {
            Accept: userAccept,
            'Content-Type': userContentType,
          },
        };

        caseManagement.deleteFile(params);
        checkMediaHeaders(createRequestMock, userAccept, userContentType);
      });
    });

    describe('negative tests', () => {
      test('should enforce required parameters', async done => {
        let err;
        try {
          await caseManagement.deleteFile({});
        } catch (e) {
          err = e;
        }

        expect(err.message).toMatch(/Missing required parameters/);
        done();
      });

      test('should reject promise when required params are not given', done => {
        const deleteFilePromise = caseManagement.deleteFile();
        expectToBePromise(deleteFilePromise);

        deleteFilePromise.catch(err => {
          expect(err.message).toMatch(/Missing required parameters/);
          done();
        });
      });
    });
  });
});
