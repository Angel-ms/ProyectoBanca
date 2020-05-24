package pqt;

import java.util.ArrayList;

/**
 * 
 * @author Ángel
 *
 */
public class Cliente {
	String nombre;
	String apellidos;
	String nif;
	String direccion;
	int telefono;
	int edad;
	ArrayList<Cuenta> cuentas;
	/**
	 * 
	 * @param nombre	Nombre del titular de la cuenta
	 * @param apellidos	Apellidos del titular de la cuenta
	 * @param nif		Nif del titular de la cuenta
	 * @param direccion	Direccion del titular de la cuenta
	 * @param telefono	Telefono del titular de la cuenta
	 * @param edad		Edad del titular de la cuenta
	 */
	public Cliente(String nombre, String apellidos, String nif, String direccion, int telefono, int edad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nif = nif;
		this.direccion = direccion;
		this.telefono = telefono;
		this.edad = edad;
	}
	/**
	 * 
	 * @return nombre actual del titular de la cuenta
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * 
	 * @param nombre nuevo nombre del titular de la cuenta
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * 
	 * @return apellidos actuales del titular de la cuenta
	 */
	public String getApellidos() {
		return apellidos;
	}
	/**
	 * 
	 * @param apellidos nuevos apellidos del titular de la cuenta 
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * 
	 * @return NIF del titular de la cuenta
	 */
	public String getNif() {
		return nif;
	}
	/**
	 * 
	 * @param nif nuevo nif del titular de la cuenta
	 */
	public void setNif(String nif) {
		this.nif = nif;
	}

	/**
	 * 
	 * @return direccion actual del titular de la cuenta
	 */
	public String getDireccion() {
		return direccion;
	}
	/**
	 * 
	 * @param direccion nueva direccion del titular de la cuenta
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * 
	 * @return telefono actual del titular de la cuenta
	 */
	public int getTelefono() {
		return telefono;
	}
	/**
	 * 
	 * @param telefono nuevo telefono del titular de la cuenta
	 */
	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	/**
	 * 
	 * @return edad actual del titular de la cuenta
	 */
	public int getEdad() {
		return edad;
	}
	/**
	 * 
	 * @param edad nueva edad del titular de la cuenta
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	/**
	 * 
	 * @param cantidad cantidad a ingresar en euros
	 * @param cuenta indice de la cuenta del cliente en la que se quiere hacer el ingreso
	 */
	public void ingresar(float cantidad, int cuenta) {
		cuentas.get(cuenta).saldo += cantidad;
	}
	
	/**
	 * 
	 * @param cantidad cantidad a comprobar en euros
	 * @param cuenta indice de la cuenta del cliente en la que se quiere hacer la comprobacion
	 * @return True si hay suficiente saldo y false en el resto de los casos
	 */
	public boolean haySuficienteSaldo (float cantidad, int cuenta) {
		return (cuentas.get(cuenta).saldo >= cantidad);
	}
	/**
	 * 
	 * @param cantidad cantidad a retirar en euros
	 * @param cuenta indice de la cuenta del cliente de la que se quiere retirar el importe
	 */
	public void retirar(float cantidad, int cuenta) {
		if(haySuficienteSaldo(cantidad,cuenta)) {
			cuentas.get(cuenta).saldo -= cantidad;
		} else {
			System.out.println("ERROR: No hay suficientes fondos");
		}
	}
	
	/**
	 * 
	 * @param cantidad cantidad que se quiere pagar por internet
	 * @param cuenta indice de la cuenta del cliente de la que se quiere retirar el importe
	 */
	public void pagarInternet(float cantidad, int cuenta) {
		if (cuentas.get(cuenta).tarjetaAsociada != null) {	
			if(cantidad <= cuentas.get(cuenta).getTarjetaAsociada().getLimitePagoInternet()) {
				retirar(cantidad,cuenta);
				cuentas.get(cuenta).tarjetaAsociada.setPagosRealizados(cuentas.get(cuenta).getTarjetaAsociada().getPagosRealizados()+1);
			} else {
				System.out.println("ERROR: El coste es superior al limite establecido para pagos por internet");
			}
		} else {
			System.out.println("ERROR: No hay ninguna tarjeta asociada a esta cuenta");
		}
		
	}
	
	/**
	 * 
	 * @param cantidad cantidad que se quiere retirar en metalico
	 * @param cuenta indice de la cuenta del cliente de la que se quiere retirar el importe
	 */
	public void retirarMetalico(float cantidad, int cuenta) {
		if (cuentas.get(cuenta).tarjetaAsociada != null) {	
			if(cantidad <= cuentas.get(cuenta).getTarjetaAsociada().getLimiteRetiradaCajero()) {
				retirar(cantidad,cuenta);
				cuentas.get(cuenta).tarjetaAsociada.setPagosRealizados(cuentas.get(cuenta).getTarjetaAsociada().getPagosRealizados()+1);
			} else {
				System.out.println("ERROR: El coste es superior al limite establecido para retirar en metálico");
			}
		} else {
			System.out.println("ERROR: No hay ninguna tarjeta asociada a esta cuenta");
		}
		
	}
	
}
