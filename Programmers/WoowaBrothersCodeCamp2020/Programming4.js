function solution(weights) {
    let answer = 0;
    if (weights.length === 1)
        return 1;

    let newArr = [];
    weights.map((w) => {
        const temp = {
            value: w,
            number: 1
        };
        newArr.push(temp)
    })
    let prevLen = newArr.length;
    let curLen = 0;
    while (prevLen !== curLen) {
        prevLen = newArr.length;
        for (let index = 0; index < newArr.length - 1; index++) {
            if (newArr[index].value === newArr[index + 1].value) {
                let temp = {
                    value: newArr[index].value * 2,
                    number: newArr[index].number + newArr[index + 1].number
                }
                newArr.splice(index, 1);
                newArr.splice(index, 1);
                newArr.push(temp)
                newArr.sort((o1, o2) => {
                    return o1.value - o2.value;
                })
                break;
            }
        }
        curLen = newArr.length;
    }
    // Ctrl-C , Ctrl-V가 안돼서 IDE에서 풀다가 다 풀었는데 시간초과로 이 밑에 못적음...
    // 교훈 : 앞으로 시간 안배를 잘하자.
    newArr.sort((o1, o2) => {
        return o2.number - o1.number;
    })
    answer = newArr[0].number;
    return answer;
}

console.log(solution([2, 2, 2, 2, 3, 3, 5, 6]))
console.log(solution([3, 3, 3, 3, 3, 3, 12]))
console.log(solution([16, 16, 16, 16, 16, 16, 16, 16, 1, 1, 2, 4, 4]))
console.log(solution([1]))