import java.util.*;
public class Car {
    int id;
    ArrayList<Point> locations = new ArrayList<>();
    ArrayList<Ad> cache = new ArrayList<>();
    Ad lastDisplayed = null;
    Car(int id) {
        this.id = id;
    }
}
