package CamelCase;

import java.util.Scanner;

public class CamelCase {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the operation: ");
        String input = scanner.nextLine();
        StringBuilder output = new StringBuilder();

        while (!(input.isEmpty())) {
            String[] inputArray = input.split(";");
            StringBuilder result = new StringBuilder();

            switch (inputArray[0]) {
                case "S":   // "S" is used to split the combined words
                    switch (inputArray[1]) {
                        case "V":
                        case "C":
                            String[] splitWordsC = inputArray[2].split("(?=[A-Z])");
                            for (String part : splitWordsC) {
                                result.append(part.toLowerCase()).append(" ");
                            }
                            break;

                        case "M":
                            String[] splitWordsM = inputArray[2].split("(?=[A-Z])");
                            for (String s : splitWordsM) {
                                int index = s.indexOf('(');
                                if (index != -1) {
                                    s = s.substring(0, index);
                                }
                                result.append(s.toLowerCase()).append(" ");
                            }
                            break;
                    }
                    break;

                case "C":   // "C" is used to combine the split words
                    switch (inputArray[1]) {
                        case "V":
                        case "C":
                        case "M":
                            String[] combinedWords = inputArray[2].split(" ");
                            for (int i = 0; i < combinedWords.length; i++) {
                                String part = combinedWords[i];
                                if (i == 0) {
                                    result.append(part.toLowerCase());
                                } else {
                                    result.append(Character.toUpperCase(part.charAt(0)))
                                            .append(part.substring(1));
                                }
                            }
                            if (inputArray[1].equals("M")) {
                                result.append("()");
                            }
                            break;
                    }
                    break;
            }
                output.append(result.toString()).append("\n");
        }
        System.out.println(output);
    }
}





