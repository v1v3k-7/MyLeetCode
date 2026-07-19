class Solution {
    public boolean canReach(int[] start, int[] target) 
    {
        //start or target ka color same hai mtlb ki wo even move kie, if alag hai mtlb ki wo odd move kia
        // (i+j) -> even mean black color hoga wo cell, odd hua to white color
        return ((start[0]+start[1])%2) == ((target[0]+target[1])%2);
    }
}