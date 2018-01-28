package Persistencia;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ficheros {
	
	public void BorrarFicheroSolucion() {
		try {
			File f = new File("SolucionesTerreno.txt");
			FileWriter fos = new FileWriter(f.getAbsolutePath());
			BufferedWriter bw = new BufferedWriter(fos);
			bw.write("");
			bw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<Integer> LecturaFicheroTerrenoPrefijado() {
		ArrayList<Integer> contenido = new ArrayList<Integer>();
		Scanner datos;
		try {
			File f = new File("DatosTerrenoPrefijado.txt");
			datos = new Scanner(new FileReader(f.getAbsolutePath()));
			while (datos.hasNext()) {
				int X = datos.nextInt();
				System.out.println("	Número de filas del terreno: "+X);
				contenido.add(X);
				int Y = datos.nextInt();
				System.out.println("	Número de columnas del terreno: "+Y);
				contenido.add(Y);
				int maximo = datos.nextInt();
				System.out.println("	Valor de tierra máximo en el terreno: "+maximo);
				contenido.add(maximo);
				int k = datos.nextInt();
				System.out.println("	Valor de tierra mínimo en el terreno: "+k);
				contenido.add(k);
				int v = X * Y * k;
				contenido.add(v);
				System.out.println("	Tierra total del terreno: "+v);
			}
		} catch (Exception e) {
		}
		
		return contenido;
	}
	
/**	public void EscrituraSolucionFichero(String Terreno[][], int filas, int columnas,int k ,int maximo) {
		try {
			File file = new File( "TerrenosFinales.txt");
			FileWriter fos = new FileWriter(file.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fos);
			bw.write("" + Tractor.getX());
			bw.write("" + Tractor.getY());
			bw.write("" + k);
			bw.write("" + maximo);
			bw.write("" + filas);
			bw.write("" + columnas);
			bw.newLine();
			for (int i = 0; i < Terreno.length; i++) {
				for (int j = 0; j < Terreno[i].length; j++) {
					bw.write(Terreno[i][j]);
				}
				bw.newLine();
			}
			bw.newLine();
			bw.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}**/

	
	

}
