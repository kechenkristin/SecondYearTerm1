import java.util.Random;

public class Ugg {

    // nested enum class
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

    // nested uggRock class
    static class UggRock {
        // fields
        private UggRockType type;
        private UggRockSize size;

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

    public UggRock drawRock() {
        Random r1 = new Random();
        double randomSize = r1.nextDouble();
        UggRockSize size;
        if (randomSize < 6.0 / 9.0) {
            size = UggRockSize.NOTSOBIGUN;
        } else if (randomSize < 8.0 / 9.0) {
            size = UggRockSize.QUITBIGUN;
        } else {
            size = UggRockSize.BIGUN;
        }

        Random r2 = new Random();
        double randomType = r2.nextDouble();
        UggRockType type;
        if (randomType < 0.25) {
            type = UggRockType.SPECKLY;
        } else if (randomType < 0.5) {
            type = UggRockType.OUCHYBLACK;
        } else if (randomType < 0.75) {
            type = UggRockType.FLOATY;
        } else {
            type = UggRockType.HOTHOTHOT;
        }

        return new UggRock(type, size);
    }

    public static void main(String[] args) {
        System.out.println("hello");
    }
}
