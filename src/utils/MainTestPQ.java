package utils;

//
// import java.util.ListIterator;
// import java.util.List;
// import java.util.Arrays;
//
//



public class MainTestPQ{

    public static void main(String[] args){
	System.out.println("HEEELOOLLLOOOO");

	MinPriorityQueue array_minpq = new MinPriorityQueue();
	System.out.println(array_minpq.size());
	//minpq.add(3);
	// minpq.add(5);
	array_minpq.add(7);
	System.out.println("Add 7: ");
	array_minpq.showResult();
	System.out.println("array_pq size= "+array_minpq.size());
	System.out.println("\n");

	array_minpq.add(3);
	System.out.println("Add 3: ");
	array_minpq.showResult();
	System.out.println("array_pq size= "+array_minpq.size());
	System.out.println("\n");

	array_minpq.add(4);
	System.out.println("Add 4: ");
	array_minpq.showResult();
	System.out.println("array_pq size= "+array_minpq.size());
	System.out.println("\n");

	array_minpq.add(2);
	System.out.println("Add 2: ");
	array_minpq.showResult();
	System.out.println("array_pq size= "+array_minpq.size());
	System.out.println("\n");

	array_minpq.add(1);
	array_minpq.add(9);
	array_minpq.add(4);
	array_minpq.add(2);
	array_minpq.add(3);
	array_minpq.add(6);
	array_minpq.add(3);
	array_minpq.add(2);
	array_minpq.add(9);
	array_minpq.add(5);

	array_minpq.showResult();
	System.out.print("\nBefore Remove (size of minPQ): ");


	System.out.println(array_minpq.size());
	System.out.println(" ++++++++++++++++++++++++++++++++++++++++++++++++++++ \n");

	array_minpq.remove();
	System.out.println("Remove Element at First Node");
	array_minpq.showResult();
	System.out.println("array_pq size= "+array_minpq.size());
	System.out.println("\n");

	array_minpq.remove();
	System.out.println("Remove Element at First Node");
	array_minpq.showResult();
	System.out.println("array_pq size= "+array_minpq.size());
	System.out.println("\n");

	array_minpq.remove();
	array_minpq.showResult();
	System.out.println("array_pq size= "+array_minpq.size());
	System.out.println("\n");

	array_minpq.remove();
	array_minpq.showResult();
	System.out.println("array_pq size= "+array_minpq.size());
	System.out.println("\n");
	array_minpq.remove();
	array_minpq.remove();
	array_minpq.remove();
	array_minpq.remove();
	array_minpq.remove();
	array_minpq.remove();
	array_minpq.remove();
	array_minpq.remove();
	array_minpq.remove();
	array_minpq.remove();

	// minpq.remove();
	// minpq.remove();
	//
	//array_minpq.showResult();
	System.out.print("\nAfter Remove (size of minPQ): ");
	System.out.println(array_minpq.size());


    }
}
