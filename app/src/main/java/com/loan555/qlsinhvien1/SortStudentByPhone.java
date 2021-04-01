package com.loan555.qlsinhvien1;
import  java.util.Comparator;

public class SortStudentByPhone implements Comparator<Student>{
    @Override
    public int compare(Student st1,Student st2){
        return st1.getPhoneNumber().compareTo(st2.getPhoneNumber());
    }

}
