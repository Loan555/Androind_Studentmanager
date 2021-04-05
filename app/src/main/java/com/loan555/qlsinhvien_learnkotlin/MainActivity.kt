package com.loan555.qlsinhvien_learnkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        ---------------start
        var student1: Student = Student("Loan",1999,"0332080038","CNTT",true)
        var st2: Student = Student("Tuan",1995,"034208984","DKCN",true)
        var st3: Student = Student("Dat",2000,"01234","Y",false)
        var studentList : StudentManager = StudentManager()
        studentList.addStudent(student1)
        studentList.addStudent(st2)
        studentList.addStudent(st3)

        var strResult: String

        studentList.editStudent(0,st2)

        for(i in 0 until studentList.getStudentList().size){
            Log.d("result",studentList.getStudentList().get(i).toString())
        }

//        studenList.deleteStudent(student1)
//        studentList.getStudentList().sortBy { it.getName() }
//        studentList.getStudentList().sortBy { it.getBirth() }
//        var stUni: StudentManager = studentList.classifyEducation(false)
        var stSearch : StudentManager = studentList.searchStudent("199")

            Log.d("result",stSearch.getStudentList().toString())

    }
}