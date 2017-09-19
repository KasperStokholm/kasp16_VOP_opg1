/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lektion2;

import java.util.Arrays;

/**
 *
 * @author Kasper
 */
public class Lektion2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arrayOne = {2, 15, 6, 8};
        int[] arrayTwo = {13, 27};
        
        System.out.println(Arrays.toString(arrayManipulation(arrayOne, arrayTwo)));
    } 
    
    public static int[][] arrayManipulation(int[] arrayOne, int[] arrayTwo){
        int[][] twoDimensional = new int[4][4];
        
        for(int i = 0; i < twoDimensional.length; i++){
            for(int j = 0; j < twoDimensional[i].length; j++)
                twoDimensional[i][j] = 2;
        }
        return twoDimensional;
    }
    
}

