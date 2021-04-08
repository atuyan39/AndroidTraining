package com.hatenablog.atuyan39.androidtraining;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class TrainingCheckBoxActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_check_box);

        // Viewを取得
        CheckBox checkBox = findViewById(R.id.check_box_1);
        checkBox.setText(R.string.cb1_text);

        // checkBoxの変更の通知を受け取る
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // 三項演算子で一行にまとめると短くて済む
                // R.string.cb1_check_onをstringに変換する場合は、getString(id)
                String toastText = isChecked ? "チェックが付きました" : "チェックが外れました";
                Toast.makeText(getApplicationContext(), toastText, Toast.LENGTH_SHORT).show();
            }
        });
    }
}