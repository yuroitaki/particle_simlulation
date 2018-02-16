package utils;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Collections; // Add my own

public class List<T> implements Iterable<T>{

    public static class ListNode<U> {

        private U           content;
        private ListNode<U> next;
        public int index;

    }

    private ListNode<T> front;
    private ListNode<T> back;
    private int         size;

    public List() {
        size  = 0;
    }

    /**
     * Adds elem to the end of the list.
     * @param elem to be added.
     */
    public void add(T elem) {
        ListNode<T> n = new ListNode<T>();
        n.content = elem;
        n.index = size; //add my own
        if (size == 0) {
            front = n;
            back  = n;
        } else {
            back.next = n;
            back      = n;
        }
        size++;
    }
    // public T getFirstNodeValue(){
    //   return front.content;
    // }
    // public int getBackNodeIndex(){
    //   return back.index;
    // }
    // public int getFirstNodeIndex(){
    //   return front.index;
    // }
    // public T getContent(){
    //   return back.content;
    // }
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>(){

            private ListNode<T> next = front;

            @Override
            public boolean hasNext() {
                return next != null;
            }

            @Override
            public T next() {
                if (!hasNext()) { throw new NoSuchElementException(); }
                T elem = next.content;
                next = next.next;
                return elem;
            }

            // @Override
            // public int nextIndex(){
            //     if(!hasNext()){ throw new NoSuchElementException();}
            //     int index = next.index;
            //     next = next.next;
            //     return index;
            // }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }

        };
    }

    public int size() {
        return size;
    }

    // Our Own Fn :Swap Function in Linked List
    public void swapElement(T first_elem, T second_elem){
        // Collections.swap(heap,first_elem, second_elem);
        if(first_elem == second_elem) return;

        ListNode prevX = null;
        ListNode currX = front;

        while( currX != null && currX.content != first_elem){
            prevX = currX;
            currX = currX.next;
        }

        ListNode prevY = null;
        ListNode currY = front;

        while( currY != null && currY.content != second_elem){
            prevY = currY;
            currY = currY.next;
        }

        if(currX == null || currY == null) return;

        if(prevX != null){
            prevX.next = currY;
        }else{
            front = currY;
        }

        if(prevY != null){
            prevY.next = currX;
        }else{
            front = currX;
        }

        ListNode temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

}

