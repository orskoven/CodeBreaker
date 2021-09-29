import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int k = 0;
        do {
            System.out.println("Please choose to (press 'E') for Ceasarencoding , Ceasardeocding (press 'D')\nVigenere-encode(press 'V'), Vigenere-decode(press 'F') standard-encoding-decoding (press 'S')");
            String inputAnswerGameMode = scanner.nextLine();
            String messageGameModeChoice = (inputAnswerGameMode.toUpperCase(Locale.ROOT).equals("E")) ?
                    "You chose: Ceasarencoding"
                    : (inputAnswerGameMode.toUpperCase(Locale.ROOT).equals("D")) ?
                    "You chose: Ceasardecoding" : (inputAnswerGameMode.toUpperCase(Locale.ROOT).equals("V")) ?
                    "You chose: Vigener-encoding"
                    : (inputAnswerGameMode.toUpperCase(Locale.ROOT).equals("F")) ?
                    "You chose: Vigenere-decoding" :(inputAnswerGameMode.toUpperCase(Locale.ROOT).equals("S")) ?"You chose: Standard-encoding-decoding" :"Please press 'E','D','V','F' or 'S' inorder to continue";
            System.out.println(messageGameModeChoice);
            boolean checkTheInput = inputAnswerGameMode.toUpperCase(Locale.ROOT).equals("E") || (inputAnswerGameMode.toUpperCase(Locale.ROOT).equals("D")) ||
                    (inputAnswerGameMode.toUpperCase(Locale.ROOT).equals("V")) ||
                    (inputAnswerGameMode.toUpperCase(Locale.ROOT).equals("F"))||
                    (inputAnswerGameMode.toUpperCase(Locale.ROOT).equals("S"));
            for (boolean t = checkTheInput; t; t = false)
                if (inputAnswerGameMode.toUpperCase(Locale.ROOT).equals("E")) {
                    try {
                        System.out.println("Please enter the message you want to ceasar-encode:");
                        String ceasarEncoderInput = scanner.nextLine();
                        System.out.println("Which direcetion should the characters be shifted?");
                        String shiftInputDirectionEncoded = scanner.nextLine();
                        System.out.println("How much should it be shifted?");
                        int shiftLengthEncoded = scanner.nextInt();
                        System.out.println("Yor ceasar message encoded is:");
                        System.out.println(ceasarEncoder(ceasarEncoderInput, shiftInputDirectionEncoded, shiftLengthEncoded));
                        System.out.println(scanner.nextLine());
                    } catch (InputMismatchException exception) {
                        System.out.println("Something went wrong?");
                    }
                } else if (inputAnswerGameMode.toUpperCase(Locale.ROOT).equals("D")) {
                    try {
                        System.out.println("Please enter the message you want to ceasar-decode:");
                        String ceasarDecoderInput = scanner.nextLine();
                        System.out.println("Which direcetion should the characters be shifted?");
                        String shiftInputDirectionDecoded = scanner.nextLine();
                        System.out.println("How much should it be shifted?");
                        int shiftLengthDecoded = scanner.nextInt();
                        System.out.println("Yor ceasar message decoded is:");
                        System.out.println(ceasarDecoder(ceasarDecoderInput, shiftInputDirectionDecoded, shiftLengthDecoded));
                        System.out.println(scanner.nextLine());
                    } catch (InputMismatchException exception) {
                        System.out.println("Something went wrong?");
                    }
                } else if (inputAnswerGameMode.toUpperCase(Locale.ROOT).equals("V")) {
                    try {
                        System.out.println("Please enter the message you want to vigenere-encode:");
                        String vigenereEncoderInput = scanner.nextLine();
                        System.out.println("Which key?");
                        String keyEncoder = scanner.nextLine();
                        System.out.println("Yor vigenere message encoded is:");
                        System.out.println(vigenereEncoder(vigenereEncoderInput, keyEncoder));
                    } catch (InputMismatchException exception) {
                        System.out.println("Something went wrong?");
                    }
                } else if (inputAnswerGameMode.toUpperCase(Locale.ROOT).equals("F")) {
                    try {
                        System.out.println("Please enter the message you want to vigenere-decode:");
                        String vigenereDecoderInput = scanner.nextLine();
                        System.out.println("Which direcetion should the characters be shifted?");
                        String shiftInputDirectionEncoded = scanner.nextLine();
                        System.out.println("How much should it be shifted?");
                        int shiftLengthEncoded = scanner.nextInt();
                        System.out.println("Yor ceasar message encoded is:");
                        System.out.println(ceasarEncoder(vigenereDecoderInput, shiftInputDirectionEncoded, shiftLengthEncoded));
                        System.out.println(scanner.nextLine());
                    } catch (InputMismatchException exception) {
                        System.out.println("Something went wrong?");
                    }
                } else if (inputAnswerGameMode.toUpperCase(Locale.ROOT).equals("S")) {
                    try {
                        System.out.println("Please enter the message you want to standard-encode:");
                        String encoderInput = scanner.nextLine();
                        System.out.println("Yor message encoded is:");
                        System.out.println(Arrays.toString(numberCypherEncoder(encoderInput)));
                        System.out.println("Yor message decoded is:");
                        System.out.println(numberCypherDecoder((numberCypherEncoder(encoderInput))));
                    } catch (InputMismatchException exception) {
                        System.out.println("Something went wrong?");
                    }
                }


        } while (k < 20);
    }

    public static String numberCypherDecoder(int[] original) {
        String reversed = "";
        for (int i = 0; i < original.length; i++) {
            char k = (char) (original[i] + 96);
            reversed += k;
        }

        return reversed;
    }

    public static String numberCypherDecoderVigneree(int[] original) {
        String reversed = "";
        for (int i = 0; i < original.length; i++) {
            char k = (char) (original[i]);
            reversed += k;
        }

        return reversed;
    }


    public static String ceasarEncoder(String inputCeasar, String shiftDirection, int shiftLength) {
        int[] counterArray = new int[inputCeasar.length()];
        for (int k = counterArray[0]; k < inputCeasar.length(); k++) {
            for (char i = (inputCeasar.charAt(k)); counterArray[k] <= k; i++) {
                if (Objects.equals(shiftDirection, "right")) {
                    if (i > 118) {
                        counterArray[k] = i - 24 + shiftLength;
                    } else if (counterArray[k] >= i) {
                        counterArray[k] = i + shiftLength - 1 % 96;
                    } else {
                        counterArray[k] = i + shiftLength - 1 % 96;
                    }
                } else {
                    if (i > 118) {
                        counterArray[k] = i - 24 - shiftLength;
                    } else if (counterArray[k] >= i) {
                        counterArray[k] = i - shiftLength - 1 % 96;
                    } else {
                        counterArray[k] = i - shiftLength - 1 % 96;
                    }
                }
            }
        }
        return numberCypherDecoder(counterArray);


    }

    public static String vigenereEncoder(String inputVigenere, String key) {
        int[] counterArray = new int[inputVigenere.length()];
        int[] counterKeyInt = new int[inputVigenere.length()];
        for (int k = counterArray[0]; k < inputVigenere.length(); )
            for (int i = 0; k < inputVigenere.length();) {
                for (char f = (key.charAt(i)); k < inputVigenere.length();k++) {
                        char t = (inputVigenere.charAt(k));
                        char s = key.charAt(i++);
                        counterKeyInt[k] = s-97;
                        counterArray[k] = t + counterKeyInt[k];
                          if (i == key.length()){
                            i = 0;
                            }

                      }

            }
        return numberCypherDecoderVigneree(counterArray);


    }


    public static String ceasarDecoder(String inputCeasar, String shiftDirection, int shiftLength) {
        int[] counterArray = new int[inputCeasar.length()];
        for (int k = counterArray[0]; k < inputCeasar.length(); k++) {
            for (char i = (inputCeasar.charAt(k)); counterArray[k] <= k; i++) {
                if (Objects.equals(shiftDirection, "right")) {
                    if (i == 'a' || i == 'b' || i == 'c') {
                        counterArray[k] = i + 24 - shiftLength;
                    } else if (counterArray[k] >= i) {
                        counterArray[k] = i + shiftLength - 1 % 96;
                    } else {
                        counterArray[k] = i + shiftLength - 1 % 96;
                    }
                } else {
                    if (i == 'a' || i == 'b' || i == 'c') {
                        counterArray[k] = i + 24 + shiftLength;
                    } else if (counterArray[k] >= i) {
                        counterArray[k] = i - shiftLength + 1 % 96;
                    } else {
                        counterArray[k] = i - shiftLength - 1 % 96;
                    }
                }
            }
        }
        return numberCypherDecoder(counterArray);
    }

    public static int[] numberCypherEncoder(String inputString) {
        int[] counterArray = new int[inputString.length()];
        for (int k = counterArray[0]; k < inputString.length(); k++) {
            for (char i = inputString.charAt(k); counterArray[k] <= k; i++) {
                if (counterArray[k] >= i) {
                    counterArray[k] = i -1% 96 - 95;
                } else {
                    counterArray[k] = i -1% 96 - 95;
                }
            }
        }
        return counterArray;
    }

}