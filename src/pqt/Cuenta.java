package pqt;

public class Cuenta {
	float saldo;
	float limite;
	int fechaApertura;
	float[] historialSaldos;
	Tarjeta tarjetaAsociada;
	
	public Cuenta(float saldo, float limite) {
		super();
		this.saldo = saldo;
		this.limite = limite;
	}
	
	
	public float getSaldo() {
		return saldo;
	}
	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}
	
	
	public float getLimite() {
		return limite;
	}
	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	
	public Tarjeta getTarjetaAsociada() {
		return tarjetaAsociada;
	}
	public void setTarjetaAsociada(Tarjeta tarjetaAsociada) {
		this.tarjetaAsociada = tarjetaAsociada;
	}
	
	
	public int getFechaApertura() {
		return fechaApertura;
	}
	
	
	public float[] getHistorialSaldos() {
		return historialSaldos;
	}
	
	
	
}
