package treillis;
import Noeuds.Noeud;


public class Barre {

    //Définitions des attributs
    
    private int id ; //identificateur
    private typeBarre type;
    private NoeudSimple[] points;
    
    
    public Barre(int id, typeBarre type, NoeudSimple debut, NoeudSimple fin){
        
        this.points= new NoeudSimple[2];
        this.points[0]=n1;
        this.points[1]=n2;
        this.type= type;
        this.id=id;
    }

    //méthode get
    public int getid(){
        return this.id;
    }

    public typeBarre gettypeBarre(){
        return this.type;
    }

       //méthode get

   public NoeudSimple getPoint(int i){
    // ! eventuellement mettre une exception si i>1
    return this.points[i];
    
}  //surcharge
   public NoeudSimple[] getPoint(){
   
    return this.points;
}
   //méthode set
  
   public void setPoint(int i, Noeud n){
   //! idem, exception si i>1
   this.points[i]=n;
}

    //méthode set
    public void setid(int i){
        this.id=i;
    }

    public void settypeBarre(typeBarre t){
        this.type= t;
    }
//méthode contains ; méthode qui permet de savoir si un Noeud appartient à la barre

public boolean contains(Noeud n){
    boolean test=false;
    for (int i=0; i<2; i++){
        if (n.getid()==this.getPoint(i).getid()){
            test=true;
    }
}
    return test;
}
    //méthode toString

    public String toString(){
        String res="";
        res=" identificateur = "+String.valueOf(this.getid());
        res= res+ this.getPoint().toString();
        res= res+ this.type.toString();
        return res;
    }



}
