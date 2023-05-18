package treillis;
import java.util.*;


public class Terrain{

    // Attributs

    private double maxX;
    private double maxY;
    private double minX;
    private double minY;
    //ces 4 attributs definissent la zone constructible
    private ArrayList<TriangleTerrain> triangles;
    
    //Constructeur
    public Terrain(double minx,double maxx, double miny,double maxy ,  ArrayList<TriangleTerrain> t)
    {
        this.maxX= maxx;
        this.maxY= maxy;
        this.minX= minx;
        this.minY=miny;
        this.triangles= t;
    }

    public Terrain(ArrayList<TriangleTerrain> t)
    {
     
        this.triangles= t;
    }

    //méthode get

    public double getmaxX(){
        return this.maxX;
    }
    public double getmaxY(){
        return this.maxY;
    }
    public double getminY(){
    return this.minY;
}
    public double getminX(){
    return this.minX;
    }

    public ArrayList<TriangleTerrain> gettriangle(){
    return this.triangles;

}   

public TriangleTerrain gettriangleId(int id){
    TriangleTerrain t = new TriangleTerrain();
for(int i=0 ;i<this.triangles.size();i++){
    if (id == this.gettriangle(i).getid()){
        t=this.gettriangle(i);
    }
}
    return t;
}
    


    public TriangleTerrain gettriangle(int i){
    return this.triangles.get(i);

}  
    //méthode set
    public void setmaxX(double i){
        this.maxX=i;
    }
    public void setmaxY(double i){
        this.maxY= i;
    }
    
    public void setminX(double i){
        this.minX= i;
}

    public void setminY(double i){
        this.minY=i;
    }

    public void settriangle(ArrayList<TriangleTerrain> triangles){
        this.triangles= triangles;
    }
    //méthode pour remplacer un triangle par un autre
    public void settriangle(TriangleTerrain t,TriangleTerrain triangle2){
        for(int i=0;i<this.gettriangle().size();i++){
            if(this.gettriangle(i)==triangle2){
                this.triangles.set(i,triangle2);
            }
        }
       
        
    }

    //méthode contain 

    //méthode qui verifie si l'id d'un triangle est deja contenu
    public boolean contain(int id){
        boolean test=false;
        for(int i=0;i<this.gettriangle().size();i++){
            if(this.gettriangle(i).getid()==id){
                test=true;
            }
        }
        return test;
    }

    public void add(TriangleTerrain triangle){
        this.triangles.add(triangle);
    }

    //méthode toString
    public static String formatDouble(double x) {
        return formatDouble(x);
    }

    public  String toString(){
    
    String res= "";
        
        res="maxX= "+ formatDouble(this.maxX)+" ; ";
        res= res+ "maxY ="+ formatDouble(this.maxY)+" ; ";
        res = res+ "minX= "+ formatDouble(this.minX)+" ; ";
        res= res+ "minY=" + formatDouble(this.minY)+" ; ";
        res= res+" triangle= ";
        for(int i=0;i<this.gettriangle().size();i++){
            res= res+(this.gettriangle(i).toString());
        }
    return res;
    }
   

    //méthode qui renvoie un String au format BNF, ce qui servira à la sauvegarde du treillis
    public String toStringBNF(){
        String res="";
        res="ZoneConstructible;"+String.valueOf(this.getminX())+";"+String.valueOf(this.getmaxX())+
        ";"+String.valueOf(this.getminY())+";"+String.valueOf(this.getmaxY())+"\n";
        
        System.out.println(res);
        for (int i =0;i<this.gettriangle().size();i++){
            TriangleTerrain t =this.gettriangle(i);
            res=res +t.toStringBNF()+"\n";
        }
        
       
        return res;
    }
}

