package ke_thua.bai_tap.point2d_point3d;

import java.util.Arrays;

public class Point2D {
    float x = 0.0f;
    float y = 0.0f;
    float[] t = new float[2];
    Point2D(){
    }

    Point2D(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }

    public float[] getXY(){
        t[0] = this.x;
        t[1] = y;
        return t;
    }

    @Override
    public String toString() {
        return "mảng chứa x,y "
                + Arrays.toString(getXY());
    }

    public static void main(String[] args) {
        Point2D point2D1 = new Point2D();
        System.out.println(point2D1);
        Point2D point2D = new Point2D(1.0f,2.0f);
        System.out.println(point2D);
    }
}
