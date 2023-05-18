package Noeuds;

import java.io.IOException;
import java.io.Writer;
import treillis.*

import Sauvegarde.NumeroteurTreillis;

public abstract class Appui extends NoeudSimple {

 //Attributs

 private double position;
 private TriangleTerrain triangle;
 private int numero;
 private int numero2;

 //constructeur

Appui(int i,TriangleTerrain triangle, int s, double a){
  super(i,a*triangle.getPoint(s).getabscisse()+(1-s)*triangle.getPoint((s+1)%3).getabscisse(),  
  a*triangle.getPoint(s).getabscisse()+(1-s)*triangle.getPoint((s+1)%3).getabscisse());
  this.triangle=triangle;
  this.numero=s;
  this.numero2=(s+1)%3;
 
 this.position=a;
}




public abstract void save(Writer w, NumeroteurTreillis<Noeud> n) throws IOException;
        
public double getposition(){
  return this.position;
}

public double getabscisse(){
  return this.getabscisse();
}

public double getordonnee(){
  return this.getordonnee();
}

public int getnumero(){
  return this.numero;
}
public TriangleTerrain gettriangle(){
   return this.triangle;
}

public int getidtriangle(){
  return this.triangle.getid();
}

public void setposition(double a){
   this.position=a;
}
public void setnumero(int num){
   this.numero=num;
}
public void settriangle(TriangleTerrain t){
   this.triangle=t;
}          

 
}
