/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.ziceck.crypto;

import io.github.ziceck.crypto.exception.AtbashException;
import java.util.HashMap;
import java.util.Map;

/**
 *This class provide methods to encrypt and decrypt text using
 * atbash, this class use the entire ASCII table instead of 
 * just the entire alphabet
 * @author Ziceck
 * @version 1.0
 * 
 */
public class Atbash {
    private Map<String,String> tableEncrypted;
    private Map<String,String> tableDecrypted;
    private int min;
    private int max;
    /**
     *Default Constructor 
     */
    public Atbash(){
        this.min=0;
        this.max=255;
        loadTableDecrypted();
        loadTableEncrypted();
    }
    
    /**
     * 
     * @param min First value used in the ASCII table
     * @param max Last value used in the ASCII table
     * @throws AtbashException throw exception when When min is 
     * less than 0 and max is greater than 255, also if min is greater than max
     */
    public Atbash(int min, int max) throws AtbashException{
        if(min>=0 && max<=255 && max>min){
        this.min=min;
        this.max=max;  
        loadTableEncrypted();
        loadTableDecrypted();
        } else{
            throw new AtbashException("The value of min should be >=0  "
                    + "and max should by <=255 and max>min");
        }
    }
    
    /**
     *This method load the key and value in the
     * tableEncrypted.
     * Example:
     * Key  | Value
     * 1    | 255
     * 2    | 254
     * This numbers are characters in the ascii table.
     */
    private  void loadTableEncrypted(){
        System.out.println("Table Ecrypted");
        tableEncrypted=new HashMap<String,String>();
        for (int i = min,omax=max; i <= max; i++) {
            char key = (char) i;
            char value = (char) (omax);
            System.out.println("Key = "+key+" Value = "+value+" >> "+i+" , "+omax);
            omax--;
            tableEncrypted.put( key+"" , value+"" );
        }
    }
    
    
    /**
     *This method load the key and value in the tableDecrypted.
     * Example:
     * Key  |   Value
     * 255  |   1
     * 254  |   2
     * This numbers are characters in the ascii table.
     */
    private void loadTableDecrypted(){
        System.out.println("\n\nTable Decrypted");
        tableDecrypted=new HashMap<String,String>();
        for (int i = max,omin=min; i > min; i--) {
            char key = (char) i;
            char value = (char) (omin);
            System.out.println("Key = "+key+" Value = "+value+" >> "+i+" , "+omin);
            omin++;
            tableDecrypted.put(key+"", value+"");
        } 
    }
    
    /**
     * @param text Is any text to be encrypted
     * @return a new text Encrypted. 
     */
    public String encrypt(String text){
        if(text!=null){
            String encryptedText="";
            for (int i = 0; i < text.length(); i++) {
                encryptedText+=tableEncrypted.getOrDefault(text.charAt(i)+"",text.charAt(i)+"");
            }
            return encryptedText;
        } else{
            throw new NullPointerException("Text is null, "
                    + "The encryp method should not receive an empty string");
        }
    }
    
    /**
     * 
     * @param text Is any text to be decrypted
     * @return a new text Decrypted.
     */
    public String decrypt(String text){
        String decryptedText="";
        if(text!=null){
            for (int i = 0; i < text.length(); i++) {
                decryptedText+=tableDecrypted.getOrDefault(text.charAt(i)+"",text.charAt(i)+"");
            }
        return decryptedText;
        } else {
            throw new NullPointerException("Text is null, "
                    + "The decrypt method should not receive an empty string");            
        }
    }
    

}
