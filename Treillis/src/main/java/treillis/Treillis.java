package treillis;
import java.util.*;
import java.io.File;
import java.io.IOException;
import java.io.*;

import Noeuds.AppuiDouble;
import Noeuds.AppuiSimple;
import Noeuds.Noeud;
import Noeuds.NoeudSimple;





public class Treillis {

   
    //Attributs
    private Terrain terrain; //terrain
    private ArrayList<Noeud> listpoint; //ensemble de noeuds
    private ArrayList<Barre> listbarre; //ensemble de barre
    private CatalogueBarre catalogue;
    
    //Constructeur
    public Treillis(Terrain t,ArrayList<Noeud> point,ArrayList<Barre> barre,CatalogueBarre catalogue ){
        this.terrain=t;

        //il faut respecter les différentes contraintes à la création du treillis

        this.listpoint=point;
        this.listbarre=barre;
        this.catalogue=catalogue;
    }

    //méthodes get
    public Terrain getterrain(){
        return this.terrain;
        
    }
    
    public ArrayList<Noeud> getnoeud(){
        return this.listpoint;
    }

    public Noeud getnoeud(int i){
        return this.listpoint.get(i);
    }

    public ArrayList<Barre> getbarre(){
        return this.listbarre;
    }

    public Barre getbarre(int i){
        return this.listbarre.get(i);
    }

    
    public CatalogueBarre getcatalogue(){
        return this.catalogue;
    }

    //méthodes set
    public void setterrain(Terrain t){
        this.terrain=t;
    }

    public void setnoeud(ArrayList<Noeud> n){
        this.listpoint=n;
    }

    public void setbarre(ArrayList<Barre> n){
        this.listbarre=n;
    }

    public void setcatalogue(CatalogueBarre n){
        this.catalogue=n;
    }
    //méthode size
    public int sizeNoeud(){
        return this.getnoeud().size();
    }

    public int sizeBarre(){
        return this.getbarre().size();
    }

    //méthodes add qui permettront d'ajouter des noeuds et des barres au treillis

    public void add(Noeud n){
        this.listpoint.add(n);
    }

    public void add(Barre b){
        this.listbarre.add(b);
    }

   
  public boolean contains(Noeud n){
    boolean test=false;
    for (int i=0;i<this.listpoint.size();i++){
       if (n== this.getnoeud(i)){
          test=true;
       }
    }
    return test;
 }

    public boolean contains(Barre n){
    boolean test=false;
    for (int i=0;i<this.listbarre.size();i++){
       if (n.getid()== this.getbarre(i).getid()){
          test=true;
       }
    }
    return test;
 }
    //méthodes remove
    public void remove(Noeud n){
        if(this.contains(n)==true){
    
        }else{
          for (int i=0;i<this.sizeNoeud();i++){
             if (n.getid()== this.getnoeud(i).getid()){
                this.listpoint.remove(i);
             }
          }
    
        }
       }

       public void remove(Barre n){
        if(this.contains(n)==true){
    
        }else{
          for (int i=0;i<this.sizeBarre();i++){
             if (n.getid()== this.getbarre(i).getid()){
                this.listbarre.remove(i);
             }
          }
    
        }
       }

      

       

       //méthode toString
       public String toString(){
           String res="";
            res= "Terrain = "+this.getterrain().toString();
            res= res+" Points = ";
            for(int i=0;i<this.sizeNoeud();i++){
                res=res+this.getnoeud(i).toString();
            }
            res= res+ " Barre = ";
            for(int i=0;i<this.sizeBarre();i++){
                res=res+this.getbarre(i).toString();
            }
            res= res+this.getcatalogue().toString();
           return res;
       }

       public String toStringBNF(){
           ArrayList<Noeud> test = new ArrayList<Noeud>();
           //cette arraylist va contenir tout les noeuds du treillis 
           String res="";
            //description du terrain
           res=this.getterrain().toStringBNF();
           
           res=res+"FINTRIANGLES";
           
           res=res+"\n"+"TypeBarre;";
        //Description des typeBarre
           for(int i=0;i<this.getcatalogue().getTypeBarre().size();i++){
            res=res+this.getcatalogue().getTypeBarre(i).toStringBNF()+"\n";
           }
           res=res+"FINCATALOGUE"+"\n";
         
           for(int i=0;i<this.getnoeud().size();i++){
            if (test.contains(this.getnoeud(i))){

            }else{
                res=res+this.getnoeud(i).toStringBNF();
            }
            //de cette manière, chaque noeud n'apparaitra qu'une fois   
           }
           res=res+"\n"+"FINNOEUDS"+"\n";
          
           for(int i=0;i<this.getbarre().size();i++){
               
               res=res+this.getbarre(i).toStringBNF()+"\n";
           }
           
           res=res+"FINBARRES"+"\n";
        

           
           
           return res;
       }

       public void sauvegarde(String nom) throws IOException{
        try{
        File file = new File("nom"+".txt");
        //créer le fichier s'il n'existe pas
        if(!file.exists()){
            file.createNewFile();
        }

        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(this.toStringBNF());
        bw.close();
    }catch (IOException e){
        e.printStackTrace();
    }



    }

    public static Treillis lecture(String tt) throws IOException{

        
        ArrayList<TriangleTerrain> triangles = new ArrayList<TriangleTerrain>();
        ArrayList<Noeud> noeud = new ArrayList<Noeud>();
        ArrayList<Barre> barre = new ArrayList<Barre>();
        ArrayList<typeBarre> typebarre = new ArrayList<typeBarre>();

        ArrayList<Integer> identificateurt = new ArrayList<Integer>();
        ArrayList<Integer> identificateurn = new ArrayList<Integer>();
        ArrayList<Integer> identificateurtb = new ArrayList<Integer>();
        
        
        CatalogueBarre catalogue = new CatalogueBarre(typebarre);
        double minX ;
        double maxX ;
        double minY ;
        double maxY ;
      
        Terrain terrain= new Terrain(triangles);
        /*En BNF, les triangles ne contiennent que les id des points , on va donc les stocker afin de creer les triangles correspondant 
        une fois que les points auront été lu et leur id obtenus*/
        
        try (BufferedReader bin = Extraire(tt)){
            String line;
    
            while((line = bin.readLine())!=null && line.length() != 0){
             String[] bouts = line.split("[;()]");
             ;

             if(bouts[0].equals("ZoneConstructible")){
                 //lis la ligne contenant la zone constructible
                  minX = Double.parseDouble(bouts[1]);
                  maxX = Double.parseDouble(bouts[2]);
                  minY = Double.parseDouble(bouts[3]);
                  maxY = Double.parseDouble(bouts[4]);
                  terrain.setmaxX(maxX);
                  terrain.setmaxY(maxY);
                  terrain.setminX(minX);
                  terrain.setminY(minY);


             }else if(bouts[0].equals("Triangle")){
                 //lis une ligne contenant un triangle
                int id= Integer.parseInt(bouts[1]);
                
                
                Point p1 = new Point (1,Double.parseDouble(bouts[3]), Double.parseDouble(bouts[4]));
                //on commence à 1 car la valeur contenue dans la case 0 est l'id
                Point p2 = new Point (1,Double.parseDouble(bouts[7]),Double.parseDouble(bouts[8]));
                Point p3 = new Point (1,Double.parseDouble(bouts[11]), Double.parseDouble(bouts[12]));
                TriangleTerrain t1= new TriangleTerrain(id,p1,p2,p3);
                terrain.add(t1);
                //ajoute le triangle a la liste de triangle
             }
            

            else if(bouts[0].equals("TypeBarre")){

                typeBarre type = new typeBarre();
                type.setid(Integer.parseInt(bouts[1]));
                
                type.setcout(Double.parseDouble(bouts[2]));
                type.setlongmin(Double.parseDouble(bouts[3]));
                type.setlongmax(Double.parseDouble(bouts[4]));
                type.setresistsn(Double.parseDouble(bouts[5]));
                type.setresistcmpn(Double.parseDouble(bouts[6]));
                catalogue.add(type);
            }

             else if(bouts[0].equals("AppuiDouble")){
                int idn= Integer.parseInt(bouts[1]);
                int idt= Integer.parseInt(bouts[2]);
                
                if (terrain.contain(idt)==true){
                    int i=0;
                    while(triangles.get(i).getid() !=idt){
                        i++;
                    }
                    TriangleTerrain tr= triangles.get(i);
                    int numero= Integer.parseInt(bouts[3]);
                    double position= Double.parseDouble(bouts[4]);
                    AppuiDouble ad= new AppuiDouble(idn, tr, numero, position);
                    noeud.add(ad);
                    }else{
                        identificateurt.add(idt);
                        identificateurn.add(idn);
                    }

             }else if(bouts[0].equals("AppuiSimple")){
                
                int idn= Integer.parseInt(bouts[1]);
                int idt= Integer.parseInt(bouts[2]);

                if (terrain.contain(idt)==true){
                    int i=0;
                    while(triangles.get(i).getid() !=idt){
                        i++;
                    }
                    
                    TriangleTerrain tr= triangles.get(i);
                    int numero= Integer.parseInt(bouts[3]);
                    double position= Double.parseDouble(bouts[4]);
                    AppuiSimple ad= new AppuiSimple(idn, tr, numero, position);
                    noeud.add(ad);

                    }else{
                        identificateurt.add(idt);
                        identificateurn.add(idn);
                    }
            

             }else if(bouts[0].equals("NoeudSimple")){
                
            int id= Integer.parseInt(bouts[1]);
           
            double abscisse=Double.parseDouble(bouts[3]);
            double ordonnee=Double.parseDouble(bouts[4]);
            NoeudSimple ns= new NoeudSimple(id,abscisse,ordonnee);
            noeud.add(ns);

            }else if(bouts[0].equals("Barre")){
            
                int idb= Integer.parseInt(bouts[1]);
                int idtb= Integer.parseInt(bouts[2]);
                int idn1 =Integer.parseInt(bouts[3]);
                int idn2 =Integer.parseInt(bouts[4]);
                typeBarre aa=null;
           
                if (catalogue.contains(idtb)==true ){
                    aa=catalogue.gettypebarre(idtb);
                   
                  
                }else{
                    identificateurtb.add(idtb);
                }

                
                NoeudSimple n1=null;
                for(int i=0;i<noeud.size();i++){
                   
                    if(noeud.get(i).getid()==idn1){
                        n1=noeud.get(i);
                      
                    }
                }
                
                NoeudSimple n2=null;
                for(int i=0;i<noeud.size();i++){
                   
                    if(noeud.get(i).getid()==idn2){
                        n2=noeud.get(i);
                       
                }
                if(n1!= null && n2!=null && aa!=null){
                Barre br=new Barre(idb, aa, n1, n2);
                barre.add(br);

                }
            }
           
            
            }
        }
        
        Treillis t= new Treillis(terrain, noeud, barre, catalogue);
        return t;
    
    }
}

    public static BufferedReader Extraire(String txt) throws IOException {
			
		//fonction qui extrait le fichier .txt
		 txt="Sauvegarde/"+txt+".txt";
		 InputStream ips = new FileInputStream(txt);
		 InputStreamReader ipsr = new InputStreamReader(ips);
		 BufferedReader br = new BufferedReader(ipsr); 

		 return br; 
				   }
			   

      /* public void save(Writer w, NumeroteurTreillis<Noeud> num) throws IOException{

    }
    public void sauvegarde(File fout) throws IOException{
        NumeroteurTreillis<Noeud> num = new NumeroteurTreillis<Noeud>();
        try(BufferedWriter bout=new BufferedWriter(new FileWriter(fout))){
         this.save(bout,num);

    }

   
}*/
public static void main(String[] args) throws IOException{
   
    Point p1 = new Point(10,0,-6);
    Point p2 = new Point(20,0,2);
    Point p3 = new Point(30,-3,2);
    TriangleTerrain t1= new TriangleTerrain(1, p1, p2, p3);
    ArrayList<TriangleTerrain> tr = new ArrayList<TriangleTerrain>();
    tr.add(t1);
    Terrain terrain = new Terrain(0.5, 4, -5, 1, tr);
    AppuiDouble n1 = new AppuiDouble(1,t1,0,0.75);
    AppuiSimple n2 = new AppuiSimple(2,t1,0,0.25);
    NoeudSimple n3= new NoeudSimple(3,2,2);
    typeBarre t =new typeBarre(1,100,1,5,1000,2000);
    ArrayList<typeBarre> catalogue= new ArrayList<typeBarre>();
    catalogue.add(t);
    CatalogueBarre cata = new CatalogueBarre(catalogue);
    Barre b1 = new Barre(1, t, n1, n3);
    Barre b2 = new Barre(2, t, n2, n3);
    Barre b3 = new Barre(2, t, n1, n2);
    ArrayList<Noeud> ln= new ArrayList<Noeud>();
    ln.add(n1);
    ln.add(n2);
    ln.add(n3);
    ArrayList<Barre> lb= new ArrayList<Barre>();
    lb.add(b1);
    lb.add(b2);
    lb.add(b3);
    Treillis treillis = new Treillis(terrain,ln,lb,cata);
    System.out.println("Ceci est un test");
    System.out.println(treillis.toStringBNF());
    System.out.println("");
    System.out.println("");
    System.out.println(cata.getTypeBarre(0).toStringBNF());
    treillis.sauvegarde("test");
    String ll= "test";
    Treillis treillis2 = lecture(ll);
    treillis2.sauvegarde("prionsleseigneur");
    System.out.println(treillis2.toStringBNF());
}
}

