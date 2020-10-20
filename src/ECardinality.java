public enum ECardinality {
    NORTH("north"),
    SOUTH("south"),
    EAST("east"),
    WEST("west");

    private String value;

    ECardinality(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
