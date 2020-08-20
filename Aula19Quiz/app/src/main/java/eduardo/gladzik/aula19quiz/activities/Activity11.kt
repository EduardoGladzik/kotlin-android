package eduardo.gladzik.aula19quiz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import eduardo.gladzik.aula19quiz.R
import eduardo.gladzik.aula19quiz.extension.toast
import eduardo.gladzik.aula19quiz.model.Quiz
import kotlinx.android.synthetic.main.activity_11.*
import kotlinx.android.synthetic.main.activity_7.*

class Activity11 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_11)
        activity11ButtonNext.visibility = View.INVISIBLE

        Quiz.shuffleQuestions()
        val question = Quiz.questionsArray.get(0)

        getScore()

        activity11TextViewQuestion.text = question.questionDescription
        activity11RadioButtonA.text = question.option1
        activity11RadioButtonB.text = question.option2
        activity11RadioButtonC.text = question.option3
        activity11RadioButtonD.text = question.option4

        activity11ButtonConfirm.setOnClickListener {
            activity11ButtonNext.visibility = View.VISIBLE
            activity11ButtonConfirm.visibility = View.INVISIBLE

            val id = activity11RadioGroup.checkedRadioButtonId
            val radio: RadioButton = findViewById(id)

            if (Quiz.verifyTheCorrectAnswer(radio.text.toString())) {
                toast(R.string.toast_thats_correct)
            } else {
                toast(R.string.toast_thats_incorrect)
            }
        }

        activity11ButtonNext.setOnClickListener {
            startActivity(Intent(this@Activity11, Activity12::class.java))
            finish()
        }
    }

    fun getScore() {
        activity11TextViewScore.text = Quiz.score().toString()
    }
}