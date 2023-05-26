
    import javax.swing.JPanel;

public class PanelBuilder extends JPanel {
   
    private int x, y, width, height;

   PanelBuilder(int x, int y, int width, int height)
   {
    this.setLayout(null);
    this.x = x;
    this.y = y;
    this.width = width;
    this.height = height;
    this.setBounds(x, y, width, height);

   }

public int getX() {
    return x;
}

public int getY() {
    return y;
}

public int getWidth() {
    return width;
}

public int getHeight() {
    return height;
}

}
