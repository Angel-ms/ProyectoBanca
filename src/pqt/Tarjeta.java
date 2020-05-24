package pqt;

/**
 * 
 * @author Ángel
 *
 */
public class Tarjeta {
	float limiteRetiradaCajero;
	float limitePagoInternet;
	int pagosRealizados;
	/**
	 * Constructor para una tarjeta "desactivada"
	 */
	Tarjeta(){
		limiteRetiradaCajero = 0;
		limitePagoInternet = 0;
		pagosRealizados = 0;
	}

	/**
	 * 
	 * @param limiteRetiradaCajero Cantidad máxima que se puede extraer en un cajero de una vez
	 * @param limitePagoInternet Cantidad máxima que se puede gasta en un pago por internet
	 */
	public Tarjeta(float limiteRetiradaCajero, float limitePagoInternet) {
		this.limiteRetiradaCajero = limiteRetiradaCajero;
		this.limitePagoInternet = limitePagoInternet;
		pagosRealizados = 0;
	}
	/**
	 * 
	 * @return limite actual de retirada en cajero en euros
	 */
	public float getLimiteRetiradaCajero() {
		return limiteRetiradaCajero;
	}
	/**
	 * 
	 * @param limiteRetiradaCajero nuevo limite de retirada en cajero en euros
	 */
	public void setLimiteRetiradaCajero(float limiteRetiradaCajero) {
		this.limiteRetiradaCajero = limiteRetiradaCajero;
	}

	/**
	 * 
	 * @return limite actual de pago por internet en euros
	 */
	public float getLimitePagoInternet() {
		return limitePagoInternet;
	}
	/**
	 * 
	 * @param limitePagoInternet nuevo limite de pago por internet en euros
	 */
	public void setLimitePagoInternet(float limitePagoInternet) {
		this.limitePagoInternet = limitePagoInternet;
	}

	/**
	 * 
	 * @param pagosRealizados nueva cantidad de pagos realizados
	 */
	public void setPagosRealizados(int pagosRealizados) {
		this.pagosRealizados = pagosRealizados;
	}
	/**
	 * 
	 * @return cantidad de pagos que se han realizado
	 */
	public int getPagosRealizados() {
		return pagosRealizados;
	}
	
}
