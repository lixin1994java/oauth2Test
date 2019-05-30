package com.oath2test.auth2server.entity;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;

class Test {

    private  String xixi="123"  ;
    String haha="456"  ;

   private class  a{
        private String aa= "789";
    }

    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        objects.add(1);
        objects.add(2);
        objects.add(3);
        objects.stream().limit(1).peek(e->{
            System.out.println(e);
        });


    }
}

class XiXi{
    public static void main(String[] args) {
        Test test = new Test();
        Class<? extends Test> aClass = test.getClass();
        Class<?> enclosingClass = aClass.getEnclosingClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            try {
                declaredField.setAccessible(true);
                System.out.println(declaredField.get(test));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }


    }
}


