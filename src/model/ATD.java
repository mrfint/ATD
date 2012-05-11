
package model;

interface ATD {
    void addToStart(int x);
    void addToEnd(int x);
    void addToPos(int pos, int x);
    void delFromStart();
    void delFromEnd();
    void del(int pos);
    int  size();
    void clear();
    void set(int pos, int x);
    int  get(int pos);
    int  find(int x);
    void sort();
    void  setArray(int[] a);
    int[] toArray();
}
