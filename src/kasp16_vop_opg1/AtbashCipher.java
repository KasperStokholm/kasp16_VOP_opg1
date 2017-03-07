/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasp16_vop_opg1;

import ancient_encryption.CipherInterface;

/**
 *
 * @author Kasper
 */
public class AtbashCipher extends AbstractCipher{

    @Override
    public String encrypt(String message) {
        
        String encrypted = "";
        
        for(char c: message.toCharArray()){
            int index = findCharIndex(c);
            if(index != -1){
                encrypted += ALPHABETH[ALPHABETH.length-1-index];
            }else{
                encrypted += c;
            }
        }
        return encrypted;
    }

    @Override
    public String decrypt(String encrypted) {
        
        return encrypt(encrypted);
        
    }
    
    
    
}
