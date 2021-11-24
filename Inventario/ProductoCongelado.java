/*
 * CLASE: PRODUCTO CONGELADO
 * FECHA: NOVIEMBRE 24 DE 2021
*/
package ejemplo1;

public class ProductoCongelado extends Producto {
	// ATRIBUTOS
	private double temperatura;

	// METODO CONSTRUCTOR CON PARÁMETROS
	ProductoCongelado(String caducidad, double numeroLote, double temperatura) {
		super(caducidad, numeroLote);
		this.temperatura = temperatura;
	}

	// METODOS
	// METODO QUE MUESTRA LA INFORMACIÓN DEL PRODUCTO
	public void mostrarProducto() {
		System.out.format("%-30s%-30s%-30s", getCaducidad(), getNumeroLote(), temperatura);
	}

	// METODOS GETTERS Y SETTERS
	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

}
