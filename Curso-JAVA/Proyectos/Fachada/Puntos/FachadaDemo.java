package Fachada.Puntos;

class PuntoCart{
  double x, y;
  public PuntoCart( double xx, double yy ){
    x = xx;
    y = yy;
  }
  public void  mover(int dx, int dy ) {
    x += dx;
    y += dy;
  }
  public String toString() {
    return "(" + x + "," + y + ")";
  }
  public double getX() {
    return x;
  }
  public double getY() {
    return y;
  } 
}
class PuntoPolar{
  private double radio, angulo;
  public PuntoPolar(double r, double a ) {
    radio = r;
    angulo = a;
  }
  public void rotar( int ang ) {
    angulo += ang % 360;
  }
  public String toString() {
    return ("[" + radio + "@" + angulo + "]");
  }
}
class Punto{
  private PuntoCart pc; 
  public Punto( double xx, double yy ) {
    pc = new PuntoCart( xx,yy );
  }
  public String toString() {
    return pc.toString();
  }
  public void  mover( int dx, int dy ) {
    pc.mover( dx,dy );
  }
  public void rotar( int angulo, Punto o ) {    
    double x = pc.getX() - o.pc.getX();    
    double y = pc.getY() - o.pc.getY();    
    PuntoPolar pp = new PuntoPolar( Math.sqrt(x*x+y*y),Math.atan2(y,x)*180/Math.PI );    
    pp.rotar( angulo );    
    System.out.println( "  PuntoPolar es " + pp );    
    String str = pp.toString();  
    int i = str.indexOf( '@' );    
    double r = Double.parseDouble( str.substring(1,i) );    
    double a = Double.parseDouble( str.substring(i+1,str.length()-1) );    
     pc = new PuntoCart(r*Math.cos(a*Math.PI/180) + o.pc.getX(),r*Math.sin(a*Math.PI/180) + o.pc.getY() );  
 }
}
class Linea {  
   private Punto o, e;  
   public Linea( Punto origen, Punto fin ) {    
     o = origen;
     e = fin;  
   }  
   public void  mover( int dx, int dy ) {
     o.mover( dx, dy );    
     e.mover( dx, dy );
   }  
   public void  rotar( int angulo ) {
     e.rotar( angulo, o );
   }  
   public String toString() {   
       return "origen es " + o + ", final es " + e;  }
}


public class FachadaDemo {  
  public static void main( String[] args ) {
		System.out.println( "Bienvenido\n"); 
    Linea linea1 = new Linea( new Punto(2,4), new Punto(2,10) );   
    linea1.mover(-2,-3); 
    System.out.println( "despues de mover:  " + linea1 ); 
    linea1.rotar(45);  
    System.out.println( "despues de rotar: " + linea1 );
    Linea linea2 = new Linea( new Punto(2,1), new Punto(2.866,1.5) );
    linea2.rotar(30);    System.out.println( "30 grados to 60 grados: " + linea2 );
  }
}


