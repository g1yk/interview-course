// https://leetcode.com/problems/binary-tree-postorder-traversal/

function postorderTraversal(root) {
    const result = [];
    postOrder(root, result);
    return result;
}

function postOrder(node, result) {
    if (!node) return;

    postOrder(node.left, result);
    postOrder(node.right, result);
    result.push(node.val);
}
