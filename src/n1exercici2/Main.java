package n1exercici2;

import java.io.File;
import java.sql.Date;
import java.util.Arrays;


public class Main {

	public static void main(String[] args) {

		String rutaCarpeta;

		//miro l'argument del main
		if(args.length == 0) {
			//si no té argument mostro l'arrel del projecte
			rutaCarpeta=System.getProperty("user.dir");
		}else {
			rutaCarpeta=args[0];
		}

		//pot no existir el directori que pasem
		try {
			File ruta = new File(rutaCarpeta);
			llistaDirectori(ruta);	
		}catch(NullPointerException e) {
			System.out.println("No existeix el directori");
		}		

	}

	//metode que donat un directori llista el contingut, inclos el dels subdirectoris
	static void llistaDirectori(File ruta){

		File[] fitxers = ruta.listFiles();
		Arrays.sort(fitxers);

		for (int i = 0; i<fitxers.length; i++) {

			//faig la impressió dels fitxers continguts en aquesta carpeta
			System.out.print(fitxers[i].getName());

			//necessito poder entrar a observar que es cada element

			File f = new File(fitxers[i].getAbsolutePath());
			if (f.isDirectory()) {
				//es subdirectori marco com D
				System.out.print(" D ");
				Date d = new Date(f.lastModified());
				System.out.println(d);

				//crida recursiva a llistar el contingut del subdirectori
				llistaDirectori(f);

			}else {
				//es un fitxer, marco amb F
				System.out.print(" F ");
				Date d = new Date(f.lastModified());
				System.out.println(d);
			}

		}

	}
	
}
