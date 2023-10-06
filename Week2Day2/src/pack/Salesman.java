package pack;

public class Salesman {
	//property or field
	public String name;
	public float total;
	
	//constructor: generate new instance of a class
	//Salesman man = new Salesman();oat? 0
	public Salesman() {
		
	}
	
	public Salesman(String name, float total) {
		this.name = name;
		this.total = total;
		
	}

	//getter
	public String getName() {
		return this.name;
	}
	
	//setter
	public void setName(String name) {
		this.name = name;
	}
	
	public String display() {
		return this.name + ": " + this.total;
	}
}
