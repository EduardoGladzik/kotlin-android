package eduardo.gladzik.aula19quiz.model

import android.content.Context
import eduardo.gladzik.aula19quiz.R

class Quiz {

    companion object {
        var context: Context? = null
        var questionsArray = ArrayList<Question>()

//        init {
//            generateQuestions()
//            shuffleQuestions()
//        }

        fun generateQuestions() {
            questionsArray.add(Question(context!!.getString(R.string.question1), "a. Red / Green", "b. Yellow", "c. Sun and Moon", "d. Unite", "a. Red / Green"))
            questionsArray.add(Question(context!!.getString(R.string.question2), "a. Squirtle", "b. Totodile", "c. Charmander", "d. Trecko", "b. Totodile"))
            questionsArray.add(Question(context!!.getString(R.string.question3), "a. Chikorita", "b. Venusaur", "c. Ivysaur", "d. Dinossaur", "c. Ivysaur"))
            questionsArray.add(Question(context!!.getString(R.string.question4), "a. ${context!!.getString(R.string.red)}", "b. ${context!!.getString(R.string.yellow)}", "c. ${context!!.getString(R.string.purple)}", "d. ${context!!.getString(R.string.blue)}", "d. ${context!!.getString(R.string.blue)}"))
            questionsArray.add(Question(context!!.getString(R.string.question5), "a. 26", "b. 23", "c. 32", "d. 29", "a. 26"))
            questionsArray.add(Question(context!!.getString(R.string.question6), "a. Snivy", "b. Bulbasaur", "c. Chikorita", "d. Trecko", "b. Bulbasaur"))
            questionsArray.add(Question(context!!.getString(R.string.question7), "a. 0/7", "b. 2/5", "c. 1/6", "d. 3/4", "c. 1/6"))
            questionsArray.add(Question(context!!.getString(R.string.question8), "a. Raikou", "b. Articuno", "c. Zapdos", "d. Moltres", "d. Moltres"))
            questionsArray.add(Question(context!!.getString(R.string.question9), "a. Articuno", "b. Zapdos", "c. Moltres", "d. Pikachu", "a. Articuno"))
            questionsArray.add(Question(context!!.getString(R.string.question10), "a. Moltres", "b. Zapdos", "c. Articuno", "d. Ash", "b. Zapdos"))
            questionsArray.add(Question(context!!.getString(R.string.question11), "a. Suicune", "b. Raikou", "c. Entei", "d. Pikachu", "c. Entei"))
            questionsArray.add(Question(context!!.getString(R.string.question12), "a. Entei", "b. Suicune", "c. Chikorita", "d. Raikou", "d. Raikou"))
            questionsArray.add(Question(context!!.getString(R.string.question13), "a. Suicune", "b. Entei", "c. Raikou", "d. Diglet", "a. Suicune"))
            questionsArray.add(Question(context!!.getString(R.string.question14), "a. ${context!!.getString(R.string.blue)}", "b. ${context!!.getString(R.string.purple)}", "c. ${context!!.getString(R.string.red)}", "d. ${context!!.getString(R.string.yellow)}", "b. ${context!!.getString(R.string.purple)}"))
            questionsArray.add(Question(context!!.getString(R.string.question15), "a. ${context!!.getString(R.string.blue)}", "b. ${context!!.getString(R.string.purple)}", "c. ${context!!.getString(R.string.yellow)}", "d. ${context!!.getString(R.string.red)}", "c. ${context!!.getString(R.string.yellow)}"))
            questionsArray.add(Question(context!!.getString(R.string.question16), "a. Totodile", "b. Greninja", "c. Omanite", "d. Squirtle", "d. Squirtle"))
            questionsArray.add(Question(context!!.getString(R.string.question17), "a. Charmander", "b. Tepig", "c. Chimchar", "d. Fennekin", "a. Charmander"))
            questionsArray.add(Question(context!!.getString(R.string.question18), "a. Jolteon", "b. Vaporeon", "c. Flareon", "d. Espeon", "b. Vaporeon"))
            questionsArray.add(Question(context!!.getString(R.string.question19), "a. Vaporeon", "b. Flareon", "c. Jolteon", "d. Espeon", "c. Jolteon"))
            questionsArray.add(Question(context!!.getString(R.string.question20), "a. Vaporeon", "b. Jolteon", "c. Espeon", "d. Flareon", "d. Flareon"))
            questionsArray.add(Question(context!!.getString(R.string.question21), "a. Espeon", "b. Jolteon", "c. Flareon", "d. Vaporeon", "a. Espeon"))
            questionsArray.add(Question(context!!.getString(R.string.question22), "a. Espeon", "b. Umbreon", "c. Flareon", "d. Jolteon", "b. Umbreon"))
            questionsArray.add(Question(context!!.getString(R.string.question23), "a. Espeon", "b. Umbreon", "c. Leafeon", "d. Jolteon", "c. Leafeon"))
            questionsArray.add(Question(context!!.getString(R.string.question24), "a. Leafeon", "b. Espeon", "c. Flareon", "d. Glaceon", "d. Glaceon"))
            questionsArray.add(Question(context!!.getString(R.string.question25), "a. Pikachu", "b. Squirtle", "c. Bulbasaur", "d. Charmander", "a. Pikachu"))
            questionsArray.add(Question(context!!.getString(R.string.question26), "a. 6", "b. 8", "c. 10", "d. 4", "b. 8"))
            questionsArray.add(Question(context!!.getString(R.string.question27), "a. Cascate", "b. Thunder", "c. Boulder", "d. Rainbow", "c. Boulder"))
            questionsArray.add(Question(context!!.getString(R.string.question28), "a. Thunder", "b. Boulder", "c. Rainbow", "d. Cascate", "d. Cascate"))
            questionsArray.add(Question(context!!.getString(R.string.question29), "a. Thunder", "b. Soul", "c. Cascate", "d. Marsh", "a. Thunder"))
            questionsArray.add(Question(context!!.getString(R.string.question30), "a. Rainbow", "b. Volcano", "c. Earth", "d. Boulder", "b. Volcano"))
        }

        fun markAsRepeatedAnswer() {
            questionsArray.get(0).repeatedQuestion = true
        }

        fun shuffleQuestions() {
            while(questionsArray.get(0).repeatedQuestion) {
                questionsArray.shuffle()
            }
            markAsRepeatedAnswer()
        }

        fun score(): Int {
            var score = 0
            for(question in questionsArray) {
                if(question.correctAnswer) {
                    score++
                }
            }
            return score
        }

        fun verifyTheCorrectAnswer(answer: String): Boolean {
            if(answer.equals(questionsArray.get(0).corretOptionAnswer)) {
                questionsArray.get(0).correctAnswer = true
                return true
            } else {
                return false
            }
        }

        fun clearAll() {
            questionsArray.clear()
            generateQuestions()
        }

        fun checkAvarageCorrectAnswers(): Double {
            return (score() / 20.0) * 100
        }

        fun finalMessage(): String {
            if (checkAvarageCorrectAnswers() >= 100) {
                return "Master!"
            } else if (checkAvarageCorrectAnswers() >= 80) {
                return "Ultra!"
            } else if (checkAvarageCorrectAnswers() >= 50) {
                return "Great!"
            } else {
                return "Bad..."
            }
        }

        fun finalImagee(): Int {
            if(checkAvarageCorrectAnswers() >= 100) {
                return R.drawable.icon3
            } else if(checkAvarageCorrectAnswers() >= 80) {
                return R.drawable.icon5
            } else if(checkAvarageCorrectAnswers() >= 50) {
                return R.drawable.icon2
            } else {
                return R.drawable.icon4
            }
        }
    }
}