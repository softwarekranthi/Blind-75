package Trees;

public class A104_Max_Depth_Binary_Tree {
   public int maxDepth(TreeNode root) {
      return 0;
   }
   public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
      }
   }
}
