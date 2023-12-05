import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class work5 {
        public static void main(String[] args) {

            System.out.println("задание1: " + sameLetterPattern("ABAB", "CDCD"));
            System.out.println(sameLetterPattern("ABCBA", "BCDCB"));
            System.out.println(sameLetterPattern("FFGG", "CDCD"));
            System.out.println(sameLetterPattern("FFFF", "ABCD"));

            System.out.println("задание2: " + spiderVsFly("H3", "E2"));
            System.out.println(spiderVsFly("A4", "B2"));
            System.out.println(spiderVsFly("A4", "C2"));

            System.out.println("задание3: " + digitsCount(4666)); // 4
            System.out.println(digitsCount(544)); // 3
            System.out.println(digitsCount(121317)); // 6
            System.out.println(digitsCount(0)); // 1
            System.out.println(digitsCount(12345)); // 5
            System.out.println(digitsCount(1289396387328L));

            System.out.println("задание4: " + totalPoints(new String[]{"cat", "create", "sat"}, "caster")); // 2
            System.out.println(totalPoints(new String[]{"trance", "recant"}, "recant")); // 108
            System.out.println(totalPoints(new String[]{"dote", "dotes", "toes", "set", "dot", "dots", "sted"}, "tossed")); // 13

            System.out.println("задание5: " + Arrays.deepToString(sumsUp(new int[]{1, 2, 3, 4, 5}))); // [[3, 5]]
            System.out.println(Arrays.deepToString(sumsUp(new int[]{1, 2, 3, 7, 9}))); // [[1, 7]]
            System.out.println(Arrays.deepToString(sumsUp(new int[]{10, 9, 7, 2, 8}))); // []
            System.out.println(Arrays.deepToString(sumsUp(new int[]{1, 6, 5, 4, 8, 2, 3, 7}))); // [[2, 6], [3, 5], [1, 7]]

            System.out.println("задание6: " + takeDownAverage(new String[]{"95%", "83%", "90%", "87%", "88%", "93%"})); // "54%"
            System.out.println(takeDownAverage(new String[]{"10%"})); // "0%"
            System.out.println(takeDownAverage(new String[]{"53%", "79%"})); // "51%"

            System.out.println("задание7: " + caesarCipher(new String[] {"encode"}, "HELLO WORLD", 3));
            System.out.println(caesarCipher(new String[] {"encode"}, "almost last task!", 4));

            System.out.println("задание8: " + setSetup(5, 3)); // 60
            System.out.println(setSetup(7, 3)); // 210

            System.out.println("задание9: " + timeDifference("Los Angeles", "April 1, 2011 23:23", "Canberra")); // 2011-4-2 17:23
            System.out.println(timeDifference("London", "July 31, 1983 23:01", "Rome")); // 1983-8-1 00:01
            System.out.println(timeDifference("New York", "December 31, 1970 13:40", "Beijing")); // 1971-1-1 02:40

            System.out.println("задание10: " + isNew(3));
            System.out.println(isNew(30));
            System.out.println(isNew(321));
            System.out.println(isNew(123));




        }



        //задание1(один ли шаблон)
        public static boolean sameLetterPattern(String str1, String str2) {
            if (str1.length() != str2.length()) {//размер
                return false;
            }

            for (int i = 1; i < str1.length(); i++) {
                if (str1.charAt(i) - str1.charAt(i - 1) != str2.charAt(i) - str2.charAt(i - 1)) {
                    return false;//проверка самих символов
                }
            }
            return true;
        }

        //задание2
        public static String spiderVsFly(String Spider, String Fly){
            int spider = Character.getNumericValue(Spider.charAt(1));
            int fly = Character.getNumericValue(Fly.charAt(1));

            int circleDif = Math.abs(Spider.charAt(0) - Fly.charAt(0));

            int walk = 1;

            double minLen = 100;
            int min_route = 0;

            StringBuilder path = new StringBuilder();

            int spiderMove = min_route > spider ? 1 : -1;

            int flyMove = min_route > fly ? -1 : 1;

            if (circleDif > 8 - circleDif){
                circleDif = 8 - circleDif;
                walk = -1;
            }

            for (int i = 0; i < 5; i++){
                double len = (Math.abs(spider - i) + Math.abs(fly - i)
                );

                len += circleDif * Math.sqrt(i*i*2 - 2*i*i*Math.cos(Math.toRadians(45)));

                if (len < minLen) {
                    minLen = len;
                    min_route = i;
                }
            }

            for (int i = spider; i != min_route + spiderMove; i += spiderMove){
                if (i == 0){
                    path.append('A');
                }
                else {
                    path.append(Spider.charAt(0));
                }

                path.append(i).append('-');
            }

            if (min_route != 0){
                for (int i = 0; i < circleDif; i++){
                    path.append(Character.toString(path.charAt(path.length() - 3) + walk))
                            .append(min_route).append('-');
                }
            }

            for (int i = min_route + flyMove; i != fly + flyMove; i += flyMove){

                path.append(Fly.charAt(0));
                path.append(i).append('-');
            }

            path.deleteCharAt(path.length()-1);

            return path.toString();
        }

        //задание3(колво цифр)
        public static int digitsCount(long n) {
            return n < 10 ? 1 : 1 + digitsCount(n / 10);//через оператор
    }

        //задание4(найти слова за баллы)
        public static int totalPoints(String[] words, String scrambled) {
            int result = 0;
            Map<Character, Integer> scrambledMap = createCharMap(scrambled);//словарь символов из ключевого слова

            for (String word : words) {
                if (isValidWord(word, scrambledMap)) {
                    result += word.length() == 3 ? 1 : word.length() == 4 ? 2 : word.length() == 5 ? 3 : 54;
                }
            }
            return result;
        }

    private static boolean isValidWord(String word, Map<Character, Integer> scrambledMap) {
        Map<Character, Integer> wordMap = createCharMap(word);//словарь символов из слова
        for (char c : wordMap.keySet()) {
            if (!scrambledMap.containsKey(c) || wordMap.get(c) > scrambledMap.get(c)) {
                return false;
            }
        }
        return true;
    }

    private static Map<Character, Integer> createCharMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

        //задание5(пара дающая 8)
        public static int[][] sumsUp(int[] arr) {
            List<int[]> pairs = new ArrayList<>();
            Set<Integer> set = new HashSet<>();

            for (int num : arr) {
                if (set.contains(8 - num)) {//есть ли "8 - 5 = 5 == 3,5"
                    pairs.add(new int[]{8 - num, num});
                }
                set.add(num);
            }
            for (int[] pair : pairs) {
                Arrays.sort(pair);//сортировка внутри пар
            }

            return pairs.toArray(new int[pairs.size()][]);
        }

        //задание6
        public static String takeDownAverage(String[] percents) {
            int avg = 0;
            for (String s : percents)
                avg += Integer.parseInt(s.substring(0, s.length() - 1));
            return (avg / percents.length - percents.length*5 - 5) + "%";
        }

        //задание7
        public static String caesarCipher(String[] operation, String message, int shift) {
            StringBuilder result = new StringBuilder();
            String mode = operation[0].toLowerCase();

            for (char character : message.toCharArray()) {
                if (Character.isLetter(character)) { // Проверка, является ли символ буквой
                    int base = Character.isUpperCase(character) ? 'A' : 'a';
                    if (mode.equals("decode")) {
                        shift = (shift % 26 + 26) % 26; // Учтем обратный сдвиг по модулю 26
                        char shifted = (char) (((character - base - shift + 26) % 26) + base); // Декодирование
                        result.append(shifted);
                    } else {
                        char shifted = (char) (((character - base + shift) % 26) + base); // Шифрование
                        result.append(shifted);
                    }
                } else {
                    result.append(character); // Если символ не является буквой, добавляем его без изменений
                }
            }

            return result.toString();
        }



    //задание8
        public static int setSetup(int n, int k) {
            return factorial(n) / factorial(n - k);
        }

    private static int factorial(int number) {
        if (number <= 1) {
            return 1;
        }
        return number * factorial(number - 1);
    }

        //задание9
        public static String timeDifference(String cityA, String timestamp, String cityB) {
            Map<String, String> timeZones = new HashMap<>();
            timeZones.put("Los Angeles", "GMT-08:00");
            timeZones.put("New York", "GMT-05:00");
            timeZones.put("Caracas", "GMT-04:30");
            timeZones.put("Buenos Aires", "GMT-03:00");
            timeZones.put("London", "GMT");
            timeZones.put("Rome", "GMT+01:00");
            timeZones.put("Moscow", "GMT+03:00");
            timeZones.put("Tehran", "GMT+03:30");
            timeZones.put("New Delhi", "GMT+05:30");
            timeZones.put("Beijing", "GMT+08:00");
            timeZones.put("Canberra", "GMT+10:00");

            SimpleDateFormat originalFormat = new SimpleDateFormat("MMMM d, yyyy HH:mm", Locale.ENGLISH);
            originalFormat.setTimeZone(TimeZone.getTimeZone(timeZones.get(cityA)));

            SimpleDateFormat targetFormat = new SimpleDateFormat("MMMM d, yyyy HH:mm", Locale.ENGLISH);
            targetFormat.setTimeZone(TimeZone.getTimeZone(timeZones.get(cityB)));

            try {
                Calendar cal = Calendar.getInstance();
                cal.setTime(originalFormat.parse(timestamp));
                return targetFormat.format(cal.getTime());
            } catch (ParseException e) {
                e.printStackTrace();
                return "Invalid date format";
            }

        }

        //задание10
            public static boolean isNew(int number) {
                if (number < 10) {
                    return true;
                }
                char[] digits = String.valueOf(number).toCharArray();
                for (int i = 1; i < digits.length; i++) {
                    if (digits[i] != '0' && digits[i] < digits[0]) {
                        return false;
                    }
                }
                return true;
            }
}