package timeconverter;

public interface TimeService {
	
	public double hourToMinute(double time);
	public double hourToSecond(double time);
	
	public double minuteToSecond(double time);
	public double minuteToHour(double time);
	
	public double secondToMinute(double time);
	public double secondToHour(double time);

}


