package com.hatenablog.atuyan39.androidtraining;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private final static String[] trainingList = {
            "TextView",
            "Button",
            "ListView"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        adapter.addAll(trainingList);
        listView.setOnItemClickListener((parent, view, position, id) -> {
            Log.d("asdf", "position:" + position + ", id:" + id);
            String text = (String) ((TextView) view).getText();
            if (text != null) {
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                startTrainingActivity(text);
            }
        });
        listView.setAdapter(adapter);
    }

    private void startTrainingActivity(@NonNull String text) {
        Intent intent = null;
        switch (text) {
            case "TextView":
                intent = new Intent(this, TrainingTextViewActivity.class);
                break;
            case "Button":
                intent = new Intent(this, TrainingButtonActivity.class);
                break;
            case "ListView":
                intent = new Intent(this, TrainingListViewActivity.class);
                break;
            default:
                Log.d("asdf", "There is no training activity!");
                return;
        }
        if (intent != null) startActivity(intent);
    }
}