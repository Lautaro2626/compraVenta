package compraVenta;

import java.util.List;

public class ComboAbsoluto extends Combo {
    private Double descuentoAbsoluto;
    private String articulo1;
    private String articulo2;
    
    
    public ComboAbsoluto(Double descuentoAbsoluto, String articulo1, String articulo2) {
		super();
		this.descuentoAbsoluto = descuentoAbsoluto;
		this.articulo1 = articulo1;
		this.articulo2 = articulo2;
	}

	public String getArticulo1() {
		return articulo1;
	}

	public void setArticulo1(String articulo1) {
		this.articulo1 = articulo1;
	}

	public String getArticulo2() {
		return articulo2;
	}

	public void setArticulo2(String articulo2) {
		this.articulo2 = articulo2;
	}


	public Double aplicarCombo(List<Articulo> articulos,Cliente cliente) throws ComboNoAplicado{
        
        Boolean art1 = Boolean.FALSE;
        Boolean art2 = Boolean.FALSE;
        
        for(Articulo articulo : articulos) {
        	if(articulo.getNombre().equals(articulo1)) {
               art1 = Boolean.TRUE;
               break;
        	}
        }
        
    	for(Articulo articulo : articulos) {
    		if(articulo.getNombre().equals(articulo2)) {
    			art2 = Boolean.TRUE;
        		break;
        	}
        }

    	if(art1 && art2) {
    		return super.costoTotal = descuentoAbsoluto;
    	}
    	
    	throw new ComboNoAplicado("no se puede aplicar el combo");
    	
    }

}