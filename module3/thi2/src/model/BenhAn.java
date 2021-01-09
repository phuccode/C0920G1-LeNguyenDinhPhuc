package model;

public class BenhAn {
    int maBenhAn;
    String phuongPhap;
    String bacSi;

    public BenhAn(int maBenhAn, String phuongPhap, String bacSi) {
        this.maBenhAn = maBenhAn;
        this.phuongPhap = phuongPhap;
        this.bacSi = bacSi;
    }

    public BenhAn(String phuongPhap, String bacSi) {
        this.phuongPhap = phuongPhap;
        this.bacSi = bacSi;
    }

    public BenhAn() {
    }

    public int getMaBenhAn() {
        return maBenhAn;
    }

    public void setMaBenhAn(int maBenhAn) {
        this.maBenhAn = maBenhAn;
    }

    public String getPhuongPhap() {
        return phuongPhap;
    }

    public void setPhuongPhap(String phuongPhap) {
        this.phuongPhap = phuongPhap;
    }

    public String getBacSi() {
        return bacSi;
    }

    public void setBacSi(String bacSi) {
        this.bacSi = bacSi;
    }
}
