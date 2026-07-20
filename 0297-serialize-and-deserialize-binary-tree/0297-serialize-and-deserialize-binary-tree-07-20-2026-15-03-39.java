/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec 
{
    int idx=-1;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) 
    {
        if(root==null) return "";
        StringBuilder sb=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        serHelp(root, sb, sb2);
        sb.deleteCharAt(sb.length()-1);
        sb2.deleteCharAt(sb2.length()-1);
        sb.append('|').append(sb2);
        return sb.toString();
    }
    public void serHelp(TreeNode root, StringBuilder sb, StringBuilder sb2)
    {
        if(root==null) return;
        int id=++idx;
        sb.append(root.val).append("_").append(id).append(","); //preorder
        serHelp(root.left, sb, sb2);
        sb2.append(root.val).append("_").append(id).append(","); //inorder
        serHelp(root.right, sb, sb2);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) 
    {
        if(data.isEmpty()) return null;
        String[] parts = data.split("\\|");
        String[] inorder=parts[1].split(",");
        String[] preorder=parts[0].split(",");
        HashMap<String, Integer> map=new HashMap<>();
        for(int i=0; i<inorder.length; i++) map.put(inorder[i], i);
        return deserHelp(inorder, preorder, 0, inorder.length-1, 0, preorder.length-1, map);
        
    }
    public TreeNode deserHelp(String[] inorder, String[] preorder, int iStart, int iEnd, int pStart, int pEnd, HashMap<String, Integer> map)
    {
        if(iStart>iEnd || pStart>pEnd) return null;

        String nodeStr=preorder[pStart];
        TreeNode root=new TreeNode(Integer.parseInt(nodeStr.split("_")[0]));
        int idx=map.get(nodeStr);
        int leftSize=idx-iStart;
        root.left=deserHelp(inorder, preorder, iStart, idx-1, pStart+1, pStart+leftSize, map);
        root.right=deserHelp(inorder, preorder, idx+1, iEnd, pStart+leftSize+1, pEnd, map);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));