package com.example.material3dialogedittext;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.textfield.TextInputEditText;

import java.text.MessageFormat;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MaterialButton button = findViewById(R.id.btn);
        TextView textView = findViewById(R.id.tv);

        button.setOnClickListener(view -> {
            View view1 = LayoutInflater.from(MainActivity.this).inflate(R.layout.dialog_layout, null);
            TextInputEditText editText = view1.findViewById(R.id.editText);
            AlertDialog alertDialog = new MaterialAlertDialogBuilder(MainActivity.this)
                    .setTitle("Title")
                    .setView(view1)
                    .setPositiveButton("Ok", (dialogInterface, i) -> {
                        textView.setText(MessageFormat.format("Typed text is: {0}", Objects.requireNonNull(editText.getText())));
                        dialogInterface.dismiss();
                    }).setNegativeButton("Close", (dialogInterface, i) -> dialogInterface.dismiss()).create();
            alertDialog.show();
        });
    }
}