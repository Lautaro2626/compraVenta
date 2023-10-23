package compraVentaTest;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;


import compraVenta.Articulo;
import compraVenta.Cliente;
import compraVenta.Supermercado;
import compraVenta.TipoArticulo;
import compraVenta.Compra;
import compraVenta.CreditosInsuficientesException;
import compraVenta.Registrocompras;


public class Testing{


	@Test
	public void queSePuedaAgregarUnClienteTest() {
		Cliente cliente1 = new Cliente();
		Supermercado supermercado = new Supermercado();
		supermercado.agregarCliente(cliente1);
		Integer valorEsperado = 1;
		Integer valorObtenido = supermercado.getClientes().size();
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void queSePuedaAgregarUnArticuloTest() {
		Articulo art = new Articulo();
		Supermercado supermercado = new Supermercado();
		supermercado.agregarArticulo(art);
		Integer valorEsperado = 1;
		Integer valorObtenido = supermercado.getArticulosDisponibles().size();
		assertEquals(valorEsperado,valorObtenido);
	}
	
	@Test
	public void queSePuedanSugerirCuatroArticulosAUnClienteTest() {
		Supermercado supermercado = new Supermercado();
		crearSetDeArticulos(supermercado);
		Cliente cliente1 = new Cliente("lautaro",1500,TipoArticulo.ANTIGUEDAD);
		supermercado.sugerirArticulos(cliente1);
		
		Integer valorEsperado = 4;
		Integer valorObtenido = supermercado.sugerirArticulos(cliente1).size();
		
		assertEquals(valorEsperado,valorObtenido);
		
	}
	
	@Test
	public void queNoSePuedanSugerirArticulosAUnClienteTest() {
		Supermercado supermercado = new Supermercado();
		crearSetDeArticulos(supermercado);
		Cliente cliente1 = new Cliente("lautaro",3,TipoArticulo.ANTIGUEDAD);
		supermercado.sugerirArticulos(cliente1);
		
		Integer valorEsperado = 0;
		Integer valorObtenido = supermercado.sugerirArticulos(cliente1).size();
		
		assertEquals(valorEsperado,valorObtenido);
		
	}
	
	@Test
	public void queSePuedaSugerirArticulosDeLujoAcordeAlPresupuestoTest() {
		Supermercado supermercado = new Supermercado();
		crearSetDeArticulos(supermercado);
		Cliente cliente1 = new Cliente("lautaro",100,TipoArticulo.DE_LUJO);
		supermercado.sugerirArticulos(cliente1);
		
		Integer valorEsperado = 1;
		Integer valorObtenido = supermercado.sugerirArticulos(cliente1).size();
		
		assertEquals(valorEsperado,valorObtenido);
		
	}

	@Test
	public void queSePuedaHacerUnaCompraTest() {
		
		Cliente cliente1 = new Cliente("lautaro",300,TipoArticulo.ANTIGUEDAD);
		Supermercado supermercado = new Supermercado();
		crearSetDeArticulos(supermercado);
		Articulo art1 = new Articulo("art1",30,"lala",330,TipoArticulo.ANTIGUEDAD);
		Articulo art2 = new Articulo("art2",30,"lala",302,TipoArticulo.DE_LUJO);
		Articulo art3 = new Articulo("art3",50,"lala",301,TipoArticulo.EXOTICO);
		
		ArrayList <Articulo> articulosComprados = new ArrayList();
		articulosComprados.add(art1);
		articulosComprados.add(art2);
		articulosComprados.add(art3);
		
		/*try {
			cliente1.registrarCompra(art1,supermercado);
		} catch (ArticuloNoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			cliente1.registrarCompra(art2,supermercado);
		} catch (ArticuloNoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}          
		try {
			cliente1.registrarCompra(art3,supermercado);
		} catch (ArticuloNoEncontradoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		Compra compra1 = new Compra(cliente1,articulosComprados);
		Registrocompras registroCompra = new Registrocompras();
		
		
		try {
			registroCompra.agregarCompra(compra1);
		} catch (CreditosInsuficientesException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Integer valorDeseado = 1;
		Integer valorObtenido = registroCompra.getCompras().size();
		
		assertEquals(valorDeseado,valorObtenido);
		
	}
	
	private void crearSetDeArticulos(Supermercado supermercado) {
		Articulo art1 = new Articulo("art1",30,"lala",330,TipoArticulo.ANTIGUEDAD);
		Articulo art2 = new Articulo("art2",30,"lala",302,TipoArticulo.DE_LUJO);
		Articulo art3 = new Articulo("art3",50,"lala",301,TipoArticulo.EXOTICO);
		Articulo art4 = new Articulo("art4",6,"lala",340,TipoArticulo.ANTIGUEDAD);
		Articulo art5 = new Articulo("art5",350,"lala",350,TipoArticulo.INVALUABLE);
		Articulo art6 = new Articulo("art6",300,"lala",306,TipoArticulo.DE_LUJO);
		Articulo art7 = new Articulo("art7",36,"lala",370,TipoArticulo.ANTIGUEDAD);
		Articulo art8 = new Articulo("art8",340,"lala",308,TipoArticulo.INVALUABLE);
		Articulo art9 = new Articulo("art9",564,"lala",309,TipoArticulo.ANTIGUEDAD);
		Articulo art10 = new Articulo("art10",3030,"lala",300,TipoArticulo.EXOTICO);
		
		supermercado.agregarArticulo(art1);
		supermercado.agregarArticulo(art2);
		supermercado.agregarArticulo(art3);
		supermercado.agregarArticulo(art4);
		supermercado.agregarArticulo(art5);
		supermercado.agregarArticulo(art6);
		supermercado.agregarArticulo(art7);
		supermercado.agregarArticulo(art8);
		supermercado.agregarArticulo(art9);
		supermercado.agregarArticulo(art10);
	}
}

