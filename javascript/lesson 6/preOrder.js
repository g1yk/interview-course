// https://leetcode.com/problems/binary-tree-preorder-traversal/

function preorderTraversal(root) {
    const result = [];
    preOrder(root, result);
    return result;
}

function preOrder(node, result) {
    if (!node) return;
    
    result.push(node.val);
    preOrder(node.left, result);
    preOrder(node.right, result);    
}
