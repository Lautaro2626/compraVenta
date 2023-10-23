package compraVenta;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Supermercado {
	private Set<Articulo> articulosDisponibles;
	private Set<Cliente> clientes;
	
	public Supermercado() {
		this.articulosDisponibles = new HashSet<>();
		this.clientes = new HashSet<>();
	}
	
	

    public Set<Articulo> sugerirArticulos(Cliente cliente) {
    	
    	Set<Articulo> sugerencias = filtrarPorPreferencias(cliente, this.articulosDisponibles);
        
        if (sugerencias.isEmpty()) {
            sugerencias = filtrarPorOtrasPreferencias(cliente, this.articulosDisponibles);
        }
       
        sugerencias = filtrarArticulosEnStock(sugerencias);

        sugerencias = filtrarArticulosQuePuedePagar(sugerencias, cliente);

        return sugerencias;
    }

    private Set<Articulo> filtrarPorPreferencias(Cliente cliente, Set<Articulo> articulosDisponibles) {
        return articulosDisponibles.stream()
                .filter(articulo -> articulo.getTipo() == cliente.getTipoPreferido())
                .collect(Collectors.toSet());
    }
    

    private Set<Articulo> filtrarPorOtrasPreferencias(Cliente cliente, Set<Articulo> articulosDisponibles) {
        return articulosDisponibles.stream()
                .filter(articulo -> articulo.getTipo() != cliente.getTipoPreferido())
                .collect(Collectors.toSet());
    }


    private Set<Articulo> filtrarArticulosEnStock(Set<Articulo> sugerencias) {
        return sugerencias.stream()
                .filter(articulo -> articulo.getCantidad() > 0)
                .collect(Collectors.toSet());
    }


    private Set<Articulo> filtrarArticulosQuePuedePagar(Set<Articulo> articulosDisponibles, Cliente cliente) {
        return articulosDisponibles.stream()
                .filter(articulo -> articulo.getValor() <= cliente.getPresupuesto())
                .collect(Collectors.toSet());
    }

	public void agregarCliente(Cliente cliente1) {
		this.clientes.add(cliente1);
		
	}


	public Set<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(Set<Cliente> clientes) {
		this.clientes = clientes;
	}



	public void agregarArticulo(Articulo art) {
		this.articulosDisponibles.add(art);
		
	}



	public Set<Articulo> getArticulosDisponibles() {
		return articulosDisponibles;
	}



	public void setArticulosDisponibles(Set<Articulo> articulosDisponibles) {
		this.articulosDisponibles = articulosDisponibles;
	}



	public Articulo buscarArticulo(Articulo articulo) throws ArticuloNoEncontradoException {
		for(Articulo articuloActual : articulosDisponibles) {
			
			if(articuloActual.equals(articulo)) {
				return articuloActual;
			}
		}
		throw new ArticuloNoEncontradoException("No existe el articulo buscado");
	}


}
