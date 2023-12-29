import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Axis> axes = createAxes();
        Lock lock = new Lock(axes, 5); // <====  See image on resources for this line

        lock.unlock(new Key(Arrays.asList(
                4,
                6,
                7,
                3,
                9  // <====  See image on resources for this line
        )));

        if (lock.isLocked()) {
            System.err.println("Wrong key");
        } else {
            System.out.println("Successfully unlocked");
        }
    }

    private static List<Axis> createAxes() {
        Axis axis1 = new Axis(2);
        Axis axis2 = new Axis(4);
        Axis axis3 = new Axis(5);
        Axis axis4 = new Axis(1);
        Axis axis5 = new Axis(7); // <====  See image on resources for this line

        return Arrays.asList(axis1, axis2, axis3, axis4, axis5);
    }
}
