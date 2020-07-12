package algorithm.BitOperation;

public class ReverseBits {
    public static void main(String[] args) {
        int rst = new ReverseBits().reverseBits(Integer.parseInt("00000010100101000001111010011100", 2));
        System.out.println(Integer.toBinaryString(rst));
    }

    public int reverseBits(int n) {
        int rst = 0;
        for (int i=31; i>=0; i--) {
            rst += (n & 1) << i;
            n >>= 1;
        }
        return rst;
    }
}
