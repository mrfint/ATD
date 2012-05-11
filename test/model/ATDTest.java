package model;

import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(value=Parameterized.class)
public class ATDTest {
    private ATD inst = null;
    private ATD c = null;

    public ATDTest(ATD inst) {
        this.inst = inst;
    }
    @Parameterized.Parameters
    public static Collection<Object[]> generateData()
    {
        Object[][] data = new Object[][] {
                    
                        { new FlowArrayList()    },
                        { new CycleArrayList()   },
                        { new OneWayLinkedList() },
                        { new TWLinkedList() },
                        { new CycleTWLinkedList() },
        };
    return Arrays.asList(data);
    }

    
    @Before
    public void setUp() throws InstantiationException, IllegalAccessException{
        
        c = inst.getClass().newInstance();
    }
    @After
    public void tearDown(){
        c = null;
    }
    //******************************************** Test zero
    @Test
    public void testZeroSize(){
        assertEquals(0, c.size());
    }
    
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testZeroGetZElement(){
       c.get(0);
    }
   
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testZeroSetZElement(){
       c.set(0,10);
    }
    
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testZeroAddToSecondPos(){
       c.addToPos(2,10);
    }
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testZeroDelFromStart(){
       c.delFromStart();
    }
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testZeroDelFromEnd(){
       c.delFromEnd();
    }
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testZeroDelFromAnyPos(){
       c.del(10);
    }
    //************************************************ One element
    @Test
    public void testOneSize(){
        c.addToStart(10);
        assertEquals(1, c.size());
    }
    @Test
    public void testOneGetZElement(){
       c.addToStart(10);
       assertEquals(10, c.get(0));
    }
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testOneGetSecondElement(){
       c.addToStart(10);
       c.get(1);
    }
    @Test
    public void testOneSetZElement(){
       c.addToStart(10);
       c.set(0,100);
       
       assertEquals(100, c.get(0));
        
    }
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testOneSetSecondElement(){
       c.addToStart(10);
       c.set(2,10);
    }
  
    @Test
    public void testOneAddToStart(){
       c.addToStart(10);
       c.addToStart(20);

       assertEquals(20, c.get(0));
       assertEquals(10, c.get(1));
       
    }
    @Test
    public void testOneAddToEnd(){
       c.addToEnd(10);
       c.addToEnd(20);
       
       assertEquals(10, c.get(0));
       assertEquals(20, c.get(1));
       
    }
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testOneAddToSomePos(){
       c.addToStart(10);
       c.addToPos(10,100);
    }
    @Test
    public void testOneDelFromStart(){
       c.addToStart(10);
       c.delFromStart();;
       assertEquals(0, c.size());
    }
    @Test
    public void testOneDelFromEnd(){
       c.addToStart(10);
       c.delFromEnd();
       assertEquals(0, c.size());
    }

    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testOneDelFromAnyPos(){
       c.del(10);
    }
   //********************************************** Test Many 
    @Test
    public void testManySize(){
        Integer[] b = new Integer[]{0, 1, 2, 3, 4};
        c.setArray(b);

        assertEquals(b.length, c.size());
    }
    @Test
    public void testMenyGetZElement(){
       Integer[] b = new Integer[]{0, 1, 2, 3, 4};
       c.setArray(b);
       
       assertEquals(b[0], c.get(0));
    }
    
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testMenyGetSomeIlligElement(){
       c.setArray(new Integer[]{0, 1, 2, 3, 4});
       c.get(90);
    }
    @Test
    public void testMenySetZElement(){
       Integer[] b = new Integer[]{0, 1, 2, 3, 4};
       c.setArray(b);
       c.set(0,100);
       b[0] = 100;
       assertTrue(c.equals(b));
        
    }
    
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testMenySetSomeIlligElement(){
       c.setArray(new Integer[]{0, 1, 2, 3, 4});
       c.set(90,10);
    }
    
    @Test
    public void testManyAddToStart(){
       c.setArray(new Integer[]{0, 1, 2, 3, 4});
       c.addToStart(10);
       Integer[] b = new Integer[]{10, 0, 1, 2, 3, 4};
       
       assertTrue(c.equals(b));

       
    }
    @Test
    public void testManyAddToEnd(){
       c.setArray(new Integer[]{0, 1, 2, 3, 4});
       c.addToEnd(10);
       
       Integer[] b = new Integer[] {0, 1, 2, 3, 4, 10};
       assertTrue(c.equals(b));
   
    }
    @Test
    public void testManyAddToSomePos(){
       c.setArray(new Integer[]{0, 1, 2, 3, 4});
       c.addToPos(2,10);
       Integer[] b = new Integer[]{0, 1, 10, 2, 3, 4};

       assertTrue(c.equals(b));
    }
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testManyAddToSomeIlligPos(){
       c.setArray(new Integer[]{0, 1, 2, 3, 4});
       c.addToPos(90,10);
    }
    @Test
    public void testManyDelFromStart(){
       c.setArray(new Integer[]{10, 0, 1, 2, 3, 4});
       c.delFromStart();
       Integer[] b = new Integer[]{0, 1, 2, 3, 4};
       assertTrue(c.equals(b));
    }
    @Test
    public void testManyDelFromEnd(){
       c.setArray(new Integer[]{0, 1, 2, 3, 4, 10});
       c.delFromEnd();
       Integer[] b = new Integer[]{0, 1, 2, 3, 4};
       assertTrue(c.equals(b));
    }

    @Test
    public void testManyDelFromAnyPos(){
       c.setArray(new Integer[]{0, 1, 10, 2, 3, 4});
       c.del(2);
       Integer[] b = new Integer[]{0, 1, 2, 3, 4};
       assertTrue(c.equals(b));
    }
    @Test(expected=ArrayIndexOutOfBoundsException.class)
    public void testManyDelFromAnyIllPos(){
        c.setArray(new Integer[]{0, 1, 2, 3, 4});
        c.del(90);
    }
    @Test
    public void testManyEquals() {
        c.setArray(new Integer[]{0, 1, 2, 3, 4});
        assertArrayEquals(new Integer[]{0, 1, 2, 3, 4}, c.toArray());
    }
    
    
    @Test(expected=UnsupportedOperationException.class)
    public void sort() {
        c.setArray(new Integer[]{4, 3, 2, 1, 0});
        c.sort();

        Integer[] b = new Integer[]{0, 1, 2, 3, 4};
        assertTrue(c.equals(b));
    }
    
    @Test
    public void find() {
       c.setArray(new Integer[]{0, 1, 2, 3, 4});

       assertEquals(4,  c.find(4));
    }
}
