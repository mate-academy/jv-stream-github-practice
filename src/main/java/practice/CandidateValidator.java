package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int YEARS_SPENT_IN_UA = 10;
    private static final int YEAR_FROM = 0;
    private static final int YEAR_TO = 1;
    private static final String SPLITTER = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && totalYearsSpentInUA(candidate.getPeriodsInUkr()) >= YEARS_SPENT_IN_UA;
    }

    private int totalYearsSpentInUA(String periodsInUA) {
        String[] splittedYears = periodsInUA.split(SPLITTER);
        return Integer.parseInt(splittedYears[YEAR_TO])
                - Integer.parseInt(splittedYears[YEAR_FROM]);
    }
}
