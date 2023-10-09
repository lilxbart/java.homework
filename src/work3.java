import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;


public class work3 {
    public static void main(String[] args) {
        System.out.println("задание1: " + duplicateChars("apple"));
        System.out.println(duplicateChars("Even if you did this task not by yourself, you have to understand every single line of code."));

        System.out.println("задание2: " + stringTransform("heDoubleLo"));
        System.out.println(stringTransform("bookkeeper"));

        System.out.println("задание3: " + doesBlockkFit(1, 3, 5, 4, 5));
        System.out.println(doesBlockkFit(1, 8, 1, 1, 1));
        System.out.println(doesBlockkFit(1, 2, 2, 1, 1));

        System.out.println("задание4:" + numCheck(243));
        System.out.println(numCheck(52));

        System.out.println("задание5:" + countRoots(new int[]{1, -3, 2}));
        System.out.println(countRoots(new int[]{2, 5, 2}));
        System.out.println(countRoots(new int[]{1, -6, 9}));

        System.out.println("задание6:" + Arrays.toString(salesData(new String[][]{
                {"Apple", "Shop1", "Shop2", "Shop3", "Shop4"},
                {"Banana", "Shop2", "Shop3", "Shop4"},
                {"Orange", "Shop1", "Shop3", "Shop4"},
                {"Pear", "Shop2", "Shop4"}})));

        System.out.println("задание7:" + validSplit("apple eagle egg goat"));
        System.out.println(validSplit("cat dog goose fish"));
        System.out.println(validSplit("cat Town"));

        System.out.println("задание8" + waveForm(new int[]{3, 1, 4, 2, 7, 5}));
        System.out.println(waveForm(new int[]{1, 2, 3, 4, 5}));
        System.out.println(waveForm(new int[]{1, 2, -6, 10, 3}));

        System.out.println("задание9: " + commonVovel("Hello world"));
        System.out.println(commonVovel("Actions speak louder than words."));

        System.out.println("задание10: " + Arrays.deepToString(dataScience(new int[][]{
                {6, 4, 19, 0, 0},
                {81, 25, 3, 1, 17},
                {48, 12, 60, 32, 14},
                {91, 47, 16, 65, 217},
                {5, 73, 0, 4, 21}})));
    }

    //задание 1
    public static String duplicateChars(String str) {
        str = str.toLowerCase();
        str = str.replaceAll("[eyuioa]", "*");
        return str;
    }

    //задание 2(разобраться с метасимволами)
    public static String stringTransform(String str) {
        String result = str.replaceAll("(\\w)\\1", "Double$1");
        return (result);
    }

    //задание 3 (разобрать)
    static boolean doesBlockkFit(int a, int b, int c, int w, int h) {
        int[] kubik = {a, b, c};
        int[] otverstie = {w, h};

        Arrays.sort(kubik);
        Arrays.sort(otverstie);

        return kubik[0] <= otverstie[0] && kubik[1] <= otverstie[1];
    }


    //задание 4
    public static boolean numCheck(int x) {

        String numberString = Integer.toString(x);//перевод числа в строку
        char[] charArray = numberString.toCharArray();//перевод строки в массив элементов

        int[] intArray = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            intArray[i] = Character.getNumericValue(charArray[i]);//цикл для перевода в массив чисел
        }

        int sum = 0;

        for (int i = 0; i < intArray.length; i++) {//по индексам
            int square = intArray[i] * intArray[i];
            sum += square;
        }
        return (x % 2 == 0 && sum % 2 == 0) || (x % 2 != 0 && sum % 2 != 0);//учитываем оба случая
    }

    //задание 5
    public static int countRoots(int[] arr) {

        int a = arr[0];
        int b = arr[1];
        int c = arr[2];
        int discriminant = b * b - 4 * a * c;

        if (discriminant < 0) {// Нет целочисленных корней
            return 0;
        } else if (discriminant == 0) {// Один целочисленный корень
            return 1;
        } else {// Два целочисленных корня
            return 2;
        }


    }

    //задание 6 разобраться с двумерными массивами(!)
    public static String[] salesData(String[][] data) {
        int maxLen = 0;
        for (String[] row : data) {
            if (row.length > maxLen) {
                maxLen = row.length;
            }
        }
        int count = 0;
        String[] result = new String[data.length];
        for (String[] row : data) {
            if (row.length == maxLen) {
                result[count] = row[0];
                count++;
            }
        }
        return Arrays.copyOf(result, count);
    }


    //задание 7
    public static boolean validSplit(String str) {

        str = str.toLowerCase();//в строчную
        str = str.replaceAll("[,.!?]", " ");
        String[] words = str.split(" ");//результат массив строк

        for (int i = 1; i < words.length; i++) {
            if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                return false;
            }
        }
        return true;
    }

    //задание 8 переделать(можно сделать проще взяв другой флаг)

    public static boolean waveForm(int[] arr) {

        if (arr.length < 3)
            return false;

        boolean increasing = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if ((increasing && arr[i] <= arr[i + 1]) || (!increasing && arr[i] >= arr[i + 1])) {
                return false;
            }
            increasing = !increasing;
        }
        return true;
    }

    //задание 9 переделать(тоже можно переделать)
    public static char commonVovel(String str) {
        String sentence = str.toLowerCase();
        Map<Character, Integer> vowelCount = new HashMap<>();
        String vowels = "aeiou"; // Гласные буквы

        for (char vowel : vowels.toCharArray()) {
            vowelCount.put(vowel, 0);
        }

        for (char letter : sentence.toCharArray()) {
            if (vowelCount.containsKey(letter)) {
                vowelCount.put(letter, vowelCount.get(letter) + 1);
            }
        }
        char mostCommonVowel = ' ';
        int maxCount = 0;

        for (char vowel : vowels.toCharArray()) {
            int count = vowelCount.get(vowel);
            if (count > maxCount) {
                maxCount = count;
                mostCommonVowel = vowel;
            }
        }

        return mostCommonVowel;
    }

    //задание 10
    public static int[][] dataScience(int[][] arrays) {
        int n = arrays.length;
        for (int i = 0; i < n; i++) {
            int total = 0;
            for (int k = 0; k < n; k++) {
                if (k != i) {
                    total += arrays[k][i];
                }
            }
            arrays[i][i] = total / (n - 1);
        }
        return arrays;
    }


}

