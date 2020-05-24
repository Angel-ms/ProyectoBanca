package pqt;

/**
 * 
 * @author �ngel
 *
 */
public class Cuenta {
	float saldo;
	float limite;
	int fechaApertura;
	float[] historialSaldos;
	Tarjeta tarjetaAsociada;
	/**
	 * 
	 * @param saldo Saldo base con el que empezar� la cuenta
	 * @param limite Limite de gasto de la cuenta
	 */
	public Cuenta(float saldo, float limite) {
		super();
		this.saldo = saldo;
		this.limite = limite;
		fechaApertura = 1;
	}
	
	/**
	 * 
	 * @return saldo actual de la cuenta
	 */
	public float getSaldo() {
		return saldo;
	}
	/**
	 * 
	 * @param saldo nuevo saldo de la cuenta
	 */
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	/**
	 * 
	 * @return limite de gasto actual
	 */
	public float getLimite() {
		return limite;
	}
	/**
	 * 
	 * @param limite nuevo limite de gasto
	 */
	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	/**
	 * 
	 * @return tarjeta asociada a la cuenta
	 */
	public Tarjeta getTarjetaAsociada() {
		return tarjetaAsociada;
	}
	public void setTarjetaAsociada(Tarjeta tarjetaAsociada) {
		this.tarjetaAsociada = tarjetaAsociada;
	}
	
	/**
	 * 
	 * @return cantidad de d�as desde que se abri� la cuenta
	 */
	public int getFechaApertura() {
		return fechaApertura;
	}
	
	/**
	 * 
	 * @return array con los saldos al final de cada d�a
	 */
	public float[] getHistorialSaldos() {
		return historialSaldos;
	}
	
	
	
}
