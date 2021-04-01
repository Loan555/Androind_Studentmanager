package com.loan555.qlsinhvien1;

import android.util.Log;

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
    //---------------check input----------
    public String inputName() {
        //check input in here
        String name = "name123";
        return name;
    }

    public int inputBirthYear() {
        //check input in here
        int birthYear = 1999;
        return birthYear;
    }

    public String inputPhoneNumber() {
        //check input in here
        String phoneNumber = "0332080038";
        return phoneNumber;
    }

    public String inputSpecialized() {
        //check input in here
        String specialized = "Công nghệ dữ liệu";
        return specialized;
    }

    public Boolean inputIsUniversity() {
        //check input in here
        Boolean university = true;
        return university;
    }

    //------------end check input----------
//    ------------------method-----------\
    public void show() {
        String result = "";
        for (Student element : studentLs) {
            result = result + "\n"+ element.toString() ;
        }
        Log.d("Result", result);
    }

    public void addStudent() {
        String name = inputName();
        int birth = inputBirthYear();
        String phoneNumber = inputPhoneNumber();
        String specialized = inputSpecialized();
        Boolean uni = inputIsUniversity();
        Student student = new Student(name, birth, phoneNumber, specialized, true);

        studentLs.add(student);

    }

    public void editStudent(int ID) {
        if (ID >= 0 && ID < this.studentLs.size()) {
            this.studentLs.get(ID).setName("z ong 5");

//            this.studentLs.get(ID).setName(inputName());
            this.studentLs.get(ID).setBirth(inputBirthYear());
            this.studentLs.get(ID).setPhoneNumber(inputPhoneNumber());
            this.studentLs.get(ID).setSpecialized(inputSpecialized());
            this.studentLs.get(ID).setUniversity(inputIsUniversity());
            Log.d("Result", "Edit student success!");
        } else Log.d("Result", "Student need to edit is not exist!");
    }

    public void deleteStudent(int ID) {
        if (ID >= 0 && ID < this.studentLs.size()) {
            this.studentLs.remove(studentLs.get(ID));
            Log.d("Result", "Remove student success!");
        } else Log.d("Result", "Student need to delete is not exist!");
    }

    public void searchStudent(String strSearch) {
        for (Student element : studentLs) {
            if (element.getName().contains(strSearch)) {
                Log.d("Result", element.toString());
            } else if (element.getPhoneNumber().contains(strSearch)) {
                Log.d("Result", element.toString());
            } else if (element.getSpecialized().contains(strSearch)) {
                Log.d("Result", element.toString());
            } else if ((element.getBirth() + "").contains(strSearch)) {
                Log.d("Result", element.toString());
            }
        }
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
