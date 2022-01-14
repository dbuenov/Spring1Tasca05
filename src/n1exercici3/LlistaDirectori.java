package n1exercici3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;

//clase que donat un directori crea el text del contingut, inclos el dels subdirectoris

public class LlistaDirectori {
	
	
		
		private String text;
		
		LlistaDirectori(File ruta, String text){
			
			this.text=text;
			
			String[] archivos = ruta.list();
			
			for (int i = 0; i<archivos.length; i++) {
				
				//vaig concatenant els fitxers
				text += archivos[i];
				
				//necessito poder entrar a observar que es cada element
				File f = new File(ruta.getAbsolutePath(), archivos[i]);
				if (f.isDirectory()) {
					//es subdirectori marco com D
					text += " D ";
					Date d = new Date(f.lastModified());
					text += (d+"\n");
												
					//crida recursiva a llistar el contingut del subdirectori, amb un nou text per concatenar després
					String textDirectori = "";
					LlistaDirectori llistat = new LlistaDirectori(f, textDirectori);
					text += llistat.getText();
					
					
				}else {
					//es un fitxer, marco amb F
					text += " F ";
					Date d = new Date(f.lastModified());
					text += (d+"\n");
				}
				
				
			}
			this.text+=text;
			
		}
		
		//mètode per escriure el contingut d'un string en un fitxer donat
		public void escriure(String ruta_fitxer, String text) {
			
			try {
				FileWriter escritor = new FileWriter(ruta_fitxer);
				
				for(int i=0; i<text.length();i++) {
					escritor.write(text.charAt(i));
				}
				escritor.close();
				
			}catch(IOException e) {}
		}
		
		public String getText() {
			return this.text;
		}
}
