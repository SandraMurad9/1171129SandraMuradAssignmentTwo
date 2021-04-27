package Classes;

public class Experiences {
    private String education;
    private String University;
    private String Bacholar;
    private String Skills;
    private String Work;
    private String SpeakLanguages;
    private String Languages;

    public Experiences() {

    }

    public Experiences(String education, String university, String bacholar, String skills, String work, String speakLanguages, String languages) {
        this.education = education;
        University = university;
        Bacholar = bacholar;
        Skills = skills;
        Work = work;
        SpeakLanguages = speakLanguages;
        Languages = languages;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getUniversity() {
        return University;
    }

    public void setUniversity(String university) {
        University = university;
    }

    public String getBacholar() {
        return Bacholar;
    }

    public void setBacholar(String bacholar) {
        Bacholar = bacholar;
    }

    public String getSkills() {
        return Skills;
    }

    public void setSkills(String skills) {
        Skills = skills;
    }

    public String getWork() {
        return Work;
    }

    public void setWork(String work) {
        Work = work;
    }

    public String getSpeakLanguages() {
        return SpeakLanguages;
    }

    public void setSpeakLanguages(String speakLanguages) {
        SpeakLanguages = speakLanguages;
    }

    public String getLanguages() {
        return Languages;
    }

    public void setLanguages(String languages) {
        Languages = languages;

    }

    @Override
    public String toString() {
        return "Experiences{" +
                "education='" + education + '\'' +
                ", University='" + University + '\'' +
                ", Bacholar='" + Bacholar + '\'' +
                ", Skills='" + Skills + '\'' +
                ", Work='" + Work + '\'' +
                ", SpeakLanguages='" + SpeakLanguages + '\'' +
                ", Languages='" + Languages + '\'' +
                '}';
    }
}

