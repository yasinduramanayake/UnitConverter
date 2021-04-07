package massconverter;

import massconverter.MassService;

public class MassCalculate implements MassService{

	@Override
	public double kilogramToGram(double mass) {
		double result = mass * 1000 ;
		return result;
	}

	@Override
	public double kilogramToMilligram(double mass) {
		double result = mass * 1000000 ;
		return result;
	}

	@Override
	public double gramToMilligram(double mass) {
		double result = mass * 1000;
		return result;
	}

	@Override
	public double gramToKilogram(double mass) {
		double result = mass * 1000;
		return result;
	}

	@Override
	public double milligramToGram(double mass) {
		double result = mass / 1000;
		return result;
	}

	@Override
	public double milligramToKilogram(double mass) {
		double result = mass * (1 / 1000000);
		return result;
	}
	
}

