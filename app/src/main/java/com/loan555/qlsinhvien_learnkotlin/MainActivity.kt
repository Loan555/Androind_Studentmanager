package com.loan555.qlsinhvien_learnkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        ---------------start
        var idClick: Int = -1

        var student1: Student = Student("Loan", 1999, "0332080038", "CNTT", true)
        var st2: Student = Student("Tuan", 1995, "034208984", "DKCN", true)
        var st3: Student = Student("Dat", 2000, "01234", "Y", false)
        var studentList: StudentManager = StudentManager()
        studentList.addStudent(student1)
        studentList.addStudent(st2)
        studentList.addStudent(st3)
//--------index
        listViewStudent.adapter = StudentAdapter(this, studentList)
//        ------------add
        buttonAdd.setOnClickListener {
            var newStudent: Student =
                Student(
                    inputName(),
                    inputBirth(),
                    inputPhone(studentList),
                    inputSpecialize(),
                    inputEducation()
                )
            if (newStudent.getName() == "" || newStudent.getBirth() < 1900 || newStudent.getBirth() > 2020 || newStudent.getPhone() == "" || newStudent.getSpecialized() == "") {
                Toast.makeText(
                    this,
                    "Bạn phải nhập đủ các ô và không được trùng sdt, 2020> năm sinh >1990!",
                    Toast.LENGTH_SHORT
                ).show()
                Log.d("result", "ko cho theem" + newStudent.toString())
            } else {
                studentList.addStudent(newStudent)
                listViewStudent.adapter = StudentAdapter(this, studentList)
            }
        }
//        ------------edit
        buttonEdit.setOnClickListener {
            var newStudent: Student = Student(
                inputName(),
                inputBirth(),
                editTextDate.text.toString(),
                inputSpecialize(),
                inputEducation()
            )
            if (newStudent.getName() == "" || newStudent.getBirth() < 1900 || newStudent.getBirth() > 2020 || newStudent.getPhone() == "" || newStudent.getSpecialized() == "") {
                Toast.makeText(
                    this,
                    "Bạn phải nhập đủ các ô và không được trùng sdt, 2020> năm sinh >1990!",
                    Toast.LENGTH_SHORT
                ).show()
                Log.d("result", "ko cho sua" + newStudent.toString())
            } else {
                if (idClick >= 0 && idClick < studentList.getSize()) {
                    studentList.editStudent(idClick, newStudent)
                    idClick = -1
                    listViewStudent.adapter = StudentAdapter(this, studentList)
                }
            }
        }

//        ------------delete
        buttonDelete.setOnClickListener {
            if (idClick >= 0 && idClick < studentList.getSize()) {
                studentList.deleteStudent(studentList.getStudentList().get(idClick))
                idClick = -1
                listViewStudent.adapter = StudentAdapter(this, studentList)
            }
        }

//      --------------sort by name
        buttonSortName.setOnClickListener {
            studentList.sortByName()
            listViewStudent.adapter = StudentAdapter(this, studentList)
        }
//        ----------sort by birth
        buttonSortBirth.setOnClickListener {
            studentList.sortByBirth()
            listViewStudent.adapter = StudentAdapter(this, studentList)
        }
//        -----------sort by spe
        buttonSortEsp.setOnClickListener {
            studentList.sortBySpecial()
            listViewStudent.adapter = StudentAdapter(this, studentList)
        }
//        ------------sort by phone
        buttonSortPhone.setOnClickListener {
            studentList.sortByPhone()
            listViewStudent.adapter = StudentAdapter(this, studentList)
        }

//        -------------classification education
        buttonListUni.setOnClickListener {
            var stListUni: StudentManager = studentList.classifyEducation(true)
            listViewStudent.adapter = StudentAdapter(this, stListUni)
        }

        buttonListCol.setOnClickListener {
            var stListCollege: StudentManager = studentList.classifyEducation(false)
            listViewStudent.adapter = StudentAdapter(this, stListCollege)
        }

//        -----------search
        buttonSearch.setOnClickListener {
            var stSrearch: StudentManager =
                studentList.searchStudent(editTextSearch.text.toString())
            listViewStudent.adapter = StudentAdapter(this, stSrearch)
        }

        listViewStudent.setOnItemClickListener { parent, view, position, id ->
            var stclick: Student = studentList.getStudentList().get(position)
            editTextPersonName.setText(stclick.getName())
            editTextDate.setText(stclick.getBirth().toString())
            editTextSpecialized.setText(stclick.getSpecialized())
            editTextPhone.setText(stclick.getPhone())
            idClick = position

            if (stclick.getIsUniversity()) {
                radioGroup.check(radioButtonUni.id)
            } else radioGroup.check(radioButtonCol.id)

            Log.d("result", "ban chon:" + stclick.toString())
        }
    }

    private fun inputName(): String {
        return editTextPersonName.text.toString()
    }

    private fun inputBirth(): Int {
        return editTextDate.text.toString().toInt()
    }

    private fun inputSpecialize(): String {
        return editTextSpecialized.text.toString()
    }

    private fun inputPhone(studentList: StudentManager): String {
        var phone: String = editTextPhone.text.toString()
        var checkPhone: Boolean = false
        for (i in 0 until studentList.getSize()) {
            if (studentList.getStudentList().get(i).getPhone() == phone) {
                checkPhone = true
                break
            }
        }
        return if (checkPhone)
            ""
        else phone
    }

    private fun inputEducation(): Boolean {
        return radioButtonUni.isChecked
    }

}