package compraVenta;

public class CreditosInsuficientesException extends Exception {
   
	private static final long serialVersionUID = -2148582536327310263L;

	public CreditosInsuficientesException(String mensaje) {
        super(mensaje);
    }
}