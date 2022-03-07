
package _99_extra;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ThatWasEasy extends MouseAdapter {

    @Override
    public void mouseClicked(MouseEvent arg0) {
        /* Use the Sound.speak method to make the button work. */
        
    }

    public static void main(String[] args) {
        new ThatWasEasy();
    }

    public ThatWasEasy() {
        showEasyButton();
        easyButtonImage.addMouseListener(this);
    }

    JLabel easyButtonImage;

    private void showEasyButton() {
        JFrame quizWindow = new JFrame();
        quizWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        quizWindow.setVisible(true);

        Icon icon = new ImageIcon(getClass().getResource("easy_button.jpg"));
        this.easyButtonImage = new JLabel(icon);
        quizWindow.add(easyButtonImage);
        quizWindow.pack();
    }
}


