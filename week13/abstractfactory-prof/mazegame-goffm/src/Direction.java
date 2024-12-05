public enum Direction {
    EAST(0), WEST(1), SOUTH(2), NORTH(3);

    private int _value;

    Direction(int Value) {
        this._value = Value;
    }

    public int getValue() {
        return _value;
    }
}
