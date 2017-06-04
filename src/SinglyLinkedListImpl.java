public class SinglyLinkedListImpl<T> {
 
    private Node<T> head;
    private Node<T> tail;
     
    /*  Append an element into the linkedlist */
    public void add(T element) {
    	
    		if (element == null) throw new RuntimeException("Can not add null");
         
        Node<T> nd = new Node<T>();
        nd.setValue(element);

        if (head == null) {
            head = nd;
            tail = nd;
        } else {
            tail.setNext(nd);  //set current tail next link to new node
            tail = nd;             //set tail as newly created node
        }
    }
   
    /* Remove the tail element from a linkedlist */
    public void removeTail(){
        
		Node<T> current = head;
		Node<T> prev = null;

		while (true) {
			if (current == null) {
				tail = prev;
				break;
			}
			//System.out.println("Current - " + current);
			if (current.getNext() == null) {
				tail = prev;
				if (prev != null)
					prev.setNext(null);
			} else {
				prev = current;
			}
			current = current.getNext();
		}
    }
     
    /*  Remove all elements in the linkedlist that are greater than a target value */                         
	public void deleteCustom(int input) {

		Node<T> current = head;
		Node<T> prev = null;

		while (true) {
			if (current == null) {
				tail = prev;
				break;
			}
			if ((int) current.getValue() > input) {
				
				if (prev == null) {
					head = current.getNext();
				} else {
					prev.setNext(current.getNext());
				}
			} else {
				prev = current;
			}
			current = current.getNext();
		}
	}

    public void traverse(){
    		System.out.println("Begin traversing..."  );
        Node<T> current = head;
        while(true){
            if(current == null){
                break;
            }
            System.out.println(current.getValue());
            current = current.getNext();
        }
    }
    
    public static void main(String[] args) {
        SinglyLinkedListImpl<Integer> sl = new SinglyLinkedListImpl<Integer>();
        //sl.add(null);
        sl.add(6);
        sl.add(2);
        sl.add(2);
        sl.add(6);
        sl.add(4);
        sl.add(5);
        sl.deleteCustom(3);
        sl.removeTail();
        sl.traverse();
	}
    
    private class Node<T>  {
    	
		private T value;
        private Node<T> next;
         
        public T getValue() {
            return value;
        }
        public void setValue(T value) {
            this.value = value;
        }
        public Node<T> getNext() {
            return next;
        }
        public void setNext(Node<T> next) {
            this.next = next;
        }
        
        @Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((next == null) ? 0 : next.hashCode());
			result = prime * result + ((value == null) ? 0 : value.hashCode());
			return result;
		}
        
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (next == null) {
				if (other.next != null)
					return false;
			} else if (!next.equals(other.next))
				return false;
			if (value == null) {
				if (other.value != null)
					return false;
			} else if (!value.equals(other.value))
				return false;
			return true;
		}
		
		@Override
		public String toString() {
			return "Node [value=" + value + ", next=" + next + "]";
		}        

		private SinglyLinkedListImpl getOuterType() {
			return SinglyLinkedListImpl.this;
		}
    }
}
 

