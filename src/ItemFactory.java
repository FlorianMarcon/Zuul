import java.util.ArrayList;
import java.util.List;

public class ItemFactory {
    
    private List<Item> items = new ArrayList<>();

    private int maxWeight;

    /**
     * Create an ItemFactory to handle items
     * 
     * @param maxWeight int representing maximum weight that factory can contained. Set to -1 to no maximum
     */
    public ItemFactory(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    /**
     * Create an ItemFactory to handle items without maximum height
     */
    public ItemFactory() {
        this.maxWeight = -1;
    }

    /**
     * Add an Item in the Factory
     * 
     * @param item to add to factory
     * @throws Error in case where we try to add too item that supported 
     */
    public void addItem(Item item) throws Error {
        Item itemContained = this.getItem(item.getName());

        if (itemContained == null)
            this.items.add(item);
        else {
            if (this.maxWeight != -1 && this.maxWeight + this.getTotalWeight() > this.maxWeight)
                throw new Error(item.getName() + " is too heavy");
            itemContained.setWeight(itemContained.getWeight() + item.getWeight());
        }
    }

    /**
     * Add an Item in the Factory
     * 
     * @param item to add to factory
     * @throws Error in case where item doesn't exist or you are trying to delete to much weight
     */
    public void removeItem(String itemName) throws Error {
        Item item = this.getItem(itemName);

        if (item == null)
            throw new Error("You don't have the " + itemName);
        else
            this.items.remove(item);
    }

    /**
     * Get total weight in the factory 
     * 
     * @return int representing total weight in the factory
     */
    private int getTotalWeight() {
        return this.items.stream()
        .mapToInt(Item::getWeight)
        .sum();
    }

    /**
     * Get an item
     * 
     * @param name Name of the item
     * @return item
     */
    public Item getItem(String name) {
        Item item = this.items.stream()
        .filter(i -> name.equals(i.getName()))
        .findAny()
        .orElse(null);

        return item;
    }

    /**
     * Get all items
     * 
     * @return List of item
     */
    public List<Item> getItems() {
        return this.items;
    }
}
