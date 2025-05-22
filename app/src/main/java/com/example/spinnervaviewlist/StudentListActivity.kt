package com.example.spinnervaviewlist

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
class StudentListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_list)

        val listView: ListView = findViewById(R.id.listViewStudents)


        val contacts = listOf(
            Contact("Nguyễn Văn A", "HE170001", Color.parseColor("#FF5733")),
            Contact("Trần Thị B", "HE170002", Color.parseColor("#4CAF50")),
            Contact("Lê Văn C", "HE170003", Color.parseColor("#3F51B5")),
            Contact("Phạm Thị D", "HE170004", Color.parseColor("#9C27B0"))
        )

        val adapter = CustomAdapter(this, contacts)
        listView.adapter = adapter
    }
}