package model;

import java.util.Iterator;

public class ATDIterator implements Iterator{
    private ATD items;
    private int position;

    public ATDIterator(ATD items) {
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
    public Object next() {
        return items.get(position++);
        
    }

    @Override
    public void remove() {
        items.del(position);
    }
}
