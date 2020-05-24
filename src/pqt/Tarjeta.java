package pqt;

public class Tarjeta {
	float limiteRetiradaCajero;
	float limitePagoInternet;
	int pagosRealizados;
	
	Tarjeta(){
		limiteRetiradaCajero = 0;
		limitePagoInternet = 0;
		pagosRealizados = 0;
	}

	public Tarjeta(float limiteRetiradaCajero, float limitePagoInternet) {
		this.limiteRetiradaCajero = limiteRetiradaCajero;
		this.limitePagoInternet = limitePagoInternet;
		pagosRealizados = 0;
	}

	public float getLimiteRetiradaCajero() {
		return limiteRetiradaCajero;
	}
	public void setLimiteRetiradaCajero(float limiteRetiradaCajero) {
		this.limiteRetiradaCajero = limiteRetiradaCajero;
	}

	
	public float getLimitePagoInternet() {
		return limitePagoInternet;
	}
	public void setLimitePagoInternet(float limitePagoInternet) {
		this.limitePagoInternet = limitePagoInternet;
	}

	
	public void setPagosRealizados(int pagosRealizados) {
		this.pagosRealizados = pagosRealizados;
	}
	public int getPagosRealizados() {
		return pagosRealizados;
	}
	
}
