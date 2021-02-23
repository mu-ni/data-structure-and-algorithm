package oa;

/**
 * Created by muni on 2021/2/23
 */
public class ThrottlingGateway {
    public static void main(String[] args) {
        int[] arriveTime = new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7,7,7,7, 11, 11, 11, 11};
        System.out.println(new ThrottlingGateway().throttlingGateway(27, arriveTime));
    }

    // 车上人数不能超过3
    // 10min内人数不能超过20 -> 20人必须在10min内到
    // 1h内人数不能超过60 -> 60人必须在1h内到
    // the last 3/20/60 visitors are within the last 1/10/60 mins
    public int throttlingGateway(int num, int[] arriveTime) {
        int cnt = 0;
        for (int i=0; i<num; i++) {
            if (i >= 3 && arriveTime[i] == arriveTime[i-3]) {
                cnt++;
            } else if (i >= 20 && arriveTime[i] - arriveTime[i-20] < 10) {
                cnt++;
            } else if (i >= 60 && arriveTime[i] - arriveTime[i-60] < 60) {
                cnt++;
            }
        }
        return cnt;
    }
}
