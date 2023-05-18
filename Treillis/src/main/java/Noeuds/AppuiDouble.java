/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Noeuds;
import treillis.TriangleTerrain;
import java.io.IOException;
import java.io.Writer;
import Sauvegarde.NumeroteurTreillis;
/**
 *
 * @author thiba
 */
public class AppuiDouble extends Appui {
    
 //Attributs

 private double abscisse;
 private double ordonnee;


 //Constructeur
     public AppuiDouble(int id, TriangleTerrain triangle, int s, double a ){

     super(id, triangle, s,  a) ;
     
   }
  

public double getabscisse(){
    return this.abscisse;
}

public double getordonnee(){
    return this.ordonnee;
}



      
public String toString(){
     String res="AppuiDouble numero"+String.valueOf(this.getid())+", ";

     return res;

 }

 public String toStringBNF(){
    String res="AppuiDouble;"+String.valueOf(this.getid())+";";
    res= res+String.valueOf(this.getidtriangle())+";";
    res= res+String.valueOf(this.getnumero())+";";
    res= res+String.valueOf(this.getposition())+"\n";
    return res;

}
@Override
public void save(Writer w, NumeroteurTreillis<Noeud> num) throws IOException{
    if(! num.contain(this)){
        int id = num.creeID(this);
        w.append("AppuiDouble;"+this.toStringBNF());
    }
}
}
