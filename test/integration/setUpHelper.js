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

const path = require('path');
/*
const readline = require('readline');
console.log('directory', __dirname);


const lineReader = readline.createInterface({
    input: fs.createReadStream(path.join(__dirname, '../../.ghostenv'))
});

var contents = fs.readFileSync('DATA', 'utf8');
console.log('fiiii', contents);


lineReader.on('line', function (line) {
    const element = line.split('=');
    const elementKey = element[0];
    const elementValue = element[1];
    console.log('elem', elementKey);
    console.log('elem2', elementValue);

    process.env[elementKey] = elementValue;
});


*/


const fs = require('fs');

try {
    // read contents of the file
    const data = fs.readFileSync(path.join(__dirname, '../../.ghostenv'), 'UTF-8');

    // split the contents by new line
    const lines = data.split(/\r?\n/);

    // print all lines
    lines.forEach((line) => {
        const element = line.split('=');
        const elementKey = element[0];
        const elementValue = element[1];
        process.env[elementKey] = elementValue;
    });
} catch (err) {
    console.error(err);
}
