package compraVenta;
import java.util.List;

public class ComboAxBCustom {
    private String articulo1;
    private String articulo2;
    private Articulo articulo3;
    
    
    public ComboAxBCustom(String articulo1, String articulo2, Articulo articulo3) {
		super();
		this.articulo1 = articulo1;
		this.articulo2 = articulo2;
		this.articulo3 = articulo3;
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
    		articulos.add(articulo3);
    	}
    	
    	throw new ComboNoAplicado("no se puede aplicar el combo");
    	
    }
}
