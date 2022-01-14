package n1exercici2;

import java.io.File;
import java.sql.Date;

public class Main {

	public static void main(String[] args) {
		
		File ruta = new File("C:/Test");
		new LlistaDirectori(ruta);		
		
		
	}

}

//clase que donat un directori llista el contingut, inclos el dels subdirectoris
class LlistaDirectori{
	LlistaDirectori(File ruta){
		
		String[] archivos = ruta.list();
		
		for (int i = 0; i<archivos.length; i++) {
			
			//faig la impressió dels fitxers
			System.out.print(archivos[i]);
			
			//necessito poder entrar a observar que es cada element
			File f = new File(ruta.getAbsolutePath(), archivos[i]);
			if (f.isDirectory()) {
				//es subdirectori marco com D
				System.out.print(" D ");
				Date d = new Date(f.lastModified());
				System.out.println(d);
								
				//crida recursiva a llistar el contingut del subdirectori
				new LlistaDirectori(f);
				
			}else {
				//es un fitxer, marco amb F
				System.out.print(" F ");
				Date d = new Date(f.lastModified());
				System.out.println(d);
			}
			
			
		}
		
	}
}
