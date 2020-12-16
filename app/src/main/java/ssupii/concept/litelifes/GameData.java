package ssupii.concept.litelifes;

public class GameData {
    private int year;
    private int age;
    private String name;
    private String countryName;

    GameData(){
        year = (int) (Math.random()*(2050-1900+1)+1900);
        age = 0;
        //TODO
        name = "Johnathan";
        //TODO
        countryName = "Germany";
    }
    GameData(int savedYear, int savedAge, String name, String countryName){
        year = savedYear;
        age = savedAge;
        this.name = name;
        //TODO
        this.countryName = countryName;
    }

    public int getGameYear(){ return year; }
    public int getAge(){ return age; }
    public String getName(){ return name; }
    //TODO
    public String getCountryName(){ return countryName; }

    protected void nextYear(){ year++; age++; }
}
