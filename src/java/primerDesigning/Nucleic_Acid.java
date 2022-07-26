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
public abstract class Nucleic_Acid {

    protected static Vector<Nucleotide> Strand;
    protected static Vector<Nucleotide> Compliment_Strand;
    
    public abstract void Sequencing();
}
