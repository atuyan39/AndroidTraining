package com.hatenablog.atuyan39.androidtraining;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class TrainingDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training_dialog);

        Button alertButton = findViewById(R.id.dialog_1_button);
        alertButton.setOnClickListener(v -> showTrainingDialog());

        Button datePickerButton = findViewById(R.id.dialog_2_button_date);
        datePickerButton.setOnClickListener(v -> showTrainingDatePickerDialog());
    }

    private void showTrainingDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(R.string.dialog_1_message)
                .setTitle(R.string.dialog_1_title);

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void showTrainingDatePickerDialog() {
        DatePickerDialog dialog = new DatePickerDialog(this);
        dialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                // OKボタンが押下された際に通知が来る
                String message = year + "/" + month + "/" + dayOfMonth;
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
            }
        });
        dialog.show();
    }
}