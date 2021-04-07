function solution(A) {
    // write your code in JavaScript (Node.js 8.9.4)
    let sorted = [...A]
    sorted = sorted.sort((a1, a2) => a1 - a2);
    let sortedSum = 0, aSum = 0;
    let res = 0;

    A.forEach((a, i) => {
        aSum += a;
        sortedSum += sorted[i];
        if (sortedSum === aSum) {
            res++;
            sortedSum = 0;
            aSum = 0;
        }
    })

    return res;
}


console.log(solution([2, 4, 1, 6, 5, 9, 7]));
console.log(solution([4, 3, 2, 6, 1]));
console.log(solution([2, 1, 6, 4, 3, 7]));