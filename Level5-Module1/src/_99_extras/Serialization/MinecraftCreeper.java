package _99_extras.Serialization;

/*
 * Complete this class so that it can be serialized.
 */
public class MinecraftCreeper {
	public String name;
	public int xPosition;
	public int yPosition;
	public int zPosition;
	public double health;

	public MinecraftCreeper(String name, int x, int y, int z) {
		this.name = name;
		this.xPosition = x;
		this.yPosition = y;
		this.zPosition = z;
		this.health = 100.0;
	}
}
