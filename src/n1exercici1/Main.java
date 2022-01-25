package n1exercici1;

import java.io.File;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		String rutaCarpeta;

		// miro l'argument del main
		if (args.length == 0) {
			rutaCarpeta = System.getProperty("user.dir");
		} else {
			rutaCarpeta = args[0];
		}

		// pot no existir el directori que pasem
		try {
			File ruta = new File(rutaCarpeta);
			llistaDirectori(ruta);
		} catch (NullPointerException e) {
			System.out.println("No existeix el directori");
		}

	}

	//metode que donat un directori ens llista el contingut alfabeticament

	static void llistaDirectori(File ruta) {

		File[] fitxers = ruta.listFiles();
		Arrays.sort(fitxers);

		for (File fitxer : fitxers) {
			System.out.println(fitxer.getName());
		}
	}
}
