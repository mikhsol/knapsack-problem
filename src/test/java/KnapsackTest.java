import com.mobiquityinc.exception.ItemInitException;
import com.mobiquityinc.exception.KnapsackInitException;
import com.mobiquityinc.exception.KnapsackMaxCapacityAchievedException;
import com.mobiquityinc.exception.KnapsackOverweightedException;
import com.mobiquityinc.packer.Item;
import com.mobiquityinc.packer.Knapsack;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertEquals;


@RunWith(Enclosed.class)
public class KnapsackTest {

    public static class NewKnapsackTest {

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

    }

    public static class KnapsackAddItem {

        private Knapsack k = new Knapsack();

        @Test
        public void knapsackAddItem()
                throws ItemInitException, KnapsackMaxCapacityAchievedException, KnapsackOverweightedException {
            Item i = new Item(1, 2.0, 3.0);
            this.k.add(i);
            assertEquals(k.getLength(), 1);
        }

        @Test(expected = KnapsackMaxCapacityAchievedException.class)
        public void knapsackAddItem_moreThenMaxCapacity()
                throws ItemInitException, KnapsackMaxCapacityAchievedException, KnapsackOverweightedException {
            this.fillKnapsack(this.k.capacity+2, 1.0);
        }

        @Test(expected = KnapsackOverweightedException.class)
        public void knapsackAddItem_overweight()
                throws ItemInitException, KnapsackMaxCapacityAchievedException, KnapsackOverweightedException {
            this.fillKnapsack(2, 100.0);
        }

        private void fillKnapsack(int capacity, double itemWeight)
                throws ItemInitException, KnapsackMaxCapacityAchievedException, KnapsackOverweightedException {
            for (int j = 0; j < capacity; j++) {
                Item i = new Item(1, itemWeight, 3.0);
                this.k.add(i);
            }
        }

    }

}
