
package model;

import java.util.Iterator;

public class FlowArrayList implements ATD, Iterable{
    private int n = 102;
    private int countLeft  = n/2;
    private int countRight = n/2;
    
    
    private Integer[] a = new Integer[n];

    private void upBorderOfArray(){
        int s = size();
        Integer[] b = new Integer[size()];
        
        for (int i = countLeft; i < countLeft+size(); i++) {
            b[i-countLeft] = a[i];
        }
        
        n = (int) (n*1.2);
        a = new Integer[n];
        setArray(b);
    }
    
    @Override
    public void addToStart(int x) {
        checkBorders();
        a[--countLeft] = x;
    }
    

    @Override
    public void addToEnd(int x) {
        checkBorders();
        a[countRight++] = x;
    }

    @Override
    public void addToPos(int pos, int x) { 
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
        a = new Integer[100];
        countLeft  = n/2;
        countRight = n/2;
        
    }

    @Override
    public void set(int pos, int x) {
        check(pos);
        a[countLeft+pos] = x;
    }

    @Override
    public int get(int pos) {
        check(pos);
        return a[countLeft+pos];
    }

    @Override
    public int find(int x) {
        int res = -1;
        for (int i = countLeft; i < countLeft+size(); i++) {
            if(a[i]==x) { 
                res = i - countLeft; 
                break;
            } 
        }
    return res;
    }

    @Override
    public void sort() {
        for (int i = countLeft; i < size()-1 ; i++) 
        {   for (int j = i+1; j < size(); j++){
                if(a[i] > a[j]) {  int c = a[i];  a[i] = a[j];   a[j] = c;  }
            }
        }

    }
    
    public boolean equals(Object ob){
        boolean res = true;
        int[] o = (int[])ob;
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
    public void setArray(int[] x) {
        clear();
        if(x.length >= n  ) {   n =  (int) (x.length*1.2); a = new Integer[n]; }
       
        for (int i = x.length/2; i >= 0; i--){             addToStart(x[i]);  }
        for (int i = x.length/2+1; i < x.length; i++){     addToEnd(x[i]);    }
    }
    
    public void setArray(Integer[] x) {
        clear();
        if(x.length >= n  ) {   n =  (int) (x.length*1.2); a = new Integer[n]; }
       
        for (int i = x.length/2; i >= 0; i--){             addToStart(x[i]);  }
        for (int i = x.length/2+1; i < x.length; i++){     addToEnd(x[i]);    }
    }
    @Override
    public int[] toArray() {
        int[] res = new int[size()];
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
    public Iterator iterator() {
        return new ATDIterator(this);
    }

}
