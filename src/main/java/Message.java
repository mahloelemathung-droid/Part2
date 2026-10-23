

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import static java.util.concurrent.ThreadLocalRandom.current;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mathung
 */
public class Message {
    


public class QuickChat {

    static Scanner input = new Scanner(System.in);
    static ArrayList<Message> messages = new ArrayList<>();

    static class Mesage {
        String messageID;
        String recipient;
        String messageText;
        String messageHash;
        int messageNumber;

        Mesage(String id, String recipient, String text,
                String hash, int number) {
            this.messageID = id;
            this.recipient = recipient;
            this.messageText = text;
            this.messageHash = hash;
            this.messageNumber = number;
        }
    }

    public static void main(String[] args) {

        System.out.println("Welcome to QuickChat.");

        System.out.print("How many messages would you like to send? ");

        int totalMessages;

        while (true) {
            try {
                totalMessages = Integer.parseInt(input.nextLine());

                if (totalMessages >= 0) {
                    break;
                }

                System.out.print("Enter zero or a positive number: ");

            } catch (NumberFormatException e) {
                System.out.print("Enter a valid whole number: ");
            }
        }

        int sentCount = 0;

        while (true) {
            System.out.println("\n--- QuickChat Menu ---");
            System.out.println("1. Send Messages");
            System.out.println("2. Show Recently Sent Messages");
            System.out.println("3. Quit");
            System.out.print("Choose an option: ");

            String choice = input.nextLine();

            switch (choice) {

                case "1":
                    while (sentCount < totalMessages) {

                        System.out.println("\nMessage "
                                + (sentCount + 1) + " of "
                                + totalMessages);

                        System.out.print("Enter recipient number: ");
                        String recipient = input.nextLine();

                        if (!CheckRecipientNumber(recipient)) {
                            System.out.println(
                                    "Invalid recipient number.");
                            continue;
                        }

                        System.out.print("Enter your message: ");
                        String message = input.nextLine();

                        if (message.length() > 250) {
                            System.out.println(
                                    "Please enter a message of "
                                    + "less than 250 characters.");
                            continue;
                        }

                        if (message.trim().isEmpty()) {
                            System.out.println(
                                    "Message cannot be empty.");
                            continue;
                        }

                        String messageID = generateMessageID();

                        String messageHash = createMessageHash(
                                messageID, sentCount + 1, message);

                        Mesage newMesage = new Mesage(
                                messageID,
                                recipient,
                                message,
                                messageHash,
                                sentCount + 1
                        );
                Message newMessage = null;

                        messages.add(newMessage);
                        sentCount++;

                        System.out.println("\nMessage sent!");
                        System.out.println("Message ID: " + messageID);
                        System.out.println("Message Hash: " + messageHash);
                        System.out.println("Messages remaining: "
                                + (totalMessages - sentCount));
                    }

                    if (sentCount == totalMessages) {
                        System.out.println(
                                "\nAll requested messages have been entered.");
                    }
                    break;

                case "2":
                    System.out.println("Coming Soon.");
                    break;

                case "3":
                    System.out.println("Thank you for using QuickChat.");
                    input.close();
                    return;

                default:
                    System.out.println(
                            "Invalid option. Please choose 1, 2 or 3.");
            }
        }
    }

    public static boolean CheckRecipientNumber(String number) {

        return number != null
                && number.matches("\\+27[0-9]{9}");
    }

    public static String generateMessageID() {

        long id = ThreadLocalRandom.current().nextLong(
                1_000_000_000L, 10_000_000_000L);

        return String.valueOf(id);
    }

    public static String createMessageHash(
            String messageID, int messageNumber, String message) {

        String[] words = message.trim().split("\\s+");

        String firstWord = words[0];
        String lastWord = words[words.length - 1];

        return messageID.substring(0, 2)
                + ":" + messageNumber
                + ":" + firstWord
                + ":" + lastWord;
    }
}

}
