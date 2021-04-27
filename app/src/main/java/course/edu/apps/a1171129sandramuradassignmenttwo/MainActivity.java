package course.edu.apps.a1171129sandramuradassignmenttwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;

import Classes.PersonalDetails;


public class MainActivity extends AppCompatActivity {

    private EditText NameTxt;
    private EditText EmailTxt;
    private EditText PhoneTxt;
    private EditText HobbiesTxt;
    private EditText AboutTxt;

    Spinner GenderSpn ;

    public CheckBox chk;

    public static final String NAME ="NAME";
    public static final String EMAIL ="EMAIL";
    public static final String PHONE ="PHONE";
    public static final String HOBBIES ="HOBBIES";
    public static final String ABOUT ="ABOUT";
    public static final String GENDER ="GENDER";
    public static final String FLAG ="FLAG";

    public boolean flag= false;

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GenderSpn = findViewById(R.id.GenderSpn);
        setupViews();
        populateSpinner();
        setupSharedPrefs();

    }
    private void setupSharedPrefs() {

        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        editor= prefs.edit();
    }

    private void setupViews() {
        NameTxt=findViewById(R.id.NameTxt);
        EmailTxt=findViewById(R.id.EmailTxt);
        PhoneTxt=findViewById(R.id.PhoneTxt);
        HobbiesTxt=findViewById(R.id.HobbiesTxt);
       AboutTxt =findViewById(R.id.AboutTxt);

    }
    private void populateSpinner() {
        ArrayList<String> data = new ArrayList<>();
        data.add("Male");
        data.add("Female");
        ArrayAdapter<String > adpter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,data);
        GenderSpn.setAdapter(adpter);
    }

    public void nextPageOnClick(View view) {

        Intent intent = new Intent(this,MainActivity2.class);

        String Name = NameTxt.getText().toString();
        intent.putExtra("NAME", Name);
        String email = EmailTxt.getText().toString();
        intent.putExtra("email", email);
        String Phone = PhoneTxt.getText().toString();
        intent.putExtra("Phone", Phone);
        String Hobbies = HobbiesTxt.getText().toString();
        intent.putExtra("Hobbies", Hobbies);
        String  About = AboutTxt.getText().toString();
        intent.putExtra(" About",  About);
        String str = GenderSpn.getSelectedItem().toString();
        intent.putExtra("spinner",str);

        PersonalDetails[] personal = new PersonalDetails[1];
        personal[0] = new PersonalDetails(Name, email,Phone,Hobbies,About,str);



        Gson gson = new Gson();
        String perosnalString = gson.toJson(personal);

        editor.putString("Personal Details", perosnalString);
        editor.commit();
        Toast.makeText(this, "Data Saved:\n" + perosnalString,
                Toast.LENGTH_SHORT).show();

        startActivity(intent);
        InputMethodManager mgr =(InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.hideSoftInputFromWindow(view.getWindowToken(),0);


        //Toast.makeText(this,str,Toast.LENGTH_SHORT).show();
    }

}
