package P2ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import p02_ExtendedDatabase.Database;
import p02_ExtendedDatabase.Person;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;
    private static final Person PERSON1 = Mockito.mock(Person.class);
    private static final Person PERSON2 = Mockito.mock(Person.class);
    private static final Person PERSON3 = Mockito.mock(Person.class);
    private static final Person[] PEOPLE = {PERSON1, PERSON2, PERSON3};

    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(PEOPLE);
    }
    @Test()
    public void constructorShouldWorkCorrectly() throws OperationNotSupportedException {
        Person[] actualPeople = database.getElements();

        Assert.assertArrayEquals(PEOPLE, actualPeople);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExceptionWithMoreThan16People() throws OperationNotSupportedException {
        database = new Database(new Person[20]);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void constructorShouldThrowExceptionWithLessThan1Person() throws OperationNotSupportedException {
        database = new Database();
    }
    @Test(expected = OperationNotSupportedException.class)
    public void addMethodShouldThrowExceptionWithNullElement() throws OperationNotSupportedException {
        database.add(null);
    }
    @Test
    public void addMethodShouldIncreaseElementsCount() throws OperationNotSupportedException {
        Person person = Mockito.mock(Person.class);

        database.add(person);

        Person[] people = database.getElements();
        int actualCount = people.length;

        Assert.assertEquals(4, actualCount);
    }
    @Test
    public void addMethodShouldAddPersonLast() throws OperationNotSupportedException {
        Person person = Mockito.mock(Person.class);

        database.add(person);

        Person[] people = database.getElements();
        int actualCount = people.length;

        Assert.assertEquals(person, people[actualCount - 1]);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void removeMethodShouldThrowExceptionWithNullDatabase() throws OperationNotSupportedException {
        database = new Database();
        database.remove();
    }
    @Test()
    public void removeMethodShouldWorkCorrectly() throws OperationNotSupportedException {
        Person person = database.getElements()[2];

        database.remove();

        Assert.assertEquals(PERSON3, person);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameMethodShouldThrowExceptionWhenUsernameNotPresent() throws OperationNotSupportedException {
        database.findByUsername("Test");
    }
    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameMethodShouldThrowExceptionWhenUsernameIsNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameMethodShouldThrowExceptionWhenUsernameIsDuplicated() throws OperationNotSupportedException {
        Mockito.when(PERSON1.getUsername()).thenReturn("Test");
        Mockito.when(PERSON2.getUsername()).thenReturn("Test");

        database.findByUsername("Test");
    }
    @Test
    public void findByUsernameMethodShouldWorkCorrectly() throws OperationNotSupportedException {
        Mockito.when(PERSON1.getUsername()).thenReturn("Test");

        Person actualPerson = database.findByUsername("Test");

        Assert.assertEquals(PERSON1, actualPerson);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void findByIdMethodShouldThrowExceptionWhenUsernameIsDuplicated() throws OperationNotSupportedException {
        Mockito.when(PERSON1.getId()).thenReturn(1);
        Mockito.when(PERSON2.getId()).thenReturn(1);

        database.findById(1);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void findByIdMethodShouldThrowExceptionWhenUsernameNotPresent() throws OperationNotSupportedException {
        database.findById(1);
    }
    @Test
    public void findByIdMethodShouldWorkCorrectly() throws OperationNotSupportedException {
        Mockito.when(PERSON1.getId()).thenReturn(1);

        Person actualPerson = database.findById(1);

        Assert.assertEquals(PERSON1, actualPerson);
    }
}
