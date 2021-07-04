function solution(money, cost) {
    let maxLen = 0;
    const floor = cost.length;
    let left = 0, right = 0;
    let currentCost = 0;

    while (right <= floor) {
        if (currentCost > money) {
            currentCost -= cost[left++];
        } else {
            currentCost += cost[right++]
        }

        if (currentCost <= money) {
            if (maxLen < (right - left))
                maxLen = right - left;
        }
    }

    return maxLen;
}

console.log(solution(420, [0, 900, 0, 200, 150, 0, 30, 50]))
console.log(solution(100, [245, 317, 151, 192]))