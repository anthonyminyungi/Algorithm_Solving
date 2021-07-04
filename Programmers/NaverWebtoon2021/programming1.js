function solution(k, rates) {
    const days = rates.length;
    if (days === 1) return k;
    let edges = [];

    for (let i = 0; i < days; i++) {
        if (i === 0) {
            if (rates[i] !== rates[i + 1]) edges.push(rates[i]);
        } else if (i === days - 1) {
            if (rates[i] !== rates[i - 1]) edges.push(rates[i]);
        } else {
            if (rates[i] > rates[i + 1] && rates[i] > rates[i - 1]) edges.push(rates[i])
            else if (rates[i] < rates[i + 1] && rates[i] < rates[i - 1]) edges.push(rates[i]);
        }
    }

    let start = k;
    let dollar = false;
    let boughtPrice = 0;
    edges.forEach(edge => {
        if (!dollar && edge <= k) {
            dollar = true;
            k -= edge;
            boughtPrice = edge;
        } else if (dollar && edge > boughtPrice) {
            dollar = false;
            k += edge;
            boughtPrice = 0;
        }
    })

    let answer = dollar ? boughtPrice : k;
    answer = answer > start ? answer : start;

    return answer;
}

console.log(solution(1000, [1200, 1000, 1100, 1200, 900, 1000, 1500, 900, 750, 1100]))
console.log(solution(1500, [1500, 1400, 1300, 1200]))
console.log(solution(1200, [1400]))
console.log(solution(1200, [1000, 1500]))