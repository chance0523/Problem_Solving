class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int lastAttackTime = attacks[attacks.length - 1][0];
        
        int castingTime = bandage[0];
        int recovery = bandage[1];
        int addRecovery = bandage[2];
        int success = 0;
        
        int idx = 0;
        
        for (int i = 0; i <= lastAttackTime; i++) {
            int attackTime = attacks[idx][0];
            int damage = attacks[idx][1];
            
            if (attackTime == i) {
                // 몬스터에게 공격 당함
                answer -= damage;
                success = 0;
                idx++;
            }
            else {
                // 회복
                success++;
                if (success == castingTime) {
                    answer += (recovery + addRecovery);
                    success = 0;
                }
                else {
                    answer += recovery;
                }
               
                if (answer > health) {
                    answer = health;
                }
            }

            if (answer <= 0) {
                return -1;
            }
        }
        
        return answer;
    }
}
