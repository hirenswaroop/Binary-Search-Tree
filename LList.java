import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Handles linked list methods
 * @author uscart
 *
 * @param <E>
 */
public class LList<E> implements List<E> {
	public Node<E> head = null;
	public Node<E> tail = null;
	public int count = 0;

   private class Node<T extends E> {
       public T data;
       public Node<T> next;

       public Node(T data, Node<T> next) {
           this.data = data;
           this.next = next;
       }
   }

   @Override
   /**
    * returns the size of the list
    */
   public int size() {
       return count;
   }

   @Override
   /**
    * throws unsupported operation exception
    */
   public boolean isEmpty() {
       throw new UnsupportedOperationException("Invalid Operation");
   }

   @Override
   /**
    * checks if the linked list contains the node
    * @param o
    * @return boolean
    */
   public boolean contains(Object o) {
       Node<E> curr = head;
       while (curr.next != null) {
           if ( o == curr.data ) {
               return true;
           }
           curr = curr.next;
       }
       return false;
   }

   @Override
   /**
    * throws unsupported operation exception
    */
   public Iterator<E> iterator() {
	   throw new UnsupportedOperationException("Invalid Operation");
   }

   @Override
   /**
    * throws unsupported operation exception
    */
   public Object[] toArray() {
       throw new UnsupportedOperationException("Invalid Operation");
   }

   @Override
   /**
    * throws unsupported operation exception
    */
   public <T> T[] toArray(T[] a) {
       throw new UnsupportedOperationException("Invalid Operation");
   }

   @Override
   /**
    * adds a new linked list node
    */
   public boolean add(E data) {
       Node<E> e = new Node<E> (data, null);
       if (head == null) {
           tail = head =  e;
       }
       else {
    	   tail.next = e;
    	   	tail =  e;
       }
       count++;
       return true;
   }

   @Override
   /**
    * throws unsupported operation exception
    */
   public boolean remove(Object o) {
       throw new UnsupportedOperationException("Invalid Operation");
   }

   @Override
   /**
    * throws unsupported operation exception
    */
   public boolean containsAll(Collection<?> c) {
       throw new UnsupportedOperationException("Invalid Operation");
   }

   @Override
   /**
    * throws unsupported operation exception
    */
   public boolean addAll(Collection<? extends E> c) {
       throw new UnsupportedOperationException("Invalid Operation");
   }

   @Override
   /**
    * throws unsupported operation exception
    */
   public boolean addAll(int index, Collection<? extends E> c) {
       throw new UnsupportedOperationException("Invalid Operation");
   }

  
   @Override
   /**
    * clears the linked list
    */
   public void clear() {
       Node<E> temp = null;
       Node<E> curr = head;
       int cnt = 0;
       
       while (curr != null) {
           temp = curr;
           curr = curr.next;
           cnt++;
           remove(cnt);
       }
   }

   @Override
   /**
    * gets a linked list node
    */
   public E get(int index) {
       int cnt = 0;
       Node<E> curr = head;
       while (curr != null) {
           if (index == cnt) {
               return curr.data;
           }
           curr = curr.next;
           cnt++;
       }
       return null;
   }

   @Override
   /**
    * throws unsupported operation exception
    */
   public E set(int index, Object element) {
       throw new UnsupportedOperationException ("Invalid Operation");
   }

   @Override
   /**
    * throws unsupported operation exception
    */
   public void add(int index, Object element) {
       throw new UnsupportedOperationException("Invalid Operation");
   }

   @Override
   /**
    * removes a linked list node
    */
   public E remove(int index) {
       if (index < 0 || index >= size()) {
           throw new ArrayIndexOutOfBoundsException();
       }
       
       Node<E> curr = head;
       Node<E> temp = null;
       Node<E> prev = null;
       int cnt = 0;
       
       while (curr != null) {
    	   		if (index == cnt) {
    	   		// Object is the first element in the list
    	   			temp = head;
    	            if (cnt == 0) {
    	                if (head == curr) {
    	                    head = curr.next;
    	                    if (curr == tail) {
    	                        tail.next = curr.next;
    	                    }
    	                    curr = null;
    	                    return temp.data;
    	                }
    	            } else if (cnt == this.size() - 1) {
    	                // Object is last element in list
    	                if (tail == curr) {
    	                    prev.next = null;
    	                    return curr.data;
    	                }
    	            } else {
    	                // Object is not head or tail
    	                prev.next = curr.next;
    	                return curr.data;
    	            }
    	            prev = curr;
    	            curr = curr.next;
    	            cnt++;
    	   		}
       }
       return null;
   }


	@Override
	/**
	 * throws unsupported operation exception
	 */
	public List subList(int fromIndex, int toIndex) {
		throw new UnsupportedOperationException("Invalid Operation");
	}

	@Override
	/**
	 * throws unsupported operation exception
	 */
	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException("Invalid Operation");
	}
	
	@Override
	/**
	 * throws unsupported operation exception
	 */
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException("Invalid Operation");
	}
	
	@Override
	/**
	 * throws unsupported operation exception
	 */
	public int indexOf(Object o) {
		throw new UnsupportedOperationException("Invalid Operation");
	}
	
	@Override
	/**
	 * throws unsupported operation exception
	 */
	public int lastIndexOf(Object o) {
		throw new UnsupportedOperationException("Invalid Operation");
	}
	
	@Override
	/**
	 * throws unsupported operation exception
	 */
	public ListIterator<E> listIterator() {
		throw new UnsupportedOperationException("Invalid Operation");
	}
	
	@Override
	/**
	 * throws unsupported operation exception
	 */
	public ListIterator<E> listIterator(int index) {
		throw new UnsupportedOperationException("Invalid Operation");
	}
}
