package com.loan555.qlsinhvien1;

import android.text.BoringLayout;
import android.util.Log;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collections;

public class StudentManage {
    private ArrayList<Student> studentLs;       // Student list

    public StudentManage() {
        ArrayList<Student> arr = new ArrayList<>();
        this.studentLs = arr;
    }

    public StudentManage(ArrayList<Student> stList) {
        this.studentLs = stList;
    }


    //    ----------get set-----------------
    public ArrayList<Student> getStudentLs() {
        return studentLs;
    }

    public void setStudentLs(ArrayList<Student> studentLs) {
        this.studentLs = studentLs;
    }

    //    --------------end get set---------

//    ------------------method-----------\
    public void show() {
        String result = "";
        for (Student element : studentLs) {
            result = result + "\n"+ element.toString() ;
        }
        Log.d("Result", result);
    }

    public void addStudent(String name, int birth, String phoneNumber, String specialized, Boolean uni) {
        Student student = new Student(name, birth, phoneNumber, specialized, uni);
        studentLs.add(student);
    }

    public void editStudent(int idStudent,String name, int birth, String phoneNumber, String specialized, Boolean uni) {

        if (idStudent >= 0 && idStudent < this.studentLs.size()) {
            Student studentEdit = new Student();
            studentEdit.setName(name);
            studentEdit.setBirth(birth);
            studentEdit.setPhoneNumber(phoneNumber);
            studentEdit.setSpecialized(specialized);
            studentEdit.setUniversity(uni);
            this.studentLs.set(idStudent,studentEdit);

            Log.d("Result", "Edit student success!");
        } else Log.d("Result", "Student need to edit is not exist!");
    }

    public void deleteStudent(int ID) {
        if (ID >= 0 && ID < this.studentLs.size()) {
            this.studentLs.remove(studentLs.get(ID));
            Log.d("Result", "Remove student success!");
        } else Log.d("Result", "Student need to delete is not exist!");
    }

    public ArrayList<Student> searchStudent(String strSearch) {
        ArrayList<Student> studentArrayListSearch = new ArrayList<>();
        strSearch = strSearch.toLowerCase();
        for (Student element : studentLs) {

            if(element.getName().toLowerCase().contains(strSearch) | element.getPhoneNumber().toLowerCase().contains(strSearch) | element.getSpecialized().toLowerCase().contains(strSearch) | (element.getBirth() + "").replaceAll("\\s+","").contains(strSearch))
            {
                studentArrayListSearch.add(element);
            }
        }
        return studentArrayListSearch;
    }

    public ArrayList<Student> classifyStudent(Boolean isUniversity) {
        ArrayList<Student> universityStudentList = new ArrayList<>();
        ArrayList<Student> notUniversityStudentList = new ArrayList<>();

        for (Student element : studentLs) {
            if (element.getUniversity()) {// neu la dai hoc
                universityStudentList.add(element);
            } else {
                notUniversityStudentList.add(element);
            }
        }
        if (isUniversity)
            return universityStudentList;
        else return notUniversityStudentList;
    }

    public void sortStudentByName() {
        Collections.sort(this.studentLs, new SortStudentByName());
    }

    public void sortStudentByBirthYear() {
        Collections.sort(this.studentLs, new SortByBirth());
    }

    public void sortStudentByPhoneNumber() {
        Collections.sort(this.studentLs, new SortStudentByPhone());
    }

    public void sortStudentBySpecialized() {
        Collections.sort(this.studentLs, new SortBySpecialized());
    }

//------------------------end method---------------
}
