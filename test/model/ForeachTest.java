package model;

import java.util.ArrayList;
import java.util.Iterator;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

public class ForeachTest {
    
    
    @Test
    public void testManyEquals() {
        FlowArrayList c = new FlowArrayList();
        c.setArray(new int[]{0, 1, 2, 3, 4});
        String s1="",s2="";
        for(Object i: c){
            s1 = (""+(Integer)i);
        }
        
        OneWayLinkedList lst = new OneWayLinkedList();
        lst.setArray(new int[]{0, 1, 2, 3, 4});
        for(Object i: lst){
            s2 = (""+(Integer)i);
        }
        
        assertTrue(s1.equals(s2));
    }
}
