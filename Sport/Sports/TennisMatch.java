package Sport.Sports;

import java.util.ArrayList;
import java.util.HashMap;

import Sport.Scores.Score;
import Sport.Teams.Teams;

public class TennisMatch extends AbstractSports {

    public final String MATCHTYPE = "Tennis";

    /* Constructor */
    public TennisMatch(
        ArrayList<Teams> teamList, 
        HashMap<Teams, ArrayList<Score>> scoreMap, 
        int duration, 
        String location
        ){
        
        this.scoreMap = scoreMap;
        this.duration = duration;
        this.location = location;
        this.teamList = teamList;
    }



    // Create a readable string from an hashmap describing tenismatch scoreMap (make a method)
    
}
