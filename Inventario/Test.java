/*
 * PROGRAMA: TEST
 * FECHA: NOVIEMBRE 24 DE 2021
*/
package ejemplo1;

import java.io.*;
import java.util.ArrayList;

public class Test {
	public static void main(String arg[]) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		// DECLARACI�N DE ARRAYLISTS
		ArrayList<ProductoFresco> reporteF = new ArrayList<ProductoFresco>();
		ArrayList<ProductoRefrigerado> reporteR = new ArrayList<ProductoRefrigerado>();
		ArrayList<ProductoCongelado> reporteC = new ArrayList<ProductoCongelado>();

		// DECLARACI�N DE VARIABLES
		boolean repetir = true;
		String fechaCaducidad = "";
		String numeroLote = "";
		String fechaEnvasado = "";
		String paisOrigen = "";
		int opcionTipo = 0;
		String codigo = "";
		double temperatura;
		int opcion = 0;
		int n = 1;

		// DECLARACI�N DE OBJETO
		Producto producto = new Producto();

		// MENSAJE DE BIENVENIDA
		System.out.println("Bienvenido a AGROALIMENTARIAS S.A.!");
		System.out.println("Relleno de inventario: \n");

		do {
			// INGRESO DE DATOS POR TECLADO
			System.out.println("Producto " + n);
			System.out.print("Ingrese la fecha de caducidad del producto (DD/MM/AAAA): ");
			fechaCaducidad = in.readLine();
			while (!producto.esFecha(fechaCaducidad)) {
				System.out.print("Por favor ingrese una fecha correcta: ");
				fechaCaducidad = in.readLine();
			}
			System.out.print("Ingrese el n�mero de lote del producto correspondiente: ");
			numeroLote = in.readLine();
			while (!producto.esNumeroValido(numeroLote)) {
				System.out.print("Por favor ingrese un n�mero de lote valido: ");
				numeroLote = in.readLine();
			}
			System.out.println(
					"\nNuestra empresa trabaja con 3 tipos distintos de productos referidos a Productos Frescos, Productos refrigerados y Productos Congelados");
			System.out.print("�Cual es su tipo de producto?  1-> Fresco  2-> Refrigerado  3-> Congelado: ");
			opcionTipo = Integer.parseInt(in.readLine());

			// EVALUACI�N DEL TIPO DE PRODUCTO
			switch (opcionTipo) {
			case 1:
				// INGRESO POR TECLADO DE DATOS ADICIONALES DEL TIPO DE PRODUCTO: FRESCO
				System.out.print("\nIngrese la fecha de envasado del producto: ");
				fechaEnvasado = in.readLine();
				while (!producto.esFecha(fechaEnvasado)) {
					System.out.print("Ingrese por favor una fecha v�lida: ");
					fechaEnvasado = in.readLine();
				}
				System.out.print("Ingrese el pa�s de Origen del producto: ");
				paisOrigen = in.readLine();

				// DECLARACION DE OBJETO
				ProductoFresco productoFresco = new ProductoFresco(fechaCaducidad, Double.parseDouble(numeroLote),
						fechaEnvasado, paisOrigen);

				// IMPRESION DE INFORMACI�N DEL PRODUCTO
				System.out.println("\nInformaci�n del producto ingresado:");
				System.out.format("%-30s%-30s%-30s%-30s", "Fecha de Caducidad", "Numero de Lote", "Fecha de envasado",
						"Pa�s de Origen");
				System.out.println("");
				productoFresco.mostrarProducto();

				// A�ADE INFORMACI�N DEL PRODUCTO AL INVENTARIO
				reporteF.add(productoFresco);
				break;
			case 2:
				// INGRESO POR TECLADO DE DATOS ADICIONALES DEL TIPO DE PRODUCTO: REFRIGERADO
				System.out.print(
						"Ingrese el c�digo del organismo de supervisi�n alimetaria correspondiente de su producto: ");
				codigo = in.readLine();
				while (!producto.esNumeroValido(codigo)) {
					System.out.println("Por favor ingrese un c�digo correcto");
					codigo = in.readLine();
				}

				// DECLARACION DE OBJETO
				ProductoRefrigerado productoRefrigerado = new ProductoRefrigerado(fechaCaducidad,
						Double.parseDouble(numeroLote), Double.parseDouble(codigo));

				// IMPRESION DE INFORMACI�N DEL PRODUCTO
				System.out.println("\nInformaci�n del producto ingresado:");
				System.out.format("%-30s%-30s%-30s", "Fecha de Caducidad", "Numero de Lote", "C�digo de Supervisi�n");
				System.out.println("");
				productoRefrigerado.mostrarProducto();

				// A�ADE INFORMACION DEL PRODUCTO AL INVENTARIO
				reporteR.add(productoRefrigerado);
				break;
			case 3:
				// INGRESO POR TECLADO DE DATOS ADICIONALES DEL TIPO DE PRODUCTO: CONGELADO
				System.out.print("Ingrese Temperatura en grados correspondiente del producto: ");
				temperatura = Double.parseDouble(in.readLine());

				// DECLARACI�N DE OBJETO
				ProductoCongelado productoCongelado = new ProductoCongelado(fechaCaducidad,
						Double.parseDouble(numeroLote), temperatura);

				// IMPRESION DE INFORMACI�N DEL PRODUCTO
				System.out.println("\nInformaci�n del producto ingresado:");
				System.out.format("%-30s%-30s%-30s", "Fecha de Caducidad", "Numero de Lote", "Temperatura �ptima");
				System.out.println("");
				productoCongelado.mostrarProducto();

				// A�ADE INFORMACI�N DEL PRODUCTO AL INVENTARIO
				reporteC.add(productoCongelado);
				break;
			default:
				System.out.println("Opci�n Invalida: ");
				break;
			}
			System.out.println("");

			// �INGRESAR NUEVO PRODUCTO?
			System.out.print("\n�Desea Ingresar otro producto?  1->SI  2->NO : ");
			opcion = Integer.parseInt(in.readLine());
			System.out.println("");
			while (opcion < 1 || opcion > 2) {
				System.out.print("\nIngrese una opci�n correcta: ");
				opcion = Integer.parseInt(in.readLine());
			}
			if (opcion == 1) {
				repetir = true;
				n++;
			} else if (opcion == 2) {
				repetir = false;
			}
		} while (repetir);

		// IMPRESION DEL INVENTARIO FINAL DE PRODUCTOS
		System.out.println("INVENTARIO TOTAL: ");
		System.out.format("%-30s%-30s%-30s%-30s%-30s%-30s%-30s", "Fecha de Caducidad", "N�mero de Lote",
				"Fecha Envasado", "Pa�s de Origen", "C�digo Supervisi�n", "Temperatura �ptima", "Tipo de Producto");
		System.out.println(
				"\n----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------\n");
		for (int i = 0; i < reporteF.size(); i++) {
			System.out.format("%-30s%-30s%-30s%-30s%-30s%-30s%-30s", reporteF.get(i).getCaducidad(),
					reporteF.get(i).getNumeroLote(), reporteF.get(i).getFechaEnvasado(),
					reporteF.get(i).getPaisOrigen(), "-", "-", "Fresco");
			System.out.println("\n");
		}

		for (int i = 0; i < reporteR.size(); i++) {
			System.out.format("%-30s%-30s%-30s%-30s%-30s%-30s%-30s", reporteR.get(i).getCaducidad(),
					reporteR.get(i).getNumeroLote(), "-", "-", reporteR.get(i).getCodigo(), "-", "Refrigerado");
			System.out.println("\n");
		}

		for (int i = 0; i < reporteC.size(); i++) {
			System.out.format("%-30s%-30s%-30s%-30s%-30s%-30s%-30s", reporteC.get(i).getCaducidad(),
					reporteC.get(i).getNumeroLote(), "-", "-", "-", reporteC.get(i).getTemperatura(), "Congelado");
			System.out.println("\n");
		}
	}
}
