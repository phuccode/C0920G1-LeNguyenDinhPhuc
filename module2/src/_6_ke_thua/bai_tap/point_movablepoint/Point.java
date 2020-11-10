package _6_ke_thua.bai_tap.point_movablepoint;

import java.util.Arrays;

public class Point {
    private float x = 0.0f;
    private float y = 0.0f;

    float arr[] = new float[2];
    Point(float x, float y){
        this.x = x;
        this.y = y;
    }

    Point(){
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

    public void setXY( float x, float y){
        this.x = x;
        this.y = y;
    }

    public float[] getXY(){
        arr[0] = this.x;
        arr[1] = this.y;
        return arr;
    }

    public String toString(){
        return "Mảng chứa x,y là "
                + Arrays.toString(getXY());
    }

    public static void main(String[] args) {
        Point point = new Point(2,3);
        System.out.println(point);
    }
}
