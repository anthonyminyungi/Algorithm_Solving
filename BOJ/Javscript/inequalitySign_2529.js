// dfs, 백트랙킹 더 공부하자...
// array loop을 통한 다른 풀이도 있었지만 다른 문제를 위해서도 우선 재귀적인 방식에 더 익숙해지자.
const solution = (input) => {
    const n = parseInt(input[0]);
    const sign = input[1].split(' ');
    const visited = new Array(10).fill(false);
    let max = Number.MIN_SAFE_INTEGER.toString();
    let min = Number.MAX_SAFE_INTEGER.toString();

    function dfs(pos, prev, result) {
        if (pos === n) {
            max = parseInt(result) > parseInt(max) ? result : max;
            min = parseInt(result) < parseInt(min) ? result : min;
            return;
        }
        if (sign[pos] === '<') {
            for (let i = prev + 1; i < 10; i++) {
                if (visited[i]) continue;
                visited[i] = true;
                dfs(pos + 1, i, result + i);
                visited[i] = false;
            }
        } else {
            for (let i = prev - 1; i >= 0; i--) {
                if (visited[i]) continue;
                visited[i] = true;
                dfs(pos + 1, i, result + i);
                visited[i] = false;
            }
        }
    }

    for (let i = 0; i < 10; i++) {
        visited[i] = true;
        dfs(0, i, `${i}`);
        visited[i] = false;
    }

    return `${max}\n${min}`;
};

let input = [];
const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});
rl
    .on('line', function (line) {
        input.push(line);
    })
    .on('close', function () {
        console.log(solution(input))
        process.exit();
    });

