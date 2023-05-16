package com.wbu.hw.dao;

import com.wbu.hw.entity.Fit;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

public class FitDao {
    //创建查询器
    QueryRunner qr = new QueryRunner(DBCommon.getDS());

    //查询所有配件
    public List<Fit> queryAllFit() {
        List<Fit> fitList = null;
        try {
            String sql = "select * from tb_fit";
            fitList = qr.query(sql, new BeanListHandler<>(Fit.class));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fitList;
    }

    //改变库存数量
    public int changeQty(String task_item) {
        int row = 0;
        try {
            String sql = "update tb_fit set fit_qty = fit_qty-1 where fit_name = ?";
            row = qr.execute(sql, task_item);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row;
    }

}
