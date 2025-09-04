package prog6112_a1;

public class SeriesModel {
    
    //Adding unique identifiers for the series model
    public String SeriesId;
    public String SeriesName;
    public String SeriesAge;
    public String SeriesNumberOfEpisodes;
    
    //Constructor for setting all the fields when a new series is captured
    public SeriesModel(String seriesId, String seriesName, String seriesAge, String seriesNumberOfEpisodes){
        this.SeriesId = seriesId;
        this.SeriesName = seriesName;
        this.SeriesAge = seriesAge;
        this.SeriesNumberOfEpisodes = seriesNumberOfEpisodes;
    }
    
    //Overriding the default toString() method 
    @Override
    public String toString(){
        return
               "SERIES ID: " + SeriesId + 
               "SERIES NAME: " + SeriesName + 
               "SERIES AGE RESTRICTION: " + SeriesAge +
               "SERIES NUMBER OF EPISODES: " + SeriesNumberOfEpisodes;
    }
         
}
