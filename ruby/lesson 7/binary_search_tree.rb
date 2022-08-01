# https://leetcode.com/problems/search-in-a-binary-search-tree/
# https://leetcode.com/problems/insert-into-a-binary-search-tree/
# https://leetcode.com/problems/delete-node-in-a-bst/

class BinarySearchTree
    def initialize
        @root = nil
    end
    
    def get(val)
        get_value(root, val)
    end
    
    def put(val)
        @root = put_value(root, val)
    end
    
    def delete(val)
        @root = delete_value(root, val)
    end

    private
    
    def get_value(node, val)
        return nil if node.nil?
        
        return get_value(node.left, val) if val < node.val
        return get_value(node.right, val) if val > node.val
        node
    end

    def put_value(node, val)
        return TreeNode.new(val) if node.nil?
        
        node.left = put_value(node.left, val) if val < node.val
        node.right = put_value(node.right, val) if val > node.val

        node
    end

    def delete_value(node, val)
        return nil if node.nil?
        
        if val < node.val
            node.left = delete_value(node.left, val)
        elsif val > node.val
            node.right = delete_value(node.right, val)
        else
            return node.right if node.left.nil?
            return node.left if node.right.nil?
            
            temp = node
            node = min(temp.right)
            node.right = delete_min(temp.right)
            node.left = temp.left
        end
        node
    end
    
    def min(node)
        node.left.nil? ? node : min(node.left)
    end
    
    def delete_min(node)
        return node&.right if node&.left.nil?
        node.left = delete_min(node.left)
        node
    end
end
