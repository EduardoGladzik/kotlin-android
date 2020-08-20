package eduardo.gladzik.aula19quiz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import eduardo.gladzik.aula19quiz.R
import eduardo.gladzik.aula19quiz.extension.toast
import eduardo.gladzik.aula19quiz.model.Quiz
import kotlinx.android.synthetic.main.activity_17.*
import kotlinx.android.synthetic.main.activity_7.*

class Activity17 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_17)

        activity17ButtonNext.visibility = View.INVISIBLE

        Quiz.shuffleQuestions()
        val question = Quiz.questionsArray.get(0)

        getScore()

        activity17TextViewQuestion.text = question.questionDescription
        activity17RadioButtonA.text = question.option1
        activity17RadioButtonB.text = question.option2
        activity17RadioButtonC.text = question.option3
        activity17RadioButtonD.text = question.option4

        activity17ButtonConfirm.setOnClickListener {
            activity17ButtonNext.visibility = View.VISIBLE
            activity17ButtonConfirm.visibility = View.INVISIBLE

            val id = activity17RadioGroup.checkedRadioButtonId
            val radio: RadioButton = findViewById(id)

            if (Quiz.verifyTheCorrectAnswer(radio.text.toString())) {
                toast(R.string.toast_thats_correct)
            } else {
                toast(R.string.toast_thats_incorrect)
            }
        }

        activity17ButtonNext.setOnClickListener {
            startActivity(Intent(this@Activity17, Activity18::class.java))
            finish()
        }
    }

    fun getScore() {
        activity17TextViewScore.text = Quiz.score().toString()
    }
}