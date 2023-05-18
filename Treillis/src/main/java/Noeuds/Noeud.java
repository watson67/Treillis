package Noeuds;
import java.awt.Color;
import java.io.IOException;
import java.io.Writer;
import Sauvegarde.NumeroteurTreillis;

public abstract class Noeud {
    // On définit cette classe comme étant abstraite car un point appartient obligatoirement à une sous-classe de la classe point
    //Attributs
    private int id; 
    
  
    //Constructeur
    Noeud(int id)
    {
       
        this.id= id;
        
    }
    
   //méthode get
    public int getid(){
    return this.id;
    
    }
    //méthode set
    public void setid(int i){
        this.id=i;
    }

 
    


    //Méthode toString
    public String toString(){
        String res="";
        res="identifiant = "+String.valueOf(this.getid());
        return res;
    }
    public abstract String toStringBNF();
    
    public abstract void save(Writer w, NumeroteurTreillis<Noeud> n) throws IOException;
        
    }

   




