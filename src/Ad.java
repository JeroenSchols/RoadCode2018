public class Ad {
    int id;
    int P;
    int B;
    int B_Remaining;
    int R;
    int curGain = 0;
    Point c;

    public Ad(int id, int P, int B, int R, int x, int y) {
        this.id = id;
        this.P = P;
        this.B = B;
        B_Remaining = B;
        this.R = R;
        this.c = new Point(x, y);
    }

    boolean isNear(Point p) {
        return c.dist2(p) < ((long) R)*R;
    }
}
