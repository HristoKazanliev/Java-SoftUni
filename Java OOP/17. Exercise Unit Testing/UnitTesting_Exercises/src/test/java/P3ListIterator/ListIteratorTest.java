package P3ListIterator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p03_IteratorTest.ListIterator;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {
    private ListIterator listIterator;
    private static final String[] input = {"1", "2", "3"};

    @Before
    public void setUp() throws OperationNotSupportedException{
        listIterator = new ListIterator(input);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExceptionWithNullElement() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void moveAndHasNextMethods() {
        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());
        Assert.assertTrue(listIterator.hasNext());
        Assert.assertTrue(listIterator.move());
        Assert.assertFalse(listIterator.hasNext());
        Assert.assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void printMethodShouldThrowExceptionWithEmptyList() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }

    @Test()
    public void printMethodShouldWorkCorrectly(){
        int index = 0;
        while (listIterator.hasNext()) {
            Assert.assertEquals(listIterator.print(), input[index]);
            index++;
            listIterator.move();
        }
    }
}
