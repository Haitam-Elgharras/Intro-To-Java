public final class TextBox extends UIControl {

    public String text=""; // field

    public TextBox() {
        // super(true);
        // System.out.println("TextBox");
    }

    @Override
    public void render() {
        System.out.println("Render TextBox");
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
