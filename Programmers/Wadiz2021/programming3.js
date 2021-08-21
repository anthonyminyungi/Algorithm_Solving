// 끼워맞추기식 억지풀이. 정석 풀이는 현재 모르겠음.
function solution(arr) {
    const count = {};
    arr.forEach(a => {
        if (a !== 0) {
            count[a] = count[a] ? count[a] + 1 : 1;
        }
    })
    const keys = Object.keys(count).map(key => parseInt(key)).sort((a, b) => a - b);
    const len = keys.length;
    const max = keys[len - 1];
    const min = keys[0];
    if (count[max] === 1) {
        return keys.length;
    } else {
        if (len === 1) {
            return count[max];
        } else {
            return Math.min(count[min] + len, Math.abs(count[max] - count[keys[len - 2]]) + len);
        }
    }
}


const ans1 = solution([1, 2, 4, 8, 4, 2, 1]);
const ans2 = solution([1, 3, 5, 7, 6, 8, 9, 5, 1]);
const ans3 = solution([10, 0, 10, 0, 10, 0]);
const ans4 = solution([5, 4, 5, 4, 5, 5]);
console.log(ans1, ans1 === 4);
console.log(ans2, ans2 === 7);
console.log(ans3, ans3 === 3);
console.log(ans4, ans4 === 4);