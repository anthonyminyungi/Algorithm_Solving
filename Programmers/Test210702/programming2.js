function solution(n) {
    let dp = new Array(10);
    for (let i = 0; i < 10; i++) {
        dp[i] = new Array(n + 1);
    }

    for (let i = 0; i < 10; i++) {
        for (let j = 0; j < n + 1; j++) {
            dp[i][j] = 0;
        }
    }

    for (let i = 0; i < 10; i++)
        dp[i][1] = 1;

    for (let d = 0; d < 10; d++) {
        for (let l = 2; l < n + 1; l++) {
            for (let x = 0; x < d; x++) {
                dp[d][l] += dp[x][l - 1];
            }
        }
    }
    console.log(dp)

    return dp.reduce((acc, cur) => acc + cur[n], 0);
}

console.log(solution(2))
console.log(solution(3))
console.log(solution(4))
console.log(solution(5))
console.log(solution(6))
console.log(solution(7))
console.log(solution(8))
console.log(solution(9))
console.log(solution(10))