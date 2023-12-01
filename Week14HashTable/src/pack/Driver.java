package pack;

public class Driver {

	public static void main(String[] args) {
		HashTable_Chaining hash = new HashTable_Chaining(10);
		hash.HashInsert(10, 10);
		hash.HashInsert(20, 20);
		hash.HashInsert(11, 11);
		hash.HashInsert(22, 22);
		System.out.println(hash);

	}

}
