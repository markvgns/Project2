import java.awt.Color;

import javax.swing.JButton;

public class ButtonBuilder extends JButton {
    String text;
    int x, y;

    ButtonBuilder(String text, int x, int y)
    {
        this.text = text;
        this.x = x;
        this.y = y;

        this.setLayout(null);
        this.setBounds(x, y, 100, 25);
        this.setText(text);
        this.setFocusable(false);
        this.setForeground(Color.BLUE);
        this.setBackground(Color.LIGHT_GRAY);

    }


}
