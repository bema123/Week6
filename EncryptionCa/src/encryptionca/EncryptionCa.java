/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package encryptionca;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Bema Meite
 */
public class EncryptionCa {

    /**
     * @param args the command line arguments
     */
    public static Scanner kb=new Scanner(System.in);
    private static final String ALGORITHM="AES";
    private static final String TRANSFORMATION="AES";
    private static final int keySize=256;
    public static void main(String[] args) {
        // TODO code application logic here
        boolean flag=true;
        while(flag=true){
            System.out.println("Select a choice");
            System.out.println("Encrypt a file");
            System.out.println("Decrypt a file");
            System.out.println("quit");
            
            String menu =kb.nextLine();
            
            if(menu.equals("1")|| menu.equalsIgnoreCase("encrypt")){
                
                    encryptFile();
            } 
            else if(menu.equals("2")||menu.equalsIgnoreCase("decrypt")){
                    decryptFile();
            }
            else if(menu.equals("3")|| menu.equalsIgnoreCase("quit")){
                    System.out.println("signing out");
                    
                break;
            }
            else{
                    System.out.println("Wrong choice, try again");
            }
        }
    }
    public static void encryptFile() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the filename to encrypt:");
            String inputFileName = scanner.nextLine();
            byte[] inputData = Files.readAllBytes(Paths.get(inputFileName));
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(keySize, new SecureRandom());
            Key secretKey = keyGenerator.generateKey();
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] encryptedData = cipher.doFinal(inputData);
            String outputFileName = "ciphertext.txt";
            Files.write(Paths.get(outputFileName), encryptedData);
            System.out.println("The file has been encrypted and saved to ciphertext.txt");
            System.out.println("The encryption key is: " + bytesToHex(secretKey.getEncoded()));
        } catch (Exception e) {
            System.out.println("An error occurred while encrypting the file: " + e.getMessage());
        }
        scanner.close();
    }
    
    public static void decryptFile() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter the filename to decrypt:");
            String inputFileName = scanner.nextLine();
            byte[] encryptedData = Files.readAllBytes(Paths.get(inputFileName));
            System.out.println("Enter the encryption key:");
            String keyString = scanner.nextLine();
            byte[] keyBytes = hexToBytes(keyString);
            Key secretKey = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] decryptedData = cipher.doFinal(encryptedData);
            String outputFileName = "plaintext.txt";
            Files.write(Paths.get(outputFileName), decryptedData);
            System.out.println("The file has been decrypted and saved to plaintext.txt");
        } catch (Exception e) {
            System.out.println("An error occurred while decrypting the file: " + e.getMessage());
        }
        scanner.close();
    }

    private static String bytesToHex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        for (byte b : bytes) {
            result.append(String.format("%02X", b));
        }
        return result.toString();
    }

    private static byte[] hexToBytes(String hex) {
        byte[] bytes = new byte[hex.length() / 2];
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 *




/**used https://www.baeldung.com/java-cipher-input-output-stream and 
https://www.codejava.net/coding/file-encryption-and-decryption-simple-example to help**/

    
    
//        private static void encryptFile(){
//            System.out.println("Enter the name of the file to encrypt");
//        String file=kb.nextLine();
//        try{
//            Key key=generateRandomKey();
//            byte[] originalData=readBytesFromFile(file);
//            byte[] encryptedData= encrypt(originalData,key);
//            
//            writeBytesToFile("ciphertext.txt",encryptedData);
//            
//            System.out.println("the file has been encrypted using " +bytesToHex(key.getEncoded()));
//        }
//    }
    

        
