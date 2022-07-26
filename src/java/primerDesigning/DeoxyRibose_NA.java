/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primerDesigning;

import java.util.Vector;

/**
 *
 * @author 7asa
 */
public class DeoxyRibose_NA extends Nucleic_Acid {

    public DeoxyRibose_NA(String sequence) {
        Compliment_Strand = new Vector<Nucleotide>();
        Strand = new Vector<Nucleotide>();
        //Getting Strand from String
        for (int i = 0; i < sequence.length(); i++) {
            Nucleotide base = new Nucleotide(sequence.charAt(i));
            Strand.addElement(base);
            //Getting Compliment Strand
            switch (sequence.charAt(i)) {
                case 'C':
                    base = new Nucleotide('G');
                    Compliment_Strand.addElement(base);
                    break;
                case 'G':
                    base = new Nucleotide('C');
                    Compliment_Strand.addElement(base);
                    break;
                case 'T':
                    base = new Nucleotide('A');
                    Compliment_Strand.addElement(base);
                    break;
                case 'A':
                    base = new Nucleotide('T');
                    Compliment_Strand.addElement(base);
                    break;
                //if bracket get index { start } end
                default:
                    break;
            }
        }
    }

    @Override
    public void Sequencing() {
        //Compliment Strand
        System.out.print("5'");
        for (Nucleotide i : Compliment_Strand) {
            System.out.print("=====");
        }
        System.out.print(" 3'");
        System.out.print("\n");
        System.out.print("  ");
        for (Nucleotide i : Compliment_Strand) {
            System.out.print("  " + i.getType() + "  ");
        }
        System.out.print("\n");
        //Hydrogen Bond
        System.out.print("  ");
        for (Nucleotide i : Strand) {
            if (i.getHydrogen_Bond().equals("Weak Bond")) {
                System.out.print(" | | ");
            } else if (i.getHydrogen_Bond().equals("Strong Bond")) {
                System.out.print(" ||| ");
            }
        }
        System.out.print("\n");
        //Forward Strand
        System.out.print("  ");
        for (Nucleotide i : Strand) {
            System.out.print("  " + i.getType() + "  ");
        }
        System.out.print("\n");
        System.out.print("3'");
        for (Nucleotide i : Strand) {
            System.out.print("=====");
        }
        System.out.print(" 5'");
        System.out.print("\n");
    }
}
