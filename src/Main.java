import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    private static final Map<Character, Integer> ROMAN_VALUES = new LinkedHashMap<>();

    static {
        ROMAN_VALUES.put('M', 1000);
        ROMAN_VALUES.put('D', 500);
        ROMAN_VALUES.put('C', 100);
        ROMAN_VALUES.put('L', 50);
        ROMAN_VALUES.put('X', 10);
        ROMAN_VALUES.put('V', 5);
        ROMAN_VALUES.put('I', 1);
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
        for (Map.Entry<Character, Integer> entry : ROMAN_VALUES.entrySet()) {
            char symbol = entry.getKey();
            int value = entry.getValue();

            while (num >= value) {
                roman.append(symbol);
                num -= value;
            }

            int nextIndex = ROMAN_VALUES.size() - 1;
            for (int i = ROMAN_VALUES.size() - 1; i >= 0; i--) {
                char nextSymbol = (char) ROMAN_VALUES.keySet().toArray()[i];
                int nextValue = ROMAN_VALUES.get(nextSymbol);

                if (nextValue + value <= num) {
                    roman.append(nextSymbol).append(symbol);
                    num -= (nextValue - value);
                    break;
                }
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
