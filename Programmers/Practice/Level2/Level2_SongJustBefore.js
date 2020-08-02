/**
 * m                   musicinfos                                                   answer
 * ABCDEFG            [12:00,12:14,HELLO,CDEFGAB, 13:00,13:05,WORLD,ABCDEF]         HELLO
 * CC#BCC#BCC#BCC#B   [03:00,03:30,FOO,CC#B, 04:00,04:08,BAR,CC#BCC#BCC#B]          FOO
 * ABC                [12:00,12:14,HELLO,C#DEFGAB, 13:00,13:05,WORLD,ABCDEF]        WORLD
 * 조건이 일치하는 음악이 여러 개일 때에는 라디오에서 재생된 시간이 제일 긴 음악 제목을 반환한다. 재생된 시간도 같을 경우 먼저 입력된 음악 제목을 반환한다.
 * @param m
 * @param musicinfos
 * @returns {string}
 */


function solution(m, musicinfos) {
    let answer = '';
    let cnt = 0;
    let restructured = [];
    const melodyMap = {
        'C#': 'b',
        'D#': 'd',
        'F#': 'g',
        'G#': 'i',
        'A#': 'k',
        'C': 'a',
        'D': 'c',
        'E': 'e',
        'F': 'f',
        'G': 'h',
        'A': 'j',
        'B': 'l'
    }
    musicinfos.map(v => {
        let t = v.split(',');
        t.map(t => {
            restructured.push(t.trim());
        })
    })

    Object.keys(melodyMap).map(v => {
        const reg = new RegExp(`${v}`, 'g')
        m = m.replace(reg, melodyMap[v]);
    })

    let matches = [];
    let seq = 1;
    restructured.map((value, index) => {
        cnt++;
        if (cnt % 4 === 0) {
            let playTime = (parseInt(restructured[index - 2].split(':')[0]) - parseInt(restructured[index - 3].split(':')[0])) * 60 + (parseInt(restructured[index - 2].split(':')[1]) - parseInt(restructured[index - 3].split(':')[1]))
            let realScore = '';
            let tempIndex = 0;
            let title = restructured[index - 1];
            let score = restructured[index];

            Object.keys(melodyMap).map(v => {
                const reg = new RegExp(`${v}`, 'g')
                score = score.replace(reg, melodyMap[v]);
            })

            for (let i = 0; i < playTime; i++) {
                realScore += score.charAt(tempIndex);
                tempIndex++;
                if (tempIndex >= score.length)
                    tempIndex = 0;
            }
            if (realScore.includes(m)) {
                matches.push({
                    title,
                    playTime,
                    seq
                })
            }
            seq++;
        }
    })
    if (matches.length === 0) {
        answer = "(None)";
    } else {
        matches.sort((p, n) => n.playTime - p.playTime);
        answer = matches[0].title;
    }
    return answer;
}

console.log(solution('ABCDEFG', ['12:00, 12:14, HELLO, CDEFGAB', '13:00, 13:05, WORLD, ABCDEF', '13:01, 13:24, CORRECT, CDEFGAB', '13:30, 13:44, LASTSS, CDEFGAB']));
console.log(solution('CC#BCC#BCC#BCC#B', ['03:00, 03:30, FOO, CC#B', '04:00, 04:08, BAR, CC#BCC#BCC#B']))
console.log(solution('A#C#F#D#G#', ['03:00, 03:30, FOO, A#C#F#D#', '04:00, 04:08, BAR, A#C#C#F#D#']))
console.log(solution('ABC', ['12:00', '12:14', 'HELLO', 'C#DEFGAB', '13:00', '13:05', 'WORLD', 'ABCDEF']))