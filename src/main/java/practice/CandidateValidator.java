package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final String DASH_SEPARATOR = "-";
    private static final int VALID_AGE = 35;
    private static final int LIVED_YEARS_IN_UKRAINE = 10;
    private static final int FROM = 0;
    private static final int TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= VALID_AGE
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && candidate.isAllowedToVote()
                && getLivedYearsInUkraine(candidate) >= LIVED_YEARS_IN_UKRAINE;
    }

    private int getLivedYearsInUkraine(Candidate candidate) {
        String[] yearsFromTo = candidate.getPeriodsInUkr().split(DASH_SEPARATOR);
        int fromYear = Integer.parseInt(yearsFromTo[FROM]);
        int toYear = Integer.parseInt(yearsFromTo[TO]);
        return toYear - fromYear;
    }
}
