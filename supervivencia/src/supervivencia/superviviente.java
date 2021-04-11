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
    private superviviente compa�ero;
    public superviviente(String nombre, int vida) {
    	this.original=nombre;
        this.nombre = nombre;
        this.vida = vida;
        this.escudo="(E)";
        this.E=false;
        this.bajas=0;
        this.compa�ero=null;
        
    }
    public String getOriginal() {
        return original;
    }
    public String getNombre() {
        return nombre;
    }
    public void setCompa�ero(superviviente compa�ero,int x ) {
    	if(compa�ero==null) { nombre=original;}
    	else { nombre=nombre+" y " + compa�ero.getNombre();}
    	if(x==1) {nombre= compa�ero.getNombre();}
    	this.compa�ero=compa�ero;
         
    }
    public superviviente getCompa�ero() {
        return compa�ero;
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
    public void da�ar() {
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