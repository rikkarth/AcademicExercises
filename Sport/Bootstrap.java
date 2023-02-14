package Sport;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Sport.Teams.Teams;
import Sport.Teams.Players.AbstractPlayer;
import Sport.Teams.Players.FootballPlayer;

public class Bootstrap {

    public ArrayList<Teams> bootstrapTeamsWithInput(){
        
        Scanner scNumberOfTeamsInLeague = new Scanner(System.in);
        System.out.println("How many teams will play in this league?");

        int numberOfSelectedTeams = scNumberOfTeamsInLeague.nextInt();

        ArrayList<Teams> teamList = new ArrayList<>();

        for (int i = 1; i <= numberOfSelectedTeams; i++) {
            System.out.print(i + " - Insert Name: ");
            Scanner scTeamName = new Scanner(System.in);

            teamList.add(new Teams(
                scTeamName.next(), 
                new ArrayList<AbstractPlayer>()
                {
                    {
                        for (int j = 1; j <= 11; j++) {
                            add(new FootballPlayer("Stub_" + j));
                        }
                    }
                }));
        }        

        return teamList;
    }
    
}