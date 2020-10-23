package com.example.mfs2020companion;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class NoteEditor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_editor);

        EditText editText = (EditText) findViewById(R.id.editTextTextMultiLine2);

        Intent intent = getIntent();
        int noteID = intent.getIntExtra("NoteID", -1);

        if(noteID != -1) {
            editText.setText((CharSequence) NotesMenu.notes.get(noteID));

        }
    }
}
