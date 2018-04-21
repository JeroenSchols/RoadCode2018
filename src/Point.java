public class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x; this.y = y;
    }

    long norm2() {
        return ((long) x)*x + ((long) y)y;
    }

    long dist2(Point p) {
        return ((long) x-p.x)*(x-p.x) + ((long) y-p.y)*(y-p.y);
    }
}
