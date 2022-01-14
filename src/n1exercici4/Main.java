package n1exercici4;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		
		//directori per llegir
		File ruta = new File("C:/Test");
		String text ="";
		LlistaDirectori llistat = new LlistaDirectori(ruta,text);
		
		//creo el fitxer i l'escric
		File fitxer = new File("C:/Test/llistat.txt");
		
		try {
			fitxer.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
				
		llistat.escriure(fitxer.getAbsolutePath(), llistat.getText());
		
		//provo el nou mètode per veure per consola el contingut del fitxer de text
		llistat.llegirFitxer(fitxer.getAbsoluteFile());
				
	}

}



