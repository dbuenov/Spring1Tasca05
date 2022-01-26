package n3exercici1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Main {

	public static void main(String[] args) {

		String directori="";
		String nomFitxer="";
		String directoriFitxer="";

		Properties propietats = new Properties();
		FileInputStream dades;
		try {
			dades = new FileInputStream("./src/n3exercici1/arxiu.properties");
			propietats.load(dades);
			directori=propietats.getProperty("directori");
			nomFitxer=propietats.getProperty("nomFitxer");
			directoriFitxer=propietats.getProperty("directoriFitxer");
			dades.close();
			
			File ruta = new File(directori);
			String textFinal = LectorDirectori.llistaDirectori(ruta,"");

			//encripto
			final String clauEncriptacio = "ElPassword";            
			EncriptatAES encriptador = new EncriptatAES();
			String textEncriptat = encriptador.encriptar(textFinal, clauEncriptacio);

			//creo el fitxer i l'escric
			File fitxer = new File(directoriFitxer+nomFitxer);
			fitxer.createNewFile();
			Fitxers.escriure(fitxer.getCanonicalPath(), textEncriptat);

			//desencripto
			String encriptatLectura = Fitxers.llegirFitxer(fitxer);
			String textDesencriptat = encriptador.desencriptar(encriptatLectura, clauEncriptacio);
			System.out.println(textDesencriptat);

		} catch (FileNotFoundException e) {
			System.out.println("No trobo el fitxer de configuració");
		}catch (IOException e2) {
			System.out.println("No puc llegir el fitxer de configuració");
		}catch (Exception e3) {
			System.out.println(e3);
		}	
	}
}



