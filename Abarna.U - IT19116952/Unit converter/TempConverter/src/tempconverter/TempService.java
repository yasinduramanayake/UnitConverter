package tempconverter;

public interface TempService {
	
	public double celsiusToFahrenheit(double temp);
	public double celsiusToKelvin(double temp);
	
	public double fahrenheitToCelsius(double temp);
	public double fahrenheitToKelvin(double temp);
	
	public double kelvinToCelsius(double temp);
	public double kelvinToFahrenheit(double temp);

}
