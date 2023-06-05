/*

�t���[���̐ݒ�

*/
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.Box;
import javax.swing.JButton;

public class StopwatchFrame extends JFrame implements ActionListener{
    JPanel cardPanel;
    CardLayout layout;

    public StopwatchFrame(ImageLabel imageLabel, CountLabel countLabel, ControlPanel controlPanel, ManualPanel manualPanel) {

        //�p�l��
        JPanel mainPanel = new JPanel();
        imageLabel.add(countLabel, BorderLayout.CENTER);
        mainPanel.add(imageLabel, BorderLayout.CENTER);

        //base�p�l��
        JPanel basePanel = new JPanel();
        basePanel.setLayout(new BorderLayout());
        basePanel.add(mainPanel, BorderLayout.CENTER);
        basePanel.add(controlPanel, BorderLayout.NORTH);

        //CardLayout�p�p�l�� 
        cardPanel = new JPanel();
        layout = new CardLayout();

        cardPanel.setLayout(layout);
        cardPanel.add(basePanel, "basePanel");
        cardPanel.add(manualPanel, "manualPanel");

        //�Œ�
        Container contentPane = getContentPane();
        contentPane.add(cardPanel, BorderLayout.CENTER);

        //���j���[�o�[
        JMenuBar menubar = new JMenuBar();
        JMenu menu1 = new JMenu("menu");
        JMenu menu2 = new JMenu("help");
        
        menu1.setForeground(Color.gray);
        menu2.setForeground(Color.gray);

        menu1.setFont(new Font("Century", Font.ITALIC, 16));
        menu2.setFont(new Font("Century", Font.ITALIC, 16));

        menu1.setMnemonic(KeyEvent.VK_M);
        menu2.setMnemonic(KeyEvent.VK_H);

        menubar.setBorderPainted(false);

        //1�I��
        JMenuItem menuitem1 = new JMenuItem("Exit");
        menuitem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //�_�C�A���O�̕\��
                int option = JOptionPane.showConfirmDialog(menuitem1,
                "�{���ɏI�����܂����H","�I��", 
                JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
	   
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
                else if(option == JOptionPane.NO_OPTION) {
                }
            }
        });
        
        // 2�����F�ݒ�
        JMenuItem menuitem2 = new JMenuItem("Text Color");
        menuitem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // �I����
                String selectvalues[] = { "��", "��", "��", "��", "��", "��", "��", "��", "��", "�D" };

                // �����\���͌��ݑI�𒆂̃��[�h
                int initialIndex = 0;

                // �_�C�A���O�̕\��
                Object value = JOptionPane.showInputDialog(menuitem2,
                "�����̐F��I�����Ă�������","�����ݒ�", 
                JOptionPane.QUESTION_MESSAGE,null, selectvalues, 
                selectvalues[initialIndex]);

	   //�I�����ꂽ�F�𕶎��̐F�ɐݒ�
	   if (value != null) {
	       switch ((String) value) {
	   	case "��":
		    countLabel.setForeground(Color.black);
		    break;

	      	case "��":
		    countLabel.setForeground(Color.white);
		    break;

	      	case "��":
		    countLabel.setForeground(Color.red);
		    break;

	      	case "��":
		    countLabel.setForeground(Color.blue);
		    break;

	      	case "��":
		    countLabel.setForeground(Color.yellow);
		    break;

	      	case "��":
		    countLabel.setForeground(Color.green);
		    break;

	      	case "��":
		    countLabel.setForeground(Color.magenta);
		    break;

	      	case "��":
		    countLabel.setForeground(Color.pink);
		    break;

	      	case "��":
		    countLabel.setForeground(Color.orange);
		    break;

	      	case "�D":
		    countLabel.setForeground(Color.gray);
		    break;

		default:
		    break;
	       }
	   }
            }
        });

        // 3�w�i�F�ݒ�
        JMenuItem menuitem3 = new JMenuItem("Background Color");
        menuitem3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // �I����
                String selectvalues[] = { "��", "��", "��", "��", "��", "��", "��", "��", "��", "�D"};

                // �����\���͌��ݑI�𒆂̃��[�h
                int initialIndex = 0;

               // �_�C�A���O�̕\��
               Object value = JOptionPane.showInputDialog(menuitem3,
               "�w�i�̐F��I�����Ă�������","�w�i�F�ݒ�", 
               JOptionPane.QUESTION_MESSAGE,null, selectvalues, 
               selectvalues[initialIndex]);

	  //�I�����ꂽ�F��w�i�̐F�ɐݒ�
	  if (value != null) {
	      switch ((String) value) {
	  	case "��":
		    countLabel.setBackground(Color.black);
		    break;

	      	case "��":
		    countLabel.setBackground(Color.white);
		    break;

	      	case "��":
		    countLabel.setBackground(Color.red);
		    break;

	      	case "��":
		    countLabel.setBackground(Color.blue);
		    break;

		case "��":
		    countLabel.setBackground(Color.yellow);
		    break;

	      	case "��":
		    countLabel.setBackground(Color.green);
		    break;

	      	case "��":
		    countLabel.setBackground(Color.magenta);
		    break;

	      	case "��":
		    countLabel.setBackground(Color.pink);
		    break;

	      	case "��":
		    countLabel.setBackground(Color.orange);
		    break;

	      	case "�D":
		    countLabel.setBackground(Color.gray);
		    break;

		default:
		    break;
	       }
	   }
            }
        });

        //4�}�j���A��
        JMenuItem menuitem4 = new JMenuItem("Manual");
        menuitem4.addActionListener(this);
        menuitem4.setActionCommand("manualPanel");

        //5�X�g�b�v�E�H�b�`
        JMenuItem menuitem5 = new JMenuItem("Stopwatch");
        menuitem5.addActionListener(this);
        menuitem5.setActionCommand("basePanel");           
 
        //���j���[�A�C�e���̐ݒ�
        menuitem1.setFont(new Font("Century", Font.ITALIC, 14));
        menuitem2.setFont(new Font("Century", Font.ITALIC, 14));
        menuitem3.setFont(new Font("Century", Font.ITALIC, 14));
        menuitem4.setFont(new Font("Century", Font.ITALIC, 14));
        menuitem5.setFont(new Font("Century", Font.ITALIC, 14));

        menuitem1.setBackground(Color.red);
        menuitem1.setOpaque(true);

        menuitem1.setMnemonic(KeyEvent.VK_E);
        menuitem2.setMnemonic(KeyEvent.VK_T);
        menuitem3.setMnemonic(KeyEvent.VK_B);
        menuitem4.setMnemonic(KeyEvent.VK_N);
        menuitem5.setMnemonic(KeyEvent.VK_S);

        menu1.add(menuitem2);
        menu1.addSeparator();
        menu1.add(menuitem3);
        menu1.addSeparator();
        menu1.add(menuitem1);

        menu2.add(menuitem4);
        menu2.addSeparator();
        menu2.add(menuitem5);

        menubar.add(menu1);
        menubar.add(Box.createHorizontalGlue());
        menubar.add(menu2);

        setJMenuBar(menubar);

        //�E�B���h�E�ݒ�
        setSize(320, 400);
        setLocationRelativeTo(null);
        setVisible(true);

        this.addWindowListener(new WindowEventHandler());

        }
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        layout.show(cardPanel, cmd);
    }
}

// �A�v���P�[�V�����p�̃E�C���h�E���X�i�[
class WindowEventHandler extends WindowAdapter {
    public void windowClosing(WindowEvent ev) {
        System.exit(0);
    }
}