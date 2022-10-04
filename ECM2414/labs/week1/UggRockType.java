public enum UggRockType {
    SPECKLY(7),
    OUCHYBLACK(20),
    FLOATY(2),
    HOTHOTHOT(15);

    private final int multiplierValue;

    UggRockType(int multiplierValue) {
        this.multiplierValue = multiplierValue;
    }

    public int getMultiplierValue() {
        return multiplierValue;
    }
}
