package compraVenta;
import java.util.*;
public class Cliente {
	private String nombre;
    private Double presupuesto;
    private TipoArticulo tipoPreferido;
    private List<Articulo> articulosComprados;

    public Cliente(String nombre, double presupuesto, TipoArticulo tipoPreferido) {
        this.nombre = nombre;
        this.presupuesto = presupuesto;
        this.tipoPreferido = tipoPreferido;
        this.articulosComprados = new ArrayList<>();
    }
    

	public Cliente() {
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getPresupuesto() {
		return presupuesto;
	}

	public void setPresupuesto(Double presupuesto) {
		this.presupuesto = presupuesto;
	}

	public TipoArticulo getTipoPreferido() {
		return tipoPreferido;
	}

	public void setTipoPreferido(TipoArticulo tipoPreferido) {
		this.tipoPreferido = tipoPreferido;
	}

	public void registrarCompra(Articulo articulo, Supermercado supermercado) throws ArticuloNoEncontradoException {
		Articulo articuloEncontrado = supermercado.buscarArticulo(articulo);
		articulosComprados.add(articuloEncontrado);
	}
	
	  
	public List<Articulo> getComprasRealizadas() {
		return articulosComprados;
	}

	public void setComprasRealizadas(List<Articulo> comprasRealizadas) {
		this.articulosComprados = comprasRealizadas;
	}
	

}
