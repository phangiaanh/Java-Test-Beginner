import java.io.*;

public class BO implements Serializable{
	protected int id;
	protected String name;
	
	public BO(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public BO() {
		this.id = 1710009;
		this.name = "Phan Gia Anh";
	}
	
	public void print() {
		System.out.println("Name: " + name + "\nID: " + id);
	}
}


	
