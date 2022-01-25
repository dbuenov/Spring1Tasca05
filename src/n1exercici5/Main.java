package n1exercici5;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//creo l'objecte que serialitzarè i deserialitzarè
		ArrayList<String> llista = new ArrayList<String>();
		llista.add("Pau");
		llista.add("Pepe");
		llista.add("Rosa");
			
		//creo el fitxer on serialitzarè l'objecte
		String ruta=System.getProperty("user.dir");
		File ser = new File(ruta+"/data.ser");
				
		try {
		
			//procès per serilalitzar
			
			ObjectOutputStream serialitzar = new ObjectOutputStream(new FileOutputStream(ser));
			serialitzar.writeObject(llista);
			serialitzar.close();
			
			//procès per deserialitzar
			ObjectInputStream deSerialitzar = new ObjectInputStream(new FileInputStream(ser));
			
			//creo l'array de destí
			ArrayList<String> llista_deserialitzada = (ArrayList<String>)deSerialitzar.readObject();
			deSerialitzar.close();
			
			//provo a imprimir per consola
			System.out.println(llista_deserialitzada.toString());
						
		} catch (Exception  e) {
			e.printStackTrace();
		}
	}
}
