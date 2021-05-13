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
import kotlinx.android.synthetic.main.activity_6.*
import kotlinx.android.synthetic.main.activity_7.*

class Activity7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_7)

        activity7ButtonNext.visibility = View.INVISIBLE

        Quiz.shuffleQuestions()
        val question = Quiz.questionsArray.get(0)

        getScore()

        activity7TextViewQuestion.text = question.questionDescription
        activity7RadioButtonA.text = question.option1
        activity7RadioButtonB.text = question.option2
        activity7RadioButtonC.text = question.option3
        activity7RadioButtonD.text = question.option4

        activity7ButtonConfirm.setOnClickListener {
            activity7ButtonNext.visibility = View.VISIBLE
            activity7ButtonConfirm.visibility = View.INVISIBLE

            val id = activity7RadioGroup.checkedRadioButtonId
            val radio: RadioButton = findViewById(id)

            if (Quiz.verifyTheCorrectAnswer(radio.text.toString())) {
                toast(R.string.toast_thats_correct)
            } else {
                toast(R.string.toast_thats_incorrect)
            }
        }

        activity7ButtonNext.setOnClickListener {
            vibrate()
            startActivity(Intent(this@Activity7, Activity8::class.java))
            finish()
        }
    }

    fun getScore() {
        activity7TextViewScore.text = Quiz.score().toString()
    }
}