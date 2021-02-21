package com.example.mysqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.microedition.khronos.egl.EGLDisplay;

public class MainActivity extends AppCompatActivity {

    private EditText editText1,editText2,editText3,editText4;
    private Button addButton,updateButton,deleteButton;
    MyDataBaseHelper myDataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDataBaseHelper=new MyDataBaseHelper(this);
        editText1=(EditText)findViewById(R.id.EditTextId);
        editText2=(EditText)findViewById(R.id.EditTextName);
        editText3=(EditText)findViewById(R.id.EditTextAge);
        editText4=(EditText)findViewById(R.id.EditTextGender);
        addButton=(Button)findViewById(R.id.addButton);
        updateButton=(Button)findViewById(R.id.updateButton);
        deleteButton=(Button)findViewById(R.id.deleteButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=editText1.getText().toString();
                String name=editText2.getText().toString();
                String age=editText3.getText().toString();
                String gender=editText4.getText().toString();
                boolean result=myDataBaseHelper.InsertData(name,age,gender);
                if(result==true)
                    Toast.makeText(MainActivity.this,"Data Successfully Added",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"Data is not inserted",Toast.LENGTH_SHORT).show();
            }
        });
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=editText1.getText().toString();
                String name=editText2.getText().toString();
                String age=editText3.getText().toString();
                String gender=editText4.getText().toString();
                boolean value =myDataBaseHelper.UpdateData(id,name,age,gender);
                if(value==true)
                    Toast.makeText(MainActivity.this,"Data Updataed successfully",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"Data is not updated",Toast.LENGTH_SHORT).show();
            }
        });
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id=editText1.getText().toString();
                String name=editText2.getText().toString();
                String age=editText3.getText().toString();
                String gender=editText4.getText().toString();
                int data=myDataBaseHelper.DeleteData(id);
                if(data>0)
                    Toast.makeText(MainActivity.this,"Data is deleted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"Data is not deleted",Toast.LENGTH_SHORT).show();
            }
        });

    }
}