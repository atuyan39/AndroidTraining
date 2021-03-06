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
            "ListView",
            "EditText",
            "SharedPreference",
            "CheckBox",
            "Switch",
            "Activity",
            "ImageView",
            "Thread",
            "Dialog",
            "Spinner",
            "Radio",
            "ViewModel",
            "ListView2"
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.list_view);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        adapter.addAll(trainingList);
        listView.setOnItemClickListener((parent, view, position, id) -> {
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
            case "EditText":
                intent = new Intent(this, TrainingEditTextActivity.class);
                break;
            case "SharedPreference":
                intent = new Intent(this, TrainingSharedPreferenceActivity.class);
                break;
            case "CheckBox":
                intent = new Intent(this, TrainingCheckBoxActivity.class);
                break;
            case "Switch":
                intent = new Intent(this, TrainingSwitchActivity.class);
                break;
            case "Activity" :
                intent = new Intent(this, TrainingActivity.class);
                break;
            case "ImageView" :
                intent = new Intent(this, TrainingImageViewActivity.class);
                break;
            case "Thread" :
                intent = new Intent(this, TrainingThreadActivity.class);
                break;
            case "Dialog" :
                intent = new Intent(this, TrainingDialogActivity.class);
                break;
            case "Spinner":
                intent = new Intent(this, TrainingSpinnerActivity.class);
                break;
            case "Radio":
                intent = new Intent(this, TrainingRadioActivity.class);
                break;
            case "ViewModel":
                intent = new Intent(this, TrainingViewModelActivity.class);
                break;
            case "ListView2":
                intent = new Intent(this, TrainingListViewActivity2.class);
                break;
            default:
                Log.d(getPackageName(), "There is no training activity!");
                return;
        }
        startActivity(intent);
    }
}