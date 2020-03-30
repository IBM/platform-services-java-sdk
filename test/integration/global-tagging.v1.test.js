/* eslint-disable no-console */
/**
 * Copyright 2020 IBM All Rights Reserved.
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

// Set up the environment
require('./setUpHelper.js');
const GlobalTaggingV1 = require('../../dist/global-tagging/v1');
const {IamAuthenticator} = require('ibm-cloud-sdk-core');
const authenticator = new IamAuthenticator({
    apikey: process.env.GST_IINTERNA_APIKEY,
});
const timeout = 10000; // ten seconds

describe('GlobalTaggingV1_integration', () => {
    jest.setTimeout(timeout);


    const tagName = 'node-sdk-' + Math.floor((Math.random() * 100000) + 1).toString();
    const providers = ['ghost'];
    const fullData = true;
    const offset = 0;
    const limit = 100;
    const orderByName = 'asc';
    const attachedOnly = false;
    const attachedTo = process.env.GST_RESOURCE_CRN;
    const fullData2 = false;

    const params = {
        providers: providers,
        fullData: fullData,
        offset: offset,
        limit: limit,
        orderByName: orderByName,
        timeout: timeout,
        attachedOnly: attachedOnly,
    };

    const paramsAttachedTo = {
        providers: providers,
        attachedTo: attachedTo,
        fullData: fullData2,
        offset: offset,
        limit: limit,
        orderByName: orderByName,
        timeout: timeout,
        attachedOnly: attachedOnly,
    };

    const options = {};
    options.authenticator = authenticator;
    options.serviceUrl = process.env.GST_TAGS_URL;
    const globalTagging = new GlobalTaggingV1(options);


    it('should getAll tags', done => {
        return globalTagging.listTags(params).then(response => {
            expect(response.hasOwnProperty('status')).toBe(true);
            expect(response.status).toBe(200);
            done();
        });
    });

    it('should Attach tag', done => {

        const resourceModel = {
            resource_id: process.env.GST_RESOURCE_CRN,
            resource_type: 'cf-application',
        };

        const resources = [resourceModel];
        const tagNameArray = [tagName];
        const params = {
            resources: resources,
            tagNames: tagNameArray
        };

        globalTagging.attachTag(params).then(response => {
            // console.log('rispostaTagAttach', response.result.results[0]);
            // console.log('risorsa', response.result.items[0]);
            expect(response.hasOwnProperty('status')).toBe(true);
            expect(response.status).toBe(200);
            expect(response.result.results[0].isError).toBe('false');

            return globalTagging.listTags(paramsAttachedTo).then(response => {
                expect(response.hasOwnProperty('status')).toBe(true);
                expect(response.status).toBe(200);
                expect(Array.isArray(response.result.items)).toBe(true);
                done();
            });

        });
    });


    it('should Detach tag', done => {

        const resourceModel = {
            resource_id: process.env.GST_RESOURCE_CRN,
            resource_type: 'cf-application',
        };

        const resources = [resourceModel];
        const tagNameArray = [tagName];
        const params = {
            resources: resources,
            tagNames: tagNameArray
        };

        globalTagging.detachTag(params).then(response => {
            expect(response.hasOwnProperty('status')).toBe(true);
            expect(response.status).toBe(200);
            expect(response.result.results[0].isError).toBe('false');


            return globalTagging.listTags(paramsAttachedTo).then(response => {
                expect(response.hasOwnProperty('status')).toBe(true);
                expect(response.status).toBe(200);
                expect(Array.isArray(response.result.items)).toBe(true);
                done();
            });

        });
    });


    it('should Delete tag', done => {

        const providers = ['ghost'];
        const params = {
            tagName: tagName,
            providers: providers,
        };

        globalTagging.deleteTag(params).then(response => {
            expect(response.hasOwnProperty('status')).toBe(true);
            expect(response.status).toBe(200);
            expect(response.result.results[0].isError).toBe('false');


            return globalTagging.listTags(paramsAttachedTo).then(response => {
                expect(response.hasOwnProperty('status')).toBe(true);
                expect(response.status).toBe(200);
                expect(Array.isArray(response.result.items)).toBe(true);
                done();
            });

        });
    });

});

