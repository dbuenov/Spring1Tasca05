package n3exercici1;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Fitxers {

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

	static String llegirFitxer(File ruta)  {

		String sortida = "";
		try {
			FileReader fitxer = new FileReader(ruta);
			int c = 0;
			while (c!=-1) {
				c = fitxer.read();
				char lletra = (char) c;
				if (c!=-1) {
					sortida += lletra;
				}
			}
			fitxer.close();			

		} catch (IOException e) {
			System.out.println("No trobo el fitxer");
		}
		return sortida;

	}
}
