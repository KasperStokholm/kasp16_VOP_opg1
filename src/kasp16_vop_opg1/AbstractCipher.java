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
public abstract class AbstractCipher implements CipherInterface {
    
    protected int findCharIndex(char ch){
        
        int returnIndex = -1;
        
        for(int i = 0; i < ALPHABETH.length; i++){
            if(ALPHABETH[i] == ch){
                returnIndex = i;
            }
        }
        return returnIndex;
    }
    
}
