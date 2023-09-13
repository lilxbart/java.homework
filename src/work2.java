import java.util.Arrays; //
import java.util.HashSet; //
import java.util.Random; //
import java.util.Set; //
public class work2 {
    public static void main(String args[]) {

        System.out.println("duplicateChars('Donald'): " + duplicateChars("Donald"));

        System.out.println("getInitials('Ryan Gosling'): " + getInitials("Ryan Gosling"));

        System.out.println("differenceEvenOdd([44, 32, 86, 19]): " + differenceEvenOdd(new int[]{44, 32, 86, 19}));

        System.out.println("equalToAvg([1, 2, 3, 4, 5]): " + equalToAvg(new int[]{1, 2, 3, 4, 5}));

        System.out.println("indexMult([1, 2, 3]): " + Arrays.toString(indexMult(new int[]{1, 2, 3})));

        System.out.println("reverse('Hello World'): " + reverse("Hello World"));

        System.out.println("Tribonacci(7): " + Tribonacci(7));

        System.out.println("pseudoHash(5): " + pseudoHash(5));

        System.out.println("botHelper('Hello, I’m under the water, please help me'): " + botHelper("Hello, I’m under the water, please help me"));

        System.out.println("isAnagram('listen', 'silent'): " + isAnagram("listen", "silent"));

    }

    //задание 1
    public static boolean duplicateChars(String str) {
        Set<Character> charSet = new HashSet<>();
        for (char c : str.toCharArray()) {
            if (charSet.contains(c)) {
                return true;
            }
            charSet.add(c);
        }
        return false;
    }

    //задание 2
    public static String getInitials(String fullName) {
        String[] names = fullName.split(" ");
        StringBuilder initials = new StringBuilder();
        for (String name : names) {
            initials.append(name.charAt(0));
        }
        return initials.toString();
    }

    //задание 3
    public static int differenceEvenOdd(int[] arr) {
        int evenSum = 0, oddSum = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                evenSum += num;
            } else {
                oddSum += num;
            }
        }
        return evenSum - oddSum;
    }

    //задание 4
    public static boolean equalToAvg(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        double avg = (double) sum / arr.length;
        for (int num : arr) {
            if (num == avg) {
                return true;
            }
        }
        return false;
    }

    //задание 5
    public static int[] indexMult(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= i;
        }
        return arr;
    }

    //задание 6
    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    //задание 7
    public static int Tribonacci(int n) {
        if (n == 0 || n == 1) return 0;
        if (n == 2) return 1;
        int a = 0, b = 0, c = 1, d;
        for (int i = 3; i <= n; i++) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }

    //задание 8
    public static String pseudoHash(int length) {
        StringBuilder sb = new StringBuilder();
        Random rand = new Random();
        String chars = "abcdef0123456789";
        for (int i = 0; i < length; i++) {
            sb.append(chars.charAt(rand.nextInt(chars.length())));
        }
        return sb.toString();
    }

    //задание 9
    public static String botHelper(String str) {
        if (str.toLowerCase().contains("help")) {
            return "Calling for a staff member";
        }
        return "Keep waiting";
    }

    //задание 10
    public static boolean isAnagram(String str1, String str2) {
        char[] chars1 = str1.replaceAll("\\s", "").toCharArray();
        char[] chars2 = str2.replaceAll("\\s", "").toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        return Arrays.equals(chars1, chars2);
    }
}
