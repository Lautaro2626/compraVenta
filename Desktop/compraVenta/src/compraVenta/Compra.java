package compraVenta;
import java.util.*;
public class Compra {

	private Cliente cliente;
    private List<Articulo> articulosComprados;
    private Double montoTotal;

    
    public Compra(Cliente cliente, ArrayList<Articulo> articulosComprados) {
		super();
		this.cliente = cliente;
		this.articulosComprados = articulosComprados;
		this.montoTotal = 0.0;
	}

	public Double getMontoTotal() {
		return montoTotal;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Articulo> getArticulosComprados() {
		return articulosComprados;
	}

	public void setArticulosComprados(List<Articulo> articulosComprados) {
		this.articulosComprados = articulosComprados;
	}

	
}
