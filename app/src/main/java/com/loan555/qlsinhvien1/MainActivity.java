package com.loan555.qlsinhvien1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String abc="Start";
        Log.d("Result",abc );

        //---------------Nhap du lieu
        Student st1=new Student("Nguyễn Thị Loan",1999,"0332080038","Công nghệ dữ liệu",true);
        Student  st2= new Student("Phạm Nhật Vượng",1995,"0332080039","Quản trị kinh doanh",true);
        Student st3= new Student("Bean Gate",1998,"0123456789","Kỹ Thuật Máy tính",false);
        Student st4=new Student("Jack Ma",2004,"0987543216","Kinh tế",false);

        ArrayList<Student> arr= new ArrayList<>();
        arr.add(st1);
        arr.add(st2);
        arr.add(st3);
        arr.add(st4);

////        -------------------------create
        StudentManage studentManage = new StudentManage(arr);
//////        ------------------------add
//        for (int i = 0; i < 9; i++) {
        studentManage.addStudent();
//        }
////        ------------------------edit
//        studentManage.editStudent(0);
////        ------------------------delete
//        studentManage.deleteStudent(1);
////        ------------------------search
        studentManage.searchStudent("kinh doanh");
////        ------------------------sort
        studentManage.sortStudentByName();
//        studentManage.sortStudentByBirthYear();
//        studentManage.sortStudentByPhoneNumber();
//        studentManage.sortStudentBySpecialized();
////--------------------------------classify
//        studentManage.classifyStudent(true);//tra ve danh sach sv la dai hoc
//        studentManage.classifyStudent(false);//tra ve danh sach sv la cao dang

////        ------------------------index
        String result="";
        result= "size:"+studentManage.getStudentLs().size()+"\n";
        Log.d("Result",result );

        studentManage.show();
    }
}