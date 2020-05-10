function solution(reqs) {
    let answer = [];
    const account = {};
    reqs.forEach((req) => {
        const splited = req.split(' ');
        const inst = splited[0];
        const ac = splited[1];
        const money = Number(splited[2]);
        if (inst !== "CREATE") {
            if (account[ac] === undefined)
                answer.push(404);
            else {
                if (inst === "DEPOSIT") {
                    account[ac].dep += money;
                    answer.push(200);
                } else {
                    if (account[ac].dep - money >= 0) {
                        account[ac].dep -= money;
                        answer.push(200);
                    } else {
                        answer.push(403);
                    }
                }
            }
        } else {
            if (account[ac] !== undefined) {
                answer.push(403)
            } else {
                account[ac] = {
                    dep: money
                }
                answer.push(200);
            }
        }
    })

    return answer;
}

console.log(solution(["DEPOSIT 3a 10000", "CREATE 3a 300000", "WITHDRAW 3a 150000", "WITHDRAW 3a 150001"]))
console.log(solution(["CREATE 3a 10000", "CREATE 3a 20000", "CREATE 2bw 30000"]))
