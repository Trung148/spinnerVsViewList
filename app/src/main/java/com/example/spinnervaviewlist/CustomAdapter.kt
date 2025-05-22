package com.example.spinnervaviewlist


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class CustomAdapter(private val context: Context, private val contactList: List<Contact>) : BaseAdapter() {

    override fun getCount(): Int = contactList.size

    override fun getItem(position: Int): Any = contactList[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val inflater = LayoutInflater.from(context)
        val view = convertView ?: inflater.inflate(R.layout.row_contact, parent, false)

        val tvAvatar = view.findViewById<TextView>(R.id.tvAvatar)
        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvMSSV = view.findViewById<TextView>(R.id.tvMaSinhVien)

        val contact = contactList[position]

        tvAvatar.text = (position + 1).toString()
        tvAvatar.setBackgroundColor(contact.color)
        tvName.text = contact.name
        tvMSSV.text = contact.studentId

        return view
    }
}