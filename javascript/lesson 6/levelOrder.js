// https://leetcode.com/problems/binary-tree-level-order-traversal/

function levelOrder(root) {
    const result = [];
    if (!root) return result;
 
    const queue = [root];
     while (queue.length > 0) {
        const size = queue.length;
        const level = [];
        for (let i = 0; i < size; i += 1) {
            const node = queue.shift();
            level.push(node.val);
            if (node.left) queue.push(node.left);
            if (node.right) queue.push(node.right);
        }
        result.push(level);
    }
    return result;
}
