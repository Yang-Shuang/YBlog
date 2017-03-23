package com.yang.base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by YangShuang
 * on 2017/3/23.
 */
public class BaseBean {
    private int errorCode;
    private String errorMsg;

    public BaseBean(){
    }

    public BaseBean(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void toJsonData() throws IllegalAccessException {
        Class c = this.getClass();
//        Field[] fields = c.getDeclaredFields();
//        for (Field field : fields){
//            System.out.print(field.get(t));
//        }
        Method[] methods = c.getMethods();
        for (Method method : methods){
            if(method.getName().startsWith("get") && !method.getName().equals("getClass"))
                try {
                    System.out.print(method.invoke(this,null)+"\n");
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
        }
    }
}
