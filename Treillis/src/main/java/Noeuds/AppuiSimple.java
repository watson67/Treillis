/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Noeuds;
import java.io.IOException;
import java.io.Writer;

import Sauvegarde.NumeroteurTreillis;
import treillis.TriangleTerrain;
/**
 *
 * @author thiba
 */
public class AppuiSimple extends Appui {

        //Attributs
        
     
         private double abscisse;
         private double ordonnee;
       
    
        //Constructeur
    
        public AppuiSimple(int id, TriangleTerrain triangle, int s, double a ){

            super(id, triangle, s,  a) ;
       
          }
         
       
       public double getabscisse(){
           return this.abscisse;
       }
       
       public double getordonnee(){
           return this.ordonnee;
       }
       
              
        public String toString(){
            String res="Noeud simple numero"+String.valueOf(this.getid())+", ";
    
            return res;
    
        }

        public String toStringBNF(){
            String res="AppuiSimple;"+String.valueOf(this.getid())+";";
            res= res+String.valueOf(this.getidtriangle())+";";
            res= res+String.valueOf(this.getnumero())+";";
            res= res+String.valueOf(this.getposition())+"\n";
            return res;
    
        }

        public void save(Writer w, NumeroteurTreillis<Noeud> num) throws IOException{
            if(! num.contain(this)){
                int id = num.creeID(this);
                w.append("AppuiSimple;"+this.toStringBNF());
            }
        }
    
    }