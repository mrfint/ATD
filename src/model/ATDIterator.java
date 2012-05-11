package model;

import java.util.Iterator;

public class ATDIterator<T> implements Iterator<T>{
    private ATD<T> items = null;
    private int position = 0;

    public ATDIterator(ATD<T> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        if(position >= items.size() ){
            return false;
        }
        else{
            return true;
        }
    }

    @Override
    public T next() {
        return items.get(position++);
        
    }

    @Override
    public void remove() {
        items.del(--position);
    }
}
