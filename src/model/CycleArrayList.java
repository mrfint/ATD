
package model;

public class CycleArrayList<T> implements ATD<T>{
    private int n = 102;
    private int countLeft  = n-1;
    private int countRight = 0;
    
    
    private T[] a = (T[]) new Object[n];

    private void upBorderOfArray(){

        T[] b = (T[]) new Object[size()];
        
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
        a[countLeft] = x;
        if(countLeft-1 == -1) countLeft = n-1;
        else {        countLeft--;          }
        
    }
    

    @Override
    public void addToEnd(T x) {
        checkBorders();
        a[countRight] = x;
        if(countRight+1 == n) countRight = 0;
        else{        countRight++;          }
        
    }

    @Override
    public void addToPos(int pos, T x) { 
        check(pos);
        checkBorders();
       
        if (countLeft+pos < n ) {
            for (int i = countLeft; i < countLeft+pos+1 ; i++) {
                a[i] = a[i+1];
            }
            a[countLeft+pos+1] = x;
            countLeft--;
        }
        else
        {
           for (int i = countRight; i > size()-pos ; i--) {
            a[i] = a[i-1];
            }
           a[size()-pos] = x;
           countRight++;
        }
        
    }

    @Override
    public int size() {
        return n-Math.abs(countRight-countLeft)-1;
    }

    @Override
    public void clear() {
        n = 100;
        a = (T[]) new Object[n];
        int countLeft  = n-1;
        int countRight = 0;
    }

    @Override
    public void set(int pos, T x) {
        check(pos);
        int indx = ((countLeft+1+pos) >= n)? (countLeft+1+pos)%n : countLeft+1+pos;
        a[indx] = x;
    }

    @Override
    public T get(int pos) {
        check(pos);
        int indx = ((countLeft+1+pos) >= n)? (countLeft+1+pos)%n : countLeft+1+pos;
        return a[indx];
    }

    @Override
    public int find(T x) {
    return 4;           //              MOCK
    }
    
    @Override
    public T[] toArray() {
        T[] res = (T[]) new Object[size()];
        int counter = 0;
        for (int i = countLeft+1; i < n; i++) {
            res[counter++] = a[i];
        }
        for (int i = 0; i < countRight; i++) {
            res[counter++] = a[i];
        }
        return res;
    }
    
    public boolean equals(Object ob){
        boolean res = true;
        T[] o = (T[])ob;
        if(size()!=o.length) return false;
        for (int i = countLeft+1; i < size(); i++) {
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
         if (countLeft+pos < n ) {
            for (int i = countLeft+pos+1; i > countLeft+1 ; i--) {
                a[i] = a[i-1];
            }
            countLeft++;
        }
        else
        {
           for (int i = size()-pos; i < countRight ; i++) {
                a[i] = a[i+1];
           }
           countRight--;
        }

    }

    @Override
    public void setArray(T[] x) {
        if(x.length > n  ) {   n = x.length; a = (T[]) new Object[x.length]; }
        countLeft  = n-1;
        countRight = 0;
        
        for (int i = 0; i < x.length; i++) {
            a[countRight] = x[i];
            countRight++;
        }
    }
    @Override
    public String toString(){ 
        String res="";
        for (int i = 0; i < n; i++) {
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
       if ( countRight == countLeft ) {
            upBorderOfArray();     
        }
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
