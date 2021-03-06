package n1exercici3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
		//directori per llegir
		
		String rutaCarpeta;
		
		if(args.length==0) {
			//si no t? argument mostro l'arrel del projecte
			rutaCarpeta=System.getProperty("user.dir");
			System.out.println("user.dir");
		}else {
			rutaCarpeta=args[0];
		}
		
		//pot no existir el directori que pasem
		try {
			File ruta = new File(rutaCarpeta);
			//per cridar el m?tode per primera vegada el faig amb una cadena vuida
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
											
				//crida recursiva a llistar el contingut del subdirectori, amb un nou text per concatenar despr?s
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
	
	//m?tode per escriure el contingut d'un string en un fitxer donat
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
	
}



