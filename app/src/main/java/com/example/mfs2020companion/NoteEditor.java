package com.example.mfs2020companion;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
        final int noteID = intent.getIntExtra("NoteID", -1);

        if(noteID != -1) {
            editText.setText((CharSequence) NotesMenu.notes.get(noteID));

        }

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                NotesMenu.notes.set(noteID, String.valueOf(s));
                NotesMenu.arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}
