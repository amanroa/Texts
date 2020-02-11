package com.manroaaashni.texts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    Button b1;
    TextView textView1;
    EditText editText;
    Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        textView1 = findViewById(R.id.textView1);
        editText = findViewById(R.id.editText);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();
                textView1.setText(name);
                editText.setText("");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resources res = getResources();
                String[] colors = res.getStringArray(R.array.colors_array);
                String txt = textView1.getText().toString();
                int index = -2;
                for (int i = 0; i < colors.length; i++) {
                    if (colors[i].equals(txt)) {
                        index = i;
                    }
                    if (index == colors.length - 1) {
                        index = -1;
                    }
                    if (index == -2 && i == colors.length -1){
                        index = -1;
                    }
                }

                textView1.setText(colors[index + 1]);
            }

        });
    }
}
