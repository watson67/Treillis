package treillis;


public class TriangleTerrain {

    //Attributs

    private int id; //identificateur
    private Point[] sommet ;//un triangle est composé de 3 points
    private Segment[] cote;//un triangle a 3 cote

    //Constructeur
    public TriangleTerrain(int id, Point n1, Point n2, Point n3){
        
        this.id=id;
        this.sommet= new Point[3];
        this.sommet[0]=n1;
        this.sommet[1]=n2;
        this.sommet[2]=n3;
        Segment s1= new Segment(n1,n2);
        Segment s2= new Segment (n2,n3);
        Segment s3= new Segment (n1,n3);
        this.cote= new Segment[3];
        this.cote[0]=s1;
        this.cote[1]=s2;
        this.cote[2]=s3;
    
    }
    public TriangleTerrain(){
        
        
    
    }
    public int getid(){
        return this.id;
        
    } 
    public Point getPoint(int i){
        // ! eventuellement mettre une exception si i>2
        return this.sommet[i];
        
    } 
    public Point[] getPoint(){
        return this.sommet;
        
    } 

    public Segment[] getSegment(){
        return this.cote;
        
    }

    public Segment getSegment(int i){
        return this.cote[i];
        
    }

    //méthode set

    public void setid(int i){
        this.id=i;
    }

    public void set(Point n1, Point n2){
        //on veut remplacer le noeud n1 par le noeud n2, à la fois dans l'attribut sommet, mais aussi dans l'attribut segment car les segments ne seront plus composés des mêmes points
        
        for (int j=0; j<3;j++){
            if(this.getSegment(j).contains(n1)==true){
                //si le segment contient le point alors
               
                Segment s= this.getSegment(j);
                for (int i=0;i<2;i++){
                    //on cherche lequel des deux noeuds du Segment il faut modifier
                    if (s.getPoint(i)==n1){
                        if(i==1){
                            Segment s1= new Segment(this.getPoint(0),n2);
                            this.cote[j]=s1;
                    }else{
                        Segment s1= new Segment(this.getPoint(1),n2);
                        this.cote[j]=s1;
                    }
                }
                }

            }
        }
        for(int i=0;i<this.sommet.length;i++){
            if(n1==this.getPoint(i)){
                this.sommet[i]=n2;
            }
        }


    }

    public String toString(){
        String res="";
        res=" identificateur = "+String.valueOf(this.getid());
        for (int i=0;i<this.sommet.length;i++){
        res= res+this.getPoint(i).toString();
        }
        for (int i=0;i<this.cote.length;i++){
            res= res+this.getSegment(i).toString();
            }
            
        return res;
    }

    public String toStringBNF(){
        String res="";
        res="Triangle;"+String.valueOf(this.getid())+";";
        for (int i=0;i<this.sommet.length;i++){
        res= res+this.getPoint(i).toStringBNF()+";";
        }
             
        return res;
    }


     //Méthode principale main
    
     public static void main(String[] args){

        //sert de test
        
        Point n1 = new Point(10,0,-6);
        Point n2 = new Point(20,0,2);
        Point n3 = new Point(30,-3,2);
        System.out.println(n1.toStringBNF());
        TriangleTerrain t = new TriangleTerrain(1,n1,n2,n3);
        System.out.println(t.toString());
        Point n4 = new Point(4,1,6);
        t.set(n1,n4);
        System.out.println();
        System.out.println(t.toString());
        System.out.println();
        System.out.println(t.toStringBNF());
}

}
