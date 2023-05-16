package com.wbu.hw.entity;

public class Fit {
    private int fit_id;
    private String fit_no;
    private String fit_name;
    private int fit_qty;
    private String fit_city;

    public Fit() {
    }

    public Fit(int fit_id, String fit_no, String fit_name, int fit_qty, String fit_city) {
        this.fit_id = fit_id;
        this.fit_no = fit_no;
        this.fit_name = fit_name;
        this.fit_qty = fit_qty;
        this.fit_city = fit_city;
    }

    public int getFit_id() {
        return fit_id;
    }

    public void setFit_id(int fit_id) {
        this.fit_id = fit_id;
    }

    public String getFit_no() {
        return fit_no;
    }

    public void setFit_no(String fit_no) {
        this.fit_no = fit_no;
    }

    public String getFit_name() {
        return fit_name;
    }

    public void setFit_name(String fit_name) {
        this.fit_name = fit_name;
    }

    public int getFit_qty() {
        return fit_qty;
    }

    public void setFit_qty(int fit_qty) {
        this.fit_qty = fit_qty;
    }

    public String getFit_city() {
        return fit_city;
    }

    public void setFit_city(String fit_city) {
        this.fit_city = fit_city;
    }

    @Override
    public String toString() {
        return "Fit{" +
                "fit_id=" + fit_id +
                ", fit_no='" + fit_no + '\'' +
                ", fit_name='" + fit_name + '\'' +
                ", fit_qty=" + fit_qty +
                ", fit_city='" + fit_city + '\'' +
                '}';
    }
}
