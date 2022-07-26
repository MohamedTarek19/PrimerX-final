/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerDesigning;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Vector;
import java.lang.*;


/**
 *
 * @author 7asa
 */
public class Primer extends Nucleic_Acid {

    public static Vector<Nucleotide> Forward_Primer;
    public static Vector<Nucleotide> Reverse_Primer;
    public Vector<MainPrimer> All_Forward;
    public Vector<MainPrimer> All_Reverse;
    private float[] bases = new float[4]; //0=>G 1=>C 2=>A 3=>T
    private float percent_digits = 0;
    private int best = 0;
    private float[] TM_percent = new float[2];

    public Primer() {
        Forward_Primer = new Vector<Nucleotide>();
        Reverse_Primer = new Vector<Nucleotide>();
        All_Forward = new Vector<MainPrimer>();
        All_Reverse = new Vector<MainPrimer>();
    }

    public void get_all_Forward_Primers(int start_index) {
        int start_index_sequence = 0, Number_of_possible_primers = 10;
        for (int index_counter = start_index_sequence; index_counter < start_index; index_counter++) {
            int i = index_counter;
            String checking_primer = "";
            String min_length_primer = "";
            for (int primer_number = 0; primer_number < Number_of_possible_primers; primer_number++) {
                if (primer_number == 0) {
                    int primer_min_size = 18;
                    for (i = index_counter; i < index_counter + primer_min_size; i++) {
                        checking_primer += Strand.elementAt(i).getType();
                    }
                    min_length_primer = checking_primer;
                } else {
                    checking_primer = min_length_primer;
                    checking_primer += Strand.elementAt(i + primer_number).getType();
                    min_length_primer = checking_primer;
                }
                MainPrimer verfied_primer = check_primer(checking_primer);
                if (verfied_primer != null) {
                    All_Forward.add(verfied_primer);
                }
            }
        }
        System.out.println(All_Forward.size());

    }

    public void get_all_Reverse_Primers(int end_index) {
        int end_index_sequence = Compliment_Strand.size() - 1, Number_of_possible_primers = 10;
        for (int index_counter = end_index_sequence; index_counter > end_index; index_counter--) {

            int i = index_counter;
            String checking_primer = "";
            String min_length_primer = "";
            for (int primer_number = 0; primer_number < Number_of_possible_primers; primer_number++) {
                if (primer_number == 0) {
                    int primer_min_size = 18;
                    for (i = index_counter; i > index_counter - primer_min_size; i--) {
                        checking_primer += Compliment_Strand.elementAt(i).getType();
                    }
                    min_length_primer = checking_primer;
                } else {
                    checking_primer = min_length_primer;
                    checking_primer += Compliment_Strand.elementAt(i - primer_number).getType();
                    min_length_primer = checking_primer;
                }
                MainPrimer verfied_primer = check_primer(checking_primer);
                if (verfied_primer != null) {
                    All_Reverse.add(verfied_primer);
                }
            }
        }
        System.out.println(All_Reverse.size());

    }

    private MainPrimer check_primer(String checking_primer) { //Get Best Till you find better
        MainPrimer verfied_primer = new MainPrimer(checking_primer);
        float CG_min = 20, CG_max = 60, TM_min = 57, TM_max = 63;
        float[] TM_CG_Check;
        int TM = 0, CG = 1;
        TM_CG_Check = TM_CGPercent(checking_primer);
        if (TM_CG_Check[TM] >= TM_min && TM_CG_Check[TM] <= TM_max) {
            if (TM_CG_Check[CG] >= CG_min && TM_CG_Check[CG] <= CG_max) {
                if (checking_primer.charAt(checking_primer.length() - 1) == 'G' || checking_primer.charAt(checking_primer.length() - 1) == 'C') {
                    System.out.println(checking_primer);
                    verfied_primer.CGPercentage = TM_CG_Check[CG];
                    verfied_primer.Temperature = TM_CG_Check[TM];
                    verfied_primer.size = checking_primer.length();
                    return verfied_primer;
                }
            }
        }
        return null;
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
        TM_percent[0] = 4 * (bases[0] + bases[1]) + 2 * (bases[2] + bases[3]);
        TM_percent[1] = (percent_digits / size) * 100;
        return TM_percent;
    }

    @Override
    public void Sequencing() {
        //Forward Primer Layout
        System.out.print("Forward Primer:\n  ");
        for (Nucleotide i : Forward_Primer) {
            System.out.print("  " + i.getType() + "  ");
        }
        System.out.print("\n");
        System.out.print("5'");
        for (Nucleotide i : Forward_Primer) {
            System.out.print("=====");
        }
        System.out.print(" 3'\n");

        //Reverse Primer Layout
        System.out.print("Reverse Primer:\n  ");
        for (Nucleotide i : Reverse_Primer) {
            System.out.print("  " + i.getType() + "  ");
        }
        System.out.print("\n");
        System.out.print("5'");
        for (Nucleotide i : Reverse_Primer) {
            System.out.print("=====");
        }
        System.out.print(" 3'\n");
    }

    public static char Get_Compliment(char base) {
        switch (base) {
            case 'G':
                return 'C';
            case 'C':
                return 'G';
            case 'A':
                return 'T';
            case 'T':
                return 'A';
            default:
                break;
        }
        return 'E';
    }

    public void Getting_Top_Primers(int maxs , int mins, int maxt, int mint, int maxcg , int mincg ) {
        //Generating top forward primers 
        //declaring variables represent the bounding values of size , CG precentage and Temperature
        int maxSize = maxs, minSize = mins, maxTemp = maxt, minTemp = mint, maxCG = maxcg, minCG = mincg;

        // we need to decrease the size of primers untill we get 10 or less presented as variable Wanted_Primers
        int Wanted_Primers = 10;
        while (All_Forward.size() > Wanted_Primers) {

            //we need to delete primers according to different variables
            // in order not to remove unwanted one as we have only one counter variable
            //deleting according to primer size
            for (int i = 0; i < All_Forward.size(); i++) {
                if (All_Forward.elementAt(i).size > maxSize || All_Forward.elementAt(i).size < minSize) {
                    All_Forward.removeElementAt(i);
                }
            }

            //deleting according to Temperature
            for (int i = 0; i < All_Forward.size(); i++) {
                if (All_Forward.elementAt(i).Temperature > maxTemp || All_Forward.elementAt(i).Temperature < minTemp) {
                    All_Forward.removeElementAt(i);
                }
            }

            //deleting according to CG percentage
            for (int i = 0; i < All_Forward.size(); i++) {
                if (All_Forward.elementAt(i).CGPercentage > maxCG || All_Forward.elementAt(i).CGPercentage < minCG) {
                    All_Forward.removeElementAt(i);
                }
            }
            
            maxCG--; maxSize--; maxTemp--; minCG++; minSize++; minTemp++;
        }
        
        //generating top reverse primers
        maxSize = maxs; minSize = mins; maxTemp = maxt; minTemp = mint; maxCG = maxcg; minCG = mincg;
        while (All_Reverse.size() > Wanted_Primers) {

            for (int i = 0; i < All_Reverse.size(); i++) {
                if (All_Reverse.elementAt(i).size > maxSize || All_Reverse.elementAt(i).size < minSize) {
                    All_Reverse.removeElementAt(i);
                }
            }

            //deleting according to Temperature
            for (int i = 0; i < All_Reverse.size(); i++) {
                if (All_Reverse.elementAt(i).Temperature > maxTemp || All_Reverse.elementAt(i).Temperature < minTemp) {
                    All_Reverse.removeElementAt(i);
                }
            }

            //deleting according to CG percentage
            for (int i = 0; i < All_Reverse.size(); i++) {
                if (All_Reverse.elementAt(i).CGPercentage > maxCG || All_Reverse.elementAt(i).CGPercentage < minCG) {
                    All_Reverse.removeElementAt(i);
                }
            }
            
            maxCG--; maxSize--; maxTemp--; minCG++; minSize++; minTemp++;
        }
        // sorting choosen primers according to thier details
        // each primer has specific size - Temperature - CG percentage
        // all CG precentages are optimal for all primers so we sort according to size and Temp
        // optimal primer should be size of 20 and Temperature of 50 the summation of them is 80
        // we make special function like hashing to generate special number for each primer represents its importance
        
        //first of all inisializing new primer vector to sort them
        Vector<MainPrimer> newVec = new Vector<MainPrimer>();
        Vector<MainPrimer> newRevVec = new Vector<MainPrimer>();
         
        int specialcounter = 0;
        while(newVec.size() < All_Forward.size()){
            for(int i = 0;i < All_Forward.size() ; i++){
                if(SpecialHashing(All_Forward.elementAt(i).Special) == specialcounter){
                    newVec.add(All_Forward.elementAt(i));
                }
            }
            specialcounter++;
        }
        
        //the same for reverse primers
        int specialreversecounter = 0;
        while(newRevVec.size() < All_Reverse.size()){
            for(int i = 0;i < All_Reverse.size() ; i++){
                if(SpecialHashing(All_Reverse.elementAt(i).Special) == specialreversecounter){
                    newRevVec.add(All_Reverse.elementAt(i));
                }
            }
            specialreversecounter++;
        }
        
        All_Reverse = newRevVec;
        All_Forward = newVec;
    }

    private float SpecialHashing(float num){
        return Math.abs(num - 80);
    }
    
    public void DisplayingPrimers(Vector<MainPrimer> temp) {
        for (int i = 0; i < temp.size(); i++) {
            temp.elementAt(i).Display();
        }
    }
}
