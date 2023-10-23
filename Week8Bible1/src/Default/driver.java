package Default;

public class driver {

	public static void main(String[] args) {
		long total = 7700000000l;
		long current = 13;
		int year = 0;
		while(current < total) {
			year += 3;
			current = current + current * 3;
		}
		System.out.println("It took " + year + " years to convert all human-beings to Christian.");

	}

}
