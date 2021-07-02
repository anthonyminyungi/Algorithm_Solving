// 미제출. 시간내에 못품.
function solution(r, d, xArr, yArr) {
    let answer = 0;
    const flowers = xArr.map((x, i) => {
        return [x, yArr[i], x + r, yArr[i] + r];
    })
    const dir = [[0, 1], [1, 0], [0, -1], [-1, 0]];

    const canMove = (pos) => {
        if (pos[0] < 0 || pos[1] < 0) return false;
        for (let i = 0; i < flowers.length; i++) {
            if (pos[0] >= flowers[i][0]
                && pos[0] <= flowers[i][2]
                && pos[1] >= flowers[i][1]
                && pos[1] <= flowers[i][3]) {
                return true;
            }
        }
        return false;
    }
    console.log(flowers)

    let q = [[0, 0]];
    let map = new Map();
    map.set([0, 0].toString(), true);

    while (q.length !== 0) {
        const cur = q.shift();
        console.log(cur)
        answer = Math.max(answer, cur[0] + cur[1]);
        for (let i = 0; i < 4; i++) {
            let newPos = [cur[0] + dir[i][0], cur[1] + dir[i][1]];

            if (!map.has(newPos.toString()) && canMove(newPos)) {
                q.push(newPos);
                map.set(newPos.toString(), true);
            }
        }
    }

    return answer;
}

console.log(solution(3, 1, [0, 2, 5, 6], [0, 4, 1, 5]))