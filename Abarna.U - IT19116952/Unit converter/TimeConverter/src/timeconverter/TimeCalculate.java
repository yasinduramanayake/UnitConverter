package timeconverter;

import timeconverter.TimeService;


public class TimeCalculate implements TimeService {
	
	@Override
	public double hourToMinute(double time) {
		double result = time * 60 ;
		return result;
	}

	@Override
	public double hourToSecond(double time) {
		double result = time * 3600 ;
		return result;
	}

	@Override
	public double minuteToSecond(double time) {
		double result = time * 60;
		return result;
	}

	@Override
	public double minuteToHour(double time) {
		double result = time / 60;
		return result;
	}

	@Override
	public double secondToMinute(double time) {
		double result = time / 60;
		return result;
	}

	@Override
	public double secondToHour(double time) {
		double result = time / 36000;
		return result;
	}

}
