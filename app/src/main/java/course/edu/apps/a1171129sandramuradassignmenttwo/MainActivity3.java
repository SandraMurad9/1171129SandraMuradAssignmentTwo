package course.edu.apps.a1171129sandramuradassignmenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import Classes.Experiences;
import Classes.PersonalDetails;

public class MainActivity3 extends AppCompatActivity {

    private TextView personalView;
    private TextView experienceView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        setupViews();
        setText();
    }
    private void setupViews() {
        personalView=findViewById(R.id.personalView);
        experienceView=findViewById(R.id.experienceView);
    }
    public void setText() {


        Intent intent= getIntent();

        String Name = intent.getStringExtra("NAME");
        String email = intent.getStringExtra("email");
        String Phone = intent.getStringExtra("Phone");
        String Hobbies = intent.getStringExtra("Hobbies");
        String About = intent.getStringExtra("About");
        String str = intent.getStringExtra("spinner");

        String education = intent.getStringExtra("EDUCATION");
        String university = intent.getStringExtra("UNIVERSITY");
        String bacholar = intent.getStringExtra("BACHOLAR");
        String skills = intent.getStringExtra("SKILLS");
        String speaklanguages = intent.getStringExtra("SPEAKLANGUAGES");
        String languages = intent.getStringExtra("LANGUAGES");

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        Gson gson = new Gson();
        String string = prefs.getString("123", "");

        PersonalDetails[] perosnalString = gson.fromJson(string, PersonalDetails[].class);
        Experiences[] experiences = gson.fromJson(string, Experiences[].class);

        personalView.setText("My Name is"+ Name +"/n" + "Email"+ email + "/n"+
                "Phone Number"+ Phone +"/n" + "my Hobbies are"+ Hobbies + "/n"+
                 About +"/n" + "I am"+ str + "/n");

        experienceView.setText("My eEducation"+ education +"/n" + "i study at"+ university + "/n"+
                "In bacholor of"+ bacholar +"/n" + "my skills are"+ skills + "/n"+
                "do I speak forgin Languages"+speaklanguages+"/n" + "the language are "+ languages + "/n");


//        Toast.makeText(this, " " + personalDetails
//                , Toast.LENGTH_SHORT).show();
    }


    }
