package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        String [] years = candidate.getPeriodsInUkr().split("-");
        return (candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && (Integer.parseInt(years[1])
                - Integer.parseInt(years[0])) > MIN_YEARS);
    }
}
