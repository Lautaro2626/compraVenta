package compraVenta;
import java.util.*;
public class Registrocompras {

	private List<Compra> compras;

    public Registrocompras() {
        this.compras = new ArrayList<>();
    }

    public void agregarCompra(Compra compra) throws CreditosInsuficientesException {

        double costoTotal = calcularCostoTotal(compra.getArticulosComprados());
        if (compra.getCliente().getPresupuesto() < costoTotal) {
            throw new CreditosInsuficientesException("Créditos insuficientes para realizar la compra.");
        }

        Double nuevoPresupuesto = compra.getCliente().getPresupuesto() - costoTotal;
        compra.getCliente().setPresupuesto(nuevoPresupuesto);
        compra.getCliente().setComprasRealizadas(compra.getArticulosComprados());

        compras.add(compra);
    }

    private double calcularCostoTotal(List<Articulo> ArticulosComprados) {
        double costoTotal = 0;
        for (Articulo articulo : ArticulosComprados) {
            costoTotal += articulo.getValor();
        }
        return costoTotal;
    }

	public List<Compra> getCompras() {
		return compras;
	}
    
}
