
public interface Consumer {//interface
	public String getName();

	public int getPower();

	public void morePower(int amount) throws NotAPowerGeneratorException;
}
