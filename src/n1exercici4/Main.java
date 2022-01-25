package n1exercici4;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		//directori per llegir
		
		String rutaCarpeta;
					
		if(args.length==0) {
			//si no té argument mostro l'arrel del projecte
			rutaCarpeta=System.getProperty("user.dir");
			
		}else{
			//miro que l'argument que hem passat no acabi en .txt
			rutaCarpeta=args[0];
			String extensio = rutaCarpeta.substring(rutaCarpeta.length()-4, rutaCarpeta.length());
						
			//si es un directori o un altre tipus de fitxer ho gestiono a aquesta branca del if
			if(!extensio.equals(".txt")) {
				
				//pot no existir el directori que pasem
				try {
					File ruta = new File(rutaCarpeta);
					//per cridar el mètode per primera vegada el faig amb una cadena vuida
					String textFinal = llistaDirectori(ruta,"");
					//creo el fitxer i l'escric
					File fitxer = new File(rutaCarpeta+"/llistat.txt");
					fitxer.createNewFile();
					escriure(fitxer.getAbsolutePath(), textFinal);
					
				}catch(NullPointerException e) {
					System.out.println("No existeix el directori");
				}catch (IOException e) {
					e.printStackTrace();
				}	
				
			//si es un txt el llegim i mostrem per pantalla
			}else {
				File fitxer = new File(rutaCarpeta);
				llegirFitxer(fitxer);				
			}			
		}						
	}

	//metode que donat un directori llista el contingut, inclos el dels subdirectoris
	static String llistaDirectori (File ruta, String text){
	
		File[] fitxers = ruta.listFiles();
		Arrays.sort(fitxers);
		
		for (int i = 0; i<fitxers.length; i++) {
			
			//vaig concatenant els fitxers
			text += fitxers[i].getName();
			
			//necessito poder entrar a observar que es cada element
			File f = new File(fitxers[i].getAbsolutePath());
			if (f.isDirectory()) {
				//es subdirectori marco com D
				text += " D ";
				Date d = new Date(f.lastModified());
				text += (d+"\n");
											
				//crida recursiva a llistar el contingut del subdirectori, amb un nou text per concatenar després
				String textDirectori = "";
				text += llistaDirectori(f, textDirectori);
				
			}else {
				//es un fitxer, marco amb F
				text += " F ";
				Date d = new Date(f.lastModified());
				text += (d+"\n");
			}
			
			
		}
		return text;
		
	}
	
	//mètode per escriure el contingut d'un string en un fitxer donat
	static void escriure(String ruta_fitxer, String text) {
		
		try {
			FileWriter escritor = new FileWriter(ruta_fitxer);
			
			for(int i=0; i<text.length();i++) {
				escritor.write(text.charAt(i));
			}
			escritor.close();
			System.out.println("He creat el fitxer "+ruta_fitxer);
			
		}catch(IOException e) {
			System.out.println("No he pogut crear el fitxer de texte");
		}
	}
	
	//metode que llegeix un fitxer i el mostra per consola
	static void llegirFitxer(File ruta)  {
		
		try {
			FileReader fitxer = new FileReader(ruta);
			int c = 0;
			while (c!=-1) {
				c = fitxer.read();
				char lletra = (char) c;
				if (c!=-1) {
					System.out.print(lletra);
				}
				
			}
			fitxer.close();			
			
		} catch (IOException e) {
			System.out.println("No trobo el fitxer");
		}
		
	}
	
}



