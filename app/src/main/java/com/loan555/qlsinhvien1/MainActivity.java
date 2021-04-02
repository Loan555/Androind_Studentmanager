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
    Button buttonAdd, btSortName, btSortBirth, btSortPhone, btSortEsp, btDelete, btSearch, btUpdate, btClassUni, btClassCol;
    EditText editTextName, editTextPhoneNumber, editTextBirth, editTextSpecial, editTextSearch;
    RadioGroup radioGroup;
    TextView mgs;
    Boolean trainingSystem = true;
    int idClick = -1;
    int checkRadioButton = R.id.radioButtonUni;
    String phoneNumberClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ////        ------------------------Khoi tao
        listViewStudent = (ListView) findViewById(R.id.listViewStudent);

        mgs = (TextView) findViewById(R.id.textTraining);
        editTextSearch = (EditText) findViewById((R.id.editTextSearch));
        editTextName = (EditText) findViewById(R.id.editTextPersonName7);
        editTextBirth = (EditText) findViewById(R.id.editTextDate);
        editTextPhoneNumber = (EditText) findViewById(R.id.editTextPhone);
        editTextSpecial = (EditText) findViewById(R.id.editTextSpecialized);

        btSortName = (Button) findViewById(R.id.buttonSortName);
        btSortBirth = (Button) findViewById(R.id.buttonSortBirth);
        btSortPhone = (Button) findViewById(R.id.buttonSortPhone);
        btSortEsp = (Button) findViewById(R.id.buttonSortEsp);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        btDelete = (Button) findViewById(R.id.buttonDelete);
        btSearch = (Button) findViewById(R.id.buttonSearch);
        btUpdate = (Button) findViewById(R.id.buttonEdit);
        btClassUni = (Button) findViewById(R.id.buttonListUni);
        btClassCol = (Button) findViewById(R.id.buttonListCol);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);


        //---------------Nhap du lieu
        Student st1 = new Student("Adrew", 1999, "0332080038", "IT", true);
        Student st2 = new Student("Pham Nhat Vuong", 1995, "0332080039", "re", true);
        Student st3 = new Student("Bean Gate", 1998, "0123456789", "kt", false);
        Student st4 = new Student("Jack Ma", 2004, "0987543216", "qtkd", false);

        ArrayList<Student> arr = new ArrayList<>();
        arr.add(st1);
        arr.add(st2);
        arr.add(st3);
        arr.add(st4);

////        -------------------------create
        StudentManage studentManage = new StudentManage(arr);

        studentManage.editStudent(0, "Hâm", 2000, "343546", "fsdfd", true);
        //------------------ Index
        radioGroup.check(checkRadioButton);

        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, studentManage.getStudentLs());//tham soos: context: manf hinhf hieenr thij , dang layout no do ra,
        listViewStudent.setAdapter(arrayAdapter);//set adapter

////        ------------------------edit
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idClick > -1 && idClick < studentManage.getStudentLs().size()) {
                    studentManage.editStudent(idClick, inputName(), inputBirthYear(), inputPhoneNumber(), inputSpecialized(), inputIsUniversity());
                    idClick = -1;
                }
                ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, studentManage.getStudentLs());//tham soos: context: manf hinhf hieenr thij , dang layout no do ra,
                listViewStudent.setAdapter(arrayAdapter);//set adapter
            }
        });
//
////        ------------------------delete
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idClick > -1 && idClick < studentManage.getStudentLs().size()) {
                    studentManage.deleteStudent(idClick);
                    idClick = -1;
                }
                ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, studentManage.getStudentLs());//tham soos: context: manf hinhf hieenr thij , dang layout no do ra,
                listViewStudent.setAdapter(arrayAdapter);//set adapter
            }
        });

////        ------------------------search
        btSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strSearch = editTextSearch.getText().toString();
                ArrayAdapter adapterSearch = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, studentManage.searchStudent(strSearch));
                listViewStudent.setAdapter(adapterSearch);
            }
        });

////        ------------------------sort name
        btSortName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentManage.sortStudentByName();
                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, studentManage.getStudentLs());
                listViewStudent.setAdapter(adapter);
            }
        });

//        ---------------------sort birth
        btSortBirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentManage.sortStudentByBirthYear();
                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, studentManage.getStudentLs());
                listViewStudent.setAdapter(adapter);
//                arrayAdapter.notifyDataSetChanged();
            }
        });

//        ------------------------sort phone
        btSortPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentManage.sortStudentByPhoneNumber();
                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, studentManage.getStudentLs());
                listViewStudent.setAdapter(adapter);
//                arrayAdapter.notifyDataSetChanged();
            }
        });

//        ---------------------------sort esp
        btSortEsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                studentManage.sortStudentBySpecialized();
                ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, studentManage.getStudentLs());
                listViewStudent.setAdapter(adapter);
//                arrayAdapter.notifyDataSetChanged();
            }
        });

////--------------------------------classify
        btClassUni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, studentManage.classifyStudent(true));
                listViewStudent.setAdapter(arrayAdapter);
            }
        });

        btClassCol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, studentManage.classifyStudent(false));
                listViewStudent.setAdapter(arrayAdapter);
            }
        });

//        -----------------------ButtonAddClick
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = inputName();
                String phone = inputPhoneNumber().replaceAll("\\s+","");
                String birth = ""+inputBirthYear();
                String spe = inputSpecialized();
                int count=0;
                for(Student element : studentManage.getStudentLs()){
                    if(element.getPhoneNumber().equals(phone)){
                        count ++;
                        break;
                    }
                }

                if(count <= 0 && phone.matches("") == false && birth.matches("") == false && spe.matches("") == false){
                    studentManage.addStudent(name, inputBirthYear(), phone, spe, inputIsUniversity());
                    ArrayAdapter adapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, studentManage.getStudentLs());
                    listViewStudent.setAdapter(adapter);
                    mgs.setText("them thanh cong");
                }else {
                    mgs.setText("SDT da trung,tat ca cac truong phai not null"+count);
                }
            }
        });

//-----------ItemClick
        listViewStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String rs = "click!";
                Log.d("Result", rs);
                idClick = position;

                mgs.setText("id = " + idClick+"/" );

                editTextPhoneNumber.setText(studentManage.getStudentLs().get(position).getPhoneNumber().toString());
                editTextName.setText(studentManage.getStudentLs().get(position).getName().toString());
                editTextBirth.setText("" + studentManage.getStudentLs().get(position).getBirth());
                editTextSpecial.setText(studentManage.getStudentLs().get(position).getSpecialized().toString());

                trainingSystem = studentManage.getStudentLs().get(position).getUniversity();

                if (trainingSystem) {
                    checkRadioButton = R.id.radioButtonUni;
                } else
                    checkRadioButton = R.id.radioButtonCol;
                radioGroup.check(checkRadioButton);

            }
        });

        //------------radioButton----------

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButtonUni: {
                        trainingSystem = true;
                    }
                    break;
                    case R.id.radioButtonCol: {
                        trainingSystem = false;
                    }
                    break;
                }
            }
        });

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
        String name = editTextName.getText().toString();
        return name;
    }

    public int inputBirthYear() {
        //check input in here
        int birthYear = Integer.parseInt(editTextBirth.getText().toString());
        return birthYear;
    }

    public String inputPhoneNumber() {
        //check input in here
        String phoneNumber = editTextPhoneNumber.getText().toString();
        return phoneNumber;
    }

    public String inputSpecialized() {
        //check input in here
        String specialized = editTextSpecial.getText().toString();
        return specialized;
    }

    public Boolean inputIsUniversity() {
        //check input in here
        return trainingSystem;
    }

}