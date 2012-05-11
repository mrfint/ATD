
package utils;

import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import java.lang.NullPointerException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import model.*;
import org.junit.*;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(value=Parameterized.class)
public class MyArraysTest {
    private int n = 50;
    private String type;
    private int[] mass;

    public MyArraysTest(String type) {
        this.type = type;
    }
    
    @Parameterized.Parameters
    public static Collection<Object[]> generateData()
    {
        Object[][] data = new Object[][] { { "one" }, { "manySortedInOrder" },
                         { "manySortedInRevertOrder" }, { "manyRandom" } };
    return Arrays.asList(data);
    }
    @Before
    public void setUp(){
        if(type.equals("one")) mass = new int[]{1};
        else
        {
            mass = new int[n];
            if(type.equals("manySortedInOrder")){ 
                for(int i=0; i<n; i++) mass[i]=i;
            }
            if(type.equals("manySortedInRevertOrder")){ 
                for(int i=n; i > 0; i--) mass[n-i]=i;
            }
            if(type.equals("manyRandom")){ 
                for(int i=0; i<n; i++) mass[i]=(int) (Math.random()*10);
            }
        }
    }
    @After
    public void tearDown(){
        mass = null;
    }
     //********************************************************Sort Bubble
    @Test
    public void testBubbleSortParam() 
    {   CycleArrayList lst = new CycleArrayList() ;
        lst.setArray(mass);

        MyArrays.sortBubble(lst.toArray());
        assertArrayEquals(mass, lst.toArray());
        
    }

    //********************************************************Sort Selection
    @Test
    public void testSelectionSortParam() 
    {   SimpleArrayList lst = new SimpleArrayList() ;
        lst.setArray(mass);

        MyArrays.sortSelection(lst.toArray());
        assertArrayEquals(mass, lst.toArray());
        
    }
    
    //********************************************************Sort Insert
    @Test
    public void testInsertSortParam() 
    {   SimpleArrayList lst = new SimpleArrayList() ;
        lst.setArray(mass);

        MyArrays.sortInsert(lst.toArray());
        assertArrayEquals(mass, lst.toArray());
        
    }
    //********************************************************Sort Shell
    @Test
    public void testShellSortParam() 
    {   SimpleArrayList lst = new SimpleArrayList() ;
        lst.setArray(mass);

        MyArrays.sortShell(lst.toArray());
        assertArrayEquals(mass, lst.toArray());
        
    }
    //********************************************************Sort Quick
    @Test(timeout=100)
    public void testQuickSortParam() 
    {   FlowArrayList lst = new FlowArrayList() ;
        lst.setArray(mass);

        MyArrays.sortQuick(lst.toArray());
        assertArrayEquals(mass, lst.toArray());
        
    }
    
}
