
package model;

import java.util.Iterator;

public class FlowArrayList<T> implements ATD<T>, Iterable<T>{
    private int n = 102;
    private int countLeft  = n/2;
    private int countRight = n/2;
    
    private T[] a = (T[]) new Object[n];

    private void upBorderOfArray(){
        int s = size();
        T[] b = (T[]) new Object[n];
        
        for (int i = countLeft; i < countLeft+size(); i++) {
            b[i-countLeft] = a[i];
        }
        
        n = (int) (n*1.2);
        a = (T[]) new Object[n];
        setArray(b);
    }
    
    @Override
    public void addToStart(T x) {
        checkBorders();
        a[--countLeft] = x;
    }
    

    @Override
    public void addToEnd(T x) {
        checkBorders();
        a[countRight++] = x;
    }

    @Override
    public void addToPos(int pos, T x) { 
        check(pos);
        checkBorders();
        
        if (pos <= size()/2) {
            for (int i = countLeft; i < countLeft+pos ; i++) {  a[i] = a[i+1]; }
            countLeft--;
        }
        else{
            for (int i = countRight+1; i > countLeft+pos ; i--){ a[i] = a[i-1];}
            countRight++;
        }
        a[countLeft+pos] = x;
    }

    @Override
    public int size() {
        return countRight-countLeft;
    }

    @Override
    public void clear() {
        n = 100;
        a = (T[]) new Object[n];
        countLeft  = n/2;
        countRight = n/2;
        
    }

    @Override
    public void set(int pos, T x) {
        check(pos);
        a[countLeft+pos] = x;
    }

   

    @Override
    public int find(T x) {
        int res = -1;
        for (int i = countLeft; i < countLeft+size(); i++) {
            if(a[i]==x) { 
                res = i - countLeft; 
                break;
            } 
        }
    return res;
    }
    
    public boolean equals(Object ob){
        boolean res = true;
        T[] o = (T[])ob;
        if(size()!=o.length) return false;
        for (int i = countLeft; i < size(); i++) {
            if(a[i]!=o[i-countLeft]) { res = false;  break; }
        }
        return res;
    }

    @Override
    public void delFromEnd() {
        del(size()-1);
    }
    
    @Override
    public void delFromStart() {
        del(0);
    }

    @Override
    public void del(int pos) {
        check(pos);
        
        if (pos <= size()/2) {
            for (int i = countLeft+pos; i >= countLeft ; i--) { a[i] = a[i-1]; }
            countLeft++;
        }
        else{
           for (int i = countLeft+pos; i <= countRight ; i++) { a[i] = a[i+1]; }
           countRight--;
        }

    }

    @Override
    public void setArray(T[] x) {
        clear();
        if(x.length >= n  ) {   n =  (int) (x.length*1.2);  a = (T[]) new Object[x.length]; }
       
        for (int i = x.length/2; i >= 0; i--){             addToStart(x[i]);  }
        for (int i = x.length/2+1; i < x.length; i++){     addToEnd(x[i]);    }
    }
    @Override
    public T[] toArray() {
        T[] res = (T[]) new Object[size()];
        int counter = 0;
        for (int i = countLeft; i < countRight; i++) {
            res[counter++] = a[i];
        }
       
        return res;
    }
    @Override
    public String toString(){ 
        String res="";
        for (int i = countLeft; i < countLeft+size(); i++) {
            System.out.print(" "+a[i]);
        }
        return res;
    }

    private void check(int pos) {
        if ( (pos >= size()) || (pos < 0) ) {
            throw new ArrayIndexOutOfBoundsException();  
        }
    }

    private void checkBorders() {
        if( (countLeft-1)==0 || (countLeft+1)==n-1 ) upBorderOfArray();
    }

    @Override
    public Iterator<T> iterator() {
        return new ATDIterator<T>(this);
    }

    @Override
    public T get(int pos) {
        check(pos);
        return a[countLeft+pos];
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
