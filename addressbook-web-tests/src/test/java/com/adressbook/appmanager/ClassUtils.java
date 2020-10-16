package com.adressbook.appmanager;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;

public abstract class ClassUtils {
    public static void getGenericParameterClass(Class actualClass) {

        ParameterizedType type = (ParameterizedType) actualClass.getGenericSuperclass();
        System.out.println(type);
        Class parameter = (Class)type.getActualTypeArguments()[0];
        System.out.println(parameter); // class java.lang.Float
//        return (Class) ((ParameterizedType) actualClass.getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
