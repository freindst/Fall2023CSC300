package Default;

public class Driver {
	static int a = 1;

	public static void main(String[] args) {
		System.out.println("hello");
		Driver d = new Driver();
		d.func1(5);
	}
	
	public void func1(int a) {
		this.func2(a);
	}
	
	public void func2(int r) {
		System.out.print(a);
	}
	
	//aabcccaa → a2b1c2a2
	//abcde -> a1b1c1d1e1
	public static String compress(String input) {
		String output = "";
		int counter = 0;
		boolean allUnique = true;
		for(int i = 0; i < input.length(); i++) {
			if (counter == 0) {
				counter = 1;
				output = output + input.charAt(i);
			} else {
				if (input.charAt(i) == input.charAt(i-1)) {
					counter++;
					allUnique = false;
				} else {
					output = output + counter;
					counter = 1;
				}
			}
		}
		output = output + counter;
		return allUnique ? input : output;
	}
	
	//not perfect solution
	public static String uncompress(String input) {
		String output = "";
		String number = "0123456789";
		String counter = "";
		for(int i = 0; i < input.length(); i = i + 2) {
			if (number.indexOf(input.charAt(i)) != -1) {//this is a character
				if (counter.length() != 0) {
					int count = Integer.parseInt(counter);
					for(int j = count - 1; j > 0; j--) {
						output += output.charAt(output.length() - 1);
					}
					counter = "";
				}
				output += input.charAt(i);
			} else {//a100: output = "a", counter = "100"
				counter += input.charAt(i);
			}
		}
		if (counter.length() != 0) {
			int count = Integer.parseInt(counter);
			for(int j = count - 1; j > 0; j--) {
				output += output.charAt(output.length() - 1);
			}
		}
		return output;
	}

}
