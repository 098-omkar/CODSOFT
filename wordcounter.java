import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class wordcounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a text or provide a file path to count the words (or 'q' to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            String text;
            if (input.endsWith(".txt")) {
                text = readFile(input);
                if (text == null) {
                    System.out.println("Error reading the file. Please make sure the file exists and is accessible.");
                    continue;
                }
            } else {
                text = input;
            }

            String[] words = text.split("[\\p{Punct}\\s]+");

            int wordCount = 0;

            for (String word : words) {
                if (StopWord(word)) {
                    wordCount++;
                }
            }

            System.out.println("Total words: " + wordCount);

            Map<String, Integer> wordFrequency = getWordFrequency(words);
            System.out.println("Unique words: " + wordFrequency.size());
            System.out.println("Word frequency:");
            for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    private static String readFile(String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            StringBuilder stringBuilder = new StringBuilder();
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine()).append("\n");
            }
            scanner.close();
            return stringBuilder.toString();
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    private static boolean StopWord(String word) {
        String[] stopWords = {"a", "an", "the", "and", "or", "but", "in", "on", "at", "to", "from", "with"};
        return !Arrays.asList(stopWords).contains(word.toLowerCase());
    }

    private static Map<String, Integer> getWordFrequency(String[] words) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            if (StopWord(word)) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0));
            }
        }
        return frequencyMap;
    }
}
