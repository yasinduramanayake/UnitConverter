package energyconverter;

public interface EnergyService {
	
	public double jouleToCalorie(double energy);
	public double jouleToKilojoule(double energy);
	
	public double calorieTojoule(double energy);
	public double calorieToKilojoule(double energy);
	
	public double kilojouleToCalorie(double energy);
	public double kilojouleToJoule(double energy);

}
