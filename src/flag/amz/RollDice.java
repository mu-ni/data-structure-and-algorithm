package flag.amz;

/**
 * Created by muni on 2019/12/9
 */
public class RollDice {
    public static void main(String[] args) {
        RollDice rd = new RollDice();
        System.out.println(rd.rollDiceSolution(new int[]{1,2,3}));
        System.out.println(rd.rollDiceSolution(new int[]{1,1,6}));
        System.out.println(rd.rollDiceSolution(new int[]{1,6,2,3}));
    }

    public int rollDiceSolution(int[] nums) {
        int min = Integer.MAX_VALUE;
        int[] cnt = new int[7];
        for (int num : nums) cnt[num]++;
        //iterate all six of possible final numbers
        //Then number of rolls can be calculated directly
        for (int i = 1; i < 7; i++) {
            int rollNum = 0;
            for(int j = 1; j < 7;j++) {
                if(j == i) continue; // if the current dice already show the final number, just skip it
                if(j + i == 7) {
                    rollNum += 2*cnt[j];
                }else {
                    rollNum += cnt[j];
                }
            }
            min = Math.min(rollNum, min);
        }
        return min;
    }
}
