import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nhập chuỗi: ");
            String input = scanner.nextLine();

            // Tách các từ trong chuỗi
            String[] words = input.split(" ");

            // Tìm từ ngắn nhất cuối cùng và từ dài nhất đầu tiên
            String shortestLast = words[words.length - 1];
            String longestFirst = words[0];
            for (String word : words) {
                if (word.length() < shortestLast.length()) {
                    shortestLast = word;
                }
                if (word.length() > longestFirst.length()) {
                    longestFirst = word;
                }
            }

            System.out.println("Từ ngắn nhất cuối cùng: " + shortestLast);
            System.out.println("Từ dài nhất đầu tiên: " + longestFirst);
        }
    }
}
