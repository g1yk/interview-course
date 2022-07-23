// https://leetcode.com/problems/binary-tree-inorder-traversal/

function inorderTraversal(root) {
    const list = [], stack = [];
    let current = root;
    while (current || stack.length > 0) {
        if (current) {
            stack.push(current);
            current = current.left;
        } else {
            current = stack.pop();
            list.push(current.val);
            current = current.right;
        }
    }
    return list;
}
