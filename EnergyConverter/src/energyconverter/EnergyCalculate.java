package energyconverter;

public class EnergyCalculate implements EnergyService{

	@Override
	public double jouleToCalorie(double energy) {
		double result = energy * 0.239;
		return result;
	}

	@Override
	public double jouleToKilojoule(double energy) {
		double result = energy / 1000;
		return result;
	}

	@Override
	public double calorieTojoule(double energy) {
		double result = energy * 4.184;
		return result;
	}

	@Override
	public double calorieToKilojoule(double energy) {
		double result = energy * 0.004184;
		return result;
	}

	@Override
	public double kilojouleToCalorie(double energy) {
		double result = energy * 0.239 * 1000;
		return result;
	}

	@Override
	public double kilojouleToJoule(double energy) {
		double result = energy * 1000;
		return result;
	}
	
	

}
