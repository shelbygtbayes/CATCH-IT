package com.example.catchit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TaskNote extends Activity  implements View.OnClickListener{
    public static String EXTRA_MESSAGE = "";
    EditText editText;
    DbHelper db;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        db = new DbHelper(this);
        setContentView(R.layout.intent_view);
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b2.setOnClickListener(this);
        Intent intent = getIntent();
        final String task = intent.getStringExtra(EXTRA_MESSAGE);
        editText = findViewById(R.id.edit);
        editText.setText(task);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            String updated = editText.getText().toString();
                db.deleteTask(task);
                if(updated.length()>0) {
                    db.insertNewTask(updated);
                    Toast.makeText(getBaseContext(),"Task Updated",Toast.LENGTH_LONG).show();
                }
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.deleteTask(task);
                Toast.makeText(getBaseContext(),"Task Deleted",Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public void onClick(View v) {

    }
}
