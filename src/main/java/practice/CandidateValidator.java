package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String YEARS_SEPARATOR = "-";
    private static final int MIN_AGE = 35;
    private static final int TIME_IN_UA = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final boolean ALLOWED_TO_VOTE = true;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkr = candidate.getPeriodsInUkr().split(YEARS_SEPARATOR);
        int firstYearInCountry = Integer.parseInt(yearsInUkr[0]);
        int lastYearInCountry = Integer.parseInt(yearsInUkr[1]);
        int currentPeriodInCountry = lastYearInCountry - firstYearInCountry;
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote() == ALLOWED_TO_VOTE
                && candidate.getNationality().equals(NATIONALITY)
                && currentPeriodInCountry >= TIME_IN_UA;
    }
}
