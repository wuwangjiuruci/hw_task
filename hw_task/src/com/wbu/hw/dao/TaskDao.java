package com.wbu.hw.dao;

import com.wbu.hw.entity.Task;
import com.wbu.hw.util.CodeUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class TaskDao {
    //创建查询器
    QueryRunner qr = new QueryRunner(DBCommon.getDS());

//    public static void main(String[] args) {
//        List<Task> list = new TaskDao().queryAllTask();
//        for (Task task : list) {
//            System.out.println(task);
//        }
//    }

    public List<Task> queryAllTask() {
        List<Task> taskList = null;
        try {
            //SQL语句
            String sql = "select * from tb_task";
            //将查询结果放入taskList
            taskList = qr.query(sql, new BeanListHandler<>(Task.class));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return taskList;
    }

    public int saveTask(String cus_name, String cus_phone, String task_item,String task_date) {
        int row = 0;
        try {
            String sql = "insert into tb_task(task_no,cus_name,cus_phone,task_item,task_date,task_status) values(?,?,?,?,?,0)";
            row = qr.execute(sql, CodeUtils.getCode(), cus_name, cus_phone, task_item,task_date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

    public int deleteTask(String task_no) {
        int row = 0;
        try {
            String sql = "delete from tb_task where task_no = ?";
            row = qr.execute(sql, task_no);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }

    public int editTaskStatus(String task_no, int status) {
        int row = 0;
        try {
            String sql = "update tb_task set task_status=? where task_no=?";
            row = qr.execute(sql, status, task_no);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }

}
