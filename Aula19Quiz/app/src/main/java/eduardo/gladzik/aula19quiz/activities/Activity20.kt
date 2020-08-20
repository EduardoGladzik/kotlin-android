package eduardo.gladzik.aula19quiz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import eduardo.gladzik.aula19quiz.R
import eduardo.gladzik.aula19quiz.extension.toast
import eduardo.gladzik.aula19quiz.model.Quiz
import kotlinx.android.synthetic.main.activity_202.*
import kotlinx.android.synthetic.main.activity_7.*

class Activity20 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_202)

        activity20ButtonNext.visibility = View.INVISIBLE

        Quiz.shuffleQuestions()
        val question = Quiz.questionsArray.get(0)

        getScore()

        activity20TextViewQuestion.text = question.questionDescription
        activity20RadioButtonA.text = question.option1
        activity20RadioButtonB.text = question.option2
        activity20RadioButtonC.text = question.option3
        activity20RadioButtonD.text = question.option4

        activity20ButtonConfirm.setOnClickListener {
            activity20ButtonNext.visibility = View.VISIBLE
            activity20ButtonConfirm.visibility = View.INVISIBLE

            val id = activity20RadioGroup.checkedRadioButtonId
            val radio: RadioButton = findViewById(id)

            if (Quiz.verifyTheCorrectAnswer(radio.text.toString())) {
                toast(R.string.toast_thats_correct)
            } else {
                toast(R.string.toast_thats_incorrect)
            }
        }

        activity20ButtonNext.setOnClickListener {
            startActivity(Intent(this@Activity20, FinalActivity::class.java))
            finish()
        }
    }

    fun getScore() {
        activity20TextViewScore.text = Quiz.score().toString()
    }
}