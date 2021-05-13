package eduardo.gladzik.aula19quiz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import eduardo.gladzik.aula19quiz.R
import eduardo.gladzik.aula19quiz.extension.toast
import eduardo.gladzik.aula19quiz.extension.vibrate
import eduardo.gladzik.aula19quiz.model.Quiz
import kotlinx.android.synthetic.main.activity_7.*
import kotlinx.android.synthetic.main.activity_9.*

class Activity9 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_9)
        activity9ButtonNext.visibility = View.INVISIBLE

        Quiz.shuffleQuestions()
        val question = Quiz.questionsArray.get(0)

        getScore()

        activity9TextViewQuestion.text = question.questionDescription
        activity9RadioButtonA.text = question.option1
        activity9RadioButtonB.text = question.option2
        activity9RadioButtonC.text = question.option3
        activity9RadioButtonD.text = question.option4

        activity9ButtonConfirm.setOnClickListener {
            activity9ButtonNext.visibility = View.VISIBLE
            activity9ButtonConfirm.visibility = View.INVISIBLE

            val id = activity9RadioGroup.checkedRadioButtonId
            val radio: RadioButton = findViewById(id)

            if (Quiz.verifyTheCorrectAnswer(radio.text.toString())) {
                toast(R.string.toast_thats_correct)
            } else {
                toast(R.string.toast_thats_incorrect)
            }
        }

        activity9ButtonNext.setOnClickListener {
            vibrate()
            startActivity(Intent(this@Activity9, Activity10::class.java))
            finish()
        }

    }

    fun getScore() {
        activity9TextViewScore.text = Quiz.score().toString()
    }
}