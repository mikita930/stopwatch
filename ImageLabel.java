/*

ImageLabel�̐ݒ�

*/
import java.awt.Image;
import java.awt.MediaTracker;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageLabel extends JLabel {
    // �摜�p�X
    static final String IMAGE_PATH = "STOPWATCH.png";
    // �摜�{��
    static final double IMAGE_MAG = 0.36;

    public ImageLabel() {
        ImageIcon image = new ImageIcon(IMAGE_PATH);
        image = getResizeImageIcon(image, IMAGE_MAG);
        setIcon(image);
        setSize(320, 400);
    }

    // �w�肳�ꂽ�{���ŃC���[�W�A�C�R���̃T�C�Y��ς��郁�\�b�h
    public ImageIcon getResizeImageIcon(ImageIcon icon, double size) {

        MediaTracker tracker = new MediaTracker(this);

        // getScaledInstance�ő傫����ύX
        Image resizeImg = icon.getImage().getScaledInstance((int) (icon.getIconWidth() * size), -1, Image.SCALE_SMOOTH);

        // MediaTracker�ŏ����̏I����҂�
        tracker.addImage(resizeImg, 1);

        ImageIcon resizeIcon = new ImageIcon(resizeImg);

        try {
            tracker.waitForAll();
        } catch (InterruptedException e) {
        }
        return resizeIcon;
    }
}