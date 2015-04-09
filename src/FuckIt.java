import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class FuckIt {
    public TreeNode lca(TreeNode node1, TreeNode node2){
        if(node1==node2){
            return node1;
        }
        if(node1.getParent()==node2){
            return node2;
        }
        if(node2.getParent()==node1){
            return node1;
        }

        List<TreeNode> list1=getPath2Root(node1);
        List<TreeNode> list2=getPath2Root(node2);
        for(int i=list1.size()-1, j=list2.size()-1; i>=0&&j>=0; i--, j--){
            if(list1.get(i)!=list2.get(j)){
                return list1.get(i).getParent();
            }
        }
        return null;
    }

    private List<TreeNode> getPath2Root(TreeNode node){
        List<TreeNode> list=new ArrayList<TreeNode>();
        while(node!=null){
            list.add(node);
            node=node.getParent();
        }
        return list;
    }

    private TreeNode getAncestor(TreeNode root, TreeNode node1, TreeNode node2){
        if(root==null || root==node1 || root==node2){
            return root;
        }

        TreeNode left=getAncestor(root.getChildAt(0), node1, node2);
        TreeNode right=getAncestor(root.getChildAt(1), node1, node2);
        if(left!=null && right!=null)
            return root;
        if(left!=null)
            return left;
        if(right!=null)
            return right;
        return null;
    }

    public static void main(String[] args){
        FuckIt fi=new FuckIt();
        TreeNode node1=null, node2=null, root=null;
        fi.lca(node1, node2);
        fi.getAncestor(root, node1, node2);
    }
}
