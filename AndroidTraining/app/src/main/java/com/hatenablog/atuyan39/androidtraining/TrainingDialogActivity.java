package com.hatenablog.atuyan39.androidtraining;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class TrainingDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_dialog);

        Button button = findViewById(R.id.dialog_1_button);
        button.setOnClickListener(v -> showTrainingDialog());
    }

    private void showTrainingDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(R.string.dialog_1_message)
                .setTitle(R.string.dialog_1_title);

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}