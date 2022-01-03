package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_MIN_TIME_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearFromToYearInUkraine = candidate.getPeriodsInUkr().split("-");
        int yearFrom = Integer.parseInt(yearFromToYearInUkraine[0]);
        int yearTo = Integer.parseInt(yearFromToYearInUkraine[1]);
        return candidate.getAge() >= REQUIRED_MIN_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && yearTo - yearFrom >= REQUIRED_MIN_TIME_IN_UKRAINE
                && candidate.isAllowedToVote();

    }
}