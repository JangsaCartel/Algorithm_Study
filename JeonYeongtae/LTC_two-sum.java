class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 2중 for문으로 두 수를 순차적으로 선택 
        // (인덱스 배열의 첫번째부터 마지막까지 모든 경우의 수를 둘러보아
        // 해답에 해당하는 두 수 조합을 찾는다.)
        for (i=0; i=nums.length-1; i++) {
        // 1. nums 배열의 첫번째부터 마지막까지 전부 실행
		        for (j=i+1; j<nums.length-1; j++) {
		        // 2. nums 배열의 첫번째부터 마지막까지 전부 실행하는데,
		        //    '중복 선택'과 '선택한 배열의 자리 순서만 다른경우를 제외'
			        if(nums[i]+nums[j]==target) {
					        return new int[]{i, j};
				        }
		        }
        }
        return null;
    }
}