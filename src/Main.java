import java.util.HashMap;
import java.util.Map;

public class Main {
    private static final Map<Character, Integer> ROMAN_VALUES = new HashMap<>();
    static {
        ROMAN_VALUES.put('I', 1);
        ROMAN_VALUES.put('V', 5);
        ROMAN_VALUES.put('X', 10);
        ROMAN_VALUES.put('L', 50);
        ROMAN_VALUES.put('C', 100);
        ROMAN_VALUES.put('D', 500);
        ROMAN_VALUES.put('M', 1000);
    }
    public static void main(String[] args) {
        int num = 1984;
        String romanNumeral = intToRoman(num);
        System.out.println("Integer " + num + " as Roman Numeral: " + romanNumeral);

        String roman = "MCMLXXXIV";
        int integer = romanToInt(roman);
        System.out.println("Roman Numeral " + roman + " as Integer: " + integer);
    }

    public static String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return "Invalid input";
        }

        StringBuilder roman = new StringBuilder();
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                roman.append(symbols[i]);
                num -= values[i];
            }
        }

        return roman.toString();
    }
    public static int romanToInt(String s) {
        int result = 0;
        int prevValue = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            char currentSymbol = s.charAt(i);
            int currentValue = ROMAN_VALUES.get(currentSymbol);

            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }

            prevValue = currentValue;
        }

        return result;
    }

}

