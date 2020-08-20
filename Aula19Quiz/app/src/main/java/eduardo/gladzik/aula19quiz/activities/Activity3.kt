package eduardo.gladzik.aula19quiz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import eduardo.gladzik.aula19quiz.R
import eduardo.gladzik.aula19quiz.extension.toast
import eduardo.gladzik.aula19quiz.model.Quiz
import kotlinx.android.synthetic.main.activity_3.*

class Activity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        activity3ButtonNext.visibility = View.INVISIBLE

        Quiz.shuffleQuestions()
        val question = Quiz.questionsArray.get(0)

        getScore()

        activity3TextViewQuestion.text = question.questionDescription
        activity3RadioButtonA.text = question.option1
        activity3RadioButtonB.text = question.option2
        activity3RadioButtonC.text = question.option3
        activity3RadioButtonD.text = question.option4

        activity3ButtonConfirm.setOnClickListener {
            activity3ButtonNext.visibility = View.VISIBLE
            activity3ButtonConfirm.visibility = View.INVISIBLE

            val id = activity3RadioGroup.checkedRadioButtonId
            val radio: RadioButton = findViewById(id)

            if (Quiz.verifyTheCorrectAnswer(radio.text.toString())) {
                toast(R.string.toast_thats_correct)
            } else {
                toast(R.string.toast_thats_incorrect)
            }
        }

        activity3ButtonNext.setOnClickListener {
            startActivity(Intent(this@Activity3, Activity4::class.java))
            finish()
        }

    }

    fun getScore() {
        activity3TextViewScore.text = Quiz.score().toString()
    }
}