import com.mobiquityinc.exception.KnapsackInitException;
import com.mobiquityinc.packer.Knapsack;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class KnapsackTest {

    @Test
    public void knapsackDefaultMaxWeight() {
        Knapsack p = new Knapsack();
        assertEquals(p.maxWeight, 100.0);
    }

    @Test
    public void knapsackInitMaxWeight() throws KnapsackInitException {
        Knapsack p = new Knapsack(50.0);
        assertEquals(p.maxWeight, 50.0);
    }

    @Test(expected = KnapsackInitException.class)
    public void knapsackWeightOverMaxPossibleWeight_throwKnapsackInitException() throws KnapsackInitException {
        new Knapsack(150.0);
    }

    @Test(expected = KnapsackInitException.class)
    public void knapsackNegativeWeight_throwKnapsackInitException() throws KnapsackInitException {
        new Knapsack(-150.0);
    }

    @Test
    public void knapsackMaxCapacity() throws KnapsackInitException {
        Knapsack p = new Knapsack(50.0);
        assertEquals(p.capacity, 15);
    }
}
