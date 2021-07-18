function solution(s) {
    const wordToDigit = {
        zero: '0',
        one: '1',
        two: '2',
        three: '3',
        four: '4',
        five: '5',
        six: '6',
        seven: '7',
        eight: '8',
        nine: '9',
    }

    Object.keys(wordToDigit).forEach((key) => {
        const reg = new RegExp(key, 'g');
        s = s.replace(reg, wordToDigit[key]);
    })

    return Number(s);
}

console.log(solution("one4seveneight"))
console.log(solution("23four5six7"))
console.log(solution("2three45sixseven"))
console.log(solution("123"))
