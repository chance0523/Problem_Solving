class Solution {
    public long solution(String numbers) {
        long answer = 0;
        String[] num_list = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
        
        for (int i = 0; i < num_list.length; i++) {
            numbers = numbers.replace(num_list[i], String.valueOf(i));
        }
        
        return Long.parseLong(numbers);
    }
}
