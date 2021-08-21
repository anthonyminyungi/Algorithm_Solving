function solution(code) {
    const answer = [];
    const blockHistory = [];
    let currentBlockLevel = -1;
    let currentPointer = 0;
    const symbolTable = [{}];

    function processLine(line, ptr) {
        while (line.charAt(0) === '.') {
            line = line.replace('.', '');
        }
        if (line.includes('=')) {
            line = line.split('=');
            symbolTable[ptr][line[0]] = parseInt(line[1]);
        } else {
            line = line.split(' ');
            const target = line[1];
            answer.push(symbolTable[ptr][target] ? `${target}=${symbolTable[ptr][target]}` : 'error');
        }
    }

    for (const line of code) {
        let tempLevel = getBlockCount(line);
        if (currentBlockLevel === -1) {
            blockHistory.push(tempLevel);
            processLine(line, currentPointer);
            currentBlockLevel = tempLevel;
            continue;
        }
        if (tempLevel > currentBlockLevel) {
            blockHistory.push(tempLevel);
            symbolTable.push(Object.assign({}, symbolTable[currentPointer]));
            currentPointer++;
            currentBlockLevel = tempLevel;

        } else if (tempLevel === currentBlockLevel) {
        } else {
            let popped = blockHistory.length - (blockHistory.indexOf(tempLevel) + 1);
            while (popped--) {
                blockHistory.pop();
                symbolTable.pop();
                currentPointer--;
            }

            currentBlockLevel = tempLevel;
        }

        processLine(line, currentPointer);
    }

    return answer;
}


function getBlockCount(str) {
    str = str.split('');
    let cnt = 0, idx = 0;
    while (str[idx] === '.') {
        cnt++;
        idx++;
    }
    return cnt;
}

console.log(solution(["a=3", "..a=4", "..b=3", "..print a", ".......a=6", ".......print a", ".......print b", "..print a", "....a=7", "....print a", "print a", "print b", "a=4", "print a", "...print a"]))