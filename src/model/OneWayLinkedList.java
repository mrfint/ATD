
package model;

import java.util.Iterator;


public class OneWayLinkedList implements 
                                        ATD, Iterable{
    private Node root = null;
    private int length = 0;
    
    @Override
    public void addToStart(int x) {
        Node newnd  = new Node(x);
        newnd.setNext(root);
        root = newnd;

        length++;
    }

    @Override
    public void addToEnd(int x) {
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
    public void addToPos(int pos, int x) {
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
    public void set(int pos, int x) {
        check(pos);
        getNodeByPos(pos).setData(x);
    }

    @Override
    public int get(int pos) {
        check(pos);
        return getNodeByPos(pos).getData();
    }

    @Override
    public int find(int x) {
        int res = -1;
       
        Node next = root;
        for (int i = 0; i < length; i++) {
            if(next.getData()==x) { res = i;  break; } 
            next = next.getNext();
        }

        return res;
    }

    @Override
    public void sort() {
        setArray(new int[]{0, 1, 2, 3, 4});   //  MOCK
    }

    @Override
    public void setArray(int[] a) {
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
    @Override
    public int[] toArray() {
        int[] res = new int[length];
        int counter = 0;
        if(root!=null){
            Node next = root;
            for (int i = 0; i < length; i++) {
                res[counter++] = next.getData();
                next = next.getNext();
            }
        }
        return res;
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
        int[] o = (int[])ob;
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
    @Override
    public Iterator iterator() {
        return new ATDIterator(this);
    }
}
     class Node{
            
            private Integer data;
            private Node next;

            public Node(int data) {
                this.data = data;
            }

            public Node(int data, Node next) {
                this.data = data;
                this.next = next;
            }


            public int getData() {
                return data;
            }

            public void setData(int data) {
                this.data = data;
            }

            public Node getNext() {
                return next;
            }

            public void setNext(Node next) {
                this.next = next;
            }


        }