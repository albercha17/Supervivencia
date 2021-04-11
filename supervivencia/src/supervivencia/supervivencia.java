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
public class supervivencia {
	static List<superviviente> supervivientes;
	static List<String> muertos;
	static List<String> muertes;
	static List <String>resucita;
	static List<String> suicidio;
	static List<String> diaN;
	static List<String> diaNG;
	static int numero,Nsuperv,Nmuerto,Nmuerte,Nresucita,NR,Nsuicidio,NdiaN, NdiaNG;
	static boolean acabado,r,j,compi;
	static String accion;
	static int p=20;
	static String archivo;
	
	
	public supervivencia(String archivo,boolean compi) throws IOException {
		this.archivo=archivo;
		this.rellenarListas();
		acabado=false;
		r=false;
		j=false;
		this.compi=compi;
		
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
	muertes=rellenar("src\\archivos\\muertes.txt");
	resucita=new ArrayList<String>();
	resucita=rellenar("src\\archivos\\resucita.txt");
	suicidio=new ArrayList<String>();
	suicidio=rellenar("src\\archivos\\suicidio.txt");
	diaN=new ArrayList<String>();
	diaN=rellenar("src\\archivos\\diaN.txt");
	diaNG=new ArrayList<String>();
	diaNG=rellenar("src\\archivos\\diaNG.txt");
}
static ArrayList<superviviente> rellenarL() throws IOException {
	String ar=archivo;
	List<superviviente> lista= new ArrayList<superviviente>();
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
      return (ArrayList<superviviente>) lista;
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
public static String bomba(){
	int bomba=(int)(Math.random()*supervivientes.size());
	String x="Ha caido una bomba atomica.Ha matado a ";
	int bom=0;
	bomba=bomba/2;
	if(bomba==0) {
		x="Ha caido una bomba atomica.No ha matado a nadie. ";
	}
	if(bomba==1) {
		x=x+supervivientes.get(bom).getNombre();
		muertos.add(supervivientes.get(bom).getNombre());
	supervivientes.remove(bom);
	}else {
	for(int i=0;i<bomba;i++) {
		bom=(int)(Math.random()*supervivientes.size());
		if(i==bomba-1) {
			x=x+" y "+supervivientes.get(bom).getNombre();
			muertos.add(supervivientes.get(bom).getNombre());
		supervivientes.remove(bom);
		}
		else if(i==bomba-2) {
			x=x+supervivientes.get(bom).getNombre();
			muertos.add(supervivientes.get(bom).getNombre());
		supervivientes.remove(bom);
		}
		else {
			x=x+supervivientes.get(bom).getNombre()+", ";
			muertos.add(supervivientes.get(bom).getNombre());
		supervivientes.remove(bom);
		}
		
	}
	}
	return x;
}
public static String jugar() {
	int numsuper=supervivientes.size();
	superviviente aux = null;
	String nombre,fin="";
	while(supervivientes.size()!=1) {
		if(supervivientes.size()==2&&!j) {
			fin="S="+supervivientes.size()+"                    SOLO QUEDAN 2 SUPERVIVIENTES"+"\n";
			j=true;
			
		}
	accion="";
	aleatorio();
	if(supervivientes.get(Nmuerto).getCompañero()==null&&(numero>=1&&numero<=3||numero>=13&&numero<=18)&&supervivientes.get(Nmuerto).getescudo()!=true) {   // muerte del 1 al 3 y de 15 a 18
		accion="muerto";
		numsuper--;
		fin=supervivientes.get(Nsuperv).getNombre()+" "+ muertes.get(Nmuerte)+ " a "+supervivientes.get(Nmuerto).getNombre() +"\n";
		supervivientes.get(Nsuperv).baja();
		muertos.add(supervivientes.get(Nmuerto).getNombre());
		supervivientes.remove(Nmuerto);
		
	}
	else if(supervivientes.get(Nsuperv).getCompañero()!=null&&supervivientes.get(Nmuerto).getCompañero()!=null&&(numero>=1&&numero<=3||numero>=13&&numero<=18)&&supervivientes.get(Nmuerto).getescudo()!=true) {   // muerte del 1 al 3 y de 15 a 18
		int x=(int)(Math.random()*2+1);
		int y=(int)(Math.random()*2+1);
		accion="muerto";
		numsuper--;
		if(x==1) {
			if(y==1)fin=supervivientes.get(Nsuperv).getNombre()+" "+ muertes.get(Nmuerte)+ " a "+supervivientes.get(Nmuerto).getCompañero().getOriginal() +"\n";
			else fin=supervivientes.get(Nsuperv).getCompañero().getNombre()+" "+ muertes.get(Nmuerte)+ " a "+supervivientes.get(Nmuerto).getCompañero().getOriginal() +"\n";
			supervivientes.get(Nsuperv).baja();
			muertos.add(supervivientes.get(Nmuerto).getCompañero().getOriginal());
			supervivientes.get(Nmuerto).setCompañero(null, 0);
		}
		else if(x==2) {
			if(y==1)fin=supervivientes.get(Nsuperv).getNombre()+" "+ muertes.get(Nmuerte)+ " a "+supervivientes.get(Nmuerto).getOriginal() +"\n";
			else fin=supervivientes.get(Nsuperv).getCompañero().getNombre()+" "+ muertes.get(Nmuerte)+ " a "+supervivientes.get(Nmuerto).getOriginal() +"\n";

			supervivientes.get(Nsuperv).baja();
			muertos.add(supervivientes.get(Nmuerto).getOriginal());
			supervivientes.get(Nmuerto).setCompañero(supervivientes.get(Nmuerto).getCompañero(), 1);
		}
	}
	
	else if(supervivientes.get(Nmuerto).getCompañero()!=null&&(numero>=1&&numero<=3||numero>=13&&numero<=18)&&supervivientes.get(Nmuerto).getescudo()!=true) {   // muerte del 1 al 3 y de 15 a 18
		int x=(int)(Math.random()*2+1);
		accion="muerto";
		numsuper--;
		if(x==1) {
			fin=supervivientes.get(Nsuperv).getNombre()+" "+ muertes.get(Nmuerte)+ " a "+supervivientes.get(Nmuerto).getCompañero().getOriginal() +"\n";
			supervivientes.get(Nsuperv).baja();
			muertos.add(supervivientes.get(Nmuerto).getCompañero().getOriginal());
			supervivientes.get(Nmuerto).setCompañero(null, 0);
		}
		else if(x==2) {
			fin=supervivientes.get(Nsuperv).getNombre()+" "+ muertes.get(Nmuerte)+ " a "+supervivientes.get(Nmuerto).getOriginal() +"\n";
			supervivientes.get(Nsuperv).baja();
			muertos.add(supervivientes.get(Nmuerto).getOriginal());
			supervivientes.get(Nmuerto).setCompañero(supervivientes.get(Nmuerto).getCompañero(), 1);
		}
		
	}
	
	else if((numero>=1&&numero<=3)||(numero>=15&&numero<=18)&&supervivientes.get(Nmuerto).getescudo()==true) {   // dañar del 1 al 3
		accion="dañar";
		fin=supervivientes.get(Nsuperv).getNombre()+" le ha quitado el escudo a "+supervivientes.get(Nmuerto).getNombre() +"\n";
		supervivientes.get(Nmuerto).dañar();
	}
	else if((numero==4||numero==5)&& !muertos.isEmpty()&&!r) {    // resucita el 4 y 5
		r=true;
		accion="resucitar";
		numsuper++;
		fin=muertos.get(Nresucita)+" "+resucita.get(NR)+"\n";
		String x=muertos.get(Nresucita);
		aux= new superviviente(x,1);
		supervivientes.add(aux);
		muertos.remove(Nresucita);
	}
	else if(supervivientes.get(Nmuerto).getCompañero()==null&&(numero==6||numero==7)&&!supervivientes.get(Nmuerto).getescudo()) { // suicidio con el 6 y 7
		accion="muerto";
		numsuper--;                                                   
		fin=supervivientes.get(Nmuerto).getNombre()+" "+suicidio.get(Nsuicidio)+"\n";
		muertos.add(supervivientes.get(Nmuerto).getNombre());
		supervivientes.remove(Nmuerto);
	}
	else if(supervivientes.get(Nmuerto).getCompañero()==null&&(numero==6||numero==7)&&!supervivientes.get(Nmuerto).getescudo()) { // suicidio con el 6 y 7
		int x=(int)(Math.random()*2+1);
		accion="muerto";
		numsuper--;
		if(x==1) {
			fin=supervivientes.get(Nmuerto).getCompañero().getOriginal()+" "+suicidio.get(Nsuicidio)+"\n";
			supervivientes.get(Nsuperv).baja();
			muertos.add(supervivientes.get(Nmuerto).getCompañero().getOriginal());
			supervivientes.get(Nmuerto).setCompañero(null, 0);
		}
		else if(x==2) {
			muertos.add(supervivientes.get(Nmuerto).getOriginal());
			supervivientes.get(Nsuperv).baja();
			muertos.add(supervivientes.get(Nmuerto).getOriginal());
			supervivientes.get(Nmuerto).setCompañero(supervivientes.get(Nmuerto).getCompañero(), 1);
		}
	}

	else if(numero==8) {   // escudo del 8
		accion="escudo";
		fin=supervivientes.get(Nsuperv).getNombre()+" ha conseguido un escudo  " +"\n";
		supervivientes.get(Nsuperv).escudo();
	}
	else if((numero==9||numero==10)) {   // dia normal del 9 al 11
		accion="dianormal";
		fin=supervivientes.get(Nsuperv).getNombre()+" "+ diaN.get(NdiaN) +"\n";
	}
	else if((numero==11||numero==12)) {   // dia normal en pareja del 12 al 14
		accion="dianormal";
		fin=supervivientes.get(Nsuperv).getNombre()+" y "+supervivientes.get(Nmuerto).getNombre()+" "+ diaNG.get(NdiaNG) +"\n";
	}
	else if(compi&&(numero>=19&&numero<=20)&&supervivientes.get(Nsuperv).getCompañero()==null) {   // alianza en pareja del 12 al 14
		accion="alianza";
		fin=supervivientes.get(Nsuperv).getNombre()+" y "+supervivientes.get(Nmuerto).getNombre()+" se han aliado\n";
		supervivientes.get(Nsuperv).setCompañero(supervivientes.get(Nmuerto),0);
		supervivientes.remove(Nmuerto);
	}
	
	else {
		accion="dianormal";
		fin="No ha ocurrido nada";
	}
	return fin;
	}
	acabado=true;
	accion="ganar";
	fin=" HA GANADO:" + supervivientes.get(0).getNombre() + " con "+ supervivientes.get(0).getbajas()+" bajas!!!!";  
	
	return fin;
}
public String getSupervivientes() {
	String x="";
	for(int i=0;i<supervivientes.size();i++) {
		x=x+supervivientes.get(i).getNombre();
		x=x+" | ";
		if(i==20) {
			x=x+"\n";
		}
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


