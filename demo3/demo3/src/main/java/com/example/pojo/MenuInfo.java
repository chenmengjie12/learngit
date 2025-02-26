package com.example.pojo;

public class MenuInfo {
    private int mid;
    private String mname;
    private double price;
    private int num;
    private String pic;
    private int cid;
    private int sales;
    private String mcreatetime;

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public String getMcreatetime() {
        return mcreatetime;
    }

    public void setMcreatetime(String mcreatetime) {
        this.mcreatetime = mcreatetime;
    }

    @Override
    public String toString() {
        return "MenuInfo{" +
                "mid=" + mid +
                ", mname='" + mname + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", pic='" + pic + '\'' +
                ", cid=" + cid +
                ", sales=" + sales +
                ", mcreatetime='" + mcreatetime + '\'' +
                '}';
    }
}
