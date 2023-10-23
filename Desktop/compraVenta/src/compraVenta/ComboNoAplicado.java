package compraVenta;

public class ComboNoAplicado extends Exception {
	
	private static final long serialVersionUID = 1L;
	private String mensaje;

	public ComboNoAplicado(String string) {
		super(string);
		this.mensaje = string;
	}

	public ComboNoAplicado() {}
	
	public void printStackTrace() {
		System.err.println(mensaje);
	}
}
