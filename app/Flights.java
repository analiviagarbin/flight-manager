package app;

public class Flights {
	
	protected String cityName;
	protected int cod;
	
	/**
	 * Construtor da classe
	 * @param city		Cidade de destino do voo
	 * @param cod		Código do voo
	 */
	public Flights(String city, int cod)
	{
		this.cityName = city;
		this.cod = cod;
	}
	
	/**
	 * Retorna o nome do destino
	 * @return			Nome do destino
	 */
	public String getCityName()
	{
		return this.cityName;
	}
	
	/**
	 * Retorna o código do voo
	 * @return			Código do voo
	 */
	public int getCod()
	{
		return this.cod;
	}
	
	/**
	 * Rotorna os dados da classe em formato de String
	 */
	public String toString()
	{
		return "(Cidade de destino: " + this.cityName
				+" Codigo do voo: " + this.cod + ")";
	}
	
	/**
	 * Verifica se um obj é igual a este objeto
	 * @param obj		Objeto a ser comparado com este objeto
	 */
	public boolean equals(Object obj)
	{
		if(this == obj)
			return true;
		if(obj == null)
			return false;
		if(!(obj instanceof Flights))
			return false;
		
		Flights flight = (Flights) obj;
		if(!(this.cityName.equals(flight.cityName)))
			return false;
		if(this.cod != flight.cod)
			return false;
		
		return true;
	}
	
	/**
	 * Calcula o hashcode da classe
	 */
	public int hashCode()
	{
		int ret = 3;
		
		ret = ret * 2 + new String(this.cityName)				.hashCode();
		ret = ret * 2 + Integer.valueOf(this.cod)				.hashCode();
		
		if(ret < 0)
			return ret * -1;
		
		return ret;
	}
	
	/**
	 * Retorna um clone desse objeto
	 */
	public Flights clone() {
		return this;
	}
	
}
