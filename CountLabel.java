/*

CountLabel�̐ݒ�

*/
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;

public class CountLabel extends JLabel {
    // �ݒ�t�H���g
    static final String LABEL_FONT = "HGP�n�p�p�޼��UB";
    // �t�H���g�T�C�Y
    static final int FONT_SIZE = 32;

    // �J�E���g�l
    int count;

    public CountLabel() {
        // �\���ʒu�ݒ�
        setLocation(70,90);
        // �\���T�C�Y�ݒ�
        setSize(160, 130);
        // �����F�ݒ�
        setForeground(Color.white);
        // �w�i�F�ݒ�
        setBackground(Color.black);
        //�w�i�񓧖���
        setOpaque(true);

        // �����A�����T�C�Y��ݒ�
        setFont( new Font(LABEL_FONT, Font.PLAIN, FONT_SIZE) );
        // ����������������
        setHorizontalAlignment(JLabel.CENTER);
    }

    // �J�E���g�ĕ\��
    public void countRepaint(int count) {
        this.count = count;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // �~���b�v�Z
        int milli = count % 10;
        // �b���v�Z
        int second = count / 10;
        // �����v�Z
        int minuts = second / 60;
        // �b���Čv�Z
        second = second % 60;

        // �\��
        String str = getTwoDigitsNum(minuts) + ":" + getTwoDigitsNum(second) + "." + milli;
        g.drawString(str, 20, 70);

    }

    // ���l��2���\���ɂ���
    public String getTwoDigitsNum(int num) {
        if(num < 10) {
            return "0" + num;
        }
        return Integer.toString(num);
    }
}