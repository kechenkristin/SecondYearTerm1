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

    public UggRock drawRock() {
        Random r1 = new Random();
        int randomNum = r1.nextInt(6);
        int size;
        if (randomNum < 3) {
            size = 1;
        } else if (randomNum < 5) {
            size = 3;
        } else {
            size = 5;
        }

        Random r2 = new Random();
        int type;
        double rNum = r2.nextInt();
        if (rNum < 0.25) {
            type = 7;
        } else if (rNum < 0.5) {
            type = 20;
        } else if (rNum < 0.75) {
            type = 15;
        } else {
            type = 2;
        }

        UggRock ret = new UggRock(7, 1);
        return ret;
    }
}
