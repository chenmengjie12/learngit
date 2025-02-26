package com.example.VO;

public class CartVO {
    private int mid;
    private String mname;
    private String pic;
    private double price;
    private String realname;
    private int id;
    private int num;
    private int cid;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

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

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "CartVO{" +
                "mid=" + mid +
                ", mname='" + mname + '\'' +
                ", pic='" + pic + '\'' +
                ", price=" + price +
                ", realname='" + realname + '\'' +
                ", id=" + id +
                ", num=" + num +
                '}';
    }
}
