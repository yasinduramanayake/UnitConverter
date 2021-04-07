package currencyconverter;

public class CurrencyCalculate implements CurencyService {

	@Override
	public double usdToaud(double curency) {
		double aud = curency * 1.31;
		return aud;
	}

	@Override
	public double usdTocad(double curency) {
		double cad = curency * 1.31;
		return cad;
	}

	@Override
	public double jpyTousd(double curency) {
		double usd = curency * 0.090;
		return usd;
	}

	@Override
	public double jpyTogbp(double curency) {
		double gbp = curency * 0.0065;
		return gbp;
	}

	@Override
	public double nzdTousd(double curency) {
		double usd = curency * 0.70;
		return usd;
	}

	@Override
	public double nzdToeuro(double curency) {
		double euro = curency * 0.60;
		return euro;
	}

}
