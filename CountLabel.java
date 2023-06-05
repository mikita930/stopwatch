/*

CountLabelの設定

*/
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JLabel;

public class CountLabel extends JLabel {
    // 設定フォント
    static final String LABEL_FONT = "HGP創英角ｺﾞｼｯｸUB";
    // フォントサイズ
    static final int FONT_SIZE = 32;

    // カウント値
    int count;

    public CountLabel() {
        // 表示位置設定
        setLocation(70,90);
        // 表示サイズ設定
        setSize(160, 130);
        // 文字色設定
        setForeground(Color.white);
        // 背景色設定
        setBackground(Color.black);
        //背景非透明化
        setOpaque(true);

        // 書式、文字サイズを設定
        setFont( new Font(LABEL_FONT, Font.PLAIN, FONT_SIZE) );
        // 水平方向中央揃え
        setHorizontalAlignment(JLabel.CENTER);
    }

    // カウント再表示
    public void countRepaint(int count) {
        this.count = count;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        // ミリ秒計算
        int milli = count % 10;
        // 秒数計算
        int second = count / 10;
        // 分数計算
        int minuts = second / 60;
        // 秒数再計算
        second = second % 60;

        // 表示
        String str = getTwoDigitsNum(minuts) + ":" + getTwoDigitsNum(second) + "." + milli;
        g.drawString(str, 20, 70);

    }

    // 数値を2桁表示にする
    public String getTwoDigitsNum(int num) {
        if(num < 10) {
            return "0" + num;
        }
        return Integer.toString(num);
    }
}