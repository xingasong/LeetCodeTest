public class FlattenTtoList {

    static TreeNode node = new TreeNode(0);
    static TreeNode node1;

    public void flatten(TreeNode root) {
        node.right = node1;
        iteration(root);
        root = node.right;
    }

    public void iteration(TreeNode root) {
        if(root == null) return;
        node1 = new TreeNode(root.val);
        node1 = node1.right;
        iteration(root.left);
        iteration(root.right);
    }

    public static void main(String[] args) {
        FlattenTtoList a = new FlattenTtoList();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        a.flatten(root);
        System.out.println(node.right.val);
    }
}
