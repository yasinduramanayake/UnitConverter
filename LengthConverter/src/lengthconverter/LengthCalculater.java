package lengthconverter;

public class LengthCalculater implements LengthService{

	@Override
	public double CentimetreToInch(double Length) {
		
		Double Inch = Length / 2.54;
		return Inch;
	}

	@Override
	public double CentimetreToMetre(double Length) 	{
	   
		Double Metre = Length / 100.00;
		return Metre;
	}


	@Override
	public double InchToCentimetre(double Length) {
		Double Centi = Length * 2.54;
		return Centi;
	}

	@Override
	public double InchToMetre(double Length) {
		Double Metre1 = Length * 0.0254;
		return Metre1;
	}

	@Override
	public double MetreToCentimetre(double Length) {
		Double cm = Length * 100;
		return cm;
	}

	@Override
	public double MetreToInch(double Length) {
		Double inch = Length * 39.3701;
		return inch;
	}



}