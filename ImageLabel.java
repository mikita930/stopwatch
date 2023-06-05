/*

ImageLabelの設定

*/
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageLabel extends JLabel {
    // 画像パス
    static final String IMAGE_PATH = "STOPWATCH.png";
    // 画像倍率
    static final double IMAGE_MAG = 0.36;

    public ImageLabel() {
        ImageIcon image = new ImageIcon(IMAGE_PATH);
        image = getResizeImageIcon(image, IMAGE_MAG);
        setIcon(image);
        setSize(320, 400);
    }

    // 指定された倍率でイメージアイコンのサイズを変えるメソッド
    public ImageIcon getResizeImageIcon(ImageIcon icon, double size) {

        MediaTracker tracker = new MediaTracker(this);

        // getScaledInstanceで大きさを変更
        Image resizeImg = icon.getImage().getScaledInstance((int) (icon.getIconWidth() * size), -1, Image.SCALE_SMOOTH);

        // MediaTrackerで処理の終了を待つ
        tracker.addImage(resizeImg, 1);

        ImageIcon resizeIcon = new ImageIcon(resizeImg);

        try {
            tracker.waitForAll();
        } catch (InterruptedException e) {
        }
        return resizeIcon;
    }
}