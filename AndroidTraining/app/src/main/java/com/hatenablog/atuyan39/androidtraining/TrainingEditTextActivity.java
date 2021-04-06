package com.hatenablog.atuyan39.androidtraining;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TrainingEditTextActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_edit_text);

        // Viewを取得する
        TextView textView = findViewById(R.id.edit_text_1_text);
        EditText editText = findViewById(R.id.edit_text_1_edit_text);
        Button button = findViewById(R.id.edit_text_1_button);

        // Buttonのクリック時の処理を追加する
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TextViewにEditTextに入力された値を設定する
                textView.setText(editText.getText());
            }
        });

        // ※ラムダ式を使う場合
        // button.setOnClickListener(v -> textView.setText(editText.getText()));
    }
}