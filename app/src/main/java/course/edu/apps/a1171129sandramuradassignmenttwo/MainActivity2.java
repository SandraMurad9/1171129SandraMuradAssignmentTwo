package course.edu.apps.a1171129sandramuradassignmenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import Classes.Experiences;

public class MainActivity2 extends AppCompatActivity {

    Spinner EduSpn ;
    private EditText UniversityTxt;
    private EditText BacholarTxt;
    private EditText skillsTxt;
    private EditText WorkTxt;
    private RadioGroup LanguagesRd;
    private RadioButton yesBtn;
    private RadioButton noBtn;
    private EditText LanguageTxt;
    public CheckBox chk;
    String LanguagesRadio;

    public static final String EDUCATION ="EDUCATION";
    public static final String UNIVERSITY ="UNIVERSITY";
    public static final String BACHOLAR ="BACHOLAR";
    public static final String SKILLS ="SKILLS";
    public static final String WORK ="WORK";
    public static final String SPEAKLANGUAGES ="SPEAKLANGUAGES";
    public static final String LANGUAGES ="LANGUAGES";
    public static final String FLAG ="FLAG";

    public boolean flag= false;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EduSpn = findViewById(R.id.EduSpn);
        setupViews();
        populateSpinner();
        getPreviousIntent();
        setupSharedPrefs();
        checkPrefs();
        setPrefs();
    }

    private void setPrefs() {


        String university=UniversityTxt.getText().toString();
        String bacholar=BacholarTxt.getText().toString();
        String skills=skillsTxt.getText().toString();
        String Work=WorkTxt.getText().toString();
        String Language=LanguageTxt.getText().toString();


        if(chk.isChecked()){
            if(!flag){

                editor.putString(UNIVERSITY,university);
                editor.putString(BACHOLAR,bacholar);
                editor.putString(SKILLS,skills);
                editor.putString(WORK,Work);
                editor.putString(LANGUAGES,Language);


                editor.putBoolean(FLAG, true);
                editor.commit();
            }
        }
    }

    private void checkPrefs() {
        flag= prefs.getBoolean(FLAG,false);
        if(flag){

            String university  = prefs.getString(UNIVERSITY,"");
            String bacholar= prefs.getString(BACHOLAR,"");
            String skills  = prefs.getString(SKILLS,"");
            String work= prefs.getString(WORK,"");
            String languages= prefs.getString(LANGUAGES,"");

            UniversityTxt.setText(university);
            BacholarTxt.setText(bacholar);
            skillsTxt.setText(skills);
            WorkTxt.setText(work);
            LanguageTxt.setText(languages);

            chk.setChecked(true);
        }
    }

    private void setupSharedPrefs() {

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor= prefs.edit();
    }
    private void getPreviousIntent() {
        Intent intent= getIntent();
        String Name = intent.getStringExtra("NAME");
        String email = intent.getStringExtra("email");
        String Phone = intent.getStringExtra("Phone");
        String Hobbies = intent.getStringExtra("Hobbies");
        String About = intent.getStringExtra("About");
        String str = intent.getStringExtra("spinner");

    }


    private void populateSpinner() {
        ArrayList<String> data = new ArrayList<>();
        data.add("Under Graduate");
        data.add("Student");
        data.add("Employee");
        data.add("Non Worker");
        ArrayAdapter<String > adpter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,data);
        EduSpn.setAdapter(adpter);
    }

    private void setupViews() {

        UniversityTxt=findViewById(R.id.UniversityTxt);
        BacholarTxt=findViewById(R.id.BacholarTxt);
        LanguageTxt=findViewById(R.id.LanguageTxt);
        LanguagesRd=findViewById(R.id.LanguagesRd);
        yesBtn=findViewById(R.id.yesBtn);
        noBtn=findViewById(R.id.noBtn);
        WorkTxt=findViewById(R.id.WorkTxt);
        skillsTxt=findViewById(R.id.skillsTxt);
        chk=findViewById(R.id.chk);

    }

    public void nextPageOnClick(View view) {
        Intent intent = new Intent(this,MainActivity3.class);

        String str = EduSpn.getSelectedItem().toString();
        intent.putExtra("spinner",str);
        String University = UniversityTxt.getText().toString();
        intent.putExtra("University", University);
        String Bacholar = BacholarTxt.getText().toString();
        intent.putExtra("Bacholar", Bacholar);
        String skills = skillsTxt.getText().toString();
        intent.putExtra("skills", skills);
        String Work = WorkTxt.getText().toString();
        intent.putExtra("Work", Work);

        if(yesBtn.isChecked()){
            LanguagesRadio=yesBtn.getText().toString();
        }
        else if(noBtn.isChecked()){
            LanguagesRadio=noBtn.getText().toString();
        }

        intent.putExtra("SpeakLanguages", LanguagesRadio);
        String Languages = LanguageTxt.getText().toString();
        intent.putExtra("Languages", Languages);


        Experiences[] experiences = new Experiences[1];
        experiences[0] = new Experiences(str,University, Bacholar,skills,Work,LanguagesRadio,Languages);



        Gson gson = new Gson();
        String experiencesString = gson.toJson(experiences);

        editor.putString("123", experiencesString);
        editor.commit();
        Toast.makeText(this, "Data Saved:\n" + experiencesString,
                Toast.LENGTH_SHORT).show();

        setPrefs();
        startActivity(intent);

        InputMethodManager mgr =(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(),0);
        //Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }
}