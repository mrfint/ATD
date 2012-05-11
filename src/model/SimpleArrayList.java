
package model;

public class SimpleArrayList<T> implements ATD<T>{
    private int count = -1;
    private int n = 100;
    
    private T[] a = (T[]) new Object[n];

    private void upBorderOfArray(){
        int nn = (int) (n*1.2);
        T[] b = (T[]) new Object[nn];
        for (int i = 0; i < n; i++) {
            b[i] = a[i];
        }
        a = b;
        n = nn;
    }
    
    @Override
    public void addToStart(T x) {
        addToPos(0, x);
    }
    

    @Override
    public void addToEnd(T x) {
        addToPos(count++, x);
    }

    @Override
    public void addToPos(int pos, T x) {
        if (pos > count+1 || pos < 0 ) {       throw new ArrayIndexOutOfBoundsException();   }
        count++;
        if( count == (n-1) )  upBorderOfArray();
        
        for (int i = count; i > pos ; i--) {
            a[i] = a[i-1];
        }
        a[pos] = x;
        
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public void clear() {
        n = 100;
        a = (T[]) new Object[n];
        count=0;
    }

    @Override
    public void set(int pos, T x) {
        if (pos > count) {       throw new ArrayIndexOutOfBoundsException();   }
        a[pos] = x;
    }

    @Override
    public T get(int pos) {
        if (pos > count) {       throw new ArrayIndexOutOfBoundsException();   }
        return a[pos];
    }

    @Override
    public int find(T x) {
        int res = -1;
        for (int i = 0; i < size(); i++) {
            if(a[i]==x) { 
                res = i; 
                break;
            } 
        }
    return res;
    }

    
    public boolean equals(Object ob){
        boolean res = true;
        T[] o = (T[])ob;
        if(size()!=o.length) return false;
        for (int i = 0; i < size(); i++) {
            if(a[i]!=o[i]) { res = false;  break; }
        }
        return res;
    }

    @Override
    public void delFromEnd() {
        del(count);
    }
    
    @Override
    public void delFromStart() {
        del(0);
    }

    @Override
    public void del(int pos) {
        if ((pos > count) || (pos < 0) ) {
            throw new ArrayIndexOutOfBoundsException();  
        }
        
        for (int i = pos; i < count ; i++) {
            a[i] = a[i+1];
        }
        count--;
    }

    @Override
    public void setArray(T[] x) {
        clear();
        if(x.length > n  ) {   n = x.length; a = (T[]) new Object[x.length];}
        count = x.length-1;
        for (int i = 0; i < x.length; i++){
                a[i] = x[i];
        }
    }
    @Override
    public T[] toArray() {
        if(size()==0) return null;
        
        T[] res = (T[]) new Object[size()];
        for (int i = 0; i <= count; i++) {
            res[i] = a[i];
        }
       
        return res;
    }
    
    @Override
    public String toString() {
        if(size()==0) return "";

        for (int i = 0; i <= count; i++) {
            System.out.print(" "+a[i]);
        }
       
        return "";
    }

    @Override
    public void sort() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
