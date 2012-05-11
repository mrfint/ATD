
package model;

interface ATD <T> {
    void addToStart(T x);
    void addToEnd(T x);
    void addToPos(int pos, T x);
    void delFromStart();
    void delFromEnd();
    void del(int pos);
    int  size();
    void clear();
    void set(int pos, T x);
    <T> T get(int pos);
    int  find(T x);
    void sort();
    void setArray(T[] a);
    T[] toArray();
    
    
}
