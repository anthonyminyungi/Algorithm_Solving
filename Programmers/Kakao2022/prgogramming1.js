function solution(id_list, report, k) {
    const reported = {}, reports = {};

    for (const str of report) {
        const split = str.split(' ');
        const from = split[0], target = split[1];
        if (!reported[target]) {
            reported[target] = [from];
        } else {
            if (!reported[target].includes(from)) {
                reported[target].push(from);
            }
        }

        if (!reports[from]) {
            reports[from] = [target];
        } else {
            if (!reports[from].includes(target)) {
                reports[from].push(target);
            }
        }
    }

    return id_list.map(id => {
        const reportsList = reports[id] || [];

        return reportsList.reduce((acc, cur) => {
            return acc + (reported[cur].length >= k ? 1 : 0)
        }, 0);
    });
}

console.log(solution(["muzi", "frodo", "apeach", "neo"], ["muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"], 2))
console.log(solution(["con", "ryan"], ["ryan con", "ryan con", "ryan con", "ryan con"], 3))