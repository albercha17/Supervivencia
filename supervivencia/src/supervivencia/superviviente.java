package supervivencia;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class superviviente implements Serializable
{
    private String nombre,escudo,original;
    private int vida,bajas;
    private boolean E;
    private superviviente compañero;
    public superviviente(String nombre, int vida) {
    	this.original=nombre;
        this.nombre = nombre;
        this.vida = vida;
        this.escudo="(E)";
        this.E=false;
        this.bajas=0;
        this.compañero=null;
        
    }
    public String getOriginal() {
        return original;
    }
    public String getNombre() {
        return nombre;
    }
    public void setCompañero(superviviente compañero,int x ) {
    	if(compañero==null) { nombre=original;}
    	else { nombre=nombre+" y " + compañero.getNombre();}
    	if(x==1) {nombre= compañero.getNombre();}
    	this.compañero=compañero;
         
    }
    public superviviente getCompañero() {
        return compañero;
    }
    public int getvida() {
        return vida;
    }
    public int getbajas() {
        return bajas;
    }
    public void baja() {
         this.bajas++;
    }
    
 
    public void setvida(int vida) {
        this.vida = vida;
    }
    public void dañar() {
    	this.vida--;
    		this.E=false;
    		this.nombre=original;
    }
    public void escudo() {
    	if(E==false)this.nombre=this.nombre+escudo;
    	this.E=true;
    	
    	
    }
    public boolean getescudo() {
    	return this.E;
    }
}