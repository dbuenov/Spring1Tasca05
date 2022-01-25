package n2exercici1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;
import java.util.Properties;

public class Main {

	public static void main(String[] args) {
		
		//llegim el fitxer properties
		
		String directori;
		String nomFitxer;
		String directoriFitxer;
		
		Properties propietats = new Properties();
		FileInputStream dades;
		try {
			dades = new FileInputStream("./src/n2exercici1/arxiu.properties");
			propietats.load(dades);
			directori=propietats.getProperty("directori");
			nomFitxer=propietats.getProperty("nomFitxer");
			directoriFitxer=propietats.getProperty("directoriFitxer");
			dades.close();
			
			guardaFitxer(directori, nomFitxer, directoriFitxer);			
			
		} catch (FileNotFoundException e) {
			System.out.println("No trobo el fitxer de configuració");
		}catch (IOException e2) {
			System.out.println("No puc llegir el fitxer de configuració");
		}
						
	}
	
	//mètode que donat un directori, un fitxer i un directori desti, 
	//escriu el llistat del directori en aquest fitxer i ho guarda al directori de desti
	
	static void guardaFitxer(String directori, String nomFitxer, String directoriFitxer) {
		String rutaCarpeta;
		
		if(directori.equals("")) {
			//si no té argument mostro l'arrel del projecte
			rutaCarpeta=System.getProperty("user.dir");
			System.out.println("user.dir");
		}else {
			rutaCarpeta=directori;
		}
		
		//pot no existir el directori que pasem
		try {
			File ruta = new File(rutaCarpeta);
			
			
			//per cridar el mètode per primera vegada el faig amb una cadena vuida
			String textFinal = llistaDirectori(ruta,"");
			
			
			//creo el fitxer i l'escric respecte el que posa al fitxer de configuració
			File fitxer = new File(directoriFitxer,nomFitxer);
						
			fitxer.createNewFile();
			
			escriureFitxer(fitxer.getCanonicalPath(), textFinal);
		
			
		}catch(NullPointerException e) {
			System.out.println("No existeix el directori");
		}catch (IOException e) {
			e.printStackTrace();
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
	static void escriureFitxer(String ruta_fitxer, String text) {
		
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
	
}



