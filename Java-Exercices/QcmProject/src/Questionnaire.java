import java.util.Scanner;


public class Questionnaire {
    private String titre;
    private Question[] questions = new Question[5];

    public void setQuestions() {
        // random questions
        this.questions[0]= new Question("Question 1", "Quelle est la capitale de la France?", new Reponse[4], 1);
        this.questions[1]= new Question("Question 2", "Quelle est la capitale de l'Allemagne?", new Reponse[4], 1);
        this.questions[2]= new Question("Question 3", "Quelle est la capitale de l'Espagne?", new Reponse[4], 1);
        this.questions[3]= new Question("Question 4", "Quelle est la capitale de l'Italie?", new Reponse[4], 1);
        this.questions[4]= new Question("Question 5", "Quelle est la capitale de la Belgique?", new Reponse[4], 1);

        // add just the correct answer
        this.questions[0].getReponses()[0] = new Reponse("Paris", true);
        this.questions[1].getReponses()[0] = new Reponse("Berlin", true);
        this.questions[2].getReponses()[0] = new Reponse("Madrid", true);
        this.questions[3].getReponses()[0] = new Reponse("Rome", true);
        this.questions[4].getReponses()[0] = new Reponse("Bruxelles", true);

        // an array of random answers for wrong answers
        String[] answers = {"Londres", "Amsterdam", "Lisbonne", "Athènes", "Budapest", "Varsovie", "Bucarest", "Sofia", "Prague", "Copenhague", "Stockholm", "Helsinki", "Oslo", "Dublin", "Vienne", "Luxembourg", "Nicosie", "La Valette", "Riga", "Vilnius", "Bratislava", "Ljubljana", "Tallinn", "Zagreb"};
        // we don't want a response to be repeated twice in the same question
        for (int i = 0; i < this.questions.length; i++) {
            int[] indexes = new int[3];
            for (int j = 1; j < this.questions[i].getReponses().length; j++) {
                int index = (int) (Math.random() * answers.length);
                while (isExist(indexes, index)) {
                    index = (int) (Math.random() * answers.length);
                }
                indexes[j - 1] = index;
                this.questions[i].getReponses()[j] = new Reponse(answers[index], false);
            }
        }

        // randomize the order of the responses
        for (int i = 0; i < this.questions.length; i++) {
            for (int j = 0; j < this.questions[i].getReponses().length; j++) {
                int index = (int) (Math.random() * this.questions[i].getReponses().length);
                Reponse temp = this.questions[i].getReponses()[j];
                this.questions[i].getReponses()[j] = this.questions[i].getReponses()[index];
                this.questions[i].getReponses()[index] = temp;
            }
        }
    }

    // check if the index is already in the array
    private boolean isExist(int[] indexes, int index) {
        for (int i = 0; i < indexes.length; i++) {
            if (indexes[i] == index) {
                return true;
            }
        }
        return false;
    }


    public Questionnaire(String titre) {
        this.titre = titre;
       setQuestions();
    }

    public void afficher(){
        // print each question separately after reading the user's answer
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        for (int i = 0; i < this.questions.length; i++) {
            System.out.println(this.questions[i].getTitre());
            System.out.println(this.questions[i].getDescription());
            for (int j = 0; j < this.questions[i].getReponses().length; j++) {
                System.out.println(j+1 +" " +this.questions[i].getReponses()[j].getTitre());
            }
            System.out.println("Enter your answer (1, 2, 3 or 4): ");
            int answer = scanner.nextInt();
            if (this.questions[i].getReponses()[answer - 1].isEstCorrecte()) {
                score += this.questions[i].getScore();
            }

        }
        System.out.println("Your score is: " + score);
    }

}
