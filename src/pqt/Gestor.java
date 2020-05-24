package pqt;

import java.util.ArrayList;

public class Gestor {
	ArrayList <Cliente> clientes;
	
	Gestor(){
		clientes = new ArrayList<>();
	}
	/**
	 * 
	 * @param nombre	Nombre del titular de la cuenta
	 * @param apellidos	Apellidos del titular de la cuenta
	 * @param nif		Nif del titular de la cuenta (se comprobara para asegurar su unicidad)
	 * @param direccion	Direccion del titular de la cuenta
	 * @param telefono	Telefono del titular de la cuenta
	 * @param edad		Edad del titular de la cuenta
	 */
	public void darClienteDeAlta(String nombre, String apellidos, String nif, String direccion, int telefono, int edad){
		if (encontrarNIF(nif) == -1) {
			clientes.add(new Cliente(nombre, apellidos, nif, direccion, telefono, edad));
		} else {
			System.out.println("ERROR: Ya existe un cliente con ese NIF");
		}
	}
	/**
	 * 
	 * @param nifCliente Nif del cliente al que se le va a abrir la cuenta
	 * @param saldo Saldo base con el que empezará la cuenta
	 * @param limite Limite de gasto de la cuenta
	 */
	public void abrirCuenta(String nifCliente, float saldo, float limite) {
		if(encontrarNIF(nifCliente)!=-1) {
			clientes.get(encontrarNIF(nifCliente)).cuentas.add(new Cuenta(saldo, limite));
		} else {
			System.out.println("ERROR: No existe ningun cliente con ese NIF");
		}
	}
	
	/**
	 * 
	 * @param nifCliente Nif del cliente al que se le va a abrir la cuenta
	 * @param indiceCuenta Indice de la cuenta del cliente de la que se quiere consultar el saldo
	 */
	public void consultarSaldoMedio(String nifCliente, int indiceCuenta) {
		if(encontrarNIF(nifCliente)!=-1) {
			float acumuladorSaldo = 0;
			for(int i = 0; i <clientes.get(encontrarNIF(nifCliente)).cuentas.get(indiceCuenta).getFechaApertura(); i++) {
				acumuladorSaldo += (clientes.get(encontrarNIF(nifCliente)).cuentas.get(indiceCuenta).getHistorialSaldos()[i]);
			}
			if(clientes.get(encontrarNIF(nifCliente)).cuentas.get(indiceCuenta).getFechaApertura()<365){
				System.out.println("El saldo medio de los ultimos " + clientes.get(encontrarNIF(nifCliente)).cuentas.get(indiceCuenta).getFechaApertura() + "días es " + (acumuladorSaldo/clientes.get(encontrarNIF(nifCliente)).cuentas.get(indiceCuenta).getFechaApertura()));
			} else { 
				System.out.println("El saldo medio del ultimo año es " + acumuladorSaldo/365);
			}
		} else {
			System.out.println("ERROR: No existe ningun cliente con ese NIF");
		}
	}
	/**
	 * 
	 * @param nifCliente Nif del cliente del que se quiere ver la cantidad de pagos
	 * @param indiceCuenta Indice de la cuenta del cliente a la que está asignada la tarjeta que se quiere consultar
	 */
	public void consultarPagosRealizado(String nifCliente, int indiceCuenta) {
		if(encontrarNIF(nifCliente)!=-1) {
			if(clientes.get(encontrarNIF(nifCliente)).cuentas.get(indiceCuenta).getTarjetaAsociada() != null) {
				System.out.println("Se han realizado " + clientes.get(encontrarNIF(nifCliente)).cuentas.get(indiceCuenta).getTarjetaAsociada().getPagosRealizados() +" pagos con esta tarjeta");
			} else {
				System.out.println("ERROR: No hay ninguna tarjeta asociada a esta cuenta");
			}
		} else {
			System.out.println("ERROR: No existe ningun cliente con ese NIF");
		}
	}
	/**
	 * 
	 * @param nifCliente Nif del cliente al que se quiere cambiar 
	 * @param nombre Nuevo nombre
	 */
	public void cambiarNombreCliente(String nifCliente, String nombre) {
		if(encontrarNIF(nifCliente)!=-1) {
			clientes.get(encontrarNIF(nifCliente)).setNombre(nombre);
		} else {
			System.out.println("ERROR: No existe ningun cliente con ese NIF");
		}
}
	/**
	 * 
	 * @param nifCliente Nif del cliente al que se quiere cambiar
	 * @param apellidos Nuevos apellidos
	 */
	public void cambiarApellidosCliente(String nifCliente, String apellidos) {
		if(encontrarNIF(nifCliente)!=-1) {
			clientes.get(encontrarNIF(nifCliente)).setApellidos(apellidos);
			
		} else {
			System.out.println("ERROR: No existe ningun cliente con ese NIF");
		}
}
	/**
	 * 
	 * @param nifCliente Nif del cliente al que se quiere cambiar
	 * @param nifNuevo Nuevo nif
	 */
	public void cambiarNIFCliente(String nifCliente, String nifNuevo) {
			if(encontrarNIF(nifCliente)!=-1) {
				clientes.get(encontrarNIF(nifCliente)).setNif(nifNuevo);
			
		} else {
			System.out.println("ERROR: No existe ningun cliente con ese NIF");
		}
}
	/**
	 * 
	 * @param nifCliente Nif del cliente al que se quiere cambiar
	 * @param direccion Nueva direccion
	 */
	public void cambiarDireccionCliente(String nifCliente, String direccion) {
		if(encontrarNIF(nifCliente)!=-1) {
			clientes.get(encontrarNIF(nifCliente)).setDireccion(direccion);
		} else {
			System.out.println("ERROR: No existe ningun cliente con ese NIF");
		}
}
	/**
	 * 
	 * @param nifCliente Nif del cliente al que se quiere cambiar
	 * @param telefono Nuevo telefono
	 */
	public void cambiarTelefonoCliente(String nifCliente, int telefono) {
		if(encontrarNIF(nifCliente)!=-1) {
			clientes.get(encontrarNIF(nifCliente)).setTelefono(telefono);
		} else {
			System.out.println("ERROR: No existe ningun cliente con ese NIF");
		}
}
	/**
	 * 
	 * @param nifCliente Nif del cliente al que se quiere cambiar
	 * @param edad Nueva edad
	 */
	public void cambiarEdadCliente(String nifCliente, int edad) {
		if(encontrarNIF(nifCliente)!=-1) {
			clientes.get(encontrarNIF(nifCliente)).setEdad(edad);
		} else {
			System.out.println("ERROR: No existe ningun cliente con ese NIF");
		}
}
	/**
	 * 
	 * @param nif Nif que se quiere consultar contra la lista de clientes
	 * @return Indice que ocupa el cliente cuyo nif se ha consultado, si no existe devuelve -1
	 */
	public int encontrarNIF (String nif) {
		int indice = -1;
		for (int i = 0; i< clientes.size(); i++) {
			if (clientes.get(i).nif.equalsIgnoreCase(nif)) {
				indice = i;
			}
		}
		return indice;
	}
	
}
