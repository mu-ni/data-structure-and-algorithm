package algorithm.ArrayAndString;

public class BullsAndCows {
    public static void main(String[] args) {
        System.out.println(new BullsAndCows().getHint("1123", "0111"));
        System.out.println(new BullsAndCows().getHint2("1123", "0111"));
    }

    public String getHint(String secret, String guess) {
        if (secret.length() != guess.length()) return "error";
        int n = secret.length();
        int[] s = new int[10];
        int[] g = new int[10];
        int bull = 0;
        int cow = 0;
        for (int i=0; i<n; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
            } else {
                s[secret.charAt(i) - '0']++;
                g[guess.charAt(i) - '0']++;
            }
        }
        for (int i=0; i<10; i++) {
            cow += Math.min(s[i], g[i]);
        }
        return bull + "A" + cow + "B";
    }

    public String getHint2(String secret, String guess) {
        if (secret.length() != guess.length()) return "error";
        int n = secret.length();
        int[] arr = new int[10];
        int bull = 0;
        int cow = 0;
        for (int i=0; i<n; i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bull++;
                continue;
            }
            if (arr[secret.charAt(i) - '0']++ < 0) {
                cow++;
            }
            if (arr[guess.charAt(i) - '0']-- > 0) {
                cow++;
            }
        }

        return bull + "A" + cow + "B";
    }
}
