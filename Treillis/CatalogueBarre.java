package treillis;
import java.util.*;


public class CatalogueBarre{

 //Attributs


 private ArrayList<typeBarre> catalogue; //on stockera ici les différentes barres contenues dans le catalogue

 //Constructeur
 public CatalogueBarre(typeBarre t){
    this.catalogue.add(t);
 }

 //méthode get
 public ArrayList<typeBarre> getTypeBarre(){
    return this.catalogue;
 }
 //surchage: méthode get qui ne retourne qu'un TypeBarre particulier; en fonction de l'identificateur

 public typeBarre getTypeBarre(int j){
  return this.catalogue.get(j);
}

  //méthode set
  public void setTypeBarre(int p, typeBarre t){
      this.catalogue.set(p, t);
  }

  //méthode contains, qui permet de savoir si le catalogue contient un typeBarre particulier, en se basant sur l'identificateur
  public boolean contains(typeBarre t){
     boolean test=false;
     for (int i=0;i<this.catalogue.size();i++){
        if (t.getid()== this.catalogue.get(i).getid()){
           test=true;
        }
     }
     return test;
  }


 //méthode add, qui permettra d'ajouter un élément au catalogue
 public void add(typeBarre t){
   this.catalogue.add(t);
 }

 //méthode remove, qui permettra de supprimer un élément du catalogue; pour cela
 public void remove(typeBarre t){
    if(this.contains(t)==true){

    }else{
      for (int i=0;i<this.catalogue.size();i++){
         if (t.getid()== this.catalogue.get(i).getid()){
            this.catalogue.remove(i);
         }
      }

    }
   }

 //méthode size, qui donne le nombre de type de barre différents  
 public int size(){
   return this.getTypeBarre().size();
 } 

 
 //méthode toString

 public String toString(){
    String res="";
    for (int i=0;i<this.size();i++){
       res=res+this.getTypeBarre(i);
    }

    return res;
 }

}