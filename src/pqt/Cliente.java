package pqt;

import java.util.ArrayList;

public class Cliente {
	String nombre;
	String apellidos;
	String nif;
	String direccion;
	int telefono;
	int edad;
	ArrayList<Cuenta> cuentas;
	
	public Cliente(String nombre, String apellidos, String nif, String direccion, int telefono, int edad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nif = nif;
		this.direccion = direccion;
		this.telefono = telefono;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}

	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	public int getTelefono() {
		return telefono;
	}
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	

	public void ingresar(float cantidad, int cuenta) {
		cuentas.get(cuenta).saldo += cantidad;
	}
	

	public boolean haySuficienteSaldo (float cantidad, int cuenta) {
		return (cuentas.get(cuenta).saldo >= cantidad);
	}
	
	public void retirar(float cantidad, int cuenta) {
		if(haySuficienteSaldo(cantidad,cuenta)) {
			cuentas.get(cuenta).saldo -= cantidad;
		} else {
			System.out.println("ERROR: No hay suficientes fondos");
		}
	}
	
	public void pagarInternet(float cantidad, int cuenta) {
		if (cuentas.get(cuenta).tarjetaAsociada != null) {	
			if(cantidad <= cuentas.get(cuenta).tarjetaAsociada.getLimitePagoInternet()) {
				retirar(cantidad,cuenta);
				cuentas.get(cuenta).tarjetaAsociada.setPagosRealizados(cuentas.get(cuenta).tarjetaAsociada.getPagosRealizados()+1);
			} else {
				System.out.println("ERROR: El coste es superior al limite establecido para pagos por internet");
			}
		} else {
			System.out.println("ERROR: No hay ninguna tarjeta asociada a esta cuenta");
		}
		
	}
	
	public void retirarMetalico(float cantidad, int cuenta) {
		if (cuentas.get(cuenta).tarjetaAsociada != null) {	
			if(cantidad <= cuentas.get(cuenta).tarjetaAsociada.getLimiteRetiradaCajero()) {
				retirar(cantidad,cuenta);
				cuentas.get(cuenta).tarjetaAsociada.setPagosRealizados(cuentas.get(cuenta).tarjetaAsociada.getPagosRealizados()+1);
			} else {
				System.out.println("ERROR: El coste es superior al limite establecido para retirar en metálico");
			}
		} else {
			System.out.println("ERROR: No hay ninguna tarjeta asociada a esta cuenta");
		}
		
	}
	
}
