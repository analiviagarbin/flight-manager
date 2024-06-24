package app;

public class Flights {
	
	protected String cityName;
	protected int cod;
	protected String departureTime;
	protected String arrivalTime;
	protected int passengerCount;


	/**
	 * Construtor da classe
	 * @param city		Cidade de destino do voo
	 * @param cod		Código do voo
	 * @param departureTime Horário de saída do voo
	 * @param arrivalTime Horário de chegada do voo
	 * @param passengerCount Quantidade de passageiros no voo
	 */
	public Flights(String city, int cod, String departureTime, String arrivalTime, int passengerCount)
	{
		this.cityName = city;
		this.cod = cod;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.passengerCount = passengerCount;
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

	// Getter for departureTime
	public String getDepartureTime() {
		return this.departureTime;
	}

	// Getter for arrivalTime
	public String getArrivalTime() {
		return this.arrivalTime;
	}

	// Getter for passengerCount
	public int getPassengerCount() {
		return this.passengerCount;
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
}
