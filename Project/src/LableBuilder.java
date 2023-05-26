import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class LableBuilder extends JLabel{
    String text;
    int x,y;

    LableBuilder(String text, int x, int y)
    {
        this.text = text;
        this.x = x;
        this.y = y;

        this.setLayout(null);
        this.setBounds(x, y, 750, 15);
        this.setText(text);
        this.setOpaque(true);
        this.setBackground(Color.BLACK);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("Times New Roman", Font.PLAIN, 10));


    }
}
