package com.wuriyanto.tutorial12;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private AutoCompleteTextView autoCompleteTextViewLanguage;
    private Button buttonSubmit;


    private ArrayAdapter<String> languageAdapter;
    private String[] languages = {"Java", "Javascript", "Golang", "PHP", "Python", "Rust", "Elixir", "C", "C++"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteTextViewLanguage = (AutoCompleteTextView) findViewById(R.id.ac_language);
        buttonSubmit = (Button) findViewById(R.id.btn_submit);

        loadLanguageDatas();

        autoCompleteTextViewLanguage.setThreshold(2);

        autoCompleteTextViewLanguage.setAdapter(languageAdapter);

        buttonSubmit.setOnClickListener(new ButtonSubmitEvent());

    }

    private void loadLanguageDatas() {
        languageAdapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, languages);
    }

    // Button Submit Event
    private class ButtonSubmitEvent implements AdapterView.OnClickListener{

        private TextView textViewResult;

        @Override
        public void onClick(View view) {
            textViewResult = (TextView) findViewById(R.id.tv_result);

            String language = autoCompleteTextViewLanguage.getText().toString();
            textViewResult.setText(language);
        }
    }
}
