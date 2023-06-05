/*

ManualPanellの設定

*/
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class ManualPanel extends JPanel {
    public ManualPanel() {
        //色の設定
        this.setBackground(Color.black);
        this.setOpaque(true);

        //Labelの設定
        JLabel title = new JLabel("<取り扱い説明書>");
        title.setForeground(Color.yellow);
        title.setFont(new Font("MS　ゴシック", Font.BOLD,24));
        JLabel text1 = new JLabel("<html>	<br>・ボタンでストップウォッチを操作　　 <html>");
        text1.setForeground(Color.white);
        text1.setFont(new Font("MS　ゴシック", Font.PLAIN, 16));
        JLabel text2 = new JLabel("<html>	<br>・menuから文字・背景の色を設定　　　<html>");
        text2.setForeground(Color.white);
        text2.setFont(new Font("MS　ゴシック", Font.PLAIN, 16));
        JLabel text3 = new JLabel("<html>	<br>・menuからexitでプログラム終了　　 　 <html>");
        text3.setForeground(Color.white);
        text3.setFont(new Font("MS　ゴシック", Font.PLAIN, 16));
        JLabel text4 = new JLabel("<html>	<br>・[alt]+[アルファベット]でショートカット<html>");
        text4.setForeground(Color.white);
        text4.setFont(new Font("MS　ゴシック", Font.PLAIN, 16));

        this.add(title);
        this.add(text1);
        this.add(text2);
        this.add(text3);
        this.add(text4);
    }
}