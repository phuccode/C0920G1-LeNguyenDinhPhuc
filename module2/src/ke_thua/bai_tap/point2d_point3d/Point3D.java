package ke_thua.bai_tap.point2d_point3d;

import java.util.Arrays;

public class Point3D extends Point2D {
    float z = 0.0f;
    float[] k = new float[3];

    Point3D( float x, float y, float z){
        super(x, y);
        this.z = z;
    }

    Point3D(){
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public float[] getXYZ(){
        k[0] = super.getX();
        k[1] = super.getY();
        k[2] = this.z;
        return k;
    }

    @Override

    public String toString(){
        return "mảng chứa x,y,z "
                + Arrays.toString(getXYZ());
    }

    public static void main(String[] args) {
        Point3D point3D = new Point3D(1.2f,2.3f,4.6f);
        System.out.println(point3D);
    }
}
