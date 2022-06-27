// https://leetcode.com/problems/shuffle-an-array/

function shuffle(values) {
    for (let i = 0; i < values.length; i++) {
        const randIndex = Math.floor(Math.random() * (i + 1));
        [values[randIndex], values[i]] = [values[i], values[randIndex]];
    }
}
