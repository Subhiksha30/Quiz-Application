import java.util.Scanner;

class Question {
    String question;
    String[] options;
    char correctAnswer;

    public Question(String question, String[] options, char correctAnswer) {
        this.question = question;
        this.options = options;
        this.correctAnswer = correctAnswer;
    }

    public boolean askQuestion(Scanner sc) {
        System.out.println("\n" + question);
        char optionChar = 'A';
        for (String option : options) {
            System.out.println(optionChar + ") " + option);
            optionChar++;
        }
        System.out.print("Your answer (A/B/C/D): ");
        char answer = Character.toUpperCase(sc.next().charAt(0));
        return answer == correctAnswer;
    }
}

public class QuizApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Question[] questions = {
            new Question("What is the capital of India?", new String[]{"Mumbai", "Delhi", "Kolkata", "Chennai"}, 'B'),
            new Question("Which planet is known as the Red Planet?", new String[]{"Earth", "Venus", "Mars", "Jupiter"}, 'C'),
            new Question("Java is a ___ language.", new String[]{"Markup", "Scripting", "Programming", "Query"}, 'C'),
            new Question("Who invented Java?", new String[]{"Dennis Ritchie", "James Gosling", "Guido van Rossum", "Bjarne Stroustrup"}, 'B'),
            new Question("What is 10 + 20?", new String[]{"25", "30", "35", "40"}, 'B')
        };

        int score = 0;

        System.out.println("Welcome to the Java Quiz!");
        System.out.println("-------------------------");

        for (Question q : questions) {
            boolean correct = q.askQuestion(sc);
            if (correct) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong!");
            }
        }

        System.out.println("\n Quiz Completed!");
        System.out.println("Your score: " + score + " out of " + questions.length);
    }
}
