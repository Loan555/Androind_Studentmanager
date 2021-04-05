package com.loan555.qlsinhvien_learnkotlin

import android.util.Log

class StudentManager {
    var studentArrayList: ArrayList<Student> = ArrayList()

    constructor()
    constructor(list: ArrayList<Student>) {
        this.studentArrayList = list
    }


    //    -----method
    fun addStudent(student: Student) { //--------add
        this.studentArrayList.add(student)
    }

    fun editStudent(index: Int, student: Student) {//    ------edit
        this.studentArrayList.set(index, student)
    }

    fun deleteStudent(student: Student) {//    -----------delete
        this.studentArrayList.remove(student)
    }

    //
    fun searchStudent(strSearch: String): StudentManager {//    ----------search
        var str = strSearch.toLowerCase()
        var arrResult: StudentManager = StudentManager()
        for (i in 0 until studentArrayList.size) {
            var stu: Student = studentArrayList.get(i)
            if (stu.getName().toLowerCase().contains(str)
                || stu.getPhone().toLowerCase().contains(str)
                || stu.getSpecialized().toLowerCase().contains(str)
                || stu.getBirth().toString().toLowerCase().contains(str)
            ) {
                Log.d("result", stu.toString())
                arrResult.addStudent(stu)
            }
        }
        return arrResult
    }

    //    ---------sort by name
    fun sortByName() {
        this.getStudentList().sortBy { it.getName() }
    }

    //    -------------sort by birth
    fun sortByBirth() {
        this.getStudentList().sortBy { it.getBirth() }
    }

    //    ---------------sort by specialized
    fun sortBySpecial() {
        this.getStudentList().sortBy { it.getSpecialized() }
    }

    //    -------------sort by phone
    fun sortByPhone() {
        this.getStudentList().sortBy { it.getPhone() }
    }

    //    ---------------Classify education
    fun classifyEducation(isUni: Boolean): StudentManager {
        var listUniversity: StudentManager = StudentManager()
        var listCollege: StudentManager = StudentManager()
        for (i in 0 until studentArrayList.size)
        if (studentArrayList.get(i).getIsUniversity()) {
            listUniversity.addStudent(studentArrayList.get(i))
        }else listCollege.addStudent(studentArrayList.get(i))

        return if ( isUni) listUniversity
        else listCollege
    }

    //-----get
    fun getStudentList(): ArrayList<Student> {
        return studentArrayList;
    }
//
    fun getSize(): Int{
        return this.studentArrayList.size
    }
}