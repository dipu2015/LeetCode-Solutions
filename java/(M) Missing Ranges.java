public class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
        //[0, 1, 3, 50, 75]
        //[-1, 0, 1, 3, 50, 75, 100]
        
        List<String> result = new ArrayList<String>();
        
        int[] arr = new int[nums.length + 2];
        arr[0] = lower - 1;
        arr[arr.length - 1] = upper + 1;
        for (int i=0; i<nums.length; i++) {
            arr[i+1] = nums[i];
        }
        
        for (int i=0; i<arr.length-1; i++) {
            if (arr[i+1] == arr[i] + 2) {
                int v = arr[i] + 1;
                String str = "" + v;
                result.add(str);
            }
            else if (arr[i+1] > arr[i] + 2) {
                int v1 = arr[i] + 1;
                int v2 = arr[i+1] - 1;
                String str = v1 + "->" + v2;
                result.add(str);
            } 
        }
        
        return result;
    }
}
