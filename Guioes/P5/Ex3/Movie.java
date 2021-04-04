import java.util.List;
import java.util.ArrayList;

public class Movie {
    private final String title;
    private final int year;
    private final Person director;
    private final Person writer;
    private final String series;
    private final List<Person> cast;
    private final List<Place> locations;
    private final List<String> languages;
    private final List<String> genres;
    private final boolean isTelevision;
    private final boolean isNetflix;
    private final boolean isIndependent;


    public static class Builder{
        //Required parameters
        private final String title;
        private final int year;

        //Optional parameters initialized with default values
        private  Person director = new Person("", 0);
        private  Person writer = new Person("", 0);
        private  String series = "";
        private  List<Person> cast = new ArrayList<Person>();
        private  List<Place> locations = new ArrayList<Place>();
        private  List<String> languages = new ArrayList<String>();
        private  List<String> genres = new ArrayList<String>();
        private  boolean isTelevision = false;
        private  boolean isNetflix = false;
        private  boolean isIndependent = false;

        //Builder Methods
        public Builder(String title, int year){
            this.title = title;
            this.year = year;
        }

        public Builder director(Person p){
            this.director = p;
            return this;
        }

        public Builder writer(Person p){
            this.writer = p;
            return this;
        }

        public Builder series(String s){
            this.series = s;
            return this;
        }

        public Builder cast(List<Person> list){
            this.cast = list;
            return this;
        }

        public Builder locations(List<Place> list){
            this.locations = list;
            return this;
        }

        public Builder languages(List<String> list){
            this.languages = list;
            return this;
        }

        public Builder genres(List<String> list){
            this.genres = list;
            return this;
        }

        public Builder isTelevision(boolean bol){
            this.isTelevision = bol;
            return this;
        }

        public Builder isNetflix(boolean bol){
            this.isNetflix = bol;
            return this;
        }

        public Builder isIndependent(boolean bol){
            this.isIndependent = bol;
            return this;
        }

        public Movie build(){
            return new Movie(this);
        }
    }

    private Movie(Builder builder){
        title = builder.title;
        year = builder.year;
        director = builder.director;
        writer = builder.writer;
        series = builder.series;
        cast = builder.cast;
        locations = builder.locations;
        languages = builder.languages;
        genres = builder.genres;
        isTelevision = builder.isTelevision;
        isNetflix = builder.isNetflix;
        isIndependent = builder.isIndependent;
    }
    
}