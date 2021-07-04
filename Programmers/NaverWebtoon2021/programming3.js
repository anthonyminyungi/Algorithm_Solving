function solution(block, board) {
    const blocks = [[[1], [1], [1]], [[1, 1, 1]], [[1, 0], [1, 1]], [[0, 1], [1, 1]], [[1, 1], [0, 1]], [[1, 1], [1, 0]]]
    const n = board.length;
    const selected = blocks[block];
    const selectedRow = selected.length, selectedCol = selected[0].length;
    let maxLine = 0;

    const checkRemove = board => {
        let count = board.length;
        for (let i = 0; i < board.length; i++) {
            if (board[i].includes(0))
                count--;
        }
        return count;
    }

    const checkCan = (i, j, row, col) => {
        for (let k = 0; k < row; k++) {
            for (let l = 0; l < col; l++) {
                if (selected[k][l] === 1 && board[i + k][j + l] === 1) return false;
            }
        }

        return true;
    }

    for (let i = 0; i <= n - selectedRow; i++) {
        for (let j = 0; j <= n - selectedCol; j++) {

            if (checkCan(i, j, selectedRow, selectedCol)) {
                for (let k = 0; k < selectedRow; k++) {
                    for (let l = 0; l < selectedCol; l++) {
                        board[i + k][j + l] = 1;
                    }
                }

                const removedLine = checkRemove(board);
                if (maxLine < removedLine) {
                    maxLine = removedLine;
                }

                for (let k = 0; k < selectedRow; k++) {
                    for (let l = 0; l < selectedCol; l++) {
                        board[i + k][j + l] = 0;
                    }
                }
            }
        }
    }

    return maxLine;
}

const board = [[1, 0, 0, 0], [1, 0, 0, 1], [1, 1, 0, 1], [1, 1, 0, 1]];

for (let i = 0; i < 6; i++) {
    console.log(solution(i, board));
}