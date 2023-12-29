public class Axis {

    private final int unlockPosition;

    private int actualPosition;

    public Axis(int unlockPosition) {
        if (unlockPosition < Config.MINIMUM_SIZE || unlockPosition > Config.SIZE) {
            throw new IllegalArgumentException(String.format("unlockPosition cannot be greater than %d or less than %d", Config.SIZE, Config.MINIMUM_SIZE));
        }

        this.unlockPosition = unlockPosition;
        this.actualPosition = unlockPosition * (-1);
    }

    public int getUnlockPosition() {
        return unlockPosition;
    }

    public int getActualPosition() {
        return actualPosition;
    }

    public void move(int value) {
        int position = this.actualPosition + value;
        if (position > 0) {
            this.actualPosition = Config.SIZE - position;
        } else {
            this.actualPosition = position;
        }
    }
}
