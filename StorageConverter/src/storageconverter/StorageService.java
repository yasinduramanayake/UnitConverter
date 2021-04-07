package storageconverter;

public interface StorageService {
	
	public double BitToByte(double Storage);
	public double BitToKiloBytes(double Storage);
	
	public double BytesToBits(double Storage);
	public double BytesToKiloBytes(double Storage);
	
	public double KiloBytesToBits(double Storage);
	public double KiloBytesToBytes(double Storage);


}
