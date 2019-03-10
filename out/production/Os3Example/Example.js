"use strict";

const data = [2, 3, 9, 1];

function processData(rawData) {
    return rawData.filter(x => x % 2 === 1)
        .map(x => x + 2);
}

function processDataLoop(rawData) {
    const resultArray = [];
    for (let i = 0; i < rawData.length; ++i) {
        const currentData = rawData[i];
        if (currentData % 2 === 1) {
            resultArray.push(currentData);
        }
    }
    return resultArray;
}

function printProcessedData(processedData) {
    console.log("Processed data:");
    processedData.forEach(x => console.log(x));
}
