package compraVenta;

import java.util.List;

abstract public class Combo {

	protected Double costoTotal;

	public Combo(){

	}
	
	public abstract Double aplicarCombo(List<Articulo> articulos,Cliente cliente) throws ComboNoAplicado;
}
