class Solution {
    List<List<Integer>> lst;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        lst=new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backtracking(candidates,target,new ArrayList<Integer>(), 0);
        return lst;
    }
    public void backtracking(int[] candidates, int target,ArrayList<Integer> arr,int start) {
        if (target==0) {
            lst.add(new ArrayList<Integer>(arr));
            return;
        }
        for (int i=start;i<candidates.length && candidates[i]<=target;i++) {
            if (i>start && candidates[i]==candidates[i-1]) continue;
            arr.add(candidates[i]);
            backtracking(candidates,target-candidates[i],arr,i+1);
            arr.remove(arr.size()-1);
        }
    }
}
