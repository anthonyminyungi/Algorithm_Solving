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
        // const n = parseInt(input[0])
        const budgets = input[1].split(' ').map(Number).sort((a, b) => a - b);
        const total = parseInt(input[2]);

        let sum = budgets.reduce((acc, cur) => acc + cur, 0);
        let upper = Math.max(...budgets);

        if (sum <= total) console.log(upper);
        else {
            let min = 0, mid = 0;
            let answer = 0;
            while (min <= upper) {
                mid = Math.round((min + upper) / 2);
                sum = budgets.reduce((acc, cur) => acc + (cur <= mid ? cur : mid), 0)
                if (sum <= total) {
                    answer = Math.max(answer, mid);
                    min = mid + 1;
                } else {
                    upper = mid - 1;
                }
            }
            console.log(answer)
        }
        process.exit();
    });