package P1Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p01_Database.Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(1 , 2, 3 , 4, 5);
    }

    @Test
    public void constructorShouldWorkCorrectly() {
        Integer[] expectedArr = { 1 , 2, 3 , 4, 5};
        Integer[] actualArr = database.getElements();

        Assert.assertEquals(expectedArr, actualArr);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExceptionWithMoreThan16Numbers() throws OperationNotSupportedException {
        Integer[] elements = new Integer[17];
        database = new Database(elements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExceptionWithLessThan1Number() throws OperationNotSupportedException {
        database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addMethodShouldThrowExceptionWithNullElement() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void addMethodShouldWorkCorrectly() throws OperationNotSupportedException {
        database.add(6);

        Integer[] elements = database.getElements();
        int size = elements.length;

        Assert.assertEquals(6, size);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeMethodShouldThrowExceptionWithNullDatabase() throws OperationNotSupportedException {
        database = new Database();
        database.remove();
    }

    @Test
    public void removeMethodWorkCorrectly() throws OperationNotSupportedException {
        Integer[] elements = database.getElements();
        Integer removedElement = elements[elements.length - 1];

        database.remove();

        int actualSize = database.getElements().length;
        int expectedSize = 4;

        Assert.assertEquals(expectedSize, actualSize);
        Assert.assertEquals(Integer.valueOf(5), removedElement);
    }
}
