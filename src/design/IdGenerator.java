package design;

public class IdGenerator {
    char[] chars;
    int n;
    int count;

    public IdGenerator(char[] chars, int n) {
        this.chars = chars;
        this.n = n;
        count = 1;
    }

    public String generateId() {
        StringBuilder sb = new StringBuilder();
        int num = count;
        while (num > 0) {
            num--;
            int index = num%chars.length;
            sb.append(chars[index]);
            num /= chars.length;
        }
        count++;
        String id = sb.toString();
        if (!isValid(id)) {
            id = generateId();
        }
        return id;
    }

    public boolean isValid(String id) {
        if (id.length() < n) return true;
        int slow = 0;
        int fast = 0;
        while (fast < id.length()) {
            if (id.charAt(fast) == id.charAt(slow)) {
                fast++;
                if (fast - slow >= n) return false;
            } else {
                slow = fast;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        IdGenerator generator = new IdGenerator(new char[]{'a', 'b', 'c'}, 3);
        for (int i=0; i<100; i++) {
            System.out.println(generator.generateId());
        }
    }
}
