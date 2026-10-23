/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.part2;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Mathung
 */
public class Part2 {

    private static Object mesageID;

    public static void main(String[] args) {
        System.out.println("Welcome to quick chat");
        System.out.println("Option 1 Send Message" );
        System.out.println("Option 2 Coming Soon" );
        System.out.println("Option 3 Exit" );
        
        Scanner input = new Scanner (System.in);
        int option =input.nextInt();
        
        switch(option){
            
            case 1: System.out.println("how many messages must i enter ");
                int numMessage = input.nextInt();
                
                for (int i = 0; i <numMessage;i++);
                
                System.out.println("Option 1) Send Message");
                System.out.println("Option 2) Disregard Message");
                System.out.println("Message successfully stored");
                
                Random rand = new Random();
                
                //rand.nextInt(maximum - minimum) + minimum
                
                long Minimum = 1000000000L;
                long Maximum = 9999999999L;
                long messageID;
            
                
                //from 5 to 10
                System.out.println("Enter Recipient Number : ");
                String Recipient = input.nextLine();
                System.out.println("Please Enter The Message");
                String Message = input.nextLine();
                
                if(Message.length() < 200){
                    System.out.println("Message Sent");
                    String id = String.valueOf(mesageID).substring(option, option);
            int i = 0;
                    int messageNumber = i;
                    
                   String[] words;
            words = Mesage.spilt("\\s+");
                   String firstWord = words[0];
                   String lastWord = words[words.length];
            String firstTwoNumbers = null;
                   
                   String hash = firstTwoNumbers+":" ;
                   
                }else{
                    System.out.println("Error on message enter less than 250 charecters");
                }
        
        }
        
       
    }
}
