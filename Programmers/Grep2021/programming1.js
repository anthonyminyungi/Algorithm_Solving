function solution(infos, actions) {
    let isLoggedIn = false;
    const cart = [];

    return actions.map((action) => {
        const split = action.split(' ');
        const op = split[0];
        if (op === 'ADD') {
            if (isLoggedIn) {
                cart.push(split[1])
                return true;
            } else {
                return false;
            }
        } else if (op === 'LOGIN') {
            if (isLoggedIn) {
                return false;
            } else {
                if (infos.includes(`${split[1]} ${split[2]}`)) {
                    isLoggedIn = true;
                    return true;
                } else return false;
            }
        } else {
            if (cart.length > 0) {
                cart.length = 0;
                return true;
            } else {
                return false;
            }
        }
    })
}

console.log(solution(["kim password", "lee abc"], [
    "ADD 30",
    "LOGIN kim abc",
    "LOGIN lee password",
    "LOGIN kim password",
    "LOGIN kim password",
    "LOGIN lee abc",
    "ADD 30",
    "ORDER",
    "ORDER",
    "ADD 40",
    "ADD 50"
]))

console.log(solution(["kim password", "lee abc"], [
    "LOGIN lee abc",
    "LOGIN kim password"
]))