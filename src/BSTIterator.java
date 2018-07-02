import java.util.Stack;

public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<>();
    private TreeNode cur;

    public BSTIterator(TreeNode root) {
        cur = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return (cur!=null||!stack.isEmpty());
    }

    /** @return the next smallest number */
    public int next() {
        while (cur!=null){
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        TreeNode node = cur;
        cur = cur.right;
        return node.val;
    }
}
