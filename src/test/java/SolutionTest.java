import org.example.Solution;
import org.junit.Assert;
import org.junit.Test;

public class SolutionTest {
    @Test
    public void maxProfitTest1() {
        int[] prices = {1, 2, 3, 0, 2};
        int output = 3;
        Assert.assertEquals(output, new Solution().maxProfit(prices));
    }

    @Test
    public void maxProfitTest2() {
        int[] prices = {1};
        int output = 0;
        Assert.assertEquals(output, new Solution().maxProfit(prices));
    }

    @Test
    public void maxProfitTest3() {
        int[] prices = {2,1,4};
        int output = 3;
        Assert.assertEquals(output, new Solution().maxProfit(prices));
    }

}
