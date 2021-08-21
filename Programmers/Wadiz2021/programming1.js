function solution(passwords, s) {
    let answer = 0;
    const map = new Map();
    for (let floor = 1; floor <= 20; floor++) {
        map.set((floor * 100) + 1, -1);
        map.set((floor * 100) + 2, -1);
    }

    passwords.forEach(pair => {
        map.set(pair[0], pair[1]);
    });

    const split = s.split('#');
    const len = split.length;

    for (let i = 0; i < len; i++) {
        if (map.has(parseInt(split[i]))) {
            if (i + 1 <= len && map.get(parseInt(split[i])) === parseInt(split[i + 1])) {
                answer++;
                i += 1;
            }
        }
    }

    return answer;
}

console.log(solution([[101, 1234], [102, 54321], [201, 202], [202, 1]], "101#1234#102#654321#51#203#201#202#1#"))
console.log(solution([[101, 9999], [102, 1111]], "201#9999#101#"))
console.log(solution([[101, 9999], [102, 1111]], "101#9999#102#1111#101#9999#101#9999#"))