package _4_lop_va_doi_tuong.bai_tap.xay_dung_lop_fan;

public class Fan {
    final int SLOW = 1;
    final int MEDIUM = 2;
    final int FAST = 3;
    private int speed = SLOW;
    private boolean isOn = false;
    private double radius = 5;
    private String color = "blue";

    Fan(int speed, boolean on, double radius, String color){
        this.speed = speed;
        this.isOn = on;
        this.radius = radius;
        this.color = color;
    }
    public int getSLOW() {
        return SLOW;
    }

    public int getMEDIUM() {
        return MEDIUM;
    }

    public int getFAST() {
        return FAST;
    }

    public String getSpeed() {
        String speedStr = "";
        if (this.isOn) {
            if (this.speed == getSLOW()) {
                speedStr = "SLOW";
            } else if (this.speed == getMEDIUM()) {
                speedStr = "MEDIUM";
            } else if (this.speed == getFAST()) {
                speedStr = "FAST";
            }
        }
        else {
            speedStr = "";
        }
        return speedStr;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        this.isOn = on;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String on(){
        String status = "";
        if (isOn){
            status = "Turning ON";
        }else {
            status = "Turning OFF";
        }
        return status;
    }

    public String toString() {
        String fan1 = "Speed: " + getSpeed()
                +". Radius: " + getRadius()
                + ". Color: " + getColor()
                + ". Status: " + on();
        return fan1;
    }

    public static void main(String[] args) {
        Fan fan2 = new Fan(1,true,2,"red");
        System.out.println(fan2.toString());
        fan2 = new Fan(3,false,2,"blue");
        System.out.println(fan2.toString());
    }
}
