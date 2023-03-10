package Sport.Sports;

import java.util.ArrayList;
import java.util.HashMap;

import Sport.Scores.Score;
import Sport.Teams.Teams;
import Sport.Teams.Players.AbstractPlayer;

public abstract class AbstractSports {

    protected ArrayList<Teams> teamList;
    protected HashMap<Teams, ArrayList<Score>> scoreMap;
    protected int duration;
    protected String location;
    protected Teams winner;
    protected Teams loser;
    protected boolean stalemate = false;

    /* METHODS */

    public void presentTeams(ArrayList<Teams> teamList){
        for (int i = 0; i < teamList.size(); i++) {
            System.out.println(teamList.get(i).getName());
            System.out.print("\n");
            for (int j = 0; j < teamList.get(i).getListOfPlayers().size(); j++) {
                System.out.println(teamList.get(i).getListOfPlayers().get(j).getName());
            }
            System.out.print("\n");
        }
    }

    public void presentMatchScore(ArrayList<Teams> teamList){
        for (int i = 0; i < teamList.size()/2; i++) {
            System.out.println(teamList.get(i).getName() + " " + teamList.get(i).getScore() + " - " + teamList.get(i+1).getScore() + " " + teamList.get(i+1).getName());
        }
    };

    public void presentScorers(ArrayList<Teams> teamList){

        for (int i = 0; i < teamList.size(); i++) {
            for (int j = 0; j < teamList.get(i).getListOfPlayers().size(); j++) {
                if(teamList.get(i).getListOfPlayers().get(j).getScores() > 0){
                    System.out.println(teamList.get(i).getListOfPlayers().get(j).getName() + " scored " + teamList.get(i).getListOfPlayers().get(j).getScores() + " points." );
                }
            }
            
        }
    }

    public void presentPerformanceRating(Teams team){
        for (AbstractPlayer player : team.getListOfPlayers()) {
            System.out.println(player.getName() + " performance: " + team.getPerformanceRatingList().get(player));
        }

    }

    public AbstractPlayer calculateManOfTheGame(ArrayList<Teams> teamList){

        /* MAN OF THE GAME PERFORMANCE IS CALCULATED BY
         * Performance Rating + (Score * 2);
         */

        int manOfTheGamePerformanceRating = 0;
        int currentManOfTheGameIndex = 0;
        int currentManOfTheGameTeam = 0;

        for (int i = 0; i < teamList.size(); i++) {
            for (int j = 0; j < teamList.get(i).getListOfPlayers().size(); j++) {
                if(teamList.get(i).getListOfPlayers().get(j).getScores() + (teamList.get(i).getPerformanceRatingList().get(teamList.get(i).getListOfPlayers().get(j)) * 2) > manOfTheGamePerformanceRating){
                    manOfTheGamePerformanceRating = teamList.get(i).getListOfPlayers().get(j).getScores() + (teamList.get(i).getPerformanceRatingList().get(teamList.get(i).getListOfPlayers().get(j)) * 2);
                    currentManOfTheGameIndex = j;
                    currentManOfTheGameTeam = i;
                }
            }
        }

        return teamList.get(currentManOfTheGameTeam).getListOfPlayers().get(currentManOfTheGameIndex);
    }


    /* GETTERS */
    public ArrayList<Teams> getTeamsList() {
        return teamList;
    }
    public HashMap<Teams, ArrayList<Score>> getScoreMap() {
        return scoreMap;
    }
    public int getDuration() {
        return duration;
    }
    public String getLocation() {
        return location;
    }
    public Teams getWinner() {
        return winner;
    }

    public Teams getLoser() {
        return loser;
    }

    public boolean isStalemate() {
        return stalemate;
    }

    public void setWinner(Teams winner) {
        this.winner = winner;
    }

    public void setLoser(Teams loser) {
        this.loser = loser;
    }

    public void setStalemate(boolean stalemate) {
        this.stalemate = stalemate;
    }    

    
}
