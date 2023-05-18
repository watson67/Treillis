package treillis;

public class Segment{

   //Attributs
   private Point[] points;
   //un segment est composé de deux Noeuds

   //Constructeur

   public Segment( Point n1, Point n2){

    this.points= new Point[2];
    this.points[0]=n1;
    this.points[1]=n2;

   }

     //méthode get

   public Point getPoint(int i){
    // ! eventuellement mettre une exception si i>1
    return this.points[i];
    
}  //surcharge
   public Point[] getPoint(){
   
    return this.points;
}
   //méthode set
  
   public void setPoint(int i, Point n){
   //! idem, exception si i>1
   this.points[i]=n;
}
   //méthode toString
   public String toString(){
   String res="";
   res= res+" Point debut = "+String.valueOf(this.getPoint(0).getid()); //on prend l'identificateur du noeud en question
   res= res+" Point fin = "+String.valueOf(this.getPoint(1).getid()); //idem
   return res;

}



public boolean contains(Point n){
    boolean test=false;
    for (int i=0; i<2; i++){
        if (n.getid()==this.getPoint(i).getid()){
            test=true;
    }
}
    return test;
}


}


