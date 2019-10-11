package algorithm.ArrayAndString;

public class BullsAndCows {
    public static void main(String[] args) {
        System.out.println(new BullsAndCows().getHint("1123", "0111"));
    }

    public String getHint(String secret, String guess) {
        if (secret.length() != guess.length()) return "error";
        int n = secret.length();
        int[] arrS = new int[10];
        int[] arrG = new int[10];
        int bull = 0;
        for (int i=0; i<n; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
                continue;
            }
            arrS[secret.charAt(i) - '0']++;
            arrG[guess.charAt(i) - '0']++;
        }

        int cow = 0;
        for (int i=0; i<10; i++) {
            cow += Math.min(arrS[i], arrG[i]);
        }

        return bull + "A" + cow + "B";
    }
}
