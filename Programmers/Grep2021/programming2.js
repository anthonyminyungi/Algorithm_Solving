const gradeMap = {
    'A+': 12,
    'A0': 11,
    'A-': 10,
    'B+': 9,
    'B0': 8,
    'B-': 7,
    'C+': 6,
    'C0': 5,
    'C-': 4,
    'D+': 3,
    'D0': 2,
    'D-': 1,
    'F': 0,
}

function solution(grades) {
    const courseMap = new Map();
    grades.forEach((grade, idx) => {
        const split = grade.split(' ');
        if (courseMap.has(split[0])) {
            const val = courseMap.get(split[0]);
            if (gradeMap[split[1]] > gradeMap[val[0].grade]) {
                val.unshift({grade: split[1], idx});
            }
            // courseMap.set(split[0], [...courseMap.get(split[0]), {grade: split[1], idx}])
        } else {
            courseMap.set(split[0], [{grade: split[1], idx}])
        }
    })

    const answer = [];

    for (const entry of courseMap) {
        // const sorted = entry[1].sort((a, b) => gradeMap[b.grade] - gradeMap[a.grade]);
        answer.push({subject: entry[0], gradeObj: entry[1][0]});
    }

    return answer.sort((a, b) => {
        const {grade: gradeA, idx: idxA} = a.gradeObj;
        const {grade: gradeB, idx: idxB} = b.gradeObj;

        if (gradeMap[gradeA] === gradeMap[gradeB]) {
            return idxA - idxB;
        } else {
            return gradeMap[gradeB] - gradeMap[gradeA];
        }
    }).map(obj => `${obj.subject} ${obj.gradeObj.grade}`);
}


console.log(solution(["DS7651 A0", "CA0055 D+", "AI5543 C0", "OS1808 B-", "DS7651 B+", "AI0001 F", "DB0001 B-", "AI5543 D+", "DS7651 A+", "OS1808 B-"]))
console.log(solution(["DM0106 D-", "PL6677 B+", "DM0106 B+", "DM0106 B+", "PL6677 C0", "GP0000 A0"]))