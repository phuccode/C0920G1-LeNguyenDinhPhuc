package _6_ke_thua.bai_tap.point_movablepoint;

import java.util.Arrays;

public class MovablePoint extends Point {
    float xSpeed = 0.0f;
    float ySpeed = 0.0f;
    float[] newArray = new float[2];
    MovablePoint(){
    }

    MovablePoint(float x, float y, float xSpeed, float ySpeed){
        super(x,y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    MovablePoint(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }

    public void setSpeed(float xSpeed, float ySpeed){
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeed(){
        newArray[0] = this.xSpeed;
        newArray[1] = this.ySpeed;
        return newArray;
    }

    public String toString(){
        return super.toString()
                + " có Speed là "
                + Arrays.toString(getSpeed());
    }

    public MovablePoint move(){
        super.setX(super.getX() + xSpeed);
        super.setY(super.getY() + ySpeed);
        return this;
    }

    public static void main(String[] args) {
        MovablePoint movablePoint = new MovablePoint(1,2);
        System.out.println(movablePoint);
        System.out.println(movablePoint.move().toString());
    }
}
