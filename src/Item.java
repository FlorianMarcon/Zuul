
public class Item {
    
    private int weight;
    private String name;

    public Item(String name, int weight) {
        this.weight = weight;
        this.name = name;
    }

    /**
     * Get Item weight
     * 
     * @return int representing item weight 
     */
    public int getWeight() {
        return this.weight;
    }

    /**
     * Get Item name
     * 
     * @return string representing name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set Item Weight
     * 
     * @param weight to set
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }
}
