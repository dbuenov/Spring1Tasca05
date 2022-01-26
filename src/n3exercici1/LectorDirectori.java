package n3exercici1;

import java.io.File;
import java.sql.Date;
import java.util.Arrays;

public class LectorDirectori {

		public static String llistaDirectori (File ruta, String text){
		
			File[] fitxers = ruta.listFiles();
			Arrays.sort(fitxers);
			
			for (int i = 0; i<fitxers.length; i++) {
				text += fitxers[i].getName();
				File f = new File(fitxers[i].getAbsolutePath());
				if (f.isDirectory()) {
					text += " D ";
					Date d = new Date(f.lastModified());
					text += (d+"\n");
					String textDirectori = "";
					text += llistaDirectori(f, textDirectori);
				}else {
					text += " F ";
					Date d = new Date(f.lastModified());
					text += (d+"\n");
				}
			}
			return text;
		}
}
