package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class ForeachTest {
    
    
    @Test
    public void testManyEquals() {
        FlowArrayList<Integer> c = new FlowArrayList<Integer>();
        c.setArray(new Integer[]{0, 1, 2, 3, 4});
        String s1="", s2="";
        for(Integer i: c){ s1+=(" "+i);        }
        
        
        OneWayLinkedList<Integer> lst = new OneWayLinkedList<Integer>();
        lst.setArray(new Integer[]{0, 1, 2, 3, 4});
        for(Integer i: lst){
            s2+=(" "+i);
        }
        ArrayList<Integer> als = 
                new ArrayList<Integer>();
        als.add(new Integer(1));
        als.add(new Integer(10));
        for(Integer i: als){
            System.out.println(" "+i);
        }
        assertTrue(s1.equals(s2));
    }
}
