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
public class Nucleotide {
    private String Type;
    private String Hydrogen_Bond;
    public Nucleotide(char Type){
        this.Type=""+Type+"";
        if(Type=='A'||Type=='T'||Type=='U'){
            Hydrogen_Bond="Weak Bond";
        }
        else if(Type=='C'||Type=='G'){
            Hydrogen_Bond="Strong Bond";    
        }
    }
    public Nucleotide(){
        
    }
    /*public void display(){
        if(Hydrogen_Bond.equals("Weak Bond")){
    
    3aoz atb3 kol al type b3dha al strand kolo
    
        }
        else if(Hydrogen_Bond.equals("Strong Bond")){
            
        }
    }*/

    public String getType() {
        return Type;
    }

    public String getHydrogen_Bond() {
        return Hydrogen_Bond;
    }
}
