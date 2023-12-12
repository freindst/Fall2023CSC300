package pack;

public class Node {
	public int Data;
	public Node leftNode;
	public Node rightNode;
	public Node parentNode;
	
	public Node(int Data) {
		this.Data = Data;
		this.leftNode = null;
		this.rightNode = null;
		this.parentNode = null;
	}
	
	public void Delete() {
		this.Data = 0;
		this.leftNode = null;
		this.rightNode = null;
		this.parentNode = null;
	}
}
