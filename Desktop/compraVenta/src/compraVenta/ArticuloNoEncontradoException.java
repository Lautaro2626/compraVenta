package compraVenta;

public class ArticuloNoEncontradoException extends Exception {

	private static final long serialVersionUID = -2148582536327310263L;

	public ArticuloNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
