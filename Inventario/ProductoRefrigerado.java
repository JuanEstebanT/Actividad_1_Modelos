/*
 * CLASE: PRODUCTO REFRIGERADO
 * FECHA: NOVIEMBRE 24 DE 2021
*/
package ejemplo1;

public class ProductoRefrigerado extends Producto {
	// ATRIBUTOS
	private double codigo;

	// METODO CONSTRUCTOR CON PARÁMETROS
	ProductoRefrigerado(String caducidad, double numeroLote, double codigo) {
		super(caducidad, numeroLote);
		this.codigo = codigo;
	}

	// METODOS
	// METODO QUE IMPRIME LA INFORMACIÓN DEL PRODUCTO
	public void mostrarProducto() {
		System.out.format("%-30s%-30s%-30s", getCaducidad(), getNumeroLote(), codigo);
	}

	// METODOS GETTERS Y SETTERS
	public double getCodigo() {
		return codigo;
	}

	public void setCodigo(double codigo) {
		this.codigo = codigo;
	}

}
