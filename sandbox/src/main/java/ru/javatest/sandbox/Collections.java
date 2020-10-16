package ru.javatest.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {
    public static void main(String[] args) {
        String[] langs = new String[4];
        langs[0] = "Java";
        langs[1] = "C#";
        langs[2] = "Python";
        langs[3] = "Groovy";

        List<String> alist = Arrays.asList("args", "new", "fast");
        alist.add("Java");
        //alist.add("ff");
        //alist.add("dsd");

        for (String l:alist) {
            System.out.println(l);
        }
    }
}
