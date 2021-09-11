// https://www.geeksforgeeks.org/final-matrix-after-incrementing-submatrices-by-k-in-range-given-by-q-queries/

function solution(board, skill) {
    const n = board.length, m = board[0].length;
    const queryBoard = Array.from(Array(n), () => new Array(m).fill(0));

    function updateQuery(r1, c1, r2, c2, deg) {
        queryBoard[r1][c1] += deg;

        if (r2 + 1 < n)
            queryBoard[r2 + 1][c1] -= deg;

        if (r2 + 1 < n && c2 + 1 < m)
            queryBoard[r2 + 1][c2 + 1] += deg;

        if (c2 + 1 < m)
            queryBoard[r1][c2 + 1] -= deg;
    }

    for (const arr of skill) {
        const type = arr[0], r1 = arr[1], c1 = arr[2], r2 = arr[3], c2 = arr[4], deg = arr[5];
        updateQuery(r1, c1, r2, c2, type === 1 ? -deg : deg);
    }

    for (let i = 0; i < n; i++) {
        for (let j = 1; j < m; j++) {
            queryBoard[i][j] += queryBoard[i][j - 1];
        }
    }

    for (let i = 0; i < m; i++) {
        for (let j = 1; j < n; j++) {
            queryBoard[j][i] += queryBoard[j - 1][i];
        }
    }

    for (let i = 0; i < n; i++) {
        for (let j = 0; j < m; j++) {
            board[i][j] += queryBoard[i][j];
        }
    }

    let ans = 0;
    for (const row of board) {
        for (const el of row) {
            if (el > 0) ans++;
        }
    }

    return ans;
}

console.log(solution([[5, 5, 5, 5, 5], [5, 5, 5, 5, 5], [5, 5, 5, 5, 5], [5, 5, 5, 5, 5]], [[1, 0, 0, 3, 4, 4], [1, 2, 0, 2, 3, 2], [2, 1, 0, 3, 1, 2], [1, 0, 1, 3, 3, 1]]))
console.log(solution([[1, 2, 3], [4, 5, 6], [7, 8, 9]], [[1, 1, 1, 2, 2, 4], [1, 0, 0, 1, 1, 2], [2, 2, 0, 2, 0, 100]]))