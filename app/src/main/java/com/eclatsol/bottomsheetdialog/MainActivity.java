package com.eclatsol.bottomsheetdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.eclatsol.bottomsheetdialog.databinding.ActivityMainBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {


    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.showBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.bottom_sheet_layout,null,false);
                bottomSheetDialog.setContentView(view);
                bottomSheetDialog.show();

                TextInputLayout textInputLayout = view.findViewById(R.id.textFieldLayout);
                TextInputEditText textInputEditText = view.findViewById(R.id.editText);
                MaterialButton materialButton = view.findViewById(R.id.dismiss);

                materialButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (textInputEditText.getText().toString().trim().isEmpty()){
                            textInputLayout.setError("Please some text type");
                        }else {
                            Toast.makeText(MainActivity.this, textInputEditText.getText().toString().trim(), Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                        }
                    }
                });

                bottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        Toast.makeText(MainActivity.this, "BottomSheet Dismiss", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }
}