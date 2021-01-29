package com.example.laba2_students

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class StudentsGroupActivity : AppCompatActivity() {
    companion object {
        val groupNumber = "groupNumber"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students_group)

        val grpNumber = intent.getStringExtra(groupNumber)
        if (grpNumber == null) { return }
        val group = StudentsGroup.getGroup(grpNumber)
        if (group == null) { return }
        val txtGroupNumber = findViewById<EditText>(R.id.grpNumberEdit)
        txtGroupNumber.setText(group.number)

        val txtFacultyName = findViewById<EditText>(R.id.facultyEdit)
        txtFacultyName.setText(group.facultyName)

        val txtImgGrp = findViewById<TextView>(R.id.grpNumberImageTxt)
        txtImgGrp.setText(group.number)

        val txtImgFaculty = findViewById<TextView>(R.id.facultyNameImageTxt)
        txtImgFaculty.setText(group.facultyName)

        if (group.educationLevel == 0) {
            findViewById<RadioButton>(R.id.edu_level_bachelor).isChecked = true
        } else {
            findViewById<RadioButton>(R.id.edu_level_master).isChecked = true
        }

        findViewById<CheckBox>(R.id.contract_flg).isChecked = group.contractExists
        findViewById<CheckBox>(R.id.privilege_flg).isChecked = group.isPrivileged
    }

    fun onOkBtnClick(view: View) {
        val group = findViewById<TextView>(R.id.grpNumberEdit).text ?: "" + "\n"
        val faculty = findViewById<TextView>(R.id.facultyEdit).text ?: "" + "\n"
        val isMaster = findViewById<RadioButton>(R.id.edu_level_master).isChecked ?: false
        val contracts = findViewById<CheckBox>(R.id.contract_flg).isChecked ?: false
        val privileged = findViewById<CheckBox>(R.id.privilege_flg).isChecked ?: false
        val outString = """
            Група $group
            Факультет $faculty
            рівень освіти - ${if (isMaster) "магістр" else "бакалавр" }
            ${if (contracts) "контрактники э" else "контрактників нема"}
            ${if (privileged) "э пільговики" else "пільговиків немаэ"}
        """.trimIndent()

        Toast.makeText(this, outString, Toast.LENGTH_LONG).show()
    }
}