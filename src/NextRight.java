import java.util.LinkedList;
import java.util.Queue;

public class NextRight {
    public static class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }

    public static void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeLinkNode node = queue.poll();
                if (i != len-1) node.next = queue.peek();
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeLinkNode head = new TreeLinkNode(0);
        connect(head);
    }
}
