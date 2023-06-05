/* 

ストップウォッチのカウントシステム

*/
public class CountController implements Runnable {
    // カウント表示ラベル
    CountLabel countLabel;
    // スレッド
    Thread thread;
    // カウント値
    int count;
    // 実行中ステータス
    boolean runStatus;

    public CountController(CountLabel countLabel) {
        this.countLabel = countLabel;
        count = 0;
        runStatus = false;
    }

    // カウント開始
    public void countStart() {
        if(!runStatus) {
            runStatus = true;
            thread = new Thread(this);
            thread.start();
        }
    }

    // カウント停止
    public void countStop() {
        runStatus = false;
    }

    // カウントリセット
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