package com.loan555.qlsinhvien1;
import  java.util.Comparator;

public class SortByBirth implements Comparator<Student>{
    @Override
    public int compare(Student st1,Student st2){
        if(st1.getBirth()>= st2.getBirth())
        return 1;
        else return -1;
    }
}
