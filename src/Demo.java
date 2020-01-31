import java.io.*;
import java.util.*;


public class Demo implements Serializable{
	
	protected int id;
	protected String name;
	
	public static void main(String[] args) {
		
		BO dung = null;
		
		try {
			FileInputStream path = new FileInputStream("Demo.ser");
			ObjectInputStream obj = new ObjectInputStream(path);
			dung = (BO)obj.readObject();
		} catch (IOException i) {
			i.printStackTrace();
			return;
		} catch (ClassNotFoundException c) {
			System.out.println(">.<");
			c.printStackTrace();
			return;
		}
		
		System.out.println("Saved name: " + dung.name + "\nSaved ID: " + dung.id);
	}

}
