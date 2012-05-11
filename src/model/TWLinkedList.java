
package model;



public class TWLinkedList<T> implements ATD<T>{
    int length = 0;
    NodeTW first = null;
    NodeTW last  = null;

    @Override
    public void addToStart(T x) {
        NodeTW temp = new NodeTW(x);
        temp.setNext(first);
        if( first != null ) {	 first.setPrev(temp);       }
        
        first = temp;
        if (last == null) {  	
            last = temp;  
        }
        
        length++;
    }

    @Override
    public void addToEnd(T x) {
        NodeTW temp = new NodeTW(x);
        temp.setPrev(last);
	if(last != null){       last.setNext(temp);          }
	last = temp;
		
        if (first == null) {	first = temp;                }
		
	length++;
    }

    @Override
    public void addToPos(int pos, T x) {
        check(pos);
        if(pos==0) addToStart(x);
        else{   
            if(pos==length){
                addToEnd(x);
            }
            else
            {
                NodeTW temp = new NodeTW(x);
                NodeTW fnd = first;
                
                fnd = getNodeByPos(pos);
                
                fnd.getPrev().setNext(temp);
                temp.setPrev(fnd.getPrev());
                fnd.getNext().setPrev(temp);
                temp.setNext(fnd);
                length++;
            }

        }
    }

    @Override
    public void delFromStart() {
        if(length==0) throw new ArrayIndexOutOfBoundsException();
        first = first.getNext();
        length--;
    }

    @Override
    public void delFromEnd() {
        if(length==0) throw new ArrayIndexOutOfBoundsException();
        last = last.getPrev();
        length--;
    }

    @Override
    public void del(int pos) {
        check(pos);
        NodeTW fnd = first;
        if(pos==0) delFromStart();
        else{   
            if(pos==length){
                delFromEnd();
            }
            else
            {
                fnd = getNodeByPos(pos);
                
                fnd.getPrev().setNext(fnd.getNext());
                fnd.getNext().setPrev(fnd.getPrev());
                length--;
            }
        }
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public void clear() {
        first = null;
        last  = null;
        length = 0;
    }

    @Override
    public void set(int pos, T x) {
        check(pos);
        getNodeByPos(pos).setValue(x);
    }

    @Override
    public T get(int pos) {
        check(pos);
        return (T) getNodeByPos(pos).getValue();
    }

    @Override
    public int find(T x) {
        if(length==0) throw new ArrayIndexOutOfBoundsException();
        NodeTW fnd = first;
        int res = -1;
        int count = 0;
        while (count < length) {
            if(fnd.getValue()==x) {     res = count;  break;    }
            fnd = fnd.getNext();
            count++;
        }
        return res;
    }

    @Override
    public void setArray(T[] a) {
        clear();
        NodeTW prevNode = new NodeTW(a[0]);
        length++;
        first = prevNode;
        
        for (int i = 1; i < a.length; i++){
                NodeTW newNode = new NodeTW(a[i]);
                length++;
                prevNode.setNext(newNode);
                newNode.setPrev(prevNode);
                prevNode = newNode;
        }
        last = prevNode;
    }
    @Override
    public T[] toArray() {
        T[] res = (T[]) new Object[size()];
        int counter = 0;
        if(first!=null){
            NodeTW next = first;
            for (int i = 0; i < length; i++) {
                res[counter++] = (T)next.getValue();
                next = next.getNext();
            }
        }
        return res;
    }
    
     public boolean equals(Object ob){
        boolean res = true;
        T[] o = (T[])ob;
        if(length!=o.length) return false;
        
        if(first==null)      return false;
       
        NodeTW next = first;
        for (int i = 0; i < length; i++) {
            if(next.getValue()!=o[i]) {
                res = false;
                break;
            }
            next = next.getNext();
        }
        
        return res;
    } 
     
     public String toString(){
        if(first==null) return "";
       
        NodeTW next = first;
        for (int i = 0; i < length; i++) {
            System.out.print(" "+next.getValue());
            next = next.getNext();
        }

        return "";
    }

    private void check(int pos) {
        if( (pos < 0) || (pos>=length) ) throw new ArrayIndexOutOfBoundsException();
    }
    
    private NodeTW getNodeByPos(int pos) {
        check(pos);
        NodeTW fnd = first;
        int count = 0;
        while (count < pos) {
            fnd = fnd.getNext();
            count++;
        }
        return fnd;
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
    class NodeTW<T>{
        private T value;
        
        private NodeTW<T> next;
        private NodeTW<T> prev;

    public NodeTW(T value) {
        this.value = value;
    }

    public NodeTW getNext() {
        return next;
    }

    public void setNext(NodeTW next) {
        this.next = next;
    }

    public NodeTW getPrev() {
        return prev;
    }

    public void setPrev(NodeTW prev) {
        this.prev = prev;
    }

    
    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    
        
  }