const CHUNK_SIZE_THRESHOLD: number = 1000;
const CHUNK_SIZE: number = 500;

function mappingData(
    originArrObj: [],
    targetArrObj: [],
    key: string,
): object[] {
    const useChunk = originArrObj.length > CHUNK_SIZE_THRESHOLD;
    const resultArr = [];
    const targetMap = new Map();

    // Create a Map to store the data from the target array
    for (const targetObj of targetArrObj) {
        const targetKey = targetObj[key];
        targetMap.set(targetKey, targetObj);
    }

    if (useChunk) {
        // Use chunk
        for (let i = 0; i < originArrObj.length; i += CHUNK_SIZE) {
            const chunk = originArrObj.slice(i, i + CHUNK_SIZE);
            chunk.forEach((originObj) => {
                const targetObj = targetMap.get(originObj[key]);
                if (targetObj) {
                    resultArr.push(Object.assign({}, originObj, targetObj));
                } else {
                    resultArr.push(originObj);
                }
            });
        }
    } else {
        // Don't use chunk
        originArrObj.forEach((originObj) => {
            const targetObj = targetMap.get(originObj[key]);
            if (targetObj) {
                resultArr.push(Object.assign({}, originObj, targetObj));
            } else {
                resultArr.push(originObj);
            }
        });
    }

    return resultArr;
}
