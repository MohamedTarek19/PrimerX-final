/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerDesigning;

import java.sql.SQLXML;
import java.util.Vector;

/**
 *
 * @author Mohamed Shafai
 */
public class MainPrimer {

    //Data Members
    public String Sequence;
    public float size;
    public float CGPercentage;
    public float Temperature;

    public float Special;
    
    //wanted varialbes for calculating CG Percentage and Primer Temperature
    private float[] bases = new float[4]; //0=>G 1=>C 2=>A 3=>T
    private float percent_digits = 0;

    public MainPrimer(String Seq) {
        Sequence = Seq;
        // calculating other data members from the sequence
        size = Seq.length();

        float[] temp = new float[2];
        temp = TM_CGPercent(Seq);
        Temperature = temp[0];
        CGPercentage = temp[1];
        Special = size + Temperature;
    }

    public void Display() {
        //Displaying data
        
        System.out.println(Sequence);
        System.out.println(size);
        System.out.println(Temperature);
        System.out.println(CGPercentage);
    }

    private float[] TM_CGPercent(String primer) {
        bases[0] = 0;
        bases[1] = 0;
        bases[2] = 0;
        bases[3] = 0;
        percent_digits = 0;
        for (int i = 0; i < primer.length(); i++) {
            switch (primer.charAt(i)) {
                case 'G':
                    bases[0]++;
                    percent_digits++;
                    break;
                case 'C':
                    bases[1]++;
                    percent_digits++;
                    break;
                case 'A':
                    bases[2]++;
                    break;
                case 'T':
                    bases[3]++;
                    break;
                default:
                    break;
            }
        }
        float size = primer.length();

        float[] TM_percent = new float[2];

        //first ellement has Temperature
        TM_percent[0] = 4 * (bases[0] + bases[1]) + 2 * (bases[2] + bases[3]);

        //second ellement has CG percentage
        TM_percent[1] = (percent_digits / size) * 100;

        return TM_percent;
    }
}
