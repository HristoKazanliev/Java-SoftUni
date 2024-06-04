package P4BubbleSort;

import org.junit.Assert;
import org.junit.Test;
import p04_BubbleSortTest.Bubble;

public class BubbleSortTest {
    private static final int[] numbers = {20, 9 , 0, 5, 12, 11, 30, 1, 25};
    private static final int[] actualNumbers = {0, 1, 5, 9, 11,  12, 20, 25, 30};

    @Test
    public void testBubbleSort() {
        Bubble.sort(numbers);
        Assert.assertArrayEquals(numbers, actualNumbers);
    }
}
