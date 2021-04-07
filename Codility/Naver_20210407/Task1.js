function solution(A) {
    // write your code in JavaScript (Node.js 8.9.4)
    const startsOne = [1];
    const startsZero = [0];

    for (let i = 1; i < A.length; i++) {
        startsOne.push(startsOne[i - 1] === 0 ? 1 : 0)
        startsZero.push(startsZero[i - 1] === 0 ? 1 : 0)
    }

    var diffCntOne = 0;
    var diffCntZero = 0;

    A.forEach((a, i) => {
        if (a !== startsZero[i]) diffCntZero++;
        if (a !== startsOne[i]) diffCntOne++;
    })

    return Math.min(diffCntZero, diffCntOne);
}

console.log(solution([1, 0, 1, 0, 1, 1]))
console.log(solution([1, 1, 0, 1, 1]))
console.log(solution([0, 1, 0]))
console.log(solution([0, 1, 1, 0]))
