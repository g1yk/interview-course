// https://leetcode.com/problems/binary-tree-inorder-traversal/

function inorderTraversal(root) {
    const result = [];
    inOrder(root, result);
    return result;
}

function inOrder(node, result) {
    if (!node) return;

    inOrder(node.left, result);
    result.push(node.val);
    inOrder(node.right, result);
}
