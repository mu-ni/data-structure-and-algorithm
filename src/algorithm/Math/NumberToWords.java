package algorithm.Math;

public class NumberToWords {
    public static void main(String[] args) {
        System.out.println(new NumberToWords().numberToWords(6));
        System.out.println(new NumberToWords().numberToWords(18));
        System.out.println(new NumberToWords().numberToWords(45));
        System.out.println(new NumberToWords().numberToWords(456));
        System.out.println(new NumberToWords().numberToWords(6712));
        System.out.println(new NumberToWords().numberToWords(12345));
        System.out.println(new NumberToWords().numberToWords(8275372));
        System.out.println(new NumberToWords().numberToWords(98567541));
        System.out.println(new NumberToWords().numberToWords(985267541));
    }

    String[] nums = new String[]{"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
    String[] teens = new String[]{"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] tens = new String[]{"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    public String numberToWords(int num) {
        return getBillion(num);
    }

    private String getNum(int num) {
        return nums[num];
    }

    private String getTen(int num) {
        if (num < 10) return getNum(num);
        if (num < 20) return teens[num - 10];

        StringBuilder sb = new StringBuilder();
        sb.append(tens[num/10]);
        if (num%10 != 0) {
            sb.append(" ").append(nums[num%10]);
        }
        return sb.toString();
    }

    private String getHundred(int num) {
        if (num < 100) return getTen(num);

        StringBuilder sb = new StringBuilder();
        sb.append(getTen(num/100)).append(" Hundred");
        if (num%100 != 0) {
            sb.append(" ").append(getTen(num%100));
        }
        return sb.toString();
    }

    private String getThousand(int num) {
        if (num < 1000) return getHundred(num);

        StringBuilder sb = new StringBuilder();
        sb.append(getHundred(num/1000)).append(" Thousand");
        if (num%1000 != 0) {
            sb.append(" ").append(getHundred(num%1000));
        }
        return sb.toString();
    }

    private String getMillion(int num) {
        if (num < 1000000) return getThousand(num);

        StringBuilder sb = new StringBuilder();
        sb.append(getThousand(num/1000000)).append(" Million");
        if (num%1000000 != 0) {
            sb.append(" ").append(getThousand(num%1000000));
        }
        return sb.toString();
    }

    private String getBillion(int num) {
        if (num < 1000000000) return getMillion(num);

        StringBuilder sb = new StringBuilder();
        sb.append(getMillion(num/1000000000)).append(" Billion");
        if (num%1000000000 != 0) {
            sb.append(" ").append(getMillion(num%1000000000));
        }
        return sb.toString();
    }
}
