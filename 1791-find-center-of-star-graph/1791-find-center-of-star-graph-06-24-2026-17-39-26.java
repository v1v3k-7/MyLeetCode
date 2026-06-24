class Solution 
{
    //star graph hai, sabka edge ek hi hoga bas center node ko chhord k (jo ki sabme common hoga). to simple hai agar kisi do edge me koi node common hai to wahi center hoga, star graph me center k alawa baki kisi k degree 2 ho hi nhi skti
    public int findCenter(int[][] edges) 
    {
        int[] edge1=edges[0];
        int[] edge2=edges[1];
        if(edge1[0]==edge2[0] || edge1[0]==edge2[1]) return edge1[0];
        else return edge1[1];
    }
}