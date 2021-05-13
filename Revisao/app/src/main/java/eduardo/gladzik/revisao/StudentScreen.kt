package eduardo.gladzik.revisao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import eduardo.gladzik.revisao.model.Student

class StudentScreen : AppCompatActivity() {

    private val textStudentName by lazy { findViewById<EditText>(R.id.textStudentname) }
    private val textGrade1 by lazy { findViewById<EditText>(R.id.grade1) }
    private val textGrade2 by lazy { findViewById<EditText>(R.id.grade2) }
    private val buttonGrade by lazy { findViewById<Button>(R.id.buttonStudentGrade) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_screen)

        buttonGrade.setOnClickListener {
            val student = Student(textStudentName.text.toString(),
                textGrade1.text.toString().toDouble(),
                textGrade2.text.toString().toDouble())

            Toast.makeText(baseContext, student.verifyStudent(), Toast.LENGTH_LONG).show()
        }
    }

}