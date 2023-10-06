package major;

public class Salesman {
	//field, property
	public String name;
	public int total;
	
	//constructor
	public Salesman(String name, int total) {
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
	
	//sort function for salesman array
	//return an array of the same size of the input
	public static Salesman[] SortList(Salesman[] list) {
		Salesman[] newList = new Salesman[list.length];
		//copy everything from list to newList
		for(int i = 0; i < list.length; i++) {
			newList[i] = list[i];
		}
		//bubble sort
		for(int n = 0; n < list.length - 1; n++) {
			for(int m = 0; m < list.length - n - 1; m++) {
				if (newList[m + 1].total < newList[m].total) {
					Salesman temp = null;
					temp = newList[m + 1];
					newList[m + 1] = newList[m];
					newList[m] = temp;
				}
			}
		}
		return newList;
	}
	
	public String getString() {
		return this.name + ": $" + this.total;
	}
	
	//output
	public static void DisplayAllSalesman(Salesman[] list) {
		for(int i = 0; i < list.length; i++) {
			System.out.println(list[i].getString());
		}
	}
	
	public static Salesman[] GetTopFive(Salesman[] sorted) {
		Salesman[] returnValue = new Salesman[5];
		for(int i = 0; i < 5; i++) {
			returnValue[i] = sorted[sorted.length - i - 1];
		}
		return returnValue;
	}
}
