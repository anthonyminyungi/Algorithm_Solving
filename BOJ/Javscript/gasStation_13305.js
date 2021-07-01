const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl
    .on('line', function (line) {
        input.push(line);
    })
    .on('close', function () {
        const n = parseInt(input[0])
        const dists = input[1].split(' ').map(Number);
        const costs = input[2].split(' ').map(Number);

        let answer = 0n;
        let prevMin = costs[0];
        for (let i = 0; i < n - 1; i++) {
            if (prevMin > costs[i])
                prevMin = costs[i];
            answer += (BigInt(prevMin) * BigInt(dists[i]));
        }
        console.log(answer.toString());
        process.exit();
    });