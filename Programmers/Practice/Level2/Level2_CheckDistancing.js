function solution(places) {
    let queue;
    const diag = [[1, 1], [1, -1], [-1, 1], [-1, -1]];
    const ortho = [[1, 0], [-1, 0], [0, 1], [0, -1]];
    const answer = [];

    function bfs(people, place) {
        while (people.length !== 0) {
            const cur = people.shift();

            for (const o of ortho) {
                let nx = cur[0] + o[0], ny = cur[1] + o[1];
                if (nx < 0 || nx > 4 || ny < 0 || ny > 4) continue;
                if (place[nx][ny] === 'P') return false;

                let temp = `${place[nx][ny]}`;
                let detected = false;
                while (true) {
                    nx += o[0];
                    ny += o[1];
                    if (nx < 0 || nx > 4 || ny < 0 || ny > 4) break;
                    if (place[nx][ny] === 'P') {
                        detected = true;
                        break;
                    }
                    temp += place[nx][ny];
                }
                if (detected && temp === 'O')
                    return false
            }

            for (const d of diag) {
                const nx = cur[0] + d[0], ny = cur[1] + d[1];
                if (nx < 0 || nx > 4 || ny < 0 || ny > 4) continue;

                if (place[nx][ny] === 'P') {
                    if (place[nx][cur[1]] !== 'X' || place[cur[0]][ny] !== 'X')
                        return false;
                }
            }
        }

        return true;
    }

    places = places.map(p => p.map(r => r.split('')));

    for (const place of places) {
        queue = [];

        for (let i = 0; i < 5; i++) {
            for (let j = 0; j < 5; j++) {
                if (place[i][j] === 'P')
                    queue.push([i, j]);
            }
        }

        answer.push(bfs(queue, place) ? 1 : 0);
    }

    return answer;
}

console.log(solution([
    ["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"],
    ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"],
    ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"],
    ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"],
    ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]
]))