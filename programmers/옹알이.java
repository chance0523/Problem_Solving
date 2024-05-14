class Solution {
	public int solution(String[] babbling) {
		int answer = 0;
		String[] words = {"aya", "ye", "woo", "ma"};
		for (int i = 0; i < babbling.length; i++) {
			String word = babbling[i];
			for (int j = 0; j < words.length; j++) {
				word = word.replace(words[j], " ");
				if (word.trim().length() == 0) {
					answer += 1;
					break;
				}
			}
		}
		return answer;
	}
}