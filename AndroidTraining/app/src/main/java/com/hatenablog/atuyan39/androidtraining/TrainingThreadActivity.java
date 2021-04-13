package com.hatenablog.atuyan39.androidtraining;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.widget.Button;
import android.widget.TextView;

public class TrainingThreadActivity extends AppCompatActivity {
    private static final int THREAD_SLEEP_TIME = 2 * 1000;
    TextView mTextView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_thread);

        mTextView = findViewById(R.id.thread_1_text_view);

        Button button = findViewById(R.id.thread_1_button);
        button.setOnClickListener((v -> startThread()));
    }

    private void startThread() {
        new Thread(() -> {
            Handler handler = new Handler(getMainLooper());
            String text = "count:";
            for (int i = 0; ; i++) {
                try {
                    String finalText = text + i;
                    Thread.sleep(THREAD_SLEEP_TIME);
                    handler.post(() -> mTextView.setText(finalText));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}