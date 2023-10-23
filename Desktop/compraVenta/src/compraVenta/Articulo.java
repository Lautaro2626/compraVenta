package compraVenta;

import java.util.Objects;

public class Articulo {

	private String nombre;
    private double valor;
    private String descripcion;
    private int cantidad;
    private TipoArticulo tipo;

    public Articulo(String nombre, double valor, String descripcion, int cantidad, TipoArticulo tipo) {
        this.nombre = nombre;
        this.valor = valor;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.tipo = tipo;
    }
    
    
    public Articulo() {
		super();
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public TipoArticulo getTipo() {
		return tipo;
	}

	public void setTipo(TipoArticulo tipo) {
		this.tipo = tipo;
	}


	@Override
	public int hashCode() {
		return Objects.hash(cantidad, descripcion, nombre, tipo, valor);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Articulo other = (Articulo) obj;
		return cantidad == other.cantidad && Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(nombre, other.nombre) && tipo == other.tipo
				&& Double.doubleToLongBits(valor) == Double.doubleToLongBits(other.valor);
	}
	
}
