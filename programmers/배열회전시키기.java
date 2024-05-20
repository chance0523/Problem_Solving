class Solution {
    public int[] solution(int[] numbers, String direction) {
        if (direction.equals("left")) {
            return left(numbers);
        }
        else {
            return right(numbers);
        }
    }
    
    private int[] left(int[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 0; i < numbers.length - 1; i++) {
            answer[i] = numbers[i + 1];
        }
        answer[numbers.length - 1] = numbers[0];
        
        return answer;
    }
    
      private int[] right(int[] numbers) {
        int[] answer = new int[numbers.length];
        for (int i = 1; i < numbers.length; i++) {
            answer[i] = numbers[i - 1];
        }
        answer[0] = numbers[numbers.length - 1];
        
        return answer;
    }
}
