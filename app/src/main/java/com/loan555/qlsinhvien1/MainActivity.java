package com.loan555.qlsinhvien1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listViewStudent;
    Button buttonAdd, btSortName, btSortBirth, btSortPhone, btSortEsp, btDelete;
    EditText editTextName;
    EditText editTextPhoneNumber;
    EditText editTextBirth;
    EditText editTextSpecial;
    RadioButton university, college;
    TextView mgs;
    Boolean trainingSystem;
    int idClickToDelete = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ////        ------------------------Khoi tao
        btSortName = (Button) findViewById(R.id.buttonSortName);
        btSortBirth = (Button) findViewById(R.id.buttonSortBirth);
        btSortPhone = (Button) findViewById(R.id.buttonSortPhone);
        btSortEsp = (Button) findViewById(R.id.buttonSortEsp);
        listViewStudent = (ListView) findViewById(R.id.listViewStudent);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        mgs = (TextView) findViewById(R.id.textTraining);
        btDelete = (Button)findViewById(R.id.buttonDelete);


        //---------------Nhap du lieu
        Student st1 = new Student("Nguyễn Thị Loan", 1999, "0332080038", "Công nghệ dữ liệu", true);
        Student st2 = new Student("Phạm Nhật Vượng", 1995, "0332080039", "Quản trị kinh doanh", true);
        Student st3 = new Student("Bean Gate", 1998, "0123456789", "Kỹ Thuật Máy tính", false);
        Student st4 = new Student("Jack Ma", 2004, "0987543216", "Kinh tế", false);

        ArrayList<Student> arr = new ArrayList<>();
        arr.add(st1);
        arr.add(st2);
        arr.add(st3);
        arr.add(st4);

////        -------------------------create
        StudentManage studentManage = new StudentManage(arr);
        //------------------ Index
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, studentManage.getStudentLs());//tham soos: context: manf hinhf hieenr thij , dang layout no do ra,
        listViewStudent.setAdapter(arrayAdapter);//set adapter

////        ------------------------edit
//        studentManage.editStudent(0);
////        ------------------------delete
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(idClickToDelete>-1 && idClickToDelete<studentManage.getStudentLs().size()) {
                    studentManage.deleteStudent(idClickToDelete);
                    idClickToDelete = -1;
                }
                arrayAdapter.notifyDataSetChanged();
            }
        });
//        studentManage.deleteStudent(1);
////        ------------------------search
//        studentManage.searchStudent("kinh doanh");
////        ------------------------sort name
        btSortName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentManage.sortStudentByName();
                arrayAdapter.notifyDataSetChanged();
            }
        });
//        ---------------------sort birth
        btSortBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentManage.sortStudentByBirthYear();
                arrayAdapter.notifyDataSetChanged();
            }
        });
//        ------------------------sort phone
        btSortPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentManage.sortStudentByPhoneNumber();
                arrayAdapter.notifyDataSetChanged();
            }
        });
//        ---------------------------sort esp
        btSortEsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentManage.sortStudentBySpecialized();
                arrayAdapter.notifyDataSetChanged();
            }
        });

////--------------------------------classify
//        studentManage.classifyStudent(true);//tra ve danh sach sv la dai hoc
//        studentManage.classifyStudent(false);//tra ve danh sach sv la cao dang


//        -----------------------ButtonAddClick
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentManage.addStudent(inputName(), inputBirthYear(), inputPhoneNumber(), inputSpecialized(), inputIsUniversity());
                arrayAdapter.notifyDataSetChanged();
            }
        });


//-----------ItemClick
        listViewStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String rs="click!";
                Log.d("Result",rs);
                mgs.setText(studentManage.getStudentLs().get(position).getName());
                idClickToDelete = position;
                //editTextName.setText("studentManage.getStudentLs().get(position).getName()");
            }
        });

        listViewStudent.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Long click", Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        //------------radioButton----------

        university = (RadioButton) findViewById(R.id.radioButtonUni);
        college = (RadioButton) findViewById(R.id.radioButtonCol);

        university.setOnCheckedChangeListener(listener);
        college.setOnCheckedChangeListener(listener);
    }

    //---------------check input----------

    CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            String onCheck = buttonView.getText().toString();
            if (onCheck == "College")
                trainingSystem = false;
            else
                trainingSystem = true;
        }
    };

    public String inputName() {
        //check input in here
        editTextName = (EditText) findViewById(R.id.editTextPersonName7);
        String name = editTextName.getText().toString();
        return name;
    }

    public int inputBirthYear() {
        //check input in here
        editTextBirth = (EditText) findViewById(R.id.editTextDate);
        int birthYear = Integer.parseInt(editTextBirth.getText().toString());
        return birthYear;
    }

    public String inputPhoneNumber() {
        //check input in here
        editTextPhoneNumber = (EditText) findViewById(R.id.editTextPhone);
        String phoneNumber = editTextPhoneNumber.getText().toString();
        return phoneNumber;
    }

    public String inputSpecialized() {
        //check input in here
        editTextSpecial = (EditText) findViewById(R.id.editTextSpecialized);
        String specialized = editTextSpecial.getText().toString();
        return specialized;
    }

    public Boolean inputIsUniversity() {
        //check input in here
        return trainingSystem;
    }

}