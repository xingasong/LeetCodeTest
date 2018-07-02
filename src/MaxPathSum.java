public class MaxPathSum {

    private class ResultType{
        int maxPath, singlePath;
        ResultType(int singlePath, int maxPath){
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }

    private ResultType helper(TreeNode node){
        if(node==null) return new ResultType(0, Integer.MIN_VALUE);
        //divide
        ResultType left = helper(node.left);
        ResultType right = helper(node.right);
        //conquer
        int singlePath = Math.max(left.singlePath, right.singlePath) + node.val;
        singlePath = Math.max(singlePath, 0);
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath+right.singlePath+node.val);

        return new ResultType(singlePath, maxPath);
    }

    private int maxPathSum(TreeNode root) {
        ResultType res = helper(root);
        return res.maxPath;
    }
}
