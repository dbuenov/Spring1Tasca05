package n1exercici1;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		
		File ruta = new File("C:/Test");
		new LlistaDirectori(ruta);		
			
	}

}

//clase que donat un directori en llista el contingut
class LlistaDirectori{
	LlistaDirectori(File ruta){
		String[] nombres = ruta.list();
		
		for (String string : nombres) {
			System.out.println(string);
		}
	}
}
