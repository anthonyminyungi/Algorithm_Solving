function solution(fees, records) {
    const baseTime = fees[0], baseFee = fees[1], unitTime = fees[2], unitFee = fees[3];
    const parkTime = {};
    const parkTimeTotal = {};

    for (const record of records) {
        const split = record.split(' ');
        const time = split[0], carNum = split[1], type = split[2];
        if (!parkTimeTotal[carNum]) {
            parkTimeTotal[carNum] = 0;
        }

        if (type === 'IN') {
            parkTime[carNum] = time;
        } else {
            const tIn = parkTime[carNum];
            delete parkTime[carNum];
            parkTimeTotal[carNum] += calcTime(tIn, time);
        }
    }

    Object.entries(parkTime).forEach(entry => {
        parkTimeTotal[entry[0]] += calcTime(entry[1], '23:59');
    })

    return Object.keys(parkTimeTotal).sort((a, b) => a - b).map(carNum => {
        const totalTime = parkTimeTotal[carNum];
        if (totalTime > baseTime) {
            return baseFee + Math.ceil((totalTime - baseTime) / unitTime) * unitFee;
        } else {
            return baseFee;
        }
    });
}

function calcTime(tIn, tOut) {
    const splitIn = tIn.split(':');
    const splitOut = tOut.split(':');
    const hIn = parseInt(splitIn[0]), mIn = parseInt(splitIn[1]);
    const hOut = parseInt(splitOut[0]), mOut = parseInt(splitOut[1]);

    return (hOut * 60 + mOut) - (hIn * 60 + mIn);
}

console.log(solution([180, 5000, 10, 600], ["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]))
console.log(solution([120, 0, 60, 591], ["16:00 3961 IN", "16:00 0202 IN", "18:00 3961 OUT", "18:00 0202 OUT", "23:58 3961 IN"]))
console.log(solution([1, 461, 1, 10], ["00:00 1234 IN"]))