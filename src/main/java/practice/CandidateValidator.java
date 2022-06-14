package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ELIGIBLE_AGE = 35;
    private static final int ELIGIBLE_PERIOD = 10;
    private static final int GET_DATE_FROM = 0;
    private static final int GET_DATE_TO = 1;
    private static final String ELIGIBLE_NATIONALITY = "Ukrainian";

    private boolean getYearsInUkraine(Candidate candidate) {
        String[] temp = candidate.getPeriodsInUkr().split("-");
        int yearFrom = Integer.parseInt(temp[GET_DATE_FROM]);
        int yearTo = Integer.parseInt(temp[GET_DATE_TO]);
        return (yearTo - yearFrom) >= ELIGIBLE_PERIOD;
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= ELIGIBLE_AGE
                && getYearsInUkraine(candidate)
                && candidate.getNationality().equals(ELIGIBLE_NATIONALITY);
    }
}
