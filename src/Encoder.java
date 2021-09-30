import java.util.Scanner;

public class Encoder {

    static Scanner scanner = new Scanner(System.in);
    static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'æ', 'ø', 'å'};
    static boolean run;

    public static char indexToCharacter(int index){
        //find the char located at given index from predefined "alphabet" array
        char character = alphabet[index];
        return character;
    }

    public static String[] numberCypherEncoder(String message) {

        String[] messageSplit = message.split(";");
        String[] messageDecoded = new String[messageSplit.length];
        for (int i = 0; i < messageDecoded.length; i++) {
            int number = Integer.parseInt(messageSplit[i]);
            char character = indexToCharacter(indexToCharacter(number - 1));
            messageDecoded[i] = String.valueOf(character);
        }
        return messageDecoded;
    }

    public static String caesarEncoderDecoder(String message, String direction, int numberOfShifts) {
        char[] newMessage = new char[message.length()];
       for (int i = 0; i < newMessage.length; i++ ) {
           for(int u = 0; u < 29; u++) {
               if (message.charAt(i) == alphabet[u]) {
                   if ((numberOfShifts + u) <= 28 && direction.equals("right")) {
                       newMessage[i] = alphabet[u + numberOfShifts];
                   } else if ((u - numberOfShifts) >= 0 && direction.equals("left")) {
                       newMessage[i] = alphabet[u - numberOfShifts];
                   } else if ((numberOfShifts + u) > 28 && direction.equals("right")) {
                       newMessage[i] = alphabet[(numberOfShifts + u) % 28];
                   } else if ((u - numberOfShifts) < 0 && direction.equals("left")) {
                       newMessage[i] = alphabet[29 + ((u - numberOfShifts) % 28)];
                   } else {
                       System.out.println("Illegal input! Try again.");
                       run = true;
                   }
               }
           }
       }
            //udkommenteret gammel caerEncoder metode
           /*if (message.charAt(i) == 'æ') {
               newMessage[i] = 'a';
           } else if (message.charAt(i) == 'ø') {
               newMessage[i] = 'b';
           } else if (message.charAt(i) == 'å') {
               newMessage[i] = 'c';
           } else {
               newMessage[i] = (char) (message.charAt(i) + 3);
           }*/

        return new String(newMessage);
        /*for (int i = 0; i < message.length(); i++) {
            letter = message.charAt(i);
            for (int u = 0; u < 29; u++) {
                String charToString = Character.toString(letter);
                if (letter == letterArray[u]) {
                    if (u > 26) {
                        System.out.print(letterArray[(u - 1) + 3 % 29]);
                    } else {
                        System.out.print(letterArray[(u - 1) + 3]);
                    }
                }
            }
        }*/
    }
    //udkommenteret gammel løsning
    /*public static String caesarDecoder(String message, String direction, int numberOfShifts) {
        char[] newMessage = new char[message.length()];

        for (int i = 0; i < newMessage.length; i++ ) {
            if (message.charAt(i) == 'a') {
                newMessage[i] = 'æ';
            } else if (message.charAt(i) == 'b') {
                newMessage[i] = 'ø';
            } else if (message.charAt(i) == 'c') {
                newMessage[i] = 'å';
            } else {
                newMessage[i] = (char) (message.charAt(i) - 3);
            }
        }
        return new String(newMessage);
    }*/

    public static void main(String[] args) {
        String a = "";
        String[] b = numberCypherEncoder("hej");
        printMessage(b);

        do {
            try {
                run = false;
                a = caesarEncoderDecoder(scanner.nextLine(),scanner.nextLine(), scanner.nextInt());
            } catch (Exception e) {
                System.out.println("Illegal value! Try again.");
                run = true;
            }
            System.out.println(a);
        } while (run);

        //a = caesarDecoder(scanner.nextLine());
    }
}


