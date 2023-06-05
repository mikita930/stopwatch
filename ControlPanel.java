/*

ControlPanelの設定

*/
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;

public class ControlPanel extends JPanel implements ActionListener {
    // カウント管理クラス
    CountController countController;

    public ControlPanel(CountController countController) {
        this.countController = countController;

        Button b;

        b = new Button("START");
        this.add("North", b);
        b.addActionListener(this);
        
        b = new Button("STOP");
        this.add("North", b);
        b.addActionListener(this);

        b = new Button("RESET");
        this.add("North", b);
        b.addActionListener(this);
    }

    public void actionPerformed(ActionEvent ev) {
        String cmd = ev.getActionCommand();

        if (cmd.equals("START")) {
            countController.countStart();

        } else if (cmd.equals("STOP")) {
            countController.countStop();

        } else if (cmd.equals("RESET")) {
            countController.countReset();

        }
    }
}