// https://leetcode.com/problems/validate-binary-search-tree/

function isValidBST(root) {
    return isValid(root);
}

function isValid(node, min = null, max = null) {
    if (node == null) return true;

    if (min != null && node.val <= min || max != null && node.val >= max) {
        return false;
    }

    return isValid(node.left, min, node.val) && isValid(node.right, node.val, max)
}
