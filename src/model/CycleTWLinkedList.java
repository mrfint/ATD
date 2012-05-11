
package model;

public class CycleTWLinkedList<T> implements ATD<T>{
    int length = 0;
    NodeTW first = null;

    @Override
    public void addToStart(T x) {
        NodeTW temp = new NodeTW(x);
        
        if( first == null ) {	 
            first = temp; 
            temp.setNext(temp);
            temp.setPrev(temp);
        }
        else{
            addNode(first.getPrev(), temp);
            first = temp;
        }
                
        length++;
    }

    @Override
    public void addToEnd(T x) {
        if (first == null){
                addToStart(x);
        }else{
                NodeTW temp = first.getPrev();
                NodeTW newNode = new NodeTW(x);
                addNode(temp, newNode);

                length++;
        }
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
                NodeTW prev = getNodeByPos(pos-1); 
                addNode(prev, new NodeTW(x));

                length++;
            }

        }
    }

    @Override
    public void delFromStart() {
        if(length==0) throw new ArrayIndexOutOfBoundsException();
        if (first.getPrev() == first) {
			clear();
		} else {
			first.getNext().setPrev(first.getPrev());
                        first.getPrev().setNext(first.getNext());
			first = first.getNext();

			length--;
		}
        
    }

    @Override
    public void delFromEnd() {
        if(length==0) throw new ArrayIndexOutOfBoundsException();
        if (first.getPrev() == first) {
                clear();
        } else {
                NodeTW prev = first.getPrev().getPrev();
                first.getPrev().setPrev(prev);
		prev.setNext(first);


                length--;
        }
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
                int count = 0;
                while (count < pos) {
                    fnd = fnd.getNext();
                    count++;
                }
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
        length = 0;
    }

    @Override
    public void set(int pos, T x) {
        getNodeByPos(pos).setValue(x);
    }

    @Override
    public T get(int pos) {
        return  (T) getNodeByPos(pos).getValue();
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
        if (a.length == 0){
                return;
        }
        clear();
        for (int i = 0; i < a.length; i++){
                addToEnd(a[i]);
        }
    }
    
    @Override
    public T[] toArray() {
        T[] res = (T[]) new Object[size()];
        int counter = 0;
        if(first!=null){
            NodeTW next = first;
            for (int i = 0; i < length; i++) {
                res[counter++] = (T) next.getValue();
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

    private void addNode(NodeTW prev, NodeTW next) {
        next.setPrev(prev);
        next.setNext(prev.getNext());
        prev.setNext(next);
        next.getNext().setPrev(next);
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
