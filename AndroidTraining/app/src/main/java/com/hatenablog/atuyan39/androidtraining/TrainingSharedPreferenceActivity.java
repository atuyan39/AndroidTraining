package com.hatenablog.atuyan39.androidtraining;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TrainingSharedPreferenceActivity extends AppCompatActivity {
    private final static String KEY_INPUT = "input";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_shared_preference);

        // Viewを取得
        TextView textView = findViewById(R.id.sp1_text_view);
        EditText editText = findViewById(R.id.sp1_edit_text);
        Button saveButton = findViewById(R.id.sp1_save_button);
        Button displayButton = findViewById(R.id.sp1_display_button);

        // Saveボタンクリック時の処理
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInputData(editText.getText().toString());
            }
        });

        // Displayボタンクリック時の処理
        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(getInputData());
            }
        });

        // SharedPreferenceの更新時にToastを表示する
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        sharedPreferences.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                Toast.makeText(getApplicationContext(), "update!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @NonNull
    private String getInputData() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        return sharedPreferences.getString(KEY_INPUT, "Nothing Input!");
    }

    private void saveInputData(@Nullable String text) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_INPUT, text);
        editor.apply();
    }
}