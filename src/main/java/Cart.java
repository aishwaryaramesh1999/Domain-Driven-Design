import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Item> itemList = new ArrayList<>();
    private List<Item> deletedItemList = new ArrayList<>();


    public boolean addItem(Item item) {
        return itemList.add(item);
    }

    public boolean removeItem(Item item) {
        if (itemList.contains(item)) {
            deletedItemList.add(item);
            return itemList.remove(item);
        }
        return false;
    }

    public List<Item> getDeletedItem() {
        return deletedItemList;
    }

    public List<Item> getItems() {
        return itemList;
    }
}
