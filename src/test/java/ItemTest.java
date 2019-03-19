import com.mobiquityinc.exception.ItemInitException;
import com.mobiquityinc.packer.Item;
import static junit.framework.TestCase.assertEquals;
import org.junit.Test;



public class ItemTest {

    @Test
    public void newItem() throws ItemInitException {
        Item i = new Item(1, 2.0, 3.0);
        assertEquals(i.id, 1);
        assertEquals(i.weight, 2.0);
        assertEquals(i.price, 3.0);
    }

    @Test(expected = ItemInitException.class)
    public void overweightItem_thrownAPIException() throws ItemInitException {
        new Item(1, 140.0, 3.0);
    }

    @Test(expected = ItemInitException.class)
    public void negativeWeightItem_thrownAPIException() throws ItemInitException {
        new Item(1, -140.0, 3.0);
    }

    @Test(expected = ItemInitException.class)
    public void maxCostItem_thrownAPIException() throws ItemInitException {
        new Item(1, 6.0, 150.0);
    }

}
