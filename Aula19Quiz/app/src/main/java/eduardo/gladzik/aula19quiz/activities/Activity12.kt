package eduardo.gladzik.aula19quiz.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import eduardo.gladzik.aula19quiz.R
import eduardo.gladzik.aula19quiz.extension.toast
import eduardo.gladzik.aula19quiz.model.Quiz
import kotlinx.android.synthetic.main.activity_12.*

class Activity12 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_12)
        activity12ButtonNext.visibility = View.INVISIBLE

        Quiz.shuffleQuestions()
        val question = Quiz.questionsArray.get(0)

        getScore()

        activity12TextViewQuestion.text = question.questionDescription
        activity12RadioButtonA.text = question.option1
        activity12RadioButtonB.text = question.option2
        activity12RadioButtonC.text = question.option3
        activity12RadioButtonD.text = question.option4

        activity12ButtonConfirm.setOnClickListener {
            activity12ButtonNext.visibility = View.VISIBLE
            activity12ButtonConfirm.visibility = View.INVISIBLE

            val id = activity12RadioGroup.checkedRadioButtonId
            val radio: RadioButton = findViewById(id)

            if (Quiz.verifyTheCorrectAnswer(radio.text.toString())) {
                toast(R.string.toast_thats_correct)
            } else {
                toast(R.string.toast_thats_incorrect)
            }
        }

        activity12ButtonNext.setOnClickListener {
            startActivity(Intent(this@Activity12, Activity13::class.java))
            finish()
        }
    }

    fun getScore() {
        activity13TextViewScore.text = Quiz.score().toString()
    }
}