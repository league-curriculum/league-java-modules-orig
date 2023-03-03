package _99_extras.Serialization;



import static org.junit.Assert.assertEquals;

import java.io.*;

import org.junit.jupiter.api.Test;



/*
 * Serialization is the process of converting an object into a stream of bytes
 * to store the object or transmit it to memory, a database, or a file. With
 * serialization, we can save an object and all of its state to a file.
 *
 * In Java, serialization is done by implementing the Serializable interface. Any
 * class that implements the Serializable interface can be "saved", as long
 * as all of its member variables are also serializable.
 *
 * Challenge: Complete the MinecraftCreeper class so that the test passes 
 * by making it implement the Serializable interface.
 */
public class Serialization {
	private static final String DATA_FILE = "src/_05_Serialization/saved.dat";

	@Test
	public void test() {
		// Construct a MinecraftCreeper object and save it to a file
		save(new MinecraftCreeper("Bonnie", 100, 250, 0));

		// Load the MinecraftCreeper object from the file
		MinecraftCreeper creeper = load();

		assertEquals("Bonnie", creeper.name);
		assertEquals(100, creeper.xPosition);
		assertEquals(250, creeper.yPosition);
		assertEquals(0, creeper.zPosition);
	}

	/*
	 * One simple way to save a serializable object to a file is using a FileOutputStream
	 * and ObjectOutputStream.
	 */
	private static void save(MinecraftCreeper data) {
		try (FileOutputStream fos = new FileOutputStream(new File(DATA_FILE)); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static MinecraftCreeper load() {
		try (FileInputStream fis = new FileInputStream(new File(DATA_FILE)); ObjectInputStream ois = new ObjectInputStream(fis)) {
			return (MinecraftCreeper) ois.readObject();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} catch (ClassNotFoundException e) {
			// This can occur if the object we read from the file is not
			// an instance of any recognized class
			e.printStackTrace();
			return null;
		}
	}
}
