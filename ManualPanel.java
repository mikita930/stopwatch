/*

ManualPanell�̐ݒ�

*/
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JLabel;

public class ManualPanel extends JPanel {
    public ManualPanel() {
        //�F�̐ݒ�
        this.setBackground(Color.black);
        this.setOpaque(true);

        //Label�̐ݒ�
        JLabel title = new JLabel("<��舵��������>");
        title.setForeground(Color.yellow);
        title.setFont(new Font("MS�@�S�V�b�N", Font.BOLD,24));
        JLabel text1 = new JLabel("<html>	<br>�E�{�^���ŃX�g�b�v�E�H�b�`�𑀍�@�@ <html>");
        text1.setForeground(Color.white);
        text1.setFont(new Font("MS�@�S�V�b�N", Font.PLAIN, 16));
        JLabel text2 = new JLabel("<html>	<br>�Emenu���當���E�w�i�̐F��ݒ�@�@�@<html>");
        text2.setForeground(Color.white);
        text2.setFont(new Font("MS�@�S�V�b�N", Font.PLAIN, 16));
        JLabel text3 = new JLabel("<html>	<br>�Emenu����exit�Ńv���O�����I���@�@ �@ <html>");
        text3.setForeground(Color.white);
        text3.setFont(new Font("MS�@�S�V�b�N", Font.PLAIN, 16));
        JLabel text4 = new JLabel("<html>	<br>�E[alt]+[�A���t�@�x�b�g]�ŃV���[�g�J�b�g<html>");
        text4.setForeground(Color.white);
        text4.setFont(new Font("MS�@�S�V�b�N", Font.PLAIN, 16));

        this.add(title);
        this.add(text1);
        this.add(text2);
        this.add(text3);
        this.add(text4);
    }
}