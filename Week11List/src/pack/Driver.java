package pack;

public class Driver {

	public static void main(String[] args) {
		MyDoublyLinkedList<Integer> list = new MyDoublyLinkedList<Integer>();
		list.Append(1);
		list.Append(2);
		System.out.println(list.Search(1).Data);
		

	}

}
