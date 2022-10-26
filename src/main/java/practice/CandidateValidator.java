package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SPLIT_FOR_DATE = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && isValidPeriods(candidate);
    }

    private boolean isValidPeriods(Candidate candidate) {
        String[] date = candidate.getPeriodsInUkr().split(SPLIT_FOR_DATE);
        int yearFrom = Integer.parseInt(date[0]);
        int yearTo = Integer.parseInt(date[1]);
        return yearTo - yearFrom >= 10;
    }
}
