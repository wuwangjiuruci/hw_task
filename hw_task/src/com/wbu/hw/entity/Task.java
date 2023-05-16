package com.wbu.hw.entity;

public class Task {
    private int task_id;
    private String task_no;
    private String task_item;
    private String cus_name;
    private String cus_phone;
    private int task_status;
    private String task_date;

    public Task() {
    }

    public Task(int task_id, String task_no, String task_item, String cus_name, String cus_phone, int task_status, String task_date) {
        this.task_id = task_id;
        this.task_no = task_no;
        this.task_item = task_item;
        this.cus_name = cus_name;
        this.cus_phone = cus_phone;
        this.task_status = task_status;
        this.task_date = task_date;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public String getTask_no() {
        return task_no;
    }

    public void setTask_no(String task_no) {
        this.task_no = task_no;
    }

    public String getTask_item() {
        return task_item;
    }

    public void setTask_item(String task_item) {
        this.task_item = task_item;
    }

    public String getCus_name() {
        return cus_name;
    }

    public void setCus_name(String cus_name) {
        this.cus_name = cus_name;
    }

    public String getCus_phone() {
        return cus_phone;
    }

    public void setCus_phone(String cus_phone) {
        this.cus_phone = cus_phone;
    }

    public int getTask_status() {
        return task_status;
    }

    public void setTask_status(int task_status) {
        this.task_status = task_status;
    }

    public String getTask_date() {
        return task_date;
    }

    public void setTask_date(String task_date) {
        this.task_date = task_date;
    }

    @Override
    public String toString() {
        return "Task{" +
                "task_id=" + task_id +
                ", task_no='" + task_no + '\'' +
                ", task_item='" + task_item + '\'' +
                ", cus_name='" + cus_name + '\'' +
                ", cus_phone='" + cus_phone + '\'' +
                ", task_status=" + task_status +
                '}';
    }
}
