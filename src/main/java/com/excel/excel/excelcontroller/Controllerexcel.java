package com.excel.excel.excelcontroller;

import com.excel.excel.util.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : yaobiao
 * @Description:
 * @time : 2019/12/15 16:34
 */
@Controller
@ResponseBody
public class Controllerexcel {

    @Autowired
    private ExcelUtil excelUtil;

    @GetMapping("/hello")
    public String test() {
        return "hello";
    }

    @GetMapping("/excel")
    public void excel(HttpServletResponse response) {
        try {//查找用户列表
            List<User> list = new ArrayList<>();
            list.add(new User("wo", "18"));
            list.add(new User("哈哈", "18"));
            //发送
            response.setContentType("application/x-execl");
            response.setHeader("Content-Disposition", "attachment;filename= " + new String("用户列表.xls".getBytes(), "ISO-8859-1"));
            ServletOutputStream outputStream = response.getOutputStream();
            excelUtil.excel(list, outputStream);
            if (outputStream != null) {
                outputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
