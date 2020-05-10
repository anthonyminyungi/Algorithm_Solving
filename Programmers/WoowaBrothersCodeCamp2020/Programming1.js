function solution(arr) {
    let answer = 1;
    let count = 0;
    let newArr = []
    let isEnd = false;
    while (!isEnd) {
        let current = arr[0];
        if (arr.length === 1) {
            newArr[0] = 1
        } else {
            arr.map((value, index) => {
                if (current !== value) {
                    newArr.push(count);
                    current = value;
                    count = 0;
                }
                if (index === arr.length - 1) {
                    count++;
                    newArr.push(count)
                }
                count++;
            })
            answer++;
            count = 0;
            current = 0;
            arr = newArr
            newArr = []
        }
        if (newArr.length === 1 && newArr[0] === 1)
            isEnd = true
    }
    return answer;
}

console.log(solution([1, 1, 3, 3, 2, 2, 4, 5, 1, 1, 1, 3, 3, 3]));
console.log(solution([1, 2, 3]))
console.log(solution([2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 2, 1, 2]))
console.log(solution([2]))