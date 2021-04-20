package com.hatenablog.atuyan39.androidtraining.ui.main;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TrainingViewModel extends ViewModel {
    private static final int THREAD_SLEEP_TIME = 1000;
    private MutableLiveData<String> mText;

    /**
     * 変更のあるデータをLiveDataとして渡す
     *
     * @return {@link MutableLiveData}
     */
    @NonNull
    public MutableLiveData<String> getText() {
        if (mText == null) {
            mText = new MutableLiveData<>();
            // 必要であれば、初期化する。
            // setValueはメインスレッドからLiveDataに通知する際に使う。
            mText.setValue("Ready?");
        }
        return mText;
    }

    /**
     * ボタン押下時の処理
     *
     * View（Fragment）はボタンを押下されたイベントの通知を行いたいので、
     * ViewModelとして提供すべきメソッドは、onClickButtonとしました。
     * setTextという命名は駄目。
     */
    public void onClickButton() {
        new Thread(() -> {
            for (int i = 0; ; i++) {
                String text = "count:";
                try {
                    Thread.sleep(THREAD_SLEEP_TIME);
                    // postValueはメインスレッド以外からLiveDataに通知する際に使う。
                    mText.postValue(text + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}