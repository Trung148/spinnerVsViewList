package com.example.spinnervaviewlist

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SpinnerActivity : AppCompatActivity() {

    private val languages = listOf("Java", "Android", "PHP", "C#", "ASP.NET")
    private var selectedPosition = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner: Spinner = findViewById(R.id.spinnerLanguages)

        val adapter = object : ArrayAdapter<String>(this, R.layout.spinner_item_with_radio, R.id.textViewLanguage, languages) {

            override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

                val view = super.getView(position, convertView, parent)
                val radioButton = view.findViewById<RadioButton>(R.id.radioButton)
                radioButton.visibility = View.GONE
                return view
            }

            override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {

                val view = super.getDropDownView(position, convertView, parent)
                val radioButton = view.findViewById<RadioButton>(R.id.radioButton)
                val textView = view.findViewById<TextView>(R.id.textViewLanguage)


                radioButton.isChecked = position == selectedPosition


                view.setOnClickListener {
                    selectedPosition = position
                    notifyDataSetChanged()
                    spinner.setSelection(position)
                }
                radioButton.setOnClickListener {
                    selectedPosition = position
                    notifyDataSetChanged()
                    spinner.setSelection(position)
                }

                return view
            }
        }

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedPosition = position
                adapter.notifyDataSetChanged()
                Toast.makeText(this@SpinnerActivity, "Selected: ${languages[position]}", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }
}
