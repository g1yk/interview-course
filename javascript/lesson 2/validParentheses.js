function isValid(s) {
    const stack = [];
    for (const c of s) {
        if (c === '(' || c === '{' || c === '[') {
            stack.push(c);
        } else {
            if (stack.length === 0) return false;
            const o = stack.pop();
            if (o === '{' && c !== '}' || o === '(' && c !== ')' || o === '[' && c !== ']' ) return false;
        }        
    }
    return stack.length === 0;
}
