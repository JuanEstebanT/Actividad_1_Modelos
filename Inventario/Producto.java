/*
 * CLASE: PRODUCTO
 * FECHA: NOVIEMBRE 24 DE 2021
*/
package ejemplo1;

public class Producto {
	// ATRIBUTOS
	private String caducidad;
	private double numeroLote;

	// METODO CONSTRUCTOR POR DEFECTO
	Producto() {

	}

	// METODO CONSTRUCTOR CON PARÁMETROS
	Producto(String caducidad, double numeroLote) {
		this.caducidad = caducidad;
		this.numeroLote = numeroLote;
	}

	// METODOS
	// METODO QUE EVALUA QUE LA FECHA SEA CORRECTA
	public boolean esFecha(String caducidad) {
		boolean valido = caducidad.matches(
				"^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$");
		if (valido) {
			valido = true;
		} else {
			valido = false;
		}
		return valido;
	}

	// METODO QUE EVALUA SI UN NÚMERO ES VÁLIDO
	public boolean esNumeroValido(String numeroLote) {
		boolean valido = numeroLote.matches("^[0-9]+?$");
		if (valido) {
			this.numeroLote = Double.parseDouble(numeroLote);
			if (this.numeroLote >= 0) {
				valido = true;
			} else {
				valido = false;
			}
		}
		return valido;
	}

	// METODOS GETTERS
	public String getCaducidad() {
		return caducidad;
	}

	public double getNumeroLote() {
		return numeroLote;
	}

}
