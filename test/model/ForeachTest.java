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
    public void testManyFoeachInteger() {
        Integer[] ni = new Integer[]{0, 1, 2, 3, 4};
        
        FlowArrayList<Integer>    als = new FlowArrayList<Integer>();
        OneWayLinkedList<Integer> lst = new OneWayLinkedList<Integer>();

        als.setArray(ni);
        lst.setArray(ni);
        
        String s1="", s2="";
        for(Integer i: als){ 
            s1+=(" "+i);        
        }
        
        for(Integer i: lst){
            s2+=(" "+i);
        }

        assertTrue(s1.equals(s2));
    }
    
    @Test
    public void testManyFoeachPerson() {
        Person[] ni = Person.gerArr();
 
        FlowArrayList<Person>    als = new FlowArrayList<Person>();
        OneWayLinkedList<Person> lst = new OneWayLinkedList<Person>();

        als.setArray(ni);
        lst.setArray(ni);

        String s1="", s2="";
        for(Person i: als){ 
            s1+=(" "+i);        
        }

        for(Person i: lst){
            s2+=(" "+i);
        }
        System.out.println("s1 : "+s1);
        System.out.println("s2 : "+s2);
        assertTrue(s1.equals(s2));
    }
}
