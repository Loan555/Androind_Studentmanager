package com.loan555.qlsinhvien_learnkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import org.w3c.dom.Text

class StudentAdapter(var context: Context, var studentList: StudentManager) : BaseAdapter() {

    class ViewHolder(row: View) {
        // run leen lan dau thi no khoi tao gia tri anh xa, run lan 2 lan 3 thi no chi cap nhat thoi
        var textViewName: TextView
        var textViewBirth: TextView
        var textViewPhone: TextView
        var textViewSpe: TextView
        var textViewUni: TextView

        init {
            textViewName = row.findViewById(R.id.textViewName) as TextView
            textViewBirth = row.findViewById(R.id.textViewBirth) as TextView
            textViewPhone = row.findViewById(R.id.textViewPhone) as TextView
            textViewSpe = row.findViewById(R.id.textViewSpe) as TextView
            textViewUni = row.findViewById(R.id.textViewEducation) as TextView
        }
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view: View?
        var viewHolder: ViewHolder
        if(convertView == null){//tao moi khi view null
            var layoutInflater: LayoutInflater = LayoutInflater.from(context)
            view = layoutInflater.inflate(R.layout.student_row,null)
            viewHolder = ViewHolder(view)
            view.tag= viewHolder
        }else{//
            view = convertView
            viewHolder= convertView.tag as ViewHolder
        }
        var student: Student = getItem(position) as Student
        viewHolder.textViewName.text = student.getName()
        viewHolder.textViewBirth.text = student.getBirth().toString()
        viewHolder.textViewPhone.text = student.getPhone()
        viewHolder.textViewSpe.text= student.getSpecialized()
        if(student.getIsUniversity())
        viewHolder.textViewUni.text="University"
        else viewHolder.textViewUni.text = "College"

        return view as View
    }

    override fun getItem(position: Int): Any {
        return studentList.getStudentList().get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return studentList.getSize()
    }
}