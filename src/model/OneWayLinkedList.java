
package model;

import java.util.Iterator;


public class OneWayLinkedList<T> implements 
                                        ATD<T>, Iterable<T>{
    private Node root = null;
    private int length = 0;
    
    @Override
    public void addToStart(T x) {
        Node newnd  = new Node(x);
        newnd.setNext(root);
        root = newnd;

        length++;
    }

    @Override
    public void addToEnd(T x) {
        Node newnd = new Node(x);
        if (root==null) {
                root = newnd;        
        }
        else {
                Node next = root;

                while (next.getNext() != null) {
                        next = next.getNext();
                }
                next.setNext(newnd);
        }
        
        length++;
    }

    @Override
    public void addToPos(int pos, T x) {
        Node newnd = new Node(x);
        if (pos == 0){
                newnd.setNext(root);
                root = newnd;
        }
        else{
                Node prev = getNodeByPos(pos-1); 
                newnd.setNext(prev.getNext());
                prev.setNext(newnd);
        }

        length++;
    }

    @Override
    public void delFromStart() {
        if ( root == null){   throw new ArrayIndexOutOfBoundsException();      }
        root = root.getNext();
        length--;
    }

    @Override
    public void delFromEnd() {
        if ( root == null){   throw new ArrayIndexOutOfBoundsException();      }
        
        if (root.getNext() == null)         {              root = null;        } 
        else {
                Node prev = getNodeByPos(length-1);
                prev.setNext(null);
        }
        length--;
    }

    @Override
    public void del(int pos) {
        
        if   (pos == 0){       delFromStart(); }
        else if(pos == length) delFromEnd();
             else{
                  Node prev = getNodeByPos(pos-1); 
                  prev.setNext(prev.getNext().getNext());
             }

        length--;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public void clear() {
        root = null;
        length = 0;
    }

    @Override
    public void set(int pos, T x) {
        check(pos);
        getNodeByPos(pos).setData(x);
    }

    @Override
    public T get(int pos) {
        check(pos);
        return (T)getNodeByPos(pos).getData();
    }

    @Override
    public int find(T x) {
        int res = -1;
       
        Node next = root;
        for (int i = 0; i < length; i++) {
            if(next.getData()==x) { res = i;  break; } 
            next = next.getNext();
        }

        return res;
    }

    @Override
    public void setArray(T[] a) {
        clear();
        Node prevNode = new Node(a[0]);
        length++;
        root = prevNode;
        for (int i = 1; i < a.length; i++){
                Node newNode = new Node(a[i]);
                length++;
                prevNode.setNext(newNode);
                prevNode = newNode;
        }
    }

    public String toString(){
        if(root==null) return "";
       
        Node next = root;
        for (int i = 0; i < length; i++) {
            System.out.print(" "+next.getData());
            next = next.getNext();
        }

        return "";
    }
    
    public boolean equals(Object ob){
        boolean res = true;
        T[] o = (T[])ob;
        if(length!=o.length) return false;
        
        if(root==null) return false;
       
        Node next = root;
        for (int i = 0; i < length; i++) {
            if(next.getData()!=o[i]) {
                res = false;
                break;
            }
            next = next.getNext();
        }
        return res;
    } 
    
	
    private void check(int pos) {
        if( (pos < 0) || (pos>=length) ) throw new ArrayIndexOutOfBoundsException();
    }
    
    private Node getNodeByPos(int pos) {
        check(pos);
        Node fnd = root;
        int count = 0;
        while (count < pos) {
            fnd = fnd.getNext();
            count++;
        }
        return fnd;
    }
    public Iterator<T> iterator() {
        return new ATDIterator<T>(this);
    }

    @Override
    public T[] toArray() {
        T[] res = (T[]) new Object[size()];
        int counter = 0;
        if(root!=null){
            Node next = root;
            for (int i = 0; i < length; i++) {
                res[counter++] = (T)next.getData();
                next = next.getNext();
            }
        }
        return res;
        
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
     class Node<T>{
            
            private T data;
            private Node<T> next;

            public Node(T data) {
                this.data = data;
            }

            public Node(T data, Node next) {
                this.data = data;
                this.next = next;
            }


            public T getData() {
                return  (T) data;
            }

            public void setData(T data) {
                this.data = data;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }


        }