package n1exercici5;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//creo l'objecte que serialitzar� i deserialitzar�
		ArrayList<String> llista = new ArrayList<String>();
		llista.add("Pau");
		llista.add("Pepe");
		llista.add("Rosa");
			
		//creo el fitxer on serialitzar� l'objecte
		String ruta=System.getProperty("user.dir");
		File ser = new File(ruta+"/data.ser");
				
		try {
		
			//proc�s per serilalitzar
			
			ObjectOutputStream serialitzar = new ObjectOutputStream(new FileOutputStream(ser));
			serialitzar.writeObject(llista);
			serialitzar.close();
			
			//proc�s per deserialitzar
			ObjectInputStream deSerialitzar = new ObjectInputStream(new FileInputStream(ser));
			
			//creo l'array de dest�
			ArrayList<String> llista_deserialitzada = (ArrayList<String>)deSerialitzar.readObject();
			deSerialitzar.close();
			
			//provo a imprimir per consola
			System.out.println(llista_deserialitzada.toString());
						
		} catch (Exception  e) {
			e.printStackTrace();
		}
	}
}
