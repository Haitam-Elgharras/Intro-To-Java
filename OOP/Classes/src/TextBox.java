public class TextBox extends UIControl {

    public String text=""; // field

    public TextBox() {
        super(true);
        System.out.println("TextBox");
    }

    @Override
    public String toString() {
        return text;
    }

    public void setText(String text) { // method
        this.text = text;
    }

    public void clear() {
        text = "";
    }
    
}
