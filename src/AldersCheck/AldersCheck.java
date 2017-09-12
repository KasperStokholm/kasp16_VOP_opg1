/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AldersCheck;

import java.util.Scanner;

/**
 *
 * @author Kasper
 */
public class AldersCheck {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();

        for (int i = 0; i < 10; i++) {
            if (i != 0) {
                System.out.println("Efter din næste fødselsdag er du " + age);
            }
            if (age < 21 && age < 18) {
                System.out.println("Din alder, " + age + " er under 21 og også under 18");
            } else if (age < 21 && age > 18) {
                System.out.println("Din alder, " + age + " er under 21 men over under 18");
            } else {
                System.out.println("Din alder, " + age + " er over 21");
            }
            age++;
        }

    }
}
