/**
 * 1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
 * 2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
 * 3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
 * 3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
 * 4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
 * 4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
 * 4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
 * 4-3. ')'를 다시 붙입니다.
 * 4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
 * 4-5. 생성된 문자열을 반환합니다.
 * @param p
 * @returns {string}
 */

function solution(p) {
    let answer = '';
    if (p.trim() === '')
        return '';
    let leftCount = 0;
    let rightCount = 0;
    let u = '';
    let v = '';
    for (let i = 0; i < p.length; i++) {
        if (p.charAt(i) === '(')
            leftCount++;
        else
            rightCount++;
        if (leftCount !== 0 && rightCount !== 0 && leftCount === rightCount) {
            let uLength = leftCount + rightCount;
            u = p.substr(0, uLength);
            v = p.substr(uLength, p.length - uLength);
            break;
        }
    }
    if (checkCorrect(u)) {
        v = solution(v);
        answer = u + v;
    } else {
        let res = '(';
        v = solution(v);
        res += v + ')';
        u = u.slice(1, u.length - 1);
        u = u.split('').map(b => {
            if (b === '(')
                return ')'
            else
                return '('
        }).join('');
        answer = res + u;

    }
    return answer;
}

function checkCorrect(s) {
    let stack = [];
    for (let i = 0; i < s.length; i++) {
        if (s.charAt(i) === '(')
            stack.push('(');
        else
            stack.pop();
    }
    return stack.length === 0;
}

console.log(solution("(()())()"))
console.log(solution(")("))
console.log(solution("()))((()"))