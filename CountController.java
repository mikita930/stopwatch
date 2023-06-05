/* 

�X�g�b�v�E�H�b�`�̃J�E���g�V�X�e��

*/
public class CountController implements Runnable {
    // �J�E���g�\�����x��
    CountLabel countLabel;
    // �X���b�h
    Thread thread;
    // �J�E���g�l
    int count;
    // ���s���X�e�[�^�X
    boolean runStatus;

    public CountController(CountLabel countLabel) {
        this.countLabel = countLabel;
        count = 0;
        runStatus = false;
    }

    // �J�E���g�J�n
    public void countStart() {
        if(!runStatus) {
            runStatus = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    // �J�E���g��~
    public void countStop() {
        runStatus = false;
    }

    // �J�E���g���Z�b�g
    public void countReset() {
        if(!runStatus) {
            count = 0;
            countLabel.countRepaint(count);
        }
    }

    public void run() {
        try {
            while(runStatus) {
                count++;
                countLabel.countRepaint(count);
                Thread.sleep(100);
            }
            thread = null;
        } catch (InterruptedException e) {

        }
    }
}