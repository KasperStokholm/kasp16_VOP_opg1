/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasp16_vop_opg1;

import static ancient_encryption.CipherInterface.ALPHABETH;

/**
 *
 * @author Kasper
 */
public class CeasarCipher extends AbstractCipher {

    private int rotFactor;
    
    public CeasarCipher(int rotFactor){
        
        if(rotFactor < 0 || rotFactor > ALPHABETH.length){
            System.out.println("Must be betweeen 0 to 51. rotFactor set to 0");
            this.rotFactor = 0;
        } else {
            this.rotFactor = rotFactor;
        }
    }
    
    @Override
    public String encrypt(String message) {
        
        String encrypted = "";
        
        for(char c: message.toCharArray()){
            int index = findCharIndex(c);
            if(index != -1){
                encrypted += ALPHABETH[(rotFactor+index)%ALPHABETH.length];
                
            }else{
                encrypted += c;
            }
        }
        return encrypted;
    
    }

    @Override
    public String decrypt(String encrypted) {

        String decrypted = "";
        
        for(char c: encrypted.toCharArray()){
            int index = findCharIndex(c);
            if(index != -1){
                int newIndex = (index-rotFactor)%ALPHABETH.length;
                if(newIndex < 0){
                    newIndex = ALPHABETH.length + newIndex;
                }
                decrypted += ALPHABETH[newIndex];
                
            }else{
                decrypted += c;
            }
        }
        return decrypted;
    }
    

}
