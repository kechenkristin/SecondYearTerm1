public class UggRock {

    // fields
    UggRockType type;
    UggRockSize size;

    public UggRockType getType() {
        return type;
    }

    public UggRockSize getSize() {
        return size;
    }

    // constructor
    public UggRock(UggRockType uggType, UggRockSize uggSize) {
        type = uggType;
        size = uggSize;
    }

    public int rockValue() {
        return type.getMultiplierValue() * size.getMultiplierValue();
    }

    @Override
    public String toString() {
        return type.toString() + size.toString();
    }



}
