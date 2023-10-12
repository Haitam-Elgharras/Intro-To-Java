import java.util.Arrays;
import java.util.Scanner;
public class RangeNotes {
    private float[] notes;
    private final Scanner scanner = new Scanner(System.in);
    public RangeNotes() {
        setSize();
        setNotes();
        sortNotes();
    }
    private void setNotes() {
        for (int i = 0; i < this.notes.length; i++) {
            System.out.println("Enter the note " + (i + 1) + ": ");
            this.notes[i] = scanner.nextFloat();
        }
    }
    private   void setSize() {
        System.out.println("Enter the number of notes: ");
        int n = scanner.nextInt();
        this.notes = new float[n];
    }
    private void sortNotes(){
        Arrays.sort(this.notes);
    }
    public  void printNotes() {
        for (int i = 0; i < this.notes.length; i++) {
            System.out.println("Note " + (i + 1) + ": " + this.notes[i]);
        }
    }

    public void getMoyenne(){
        float sum = 0;
        for (int i = 0; i < this.notes.length; i++) {
            sum += this.notes[i];
        }
        System.out.println("The average is: " + sum / this.notes.length);
    }
    public void getStudentsByNote(float note){
        int count = 0;
        for (float n : this.notes) {
            if (n == note) {
                count++;
            }
        }
        System.out.println("The number of students with the note " + note + " is: " + count);
    }

    public  void getMin() {
        System.out.println("The minimum is: " + this.notes[0]);
    }

    public  void getMax() {
        System.out.println("The maximum is: " + this.notes[this.notes.length - 1]);
    }

    public void getSize() {
        System.out.println("The number of notes is: " + this.notes.length);
    }

}




