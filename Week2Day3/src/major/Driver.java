package major;

public class Driver {

	public static void main(String[] args) {//program entry
		Salesman[] sales = new Salesman[8];
		sales[0] = new Salesman("Blade", 0);
		sales[1] = new Salesman("Kate", 1000);
		sales[2] = new Salesman("John", 500);
		sales[3] = new Salesman("Jon", 300);
		sales[4] = new Salesman("Steven", 600);
		sales[5] = new Salesman("Homer", 800);
		sales[6] = new Salesman("Matt", 700);
		sales[7] = new Salesman("Peter", 200);
		Salesman[] topFive = Salesman.GetTopFive(Salesman.SortList(sales));
		System.out.println("Give me top 5 salesman list:");
		Salesman.DisplayAllSalesman(topFive);
	}

}
