package com.wbu.hw.web;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wbu.hw.dao.FitDao;
import com.wbu.hw.dao.TaskDao;
import com.wbu.hw.entity.Fit;
import com.wbu.hw.entity.Task;
import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;


/**
 * web服务
 *
 * @author Lenovo
 */
public class MainServer {

    public static void main(String[] args) throws Exception {

        System.out.println("服务启动中...");
        //创建一个web服务 端口为80
        HttpServer server = HttpServer.create(new InetSocketAddress(80), 0);
        //设置访问时通过task来访问
        server.createContext("/task", new TestHandler());//TestHandler处理请求
        server.start();//启动线程
        System.out.println("web服务工作中...");

    }

    static class TestHandler implements HttpHandler {
        //创建全局的Dao(不用每次都建一个)
        TaskDao dao = new TaskDao();
        FitDao fitDao = new FitDao();
        //创建GSON工具
        Gson gson = new Gson();

        @Override
        public void handle(final HttpExchange exchange) {
            //为了加快处理速度 每来一个请求就新建一个线程来处理
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 获得查询字符串(get)
                        String queryString = exchange.getRequestURI().getQuery();
                        Map<String, String> queryStringInfo = formData2Dic(queryString);
                        // 获得表单提交数据(post)
                        String postString = IOUtils.toString(exchange.getRequestBody());
                        Map<String, String> postInfo = formData2Dic(postString);


                        //用来处理响应的类型 =========================================json
                        exchange.getResponseHeaders().add("Content-Type", "application/json");
                        //用来处理跨域==================================================所有人都可以访问
                        exchange.getResponseHeaders().add("Access-Control-Allow-Origin", "*");
                        //设置响应码 200 OK
                        exchange.sendResponseHeaders(200, 0);
                        //取得输出流
                        OutputStream os = exchange.getResponseBody();

                        //业务处理
                        String response = "{}";
                        //取得浏览器请求过来的方式
                        String method = exchange.getRequestMethod();
                        if (method.equals("POST") || method.equals("GET")) {
                            if (queryStringInfo.get("name").equals("query_all")) {
                                //调用Dao层查询
                                List<Task> taskList = dao.queryAllTask();
                                //将集合转成JOSN
                                String jsonList = gson.toJson(taskList);
                                response = jsonList;
                            }
                            if (queryStringInfo.get("name").equals("query_all_fit")) {
                                //调用Dao层查询
                                List<Fit> fitList = fitDao.queryAllFit();
                                //将集合转成JOSN
                                String jsonList = gson.toJson(fitList);
                                response = jsonList;
                            } else if (queryStringInfo.get("name").equals("save_task")) {
                                String cus_name = postInfo.get("cus_name");
                                String cus_phone = postInfo.get("cus_phone");
                                String task_item = postInfo.get("task_item");
                                String task_date = postInfo.get("task_date");
                                //System.out.println(cus_name);
                                //System.out.println(cus_phone);
                                //System.out.println(task_item);
                                int row = dao.saveTask(cus_name, cus_phone, task_item,task_date);
                                response = String.valueOf(row);
                            } else if (queryStringInfo.get("name").equals("delete_task")) {
                                String task_no = postInfo.get("task_no");
                                int row = dao.deleteTask(task_no);
                                response = String.valueOf(row);
                            } else if (queryStringInfo.get("name").equals("edit_status")) {
                                String task_no = postInfo.get("task_no");
                                String task_item = postInfo.get("task_item");
                                int task_status = Integer.parseInt(postInfo.get("task_status"));

                                int row = dao.editTaskStatus(task_no, task_status);
                                if (row == 1 && task_status == 2) {
                                    fitDao.changeQty(task_item);
                                }
                                response = String.valueOf(row);
                            }
                        }
                        //输出 将内容转成字符数据输出 编码
                        os.write(response.getBytes("UTF-8"));
                        os.close();
                    } catch (IOException ie) {
                        ie.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    /**
     * 专用于解析网页提交过来的数据 转成map类型
     *
     * @param formData
     * @return
     */
    public static Map<String, String> formData2Dic(String formData) {
        final Map<String, String> result = new HashMap<>();
        if (formData == null || formData.trim().length() == 0) {
            return result;
        }
        final String[] items = formData.split("&");
        Arrays.stream(items).forEach(item -> {
            final String[] keyAndVal = item.split("=");
            if (keyAndVal.length == 2) {
                try {
                    final String key = URLDecoder.decode(keyAndVal[0], "utf8");
                    final String val = URLDecoder.decode(keyAndVal[1], "utf8");
                    result.put(key, val);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        });
        return result;
    }
}
