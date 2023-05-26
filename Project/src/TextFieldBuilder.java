import javax.swing.JTextField;

public class TextFieldBuilder extends JTextField{
    
    int x,y;

    TextFieldBuilder(int x, int y)
    {
        this.setLayout(null);
        this.setBounds(x, y, 750, 13);

    }

}
