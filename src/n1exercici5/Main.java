package n1exercici5;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		//creo l'objecte que serialitzar� i deserialitzar�
		ArrayList<String> llista = new ArrayList<String>();
		llista.add("Dani");
		llista.add("Pepe");
		llista.add("Rosa");
						
		try {
			
			//proc�s per serilalitzar
			ObjectOutputStream serialitzar = new ObjectOutputStream(new FileOutputStream("C:/test/data.ser"));
			serialitzar.writeObject(llista);
			serialitzar.close();
			
			//proc�s per deserialitzar
			ObjectInputStream deSerialitzar = new ObjectInputStream(new FileInputStream("C:/test/data.ser"));
			
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
