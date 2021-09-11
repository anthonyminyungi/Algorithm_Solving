function solution(n, k) {
    const trans = n.toString(k);
    const splitZero = trans.split('0');

    let ans = 0;
    for (const candidate of splitZero) {
        if (candidate.length > 0 && isPrime(parseInt(candidate))) {
            ans++
        }
    }

    return ans;
}

function isPrime(n) {
    if (n === 1) return false;

    for (let i = 2; i * i <= n; i++) {
        if (n % i === 0) return false;
    }

    return true;
}

console.log(solution(437674, 3))
console.log(solution(110011, 10))