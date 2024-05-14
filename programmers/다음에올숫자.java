class Solution {
	public int solution(int[] common) {
		int answer = 0;
		int last = common[common.length - 1];
		if (common[2] - common[1] == common[1] - common[0]) {
			// 등차
			answer = last + (common[2] - common[1]);
		} else {
			answer = last * (common[2] / common[1]);
		}
		return answer;
	}
}