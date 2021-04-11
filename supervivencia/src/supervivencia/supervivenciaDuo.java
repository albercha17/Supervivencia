package supervivencia;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class supervivenciaDuo {
	static List<supervivienteDuo> supervivientes;
	static List<String> muertos;
	static List<String> muertes;
	static List <String>resucita;
	static List<String> suicidio;
	static List<String> diaN;
	static List<String> diaNG;
	static int numero,Nsuperv,Nmuerto,Nmuerte,Nresucita,NR,Nsuicidio,NdiaN, NdiaNG;
	static boolean acabado,r;
	static String accion;
	static int p=13;
	static String archivo;
	
	
	public supervivenciaDuo(String archivo) throws IOException {
		this.archivo=archivo;
		this.rellenarListas();
		acabado=false;
		r=false;
		
    }
static ArrayList<String> rellenar(String archivo) throws IOException {
	List<String> lista= new ArrayList<String>();
	FileReader f = new FileReader(archivo);
      BufferedReader b = new BufferedReader(f);
      String linea;
      while((linea = b.readLine()) != null) {
    	  lista.add(linea);
      }
      b.close();
      
	return (ArrayList<String>) lista;
}
static void rellenarListas() throws IOException{
	supervivientes=rellenarL();
	muertos= new ArrayList<String>();
	muertes= new ArrayList<String>();
	muertes=rellenar("C:\\Users\\Usuario\\git\\repository\\supervivencia\\src\\archivos\\muertes.txt");
	resucita=new ArrayList<String>();
	resucita=rellenar("C:\\Users\\Usuario\\git\\repository\\supervivencia\\src\\archivos\\resucita.txt");
	suicidio=new ArrayList<String>();
	suicidio=rellenar("C:\\Users\\Usuario\\git\\repository\\supervivencia\\src\\archivos\\suicidio.txt");
	diaN=new ArrayList<String>();
	diaN=rellenar("C:\\Users\\Usuario\\git\\repository\\supervivencia\\src\\archivos\\diaN.txt");
	diaNG=new ArrayList<String>();
	diaNG=rellenar("C:\\Users\\Usuario\\git\\repository\\supervivencia\\src\\archivos\\diaNG.txt");
}
static ArrayList<supervivienteDuo> rellenarL() throws IOException {
	String ar=archivo;
	int n=0;
	List<superviviente> lista= new ArrayList<superviviente>();
	List<supervivienteDuo> listaDuo= new ArrayList<supervivienteDuo>();
	superviviente s1=null;
	superviviente s2=null;
	FileReader f = new FileReader(ar);
	superviviente aux=new superviviente("",0);
      BufferedReader b = new BufferedReader(f);
      String linea;
      while((linea = b.readLine()) != null) {
    	  aux = null;
    	  aux=new superviviente(linea,1);
    	  lista.add(aux);
      }
      b.close();
      while(!lista.isEmpty()) {
    	  n = (int)(Math.random()*lista.size());
    	  s1=lista.get(n);
    	  lista.remove(n);
    	  n = (int)(Math.random()*lista.size());
    	  if(!lista.isEmpty()) {
    	  s2=lista.get(n);
    	  lista.remove(n);
    	  listaDuo.add(new supervivienteDuo(s1,s2));}
    	  s1=null;
    	  s2=null;
      }
      return (ArrayList<supervivienteDuo>) listaDuo;
}
static void aleatorio(){
	numero = (int)(Math.random()*p+1);
	Nsuperv=(int)(Math.random()*supervivientes.size());
	Nmuerto=(int)(Math.random()*supervivientes.size());
	Nresucita=(int)(Math.random()*muertos.size());
	while(Nsuperv==Nmuerto) {
		Nmuerto=(int)(Math.random()*supervivientes.size());
	}
	Nmuerte=(int)(Math.random()*muertes.size());
	NR=(int)(Math.random()*resucita.size());
	Nsuicidio=(int)(Math.random()*suicidio.size());
	NdiaN=(int)(Math.random()*diaN.size());
	NdiaNG=(int)(Math.random()*diaNG.size());
}
public static String jugar() {
	boolean acc=false;
	int x=(int)(Math.random()*2+1);
	int y=(int)(Math.random()*2+1);
	int numsuper=supervivientes.size();
	superviviente aux = null;
	String nombre,fin="";
	while(supervivientes.size()!=1&&!acc ) {
	accion="";
	aleatorio();
	if((numero>=1&&numero<=3||numero>=13&&numero<=18)&&supervivientes.get(Nsuperv).getS1(x)!=null&&supervivientes.get(Nmuerto).getS1(y)!=null/*&&supervivientes.get(Nmuerto).getS1(y).getescudo()!=true*/) {   // muerte del 1 al 3 y de 15 a 18
		accion="muerto";
		numsuper--;
		fin=supervivientes.get(Nsuperv).getS1(x).getNombre()+" "+ muertes.get(Nmuerte)+ " a "+supervivientes.get(Nmuerto).getS1(y).getNombre() +"\n";
		supervivientes.get(Nmuerto).sets1(null, y);
		if(supervivientes.get(Nmuerto).getS1(1)==null&&supervivientes.get(Nmuerto).getS1(2)==null)supervivientes.remove(Nmuerto);
		acc=true;
		return fin;
		
	}
	/*else if((numero>=1&&numero<=3)||(numero>=15&&numero<=18)&&supervivientes.get(Nsuperv).getS1(x)!=null&&supervivientes.get(Nmuerto).getS1(y)!=null&&supervivientes.get(Nmuerto).getS1(y).getescudo()==true) {   // dañar del 1 al 3
		accion="dañar";
		fin=supervivientes.get(Nsuperv).getS1(x).getNombre()+" le ha quitado el escudo a "+supervivientes.get(Nmuerto).getS1(y).getNombre() +"\n";
		supervivientes.get(Nmuerto).getS1(y).dañar();
	}*/
	else if((numero==6||numero==7)&&supervivientes.get(Nmuerto).getS1(y)!=null&&!supervivientes.get(Nmuerto).getS1(y).getescudo()) { // suicidio con el 6 y 7
		accion="muerto";
		numsuper--;                                                   
		fin=supervivientes.get(Nmuerto).getS1(y).getNombre()+" "+suicidio.get(Nsuicidio)+"\n";
		supervivientes.get(Nmuerto).sets1(null, y);
		if(supervivientes.get(Nmuerto).getS1(1)==null&&supervivientes.get(Nmuerto).getS1(2)==null)supervivientes.remove(Nmuerto);
		acc=true;
		return fin;

	}

	/*else if(numero==8&&supervivientes.get(Nsuperv).getS1(x)!=null) {   // escudo del 8
		accion="escudo";
		fin=supervivientes.get(Nsuperv).getS1(x).getNombre()+" ha conseguido un escudo  " +"\n";
		supervivientes.get(Nsuperv).getS1(x).escudo();
	}*/
	else if((numero==9||numero==10)&&supervivientes.get(Nsuperv).getS1(x)!=null) {   // dia normal del 9 al 11
		accion="dianormal";
		fin=supervivientes.get(Nsuperv).getS1(x).getNombre()+" "+ diaN.get(NdiaN) +"\n";
		acc=true;
		return fin;

	}
	else if((numero==11||numero==12)&&supervivientes.get(Nsuperv).getS1(1)!=null&&supervivientes.get(Nsuperv).getS1(2)!=null) {   // dia normal en pareja del 12 al 14
		accion="dianormal";
		fin=supervivientes.get(Nsuperv).getS1(1).getNombre()+" y "+supervivientes.get(Nsuperv).getS1(2).getNombre()+" "+ diaNG.get(NdiaNG) +"\n";
		acc=true;
		return fin;

	}
	else {
		accion="dianormal";
		fin="No ha ocurrido nada";
		acc=false;

	}
	
	}
	acabado=true;
	accion="ganar";
	fin=" HA GANADO:" + getSupervivientes();  
	
	return fin;
}
public static String getSupervivientes() {
	String x="";
	for(int i=0;i<supervivientes.size();i++) {
		if(supervivientes.get(i).getS1(1)!=null)
			x=x+supervivientes.get(i).getS1(1).getNombre();
		if(supervivientes.get(i).getS1(1)!=null&&supervivientes.get(i).getS1(2)!=null)
			x=x+" y ";
		if(supervivientes.get(i).getS1(2)!=null)
			x=x+supervivientes.get(i).getS1(2).getNombre();
		x=x+" | ";
	}
	return x;
}
public boolean getAcabado() {
	return acabado;
}
public String getAccion() {
	return accion;
}
}


