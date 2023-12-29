import java.util.List;

public class Lock {

    private final List<Axis> axes;
    private final int unlockLine;

    private boolean locked = true;

    public Lock(List<Axis> axes, int unlockLine) {
        if (unlockLine < Config.MINIMUM_SIZE || unlockLine > Config.SIZE) {
            throw new IllegalArgumentException(String.format("unlockLine cannot be greater than %d or less than %d", Config.SIZE, Config.MINIMUM_SIZE));
        }

        this.axes = axes;
        this.unlockLine = unlockLine;
    }

    public void unlock(Key key) {
        if (isUnlocked()) {
            return;
        }

        if (key.teeth().size() != axes.size()) {
            return;
        }

        for (int i = 0; i < axes.size(); i++) {
            Axis axis = axes.get(i);
            axis.move(key.teeth().get(i));

            boolean axisStillLocked = axis.getActualPosition() != unlockLine;
            if (axisStillLocked) {
                return;
            }
        }

        this.locked = false;
    }

    public boolean isLocked() {
        return locked;
    }

    public boolean isUnlocked() {
        return !locked;
    }
}
