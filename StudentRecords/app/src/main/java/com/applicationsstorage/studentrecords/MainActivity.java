package com.applicationsstorage.studentrecords;

import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText editTextId, editName, editEmail, editCC;
    Button buttonAdd, buttonGetData, buttonUpdate, buttonDelete, buttonViewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDB = new DatabaseHelper(this);

        editTextId = findViewById(R.id.editText_id);
        editName = findViewById(R.id.editText_name);
        editEmail = findViewById(R.id.editText_email);
        editCC = findViewById(R.id.editText_CC);

        buttonAdd = findViewById(R.id.button_add);
        buttonGetData = findViewById(R.id.button_view);
        buttonDelete = findViewById(R.id.button_delete);
        buttonUpdate = findViewById(R.id.button_update);
        buttonViewAll = findViewById(R.id.button_viewAll);

        //showMessage("Test","Testing Done");

        addData();
        getData();
        viewAll();
        updateData();
        deleteData();

    }

    public void addData() {
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String myEmail = editEmail.getText().toString();
                boolean isInserted = myDB.insertData(editName.getText().toString(), editEmail.getText().toString(), editCC.getText().toString());
                if (isInserted == true) {
                    Toast.makeText(MainActivity.this, "Data Inserted!!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Something Went Wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void getData() {
        buttonGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = editTextId.getText().toString();

                if (id.equals(String.valueOf(""))) {
                    editTextId.setError("Enter ID");
                    return;
                }

                Cursor cursor = myDB.getData(id);
                String data = null;

                if (cursor.moveToNext()) {
                    data = "ID: " + cursor.getString(0) + "\n" +
                            "Name: " + cursor.getString(1) + "\n" +
                            "Email: " + cursor.getString(2) + "\n" +
                            "Course Count: " + cursor.getString(3) + "\n";
                }
                showMessage("Data: ", data);
            }
        });
    }

    public void viewAll() {
        buttonViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor cursor = myDB.getAllData();

                if (cursor.getCount() == 0) {
                    showMessage("Error", "No More Entries");
                    return;
                }

                StringBuffer buffer = new StringBuffer();

                while (cursor.moveToNext()) {
                    buffer.append("ID: " + cursor.getString(0) + "\n");
                    buffer.append("Name: " + cursor.getString(1) + "\n");
                    buffer.append("Email: " + cursor.getString(2) + "\n");
                    buffer.append("Course Count: " + cursor.getString(3) + "\n\n");

                }

                showMessage("All Data", buffer.toString());
            }


        });
    }


    public void updateData() {
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdate = myDB.updateData(editTextId.getText().toString(),
                        editName.getText().toString(),
                        editEmail.getText().toString(),
                        editCC.getText().toString());

                if (isUpdate == true) {
                    Toast.makeText(MainActivity.this, "Updated Successfully", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "OpSS!!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void deleteData()
    {
        buttonDelete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Integer integer = myDB.deleteData(editTextId.getText().toString());

                if(integer==0)
                {
                    showMessage("Error","Enter Id to be deleted");
                }

                if(integer>0)
                {
                    Toast.makeText(MainActivity.this,"Record Deleted",Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.create();
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
