package ziffernfolge;

public class LinearenKongruenz implements Zufallszahl {
	
	/** Methode aus Robert Sedgewick: Algorithmen
	 * Startwert: 1234567
	 */


    private final int m=100000000, m1=10000, b=31415821;
    private int startwert = 1234567; 
    private int hoechste_zahl = 0;
    
    public LinearenKongruenz() {	
    	hoechste_zahl=100;
    }
   
    private int mult(int p, int q) { 
        int p1= p/m1;
        int p0= p%m1;
        int q1= q/m1;
        int q0= q%m1;
        return (((p0*q1+p1*q0)% m1)*m1+p0*q0)% m;
    }

    private int random() { 
    	int zufallszahl;
    	startwert = (mult(startwert,b)+1)% m;    	
    	zufallszahl=((startwert / m1)*(hoechste_zahl+1)) / m1;   
    	return zufallszahl;

    }
    public int naechste() {
        return random();
    }
    
    public int naechste(int von, int bis) {
    	hoechste_zahl= bis;
    	int zahl =0;
    	
    	if ( bis >= von) {    		
        	do {    		
        		zahl=random();
        		if(zahl>=von) {
        		break;
        		}
            }while(true);            
    	}
    	return zahl;    	
    }    
}

