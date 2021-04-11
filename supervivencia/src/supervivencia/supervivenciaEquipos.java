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
public class supervivenciaEquipos {
	static List<superviviente> supervivientes;
	static List<superviviente> supervivientes2;
	static List<String> muertos;
	static List<String> muertos2;
	static List<String> muertes;
	static List <String>resucita;
	static List<String> suicidio;
	static List<String> traicion;
	static List<String> diaN;
	static List<String> diaNG;
	static int numero,Nsuperv,Nsuperv2,Nmuerto,Nmuerto2,Nmuerte,Nresucita,Nresucita2,NR,Nsuicidio,NdiaN, NdiaNG, EQUIPO,traicionN;
	static boolean acabado,r;
	static String accion,archivo;
	static int p=27;
	
	
	public supervivenciaEquipos(String archivo) throws IOException {
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
	rellenarL();
	muertos= new ArrayList<String>();
	muertos2= new ArrayList<String>();
	muertes= new ArrayList<String>();
	muertes=rellenar("C:\\Users\\Usuario\\eclipse-workspace\\supervivencia\\src\\archivos\\muertes.txt");
	resucita=new ArrayList<String>();
	resucita=rellenar("C:\\Users\\Usuario\\eclipse-workspace\\supervivencia\\src\\archivos\\resucita.txt");
	suicidio=new ArrayList<String>();
	suicidio=rellenar("C:\\Users\\Usuario\\eclipse-workspace\\supervivencia\\src\\archivos\\suicidio.txt");
	diaN=new ArrayList<String>();
	diaN=rellenar("C:\\Users\\Usuario\\eclipse-workspace\\supervivencia\\src\\archivos\\diaN.txt");
	diaNG=new ArrayList<String>();
	diaNG=rellenar("C:\\Users\\Usuario\\eclipse-workspace\\supervivencia\\src\\archivos\\diaNG.txt");
	traicion=new ArrayList<String>();
	traicion=rellenar("C:\\Users\\Usuario\\eclipse-workspace\\supervivencia\\src\\archivos\\traicion.txt");
	
}
static ArrayList<superviviente> rellenarL() throws IOException {
	supervivientes=new ArrayList<superviviente>();
	supervivientes2=new ArrayList<superviviente>();
	int x=0;
	int e=0;
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
      while(!lista.isEmpty()) {
    	  x = (int)(Math.random()*lista.size());
    	  if(e==0) {
    		  e++;
    		  supervivientes.add(lista.get(x));
    		  lista.remove(x);
    	  }
    	  else {
    		  e--;
    		  supervivientes2.add(lista.get(x));
    		  lista.remove(x);
    	  }
      }
      
      return (ArrayList<superviviente>) lista;
}
static void aleatorio(){
	EQUIPO= (int)(Math.random()*2+1);
	numero = (int)(Math.random()*p+1);
	Nsuperv=(int)(Math.random()*supervivientes.size());
	Nsuperv2=(int)(Math.random()*supervivientes2.size());
	Nmuerto=(int)(Math.random()*supervivientes.size());
	Nresucita=(int)(Math.random()*muertos.size());
	Nmuerto2=(int)(Math.random()*supervivientes2.size());
	Nresucita2=(int)(Math.random()*muertos2.size());
	Nmuerte=(int)(Math.random()*muertes.size());
	NR=(int)(Math.random()*resucita.size());
	Nsuicidio=(int)(Math.random()*suicidio.size());
	NdiaN=(int)(Math.random()*diaN.size());
	NdiaNG=(int)(Math.random()*diaNG.size());
	traicionN=(int)(Math.random()*traicion.size());
}
public static String jugar() {
	int numsuper=supervivientes.size();
	superviviente aux = null;
	String nombre,fin="";
	aleatorio();
	if(supervivientes.size()!=0&&supervivientes2.size()!=0&&EQUIPO==1) {
	accion="";
	aleatorio();
	if((numero>=1&&numero<=3)||(numero>=13&&numero<=25)&&!supervivientes2.get(Nmuerto2).getescudo()) {   // muerte del 1 al 3 y de 15 a 18
		accion="muerto";
		numsuper--;
		fin=supervivientes.get(Nsuperv).getNombre()+" "+ muertes.get(Nmuerte)+ " a "+supervivientes2.get(Nmuerto2).getNombre() +"\n";
		muertos2.add(supervivientes2.get(Nmuerto2).getNombre());
		supervivientes2.remove(Nmuerto2);
		supervivientes.get(Nsuperv).baja();
	}
	else if((numero>=1&&numero<=3)||(numero>=15&&numero<=25)&&supervivientes2.get(Nmuerto2).getescudo()) {   // dañar del 1 al 3
		accion="dañar";
		fin=supervivientes.get(Nsuperv).getNombre()+" le ha quitado el escudo a "+supervivientes2.get(Nmuerto2).getNombre() +"\n";
		supervivientes2.get(Nmuerto2).dañar();
	}
	else if((numero==4||numero==5)&& !muertos2.isEmpty()&&!r) {    // resucita el 4 y 5
		r=true;
		accion="resucitar";
		numsuper++;
		fin=muertos2.get(Nresucita2)+" "+resucita.get(NR)+"\n";
		String x=muertos2.get(Nresucita2);
		aux= new superviviente(x,1);
		supervivientes2.add(aux);
		muertos2.remove(Nresucita2);
	}
	else if((numero==6||numero==7)&&!supervivientes2.get(Nmuerto2).getescudo()) { // suicidio con el 6 y 7
		accion="muerto";
		numsuper--;                                                   
		fin=supervivientes2.get(Nmuerto2).getNombre()+" "+suicidio.get(Nsuicidio)+"\n";
		muertos2.add(supervivientes2.get(Nmuerto2).getNombre());
		supervivientes2.remove(Nmuerto2);
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
	else if((numero==11||numero==12)&&(Nsuperv!=Nmuerto)) {   // dia normal en pareja del 12 al 14
		accion="dianormal";
		fin=supervivientes.get(Nsuperv).getNombre()+" y "+supervivientes.get(Nmuerto).getNombre()+" "+ diaNG.get(NdiaNG) +"\n";
	}
	else if(numero==26||numero==27) {   // dia normal en pareja del 12 al 14
		accion="intercambio";
		fin=supervivientes.get(Nsuperv).getNombre()+" ha traicionado a su equipo \n";
		supervivientes2.add(supervivientes.get(Nsuperv));
		supervivientes.remove(Nsuperv);
		
	}
	else {
		accion="dianormal";
		fin="No ha ocurrido nada";
	}
	return fin;
	}
	
	
	if(supervivientes.size()!=0&&supervivientes2.size()!=0&&EQUIPO==2) {
		accion="";
		aleatorio();
		if((numero>=1&&numero<=3||numero>=13&&numero<=25)&&!supervivientes.get(Nmuerto).getescudo()) {   // muerte del 1 al 3 y de 15 a 18
			accion="muerto";
			numsuper--;
			fin=supervivientes2.get(Nsuperv2).getNombre()+" "+ muertes.get(Nmuerte)+ " a "+supervivientes.get(Nmuerto).getNombre() +"\n";
			muertos.add(supervivientes.get(Nmuerto).getNombre());
			supervivientes.remove(Nmuerto);
			supervivientes2.get(Nsuperv2).baja();
		}
		else if((numero>=1&&numero<=3)||(numero>=15&&numero<=25)&&supervivientes.get(Nmuerto).getescudo()) {   // dañar del 1 al 3
			accion="dañar";
			fin=supervivientes2.get(Nsuperv2).getNombre()+" le ha quitado el escudo a "+supervivientes.get(Nmuerto).getNombre() +"\n";
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
		else if((numero==6||numero==7)&&!supervivientes.get(Nmuerto).getescudo()) { // suicidio con el 6 y 7
			accion="muerto";
			numsuper--;                                                   
			fin=supervivientes.get(Nmuerto).getNombre()+" "+suicidio.get(Nsuicidio)+"\n";
			muertos.add(supervivientes.get(Nmuerto).getNombre());
			supervivientes.remove(Nmuerto);
		}

		else if(numero==8) {   // escudo del 8
			accion="escudo";
			fin=supervivientes2.get(Nsuperv2).getNombre()+" ha conseguido un escudo  " +"\n";
			supervivientes2.get(Nsuperv2).escudo();
		}
		else if((numero==9||numero==10)) {   // dia normal del 9 al 11
			accion="dianormal";
			fin=supervivientes2.get(Nsuperv2).getNombre()+" "+ diaN.get(NdiaN) +"\n";
		}
		else if((numero==11||numero==12)&&(Nsuperv2!=Nmuerto2)) {   // dia normal en pareja del 12 al 14
			accion="dianormal";
			fin=supervivientes2.get(Nsuperv2).getNombre()+" y "+supervivientes2.get(Nmuerto2).getNombre()+" "+ diaNG.get(NdiaNG) +"\n";
		}
		else if(numero==26||numero==27) {   // traicion en pareja del 26 al 27
			accion="intercambio";
			fin=supervivientes2.get(Nsuperv2).getNombre()+" "+traicion.get(traicionN);
			supervivientes.add(supervivientes2.get(Nsuperv2));
			supervivientes2.remove(Nsuperv2);
			
		}
		else {
			accion="dianormal";
			fin="No ha ocurrido nada";
		}
		return fin;
		
		}
	
	
	acabado=true;
	accion="ganar";
	if(supervivientes.isEmpty()) {
	fin=" HA GANADO EL EQUIPO 2" ;  
	}
	else {
		fin=" HA GANADO EL EQUIPO 1";  

	}
	return fin;
}
public String getSupervivientes() {
	String x="";
	for(int i=0;i<supervivientes.size();i++) {
		x=x+supervivientes.get(i).getNombre();
		x=x+"  ";
	}
	return x;
}

public String getSupervivientes2() {
	String x="";
	for(int i=0;i<supervivientes2.size();i++) {
		x=x+supervivientes2.get(i).getNombre();
		x=x+"  ";
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


