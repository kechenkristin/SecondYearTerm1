public enum UggRockSize {
    BIGUN(5),
    QUITBIGUN(3),
    NOTSOBIGUN(1),
    ;

    private final int multiplierValue;

    UggRockSize(int value) {
        multiplierValue = value;
    }

    public int getMultiplierValue() {
        return multiplierValue;
    }
}
