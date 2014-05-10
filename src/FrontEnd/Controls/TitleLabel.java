package FrontEnd.Controls;

import javax.swing.*;
import java.awt.*;

/**
 * Created by lucas on 10/05/2014.
 */
public class TitleLabel extends JLabel {
    public TitleLabel(String text) {
        super(text);
        setFont(new Font("Segoe UI Light", Font.PLAIN, 24));
        setForeground(new Color(255, 165, 0));
    }

    public TitleLabel(String text, int size) {
        super(text);
        setFont(new Font("Segoe UI Light", Font.PLAIN, size));
        setForeground(new Color(255, 165, 0));

    }
}
