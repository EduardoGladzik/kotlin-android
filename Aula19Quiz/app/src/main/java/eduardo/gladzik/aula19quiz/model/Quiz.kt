package eduardo.gladzik.aula19quiz.model

import android.graphics.drawable.Drawable
import eduardo.gladzik.aula19quiz.R

class Quiz {

    companion object {

        var questionsArray = ArrayList<Question>()

        init {
            generateQuestions()
            shuffleQuestions()
        }

        fun generateQuestions() {
            questionsArray.add(Question("What was the first Pokemon game?", "a. Red / Green", "b. Yellow", "c. Sun and Moon", "d. Unite", "a. Red / Green"))
            questionsArray.add(Question("Initial Aquatic pokemon of the second generation", "a. Squirtle", "b. Totodile", "c. Charmander", "d. Trecko", "b. Totodile"))
            questionsArray.add(Question("Whats the evolution of Bulbasaur?", "a. Chikorita", "b. Venusaur", "c. Ivysaur", "d. Dinossaur", "c. Ivysaur"))
            questionsArray.add(Question("Whats the GreatBall color?", "a. Red", "b. Yellow", "c. Purple", "d. Blue", "d. Blue"))
            questionsArray.add(Question("How many initials exists today? (Sword and Shield generation)", "a. 26", "b. 23", "c. 32", "d. 29", "a. 26"))
            questionsArray.add(Question("Who is the first grass initial", "a. Snivy", "b. Bulbasaur", "c. Chikorita", "d. Trecko", "b. Bulbasaur"))
            questionsArray.add(Question("How many Pokemon Leagues Ash Won? and Lose?", "a. 0/7", "b. 2/5", "c. 1/6", "d. 3/4", "c. 1/6"))
            questionsArray.add(Question("Whats the name of the Legendary bird of the Fire type", "a. Raikou", "b. Articuno", "c. Zapdos", "d. Moltres", "d. Moltres"))
            questionsArray.add(Question("Whats the name of the Legendary bird of the Ice type", "a. Articuno", "b. Zapdos", "c. Moltres", "d. Pikachu", "a. Articuno"))
            questionsArray.add(Question("Whats the name of the Legendary bird of the Eletric type", "a. Moltres", "b. Zapdos", "c. Articuno", "d. Ash", "b. Zapdos"))
            questionsArray.add(Question("Whats the name of the Legendary dog of the Fire type", "a. Suicune", "b. Raikou", "c. Entei", "d. Pikachu", "c. Entei"))
            questionsArray.add(Question("Whats the name of the Legendary dog of the Eletric type", "a. Entei", "b. Suicune", "c. Chikorita", "d. Raikou", "d. Raikou"))
            questionsArray.add(Question("Whats the name of the Legendary dog of the Aqua type", "a. Suicune", "b. Entei", "c. Raikou", "d. Diglet", "a. Suicune"))
            questionsArray.add(Question("Whats the Master Ball color?", "a. Blue", "b. Purple", "c. Red", "d. Yellow", "b. Purple"))
            questionsArray.add(Question("Whats the Ultra Ball color?", "a. Blue", "b. Purple", "c. Yellow", "d. Red", "c. Yellow"))
            questionsArray.add(Question("Whats the first aquatic initial?", "a. Totodile", "b. Greninja", "c. Omanite", "d. Squirtle", "d. Squirtle"))
            questionsArray.add(Question("Whats the First fire initial?", "a. Charmander", "b. Tepig", "c. Chimchar", "d. Fennekin", "a. Charmander"))
            questionsArray.add(Question("Eevee + Water Stone =", "a. Jolteon", "b. Vaporeon", "c. Flareon", "d. Espeon", "b. Vaporeon"))
            questionsArray.add(Question("Eevee + Thunder Stone =", "a. Vaporeon", "b. Flareon", "c. Jolteon", "d. Espeon", "c. Jolteon"))
            questionsArray.add(Question("Eevee + Fire Stone =", "a. Vaporeon", "b. Jolteon", "c. Espeon", "d. Flareon", "d. Flareon"))
            questionsArray.add(Question("Eevee + Sun Stone =", "a. Espeon", "b. Jolteon", "c. Flareon", "d. Vaporeon", "a. Espeon"))
            questionsArray.add(Question("Eevee + Moon Stone =", "a. Espeon", "b. Umbreon", "c. Flareon", "d. Jolteon", "b. Umbreon"))
            questionsArray.add(Question("Eevee + Leaf Stone =", "a. Espeon", "b. Umbreon", "c. Leafeon", "d. Jolteon", "c. Leafeon"))
            questionsArray.add(Question("Eevee + Ice Stone =", "a. Leafeon", "b. Espeon", "c. Flareon", "d. Glaceon", "d. Glaceon"))
            questionsArray.add(Question("Who was the Ash's first pokemon", "a. Pikachu", "b. Squirtle", "c. Bulbasaur", "d. Charmander", "a. Pikachu"))
            questionsArray.add(Question("How many badges are there in Kanto?", "a. 6", "b. 8", "c. 10", "d. 4", "b. 8"))
            questionsArray.add(Question("Witch badge Ash get to defeat Brock?", "a. Cascate", "b. Thunder", "c. Boulder", "d. Rainbow", "c. Boulder"))
            questionsArray.add(Question("Witch badge Ash get to defeat Mysti?", "a. Thunder", "b. Boulder", "c. Rainbow", "d. Cascate", "d. Cascate"))
            questionsArray.add(Question("Witch badge Ash get to defeat Surge?", "a. Thunder", "b. Soul", "c. Cascate", "d. Marsh", "a. Thunder"))
            questionsArray.add(Question("Witch badge Ash get to defeat Blaine?", "a. Rainbow", "b. Volcano", "c. Earth", "d. Boulder", "b. Volcano"))
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