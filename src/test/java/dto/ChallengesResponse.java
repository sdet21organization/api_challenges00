package dto;

import java.util.ArrayList;

public class ChallengesResponse {

    public ArrayList<Challenge> challenges;

    public ArrayList<Challenge> getChallenges() {
        return challenges;
    }

    public void setChallenges(ArrayList<Challenge> challenges) {
        this.challenges = challenges;
    }


    @Override
    public String toString() {
        return "ChallengesResponse{" +
                "challenges=" + challenges +
                '}';
    }
}
