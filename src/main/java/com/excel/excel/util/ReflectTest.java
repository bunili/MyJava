package com.excel.excel.util;

import com.excel.excel.excelcontroller.User;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : yaobiao
 * @Description:
 * @time : 2019/12/16 11:59
 */
@Component
public class ReflectTest {


    public <E> int reafect(List<E> list, String[] fileNames) {
        try {
            for (int i = 0; i < list.size(); i++) {
                E o = (E) list.get(i);
                Class cls = o.getClass();
                for (int j = 0; j < fileNames.length; j++) {
                    String fieldName = fileNames[j].substring(0, 1).toUpperCase() + fileNames[j].substring(1);
                    Method getMethod = cls.getMethod("get" + fieldName, new Class[0]);
                    Object value = getMethod.invoke(o, new Object[0]);

                    System.out.println(value.toString());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 1;
    }


    public void text() {
        List<User> list = new ArrayList<>();
        list.add(new User("大大", "10"));
        list.add(new User("小小", "50"));
        String[] fileName = {"name"};
        int i = reafect(list, fileName);
    }


}
