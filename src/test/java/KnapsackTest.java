import com.mobiquityinc.exception.ItemInitException;
import com.mobiquityinc.exception.KnapsackInitException;
import com.mobiquityinc.exception.KnapsackMaxCapacityAchievedException;
import com.mobiquityinc.packer.Item;
import com.mobiquityinc.packer.Knapsack;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class KnapsackTest {

    @Test
    public void knapsackDefaultMaxWeight() {
        Knapsack k = new Knapsack();
        assertEquals(k.maxWeight, 100.0);
        assertEquals(k.getLength(), 0);
    }

    @Test
    public void knapsackInitMaxWeight() throws KnapsackInitException {
        Knapsack k = new Knapsack(50.0);
        assertEquals(k.maxWeight, 50.0);
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
        Knapsack k = new Knapsack(50.0);
        assertEquals(k.capacity, 15);
    }

    @Test
    public void knapsackAddItem() throws ItemInitException, KnapsackMaxCapacityAchievedException {
        Item i = new Item(1, 2.0, 3.0);
        Knapsack k = new Knapsack();
        k.add(i);
        assertEquals(k.getLength(), 1);
    }

    @Test(expected = KnapsackMaxCapacityAchievedException.class)
    public void knapsackAddItem_moreThenMaxCapacity() throws ItemInitException, KnapsackMaxCapacityAchievedException {
        Knapsack k = new Knapsack();
        for (int j = 0; j < k.capacity+2; j++) {
            Item i = new Item(1, 2.0, 3.0);
            k.add(i);
        }
    }
}
