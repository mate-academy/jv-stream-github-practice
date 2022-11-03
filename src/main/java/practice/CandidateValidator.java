package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private int neededPeriodInUkr = 10;
    private int minCandidatesAge = 35;
    private String neededNationality = "Ukrainian";

    public int getNeededPeriodInUkr() {
        return neededPeriodInUkr;
    }

    public void setNeededPeriodInUkr(int neededPeriodInUkr) {
        this.neededPeriodInUkr = neededPeriodInUkr;
    }

    public int getMinCandidateAge() {
        return minCandidatesAge;
    }

    public void setMinCandidateAge(int minCandidateAge) {
        this.minCandidatesAge = minCandidateAge;
    }

    public String getNeededNationality() {
        return neededNationality;
    }

    public void setNeededNationality(String neededNationality) {
        this.neededNationality = neededNationality;
    }

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        return (Integer.parseInt(period[1]) - Integer.parseInt(period[0]) >= neededPeriodInUkr)
                && candidate.getNationality().equals(neededNationality)
                && candidate.getAge() >= minCandidatesAge
                && candidate.isAllowedToVote();
    }
}
