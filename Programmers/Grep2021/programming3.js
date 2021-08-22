function solution(word, cards) {
    const n = cards.length;
    const wordLen = word.length;
    if (wordLen > n) {
        return 0;
    }
    const charHistory = {};
    const charPositions = word.split('').map(char => {
        if (charHistory[char]) {
            return charHistory[char];
        } else {
            const charPos = [];
            for (let i = 0; i < n; i++) {
                for (let j = 0; j < n; j++) {
                    if (char === cards[i][j])
                        charPos.push([`x:${i}`, `y:${j}`]);
                }
            }
            charHistory[char] = charPos;
            return charPos;
        }
    });


    const cardPositions = [charPositions[0].map(pos => pos.join(''))];
    for (let i = 1; i < wordLen; i++) {
        const before = cardPositions[i - 1];
        const curPos = charPositions[i];
        const temp = [];
        for (const posStr of before) {
            for (const curCharPos of curPos) {
                if (!posStr.includes(curCharPos[0]) && !posStr.includes(curCharPos[1])) {
                    temp.push(`${posStr} ${curCharPos.join('')}`);
                }
            }
        }
        cardPositions.push(temp);
    }
    // console.log(charPositions)
    // console.log(cardPositions[wordLen - 1])
    // console.log(cardPositions[wordLen - 1].map(str => str.split(' ').sort((a, b) => a - b).join('')))
    // console.log(new Set(cardPositions[wordLen - 1].map(str => str.split(' ').map(coord => coord.charAt(2) + coord.charAt(5)).sort((a, b) => a - b).join(''))))
    return new Set(cardPositions[wordLen - 1].map(str => str.split(' ').map(coord => coord.charAt(2) + coord.charAt(5)).sort((a, b) => a - b).join(''))).size;
}

console.log(solution("APPLE", ["LLZKE", "LCXEA", "CVPPS", "EAVSR", "FXPFP"]))
console.log(solution("BAB", ["ZZBZ", "BAZB", "XBXB", "XBAX"]))
console.log(solution("BABXZ", ["ZZBZ", "BAZB", "XBXB", "XBAX"]))