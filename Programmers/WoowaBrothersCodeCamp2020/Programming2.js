function solution(arr) {
    let answer = 0;
    let obj = {}
    arr.map((v) => {
        let sortedNumber = Number(v.toString().split('').sort().join(''));
        if (obj[sortedNumber] === undefined) {
            obj[sortedNumber] = 1;
        } else {
            obj[sortedNumber]++;
        }
    });
    answer = Object.keys(obj).length;
    return answer;
}

console.log(solution([112, 1814, 121, 1481, 1184]))
console.log(solution([123, 456, 789, 321, 654, 987]))
console.log(solution([1, 2, 3, 1, 2, 3, 4]))
console.log(solution([123, 234, 213, 432, 234, 1234, 2341, 12345, 324]))