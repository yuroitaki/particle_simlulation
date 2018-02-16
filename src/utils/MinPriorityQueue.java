package utils;

import java.util.Collections;
import java.util.ArrayList;

public class MinPriorityQueue<T extends Comparable<T>> {

    ArrayList<T> minPQ_array;
    final int FIRST_INDEX = 0;
    /**
     * Creates an empty queue.
     */
    public MinPriorityQueue(){
      //     // TODO implement the constructor
        minPQ_array = new ArrayList<T>();
    }

    /**
     * Returns the number of elements currently in the queue.
     */
    public int size() {
        // TODO implement this method
        return minPQ_array.size();
    }

    /**
     * Adds elem to the queue.
     */
    public void add(T elem){
      // TODO implement this method

        int tracking_index = minPQ_array.size();
        minPQ_array.add(elem); // add element at the end of array

        // Loop until tracking index equal to first index
        // the first index holds the Event that MOST likely to happen first
        while(tracking_index > FIRST_INDEX){

            int parent_index = (tracking_index+1)/2 -1;

            T elem_parent = minPQ_array.get(parent_index);
            T elem_tracking = minPQ_array.get(tracking_index);

            // if element at the top node is already MOST likely to happen first,
            // we do not need to swap tracking element with
            if(elem_parent.compareTo(elem_tracking) < 0)
                break;

            // swap Element between parent_index and tracking_index
            Collections.swap(minPQ_array,parent_index,tracking_index);
            tracking_index = parent_index;
        }
    }

	  public void addList(Iterable<? extends T> objects){
		    for(T object: objects) {
		        add(object);
		    }
	  }

    // function to test MinPriorityQueue
    public  void showResult(){
        for(T elem : minPQ_array){
            System.out.print(elem+" ");
        }
    }

    /**
     * Removes, and returns, the element at the front of the queue.
     */
     public T remove() {
        // TODO implement this method

        if(size() == 0){
            System.out.println("Error: No Element to be removed");
        }

        // Get first element at the array and then swap with last element
        T top_node = minPQ_array.get(FIRST_INDEX);
        Collections.swap(minPQ_array,FIRST_INDEX,size()-1);
        // Remove element at the last index array (the element that we already swapped)
        minPQ_array.remove(size()-1);

        int tracking_index = FIRST_INDEX;

        // Loop until there are no elements to be removed
        // note: we don't need to loop whole array since parent node are half numbers of child node
        while(tracking_index < size()/2){

            int left_child_index = tracking_index*2 + 1;
            int right_child_index = left_child_index+1;


            if(right_child_index == size())
                 break;

            T left_child = minPQ_array.get(left_child_index);
            T right_child  = minPQ_array.get(right_child_index);
            T elem_tracking = minPQ_array.get(tracking_index);

          if(right_child.compareTo(left_child) < 0){

                if(elem_tracking.compareTo(right_child) < 0)
                    break;

                Collections.swap(minPQ_array, tracking_index, right_child_index);
                tracking_index = right_child_index;

            }else{

                if(elem_tracking.compareTo(left_child) < 0)
                    break;

                Collections.swap(minPQ_array,tracking_index,left_child_index);
                tracking_index = left_child_index;
            }
        }
        return top_node;
    }

    /**
     * Returns true if the queue is empty, false otherwise.
     */
    public boolean isEmpty() {
        // TODO implement this method
        return minPQ_array.isEmpty();
    }
}
