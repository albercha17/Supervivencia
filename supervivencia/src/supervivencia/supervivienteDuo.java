package supervivencia;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class supervivienteDuo implements Serializable
{
    private superviviente s1,s2;
    public supervivienteDuo(superviviente nombre, superviviente vida) {
    	this.s1=nombre;
        this.s2 =vida;
        
    }
 
    public superviviente getS1(int x) {
    	if(x==1)return s1;
    	else return s2;
    }
    public void sets1(superviviente s1,int x) {
    	if(x==1)this.s1=s1;
    	else this.s2=s1;
    }
 
}