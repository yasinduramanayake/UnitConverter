package tempconverter;

public class TempCalculate implements TempService{

	@Override
	public double celsiusToFahrenheit(double temp) {
		double result = (temp * 1.8) + 32;
		return result;
	}

	@Override
	public double celsiusToKelvin(double temp) {
		double result = temp + 273.15;
		return result;
	}

	@Override
	public double fahrenheitToCelsius(double temp) {
		double result = (temp - 32) / 1.8 ;
		return result;
	}

	@Override
	public double fahrenheitToKelvin(double temp) {
		double result = (temp - 32) / 1.8 + 273.15;
		return result;
	}

	@Override
	public double kelvinToCelsius(double temp) {
		double result = temp - 273.15;
		return result;
	}

	@Override
	public double kelvinToFahrenheit(double temp) {
		double result = (temp - 273.15) * 1.8 + 32;
		return result;
	}
	
}
