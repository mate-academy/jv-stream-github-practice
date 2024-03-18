package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private final String ukrNationality = "Ukrainian";

    public CandidateValidator() {
    }

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(period[0]);
        int endYear = Integer.parseInt(period[1]);
        int periodInUA = endYear - startYear;
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ukrNationality)
                && periodInUA >= 10;
    }
}
