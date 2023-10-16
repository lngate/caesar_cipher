package ke.co.safaricom;


import java.util.Scanner;
public class Main {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter text to encrypt");
        String text = sc.nextLine();


        System.out.println("Enter the key value for the message: ");
        int key = sc.nextInt();


        // Encryption
        String encryptedText = encrypt(text, key);
        System.out.println("Encrypted: " + encryptedText);

        // Decryption
        String decryptedText = decrypt(encryptedText, key);
        System.out.println("Decrypted: " + decryptedText);
    }

        public static String encrypt(String text, int key) {
            StringBuilder result = new StringBuilder();
            for (char character : text.toCharArray()) {
                if (Character.isLetter(character)) {
                    char base = Character.isUpperCase(character) ? 'A' : 'a';
                    char encryptedChar = (char) ((character - base + key) % 26 + base);
                    result.append(encryptedChar);
                } else {
                    result.append(character); // Non-alphabetic characters remain unchanged
                }
            }
            return result.toString();
        }

        public static String decrypt(String text, int key) {
            return encrypt(text, 26 - key); // Decryption is just encryption with the inverse key
        }


    }

