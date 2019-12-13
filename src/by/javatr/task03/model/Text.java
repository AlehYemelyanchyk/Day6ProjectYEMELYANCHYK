package by.javatr.task03.model;

/**
 * @author Aleh Yemelyanchyk on 12/9/2019.
 */
public class Text {
    private String text;

    public Text() {
    }

    public Text(String text) {
        setText(text);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = (text == null) ? "" : text;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }

        Text newText = (Text) object;

        return this.getText() != null ? this.getText().equals(newText.getText()) : newText.getText() == null;
    }

    @Override
    public int hashCode() {
        return this.getText() != null ? this.getText().hashCode() : 0;
    }

    @Override
    public String toString() {
        return getClass().getName() + '@' +
                "text = " + this.getText();
    }
}
