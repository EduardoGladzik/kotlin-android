package eduardo.gladzik.aula19quiz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import eduardo.gladzik.aula19quiz.R
import eduardo.gladzik.aula19quiz.extension.toast
import eduardo.gladzik.aula19quiz.model.Quiz
import kotlinx.android.synthetic.main.activity_10.*

class Activity10 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_10)

        activity10ButtonNext.visibility = View.INVISIBLE

        Quiz.shuffleQuestions()
        val question = Quiz.questionsArray.get(0)

        getScore()

        activity10TextViewQuestion.text = question.questionDescription
        activity10RadioButtonA.text = question.option1
        activity10RadioButtonB.text = question.option2
        activity10RadioButtonC.text = question.option3
        activity10RadioButtonD.text = question.option4

        activity10ButtonConfirm.setOnClickListener {
            activity10ButtonNext.visibility = View.VISIBLE
            activity10ButtonConfirm.visibility = View.INVISIBLE

            val id = activity10RadioGroup.checkedRadioButtonId
            val radio: RadioButton = findViewById(id)

            if (Quiz.verifyTheCorrectAnswer(radio.text.toString())) {
                toast(R.string.toast_thats_correct)
            } else {
                toast(R.string.toast_thats_incorrect)
            }
        }

        activity10ButtonNext.setOnClickListener {
            startActivity(Intent(this@Activity10, Activity11::class.java))
            finish()
        }

    }

    fun getScore() {
        activity11TextViewScore.text = Quiz.score().toString()
    }
}