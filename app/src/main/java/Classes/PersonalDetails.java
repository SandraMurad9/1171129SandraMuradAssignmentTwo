package Classes;

import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class PersonalDetails {
    private String Name;
    private String Email;
    private String Phone;
    private String Hobbies;
    private String About;
    private String Gender ;

    public PersonalDetails() {
    }

    public PersonalDetails(String name, String email, String phone, String hobbies, String about, String gender) {
        Name = name;
        Email = email;
        Phone = phone;
        Hobbies = hobbies;
        About = about;
        Gender = gender;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getHobbies() {
        return Hobbies;
    }

    public void setHobbies(String hobbies) {
        Hobbies = hobbies;
    }

    public String getAbout() {
        return About;
    }

    public void setAbout(String about) {
        About = about;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    @Override
    public String toString() {
        return "PersonalDetails{" +
                "Name='" + Name + '\'' +
                ", Email='" + Email + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Hobbies='" + Hobbies + '\'' +
                ", About='" + About + '\'' +
                ", Gender='" + Gender + '\'' +
                '}';
    }
}
