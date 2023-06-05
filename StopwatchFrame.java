/*

フレームの設定

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

        //パネル
        JPanel mainPanel = new JPanel();
        imageLabel.add(countLabel, BorderLayout.CENTER);
        mainPanel.add(imageLabel, BorderLayout.CENTER);

        //baseパネル
        JPanel basePanel = new JPanel();
        basePanel.setLayout(new BorderLayout());
        basePanel.add(mainPanel, BorderLayout.CENTER);
        basePanel.add(controlPanel, BorderLayout.NORTH);

        //CardLayout用パネル 
        cardPanel = new JPanel();
        layout = new CardLayout();

        cardPanel.setLayout(layout);
        cardPanel.add(basePanel, "basePanel");
        cardPanel.add(manualPanel, "manualPanel");

        //固定
        Container contentPane = getContentPane();
        contentPane.add(cardPanel, BorderLayout.CENTER);

        //メニューバー
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

        //1終了
        JMenuItem menuitem1 = new JMenuItem("Exit");
        menuitem1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                //ダイアログの表示
                int option = JOptionPane.showConfirmDialog(menuitem1,
                "本当に終了しますか？","終了", 
                JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
	   
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
                else if(option == JOptionPane.NO_OPTION) {
                }
            }
        });
        
        // 2文字色設定
        JMenuItem menuitem2 = new JMenuItem("Text Color");
        menuitem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 選択肢
                String selectvalues[] = { "白", "黒", "赤", "青", "黄", "緑", "紫", "桃", "橙", "灰" };

                // 初期表示は現在選択中のモード
                int initialIndex = 0;

                // ダイアログの表示
                Object value = JOptionPane.showInputDialog(menuitem2,
                "文字の色を選択してください","文字設定", 
                JOptionPane.QUESTION_MESSAGE,null, selectvalues, 
                selectvalues[initialIndex]);

	   //選択された色を文字の色に設定
	   if (value != null) {
	       switch ((String) value) {
	   	case "黒":
		    countLabel.setForeground(Color.black);
		    break;

	      	case "白":
		    countLabel.setForeground(Color.white);
		    break;

	      	case "赤":
		    countLabel.setForeground(Color.red);
		    break;

	      	case "青":
		    countLabel.setForeground(Color.blue);
		    break;

	      	case "黄":
		    countLabel.setForeground(Color.yellow);
		    break;

	      	case "緑":
		    countLabel.setForeground(Color.green);
		    break;

	      	case "紫":
		    countLabel.setForeground(Color.magenta);
		    break;

	      	case "桃":
		    countLabel.setForeground(Color.pink);
		    break;

	      	case "橙":
		    countLabel.setForeground(Color.orange);
		    break;

	      	case "灰":
		    countLabel.setForeground(Color.gray);
		    break;

		default:
		    break;
	       }
	   }
            }
        });

        // 3背景色設定
        JMenuItem menuitem3 = new JMenuItem("Background Color");
        menuitem3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 選択肢
                String selectvalues[] = { "黒", "白", "赤", "青", "黄", "緑", "紫", "桃", "橙", "灰"};

                // 初期表示は現在選択中のモード
                int initialIndex = 0;

               // ダイアログの表示
               Object value = JOptionPane.showInputDialog(menuitem3,
               "背景の色を選択してください","背景色設定", 
               JOptionPane.QUESTION_MESSAGE,null, selectvalues, 
               selectvalues[initialIndex]);

	  //選択された色を背景の色に設定
	  if (value != null) {
	      switch ((String) value) {
	  	case "黒":
		    countLabel.setBackground(Color.black);
		    break;

	      	case "白":
		    countLabel.setBackground(Color.white);
		    break;

	      	case "赤":
		    countLabel.setBackground(Color.red);
		    break;

	      	case "青":
		    countLabel.setBackground(Color.blue);
		    break;

		case "黄":
		    countLabel.setBackground(Color.yellow);
		    break;

	      	case "緑":
		    countLabel.setBackground(Color.green);
		    break;

	      	case "紫":
		    countLabel.setBackground(Color.magenta);
		    break;

	      	case "桃":
		    countLabel.setBackground(Color.pink);
		    break;

	      	case "橙":
		    countLabel.setBackground(Color.orange);
		    break;

	      	case "灰":
		    countLabel.setBackground(Color.gray);
		    break;

		default:
		    break;
	       }
	   }
            }
        });

        //4マニュアル
        JMenuItem menuitem4 = new JMenuItem("Manual");
        menuitem4.addActionListener(this);
        menuitem4.setActionCommand("manualPanel");

        //5ストップウォッチ
        JMenuItem menuitem5 = new JMenuItem("Stopwatch");
        menuitem5.addActionListener(this);
        menuitem5.setActionCommand("basePanel");           
 
        //メニューアイテムの設定
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

        //ウィンドウ設定
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

// アプリケーション用のウインドウリスナー
class WindowEventHandler extends WindowAdapter {
    public void windowClosing(WindowEvent ev) {
        System.exit(0);
    }
}