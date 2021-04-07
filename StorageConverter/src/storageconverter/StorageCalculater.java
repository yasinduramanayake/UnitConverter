package storageconverter;

public class StorageCalculater implements StorageService{

	@Override
	public double BitToByte(double Storage) {
		Double Byte = Storage * 0.125;
		return Byte;
	}

	@Override
	public double BitToKiloBytes(double Storage) {
		Double Kilo = Storage * 0.000125;
		return Kilo;
	}

	@Override
	public double BytesToBits(double Storage) {
		Double Bits = Storage * 8;
		return Bits;
	}

	@Override
	public double BytesToKiloBytes(double Storage) {
		Double Kilo = Storage * 0.001;
		return Kilo;
	}

	@Override
	public double KiloBytesToBits(double Storage) {
		Double Bits = Storage * 8000;
		return Bits;
	}

	@Override
	public double KiloBytesToBytes(double Storage) {
		Double Bytes = Storage * 1000;
		return Bytes;
	}

}