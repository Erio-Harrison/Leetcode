package problems;

/*
    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.
 */

public class Lee12 {
    public String intToRoman(int num) {
        StringBuilder builder = new StringBuilder();
        builder.append(intToRomanDigit(num / 1000, "M", "Z", "Z"));
        builder.append(intToRomanDigit(num / 100, "C", "D", "M"));
        builder.append(intToRomanDigit(num / 10, "X", "L", "C"));
        builder.append(intToRomanDigit(num / 1, "I", "V", "X"));
        return builder.toString();
    }

    /**
     * Based on the num % 5, select and positioned the character.
     * @param num numeric to be transfered
     * @param unit I, X, or C in Roman
     * @param five V, L, or D in Roman
     * @param ten  X, C, or M in Roman
     * @return roman as combination of unit, five and ten
     */
    public String intToRomanDigit(int num, String unit, String five, String ten) {
        int digit = num % 10;
        int mod5 = num % 5;
        if (digit == 0) {
            return "";
        }
        if (mod5 == 0) return five;
        if (mod5 == 4) {
            if (digit > 5) {
                return unit + ten;
            } else {
                return unit + five;
            }
        }
        StringBuilder builder = new StringBuilder();
        if (digit > 5) builder.append(five);
        for (int i = 0; i < mod5; i++) builder.append(unit);
        return builder.toString();
    }
}
