package nombresRepetidos;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Nombre implements Comparable<Nombre> {

	String nombre;
	int cantApariciones = 1;

	public Nombre() {

	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public int compareTo(Nombre n) {
		return this.cantApariciones - n.cantApariciones;
	}

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(new File("nombres.in"));
		String nombreAnterior = null;
		PrintWriter p = new PrintWriter(new File("nombres.out"));

		int i = 0;
		int cantNiños = sc.nextInt();
		int cantMaxima = sc.nextInt();
		
		Nombre nombre;

		ArrayList<String> list = new ArrayList<String>();
		ArrayList<Nombre> list2 = new ArrayList<Nombre>();

		for (i = 0; i < cantNiños; i++) 
			list.add( sc.next());
		
		i = 0;
		list.sort(null);

		for (String nombr : list) {

			if (nombr.equals(nombreAnterior)) {
				nombre = list2.get(i - 1);
				nombre.cantApariciones++;
				list2.set(i - 1, nombre);
			} 
			
			else {
				nombre = new Nombre();
				nombre.nombre = nombr;
				list2.add(nombre);
				i++;
				nombreAnterior = nombr;
			}

		}


		Collections.sort(list2, new Comparator<Nombre>() {
			public int compare(Nombre nombre1, Nombre nombre2) {

				return -nombre1.compareTo(nombre2);
			}
		});


		for (i = 0; i < cantMaxima; i++) {
			p.println(list2.get(i).nombre + " " + list2.get(i).cantApariciones);
		}

		sc.close();
		p.close();

	}

}
