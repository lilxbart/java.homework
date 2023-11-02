import java.util.*;
public class work4 {
    public static void main(String[] args) {
        // Задача 1: Удаление повторяющихся символов из строки
        System.out.println("задание1: " + nonRepeatable("abracadabra"));
        System.out.println(nonRepeatable("paparazzi"));

        // Задача 2: Генерация комбинаций скобок
        System.out.println("задание2: " + generateBrackets(1));
        System.out.println(generateBrackets(2));
        System.out.println(generateBrackets(3));

        // Задача 3: Генерация бинарных комбинаций без соседствующих нулей
        System.out.println("задание3: " + binarySystem(3));
        System.out.println(binarySystem(4));

        // Задача 4: Поиск самой длинной последовательности
        System.out.println("задание4: " + alphabeticRow("abcdjuwx"));
        System.out.println(alphabeticRow("klmabzyxw"));

        // Задача 5: Подсчет и сортировка символов(!)
        System.out.println("задание5: " + countAndSortCharacters("aaabbcdd"));
        System.out.println(countAndSortCharacters("vvvvaajaaaaa"));

        // Задача 6: Преобразование строки в число
        System.out.println("задание6: " + convertToNum("eight"));
        System.out.println(convertToNum("five hundred sixty seven"));
        System.out.println(convertToNum("thirty one"));

        // Задача 7: Поиск подстроки максимальной длины с уникальными элементами
        System.out.println("задание7: " + uniqueSubstring("123412324"));
        System.out.println(uniqueSubstring("111111"));
        System.out.println(uniqueSubstring("77897898"));

        // Задача 8: Поиск наименьшего матричного пути
        System.out.println("задание8: " + shortestWay(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
        System.out.println(shortestWay(new int[][]{{2, 7, 3}, {1, 4, 8}, {4, 5, 9}}));

        // Задача 9: Создание новой строки на основе расположения чисел
        System.out.println("задание9: " + numericOrder("t3o the5m 1One all6 r4ule ri2ng"));
        System.out.println(numericOrder("re6sponsibility Wit1h gr5eat power3 4comes g2reat"));

        // Задача 10: Максимизация второго числа(!!!!)
        System.out.println("задание10: " + switchNums(519, 723));
        System.out.println(switchNums(491, 3912));
        System.out.println(switchNums(6274, 71259));

    }

    // Задача 1: Удаление повторяющихся символов из строки
    public static String nonRepeatable(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (result.indexOf(String.valueOf(c)) == -1) {
                result.append(c);
            }
        }
        return result.toString();
    }

    // Задача 2: Генерация комбинаций скобок
    public static List<String> generateBrackets(int n) {
        List<String> result = new ArrayList<>();
        generateBracketsHelper(n, n, "", result);
        return result;
    }

    private static void generateBracketsHelper(int open, int close, String current, List<String> result) {
        if (open == 0 && close == 0) {
            result.add(current);
            return;
        }
        if (open > 0) {
            generateBracketsHelper(open - 1, close, current + "(", result);
        }
        if (close > open) {
            generateBracketsHelper(open, close - 1, current + ")", result);
        }
    }

    // Задача 3: Генерация бинарных комбинаций без соседствующих нулей
    public static List<String> binarySystem(int n) {
        List<String> result = new ArrayList<>();
        generateBinaryCombinations(n, "", result);
        return result;
    }

    private static void generateBinaryCombinations(int n, String current, List<String> result) {
        if (current.length() == n) {
            result.add(current);
            return;
        }
        if (current.length() == 0 || current.charAt(current.length() - 1) == '1') {
            generateBinaryCombinations(n, current + "0", result);
        }
        generateBinaryCombinations(n, current + "1", result);
    }

    // Задача 4: Поиск самой длинной последовательности
    public static String alphabeticRow(String str) {
        int maxLen = 0;
        String maxRow = "";
        String currentRow = String.valueOf(str.charAt(0));

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) - str.charAt(i - 1) == 1 || str.charAt(i) - str.charAt(i - 1) == -1) {
                currentRow += str.charAt(i);
            } else {
                if (currentRow.length() > maxLen) {
                    maxLen = currentRow.length();
                    maxRow = currentRow;
                }
                currentRow = String.valueOf(str.charAt(i));
            }
        }
        if (currentRow.length() > maxLen) {
            maxRow = currentRow;
        }
        return maxRow;
    }

    // Задача 5: Подсчет и сортировка символов
    public static String countAndSortCharacters(String str) {
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        StringBuilder result = new StringBuilder();
        char[] sortedChars = str.toCharArray();
        Arrays.sort(sortedChars);

        for (char c : sortedChars) {
            result.append(c);
            result.append(charCount.get(c));
        }
        return result.toString();
    }
    // Задача 6: Преобразование строки в число
    public static int convertToNum(String str) {
        // Создаем словарь чисел
        Map<String, Integer> numDict = new HashMap<>();

        numDict.put("zero", 0);
        numDict.put("one", 1);
        numDict.put("two", 2);
        numDict.put("three", 3);
        numDict.put("four", 4);
        numDict.put("five", 5);
        numDict.put("six", 6);
        numDict.put("seven", 7);
        numDict.put("eight", 8);
        numDict.put("nine", 9);
        numDict.put("ten", 10);
        numDict.put("eleven", 11);
        numDict.put("twelve", 12);
        numDict.put("thirteen", 13);
        numDict.put("fourteen", 14);
        numDict.put("fifteen", 15);
        numDict.put("sixteen", 16);
        numDict.put("seventeen", 17);
        numDict.put("eighteen", 18);
        numDict.put("nineteen", 19);
        numDict.put("twenty", 20);
        numDict.put("thirty", 30);
        numDict.put("forty", 40);
        numDict.put("fifty", 50);
        numDict.put("sixty", 60);
        numDict.put("seventy", 70);
        numDict.put("eighty", 80);
        numDict.put("ninety", 90);
        numDict.put("hundred", 100);
        numDict.put("thousand", 1000);

        String[] words = str.split(" ");//строку на слова
        int result = 0;

        for (String word : words) {
            if (numDict.containsKey(word)) {
                if (word.contains("hundred")) {
                    result = result * 100;
                } else if (word.contains("thousand")){
                    result = result * 1000;
                } else {
                    result = result + numDict.get(word);
                }
            }
        }
        return result;
    }

    // Задача 7: Поиск подстроки максимальной длины с уникальными элементами
    public static String uniqueSubstring(String digits) {
        Set<Character> uniqueChars = new HashSet<>();
        String maxSubstring = "";
        String currentSubstring = "";

        for (char c : digits.toCharArray()) {
            if (uniqueChars.contains(c)) {
                int startIndex = currentSubstring.indexOf(c);
                currentSubstring = currentSubstring.substring(startIndex + 1);
            }
            uniqueChars.add(c);
            currentSubstring += c;
            if (currentSubstring.length() > maxSubstring.length()) {
                maxSubstring = currentSubstring;
            }
        }

        return maxSubstring;
    }

    // Задача 8: Поиск наименьшего матричного пути
    public static int shortestWay(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        // Заполним первую строку и первый столбец
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        // Заполним остальные ячейки
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    // Задача 9: Создание новой строки на основе расположения чисел
    public static String numericOrder(String str) {
        String[] words = str.split(" ");
        Map<Integer, String> wordMap = new HashMap<>();

        for (String word : words) {
            int order = Integer.parseInt(word.replaceAll("[^0-9]", ""));
            wordMap.put(order, word);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= words.length; i++) {
            result.append(wordMap.get(i));
            if (i < words.length) {
                result.append(" ");
            }
        }
        String finalResult = result.toString().replaceAll("\\d", "");

        return finalResult;
    }

    // Задача 10: Максимизация второго числа(логика понятна реализация нет)
    public static int switchNums(int num1, int num2) {
        char[] num1Digits = Integer.toString(num1).toCharArray();
        char[] num2Digits = Integer.toString(num2).toCharArray();

        Arrays.sort(num1Digits);
        Arrays.sort(num2Digits);

        int j = num2Digits.length - 1;

        for (int i = num1Digits.length - 1; i >= 0 && j >= 0; i--) {
            if (num1Digits[i] < num2Digits[j]) {
                num1Digits[i] = num2Digits[j];
                j--;
            }
        }

        return Integer.parseInt(new String(num1Digits));
    }
}