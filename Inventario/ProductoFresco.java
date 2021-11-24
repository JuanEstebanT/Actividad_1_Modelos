/*
 * CLASE: PRODUCTO FRESCO
 * FECHA: NOVIEMBRE 24 DE 2021
*/
package ejemplo1;

public class ProductoFresco extends Producto {
	// ATRIBUTOS
	private String fechaEnvasado;
	private String paisOrigen;

	// METODO CONSTRUCTOR POR DEFECTO
	ProductoFresco(String caducidad, double numeroLote, String fechaEnvasado, String paisOrigen) {
		super(caducidad, numeroLote);
		this.fechaEnvasado = fechaEnvasado;
		this.paisOrigen = paisOrigen;
	}

	// METODOS
	// METODO QUE IMPRIME LA INFORMACIÓN DEL PRODUCTO
	void mostrarProducto() {
		System.out.format("%-30s%-30s%-30s%-30s", getCaducidad(), getNumeroLote(), fechaEnvasado, paisOrigen);
	}

	// METODOS GETTERS Y SETTERS
	public String getFechaEnvasado() {
		return fechaEnvasado;
	}

	public void setFechaEnvasado(String fechaEnvasado) {
		this.fechaEnvasado = fechaEnvasado;
	}

	public String getPaisOrigen() {
		return paisOrigen;
	}

	public void setPaisOrigen(String paisOrigen) {
		this.paisOrigen = paisOrigen;
	}

}
