package ssupii.concept.litelifes;

import java.io.Serializable;

public class GameData implements Serializable {
    private int year;
    private int age;
    private String name;
    private String countryName;

    GameData(){
        year = (int) (Math.random()*(2050-1900+1)+1900);
        age = 0;
        //TODO random name system
        name = "Johnathan";
        //TODO surname
        //TODO random country system
        countryName = "Germany";
    }
    GameData(int savedYear, int savedAge, String name, String countryName){
        year = savedYear;
        age = savedAge;
        this.name = name;
        this.countryName = countryName;
    }

    public int getGameYear(){ return year; }
    public int getAge(){ return age; }
    public String getName(){ return name; }
    public String getCountryName(){ return countryName; }

    //TODO core events system
    protected void nextYear(){ year++; age++; }

    //TODO events saving system
}
