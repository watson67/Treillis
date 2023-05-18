package treillis;
import Noeuds.NoeudSimple;
public class Point {
 
 //Attributs
 private NoeudSimple noeud;

  //Constructeurs
  public Point(NoeudSimple n){
   this.noeud=n;
  }

  public Point(int id, double x, double y){
   NoeudSimple n= new NoeudSimple(id, x, y);
   this.noeud =n;
  }

  //méthode get
  public NoeudSimple getNoeudSimple(){
   return this.noeud;
  }

  public double getabscisse(){
   return this.noeud.getabscisse();
  }

  public double getordonnee(){
   return this.noeud.getordonnee();
  }

  public double getid(){
   return this.noeud.getid();
  }



  //méthode set
  public void setNoeudSimple(NoeudSimple n){
   this.noeud=n;
  }

  //méthode toString
  public String toStringBNF(){
   String res="";
   res="("+String.valueOf(this.getabscisse())+";"+String.valueOf(this.getordonnee())+")";
   return res;
  }


}
