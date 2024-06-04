package P5CustomLinkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import p05_CustomLinkedList.CustomLinkedList;

public class CustomLinkedListTest {
    private CustomLinkedList<String> customLinkedListTest;
    private static final String element = "test";
    private static final String elementToAdd = "adding";

    @Before
    public void setUp() {
        customLinkedListTest = new CustomLinkedList<>();
        customLinkedListTest.add(element);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getMethodShouldThrowExceptionWithInvalidIndexGreater() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.get(0);
    }
    @Test(expected = IllegalArgumentException.class)
    public void getMethodShouldThrowExceptionWithInvalidIndexSmaller() {
        customLinkedListTest.get(3);
    }
    @Test
    public void getMethodShouldWorkCorrectly() {
        Assert.assertEquals(customLinkedListTest.get(0), element);
    }
    @Test(expected = IllegalArgumentException.class)
    public void setMethodShouldThrowExceptionWithInvalidIndexGreater() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.set(3, element);
    }
    @Test(expected = IllegalArgumentException.class)
    public void setMethodShouldThrowExceptionWithInvalidIndexSmaller() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.set(0, element);
    }
    @Test
    public void setMethodShouldWorkCorrectly() {
        customLinkedListTest.set(0, element);
        Assert.assertEquals(customLinkedListTest.get(0), element);
    }
    @Test
    public void addMethodShouldWorkCorrectly() {
        customLinkedListTest.add(element);
        Assert.assertEquals(customLinkedListTest.get(0), element);
    }
    @Test(expected = IllegalArgumentException.class)
    public void removeAtMethodShouldThrowExceptionWithInvalidIndex() {
        customLinkedListTest = new CustomLinkedList<>();
        customLinkedListTest.removeAt(0);
    }
    @Test
    public void removeMethodShouldWorkCorrectly() {
        Assert.assertEquals(customLinkedListTest.remove("test"), 0);
    }
}
