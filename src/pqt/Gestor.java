package pqt;

import java.util.ArrayList;

public class Gestor {
	ArrayList <Cliente> clientes;
	
	Gestor(){
		clientes = new ArrayList<>();
	}
	
	public void darClienteDeAlta(String nombre, String apellidos, String nif, String direccion, int telefono, int edad){
		if (encontrarNIF(nif) == -1) {
			clientes.add(new Cliente(nombre, apellidos, nif, direccion, telefono, edad));
		} else {
			System.out.println("ERROR: Ya existe un cliente con ese NIF");
		}
	}
	
	public void abrirCuenta(String nifCliente, float saldo, float limite) {
		if(encontrarNIF(nifCliente)!=-1) {
			clientes.get(encontrarNIF(nifCliente)).cuentas.add(new Cuenta(saldo, limite));
		} else {
			System.out.println("ERROR: No existe ningun cliente con ese NIF");
		}
	}
	
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
	public void cambiarNombreCliente(String nifCliente, String nombre) {
		if(encontrarNIF(nifCliente)!=-1) {
			clientes.get(encontrarNIF(nifCliente)).setNombre(nombre);
		} else {
			System.out.println("ERROR: No existe ningun cliente con ese NIF");
		}
}
	public void cambiarApellidosCliente(String nifCliente, String apellidos) {
		if(encontrarNIF(nifCliente)!=-1) {
			clientes.get(encontrarNIF(nifCliente)).setApellidos(apellidos);
			
		} else {
			System.out.println("ERROR: No existe ningun cliente con ese NIF");
		}
}
	public void cambiarNIFCliente(String nifCliente, String nifNuevo) {
			if(encontrarNIF(nifCliente)!=-1) {
				clientes.get(encontrarNIF(nifCliente)).setNif(nifNuevo);
			
		} else {
			System.out.println("ERROR: No existe ningun cliente con ese NIF");
		}
}
	public void cambiarDireccionCliente(String nifCliente, String direccion) {
		if(encontrarNIF(nifCliente)!=-1) {
			clientes.get(encontrarNIF(nifCliente)).setDireccion(direccion);
		} else {
			System.out.println("ERROR: No existe ningun cliente con ese NIF");
		}
}
	public void cambiarTelefonoCliente(String nifCliente, int telefono) {
		if(encontrarNIF(nifCliente)!=-1) {
			clientes.get(encontrarNIF(nifCliente)).setTelefono(telefono);
		} else {
			System.out.println("ERROR: No existe ningun cliente con ese NIF");
		}
}
	public void cambiarEdadCliente(String nifCliente, int edad) {
		if(encontrarNIF(nifCliente)!=-1) {
			clientes.get(encontrarNIF(nifCliente)).setEdad(edad);
		} else {
			System.out.println("ERROR: No existe ningun cliente con ese NIF");
		}
}
	
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
