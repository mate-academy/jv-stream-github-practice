package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SEPARATOR = "-";
    private static final String NATIONALITY = "Ukrainian";
    private static final int MINIMUM_AGE = 35;
    private static final int YEARS_IN_UKRAINE = 10;
    private static final int END_DATE = 1;
    private static final int START_DATE = 0;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMUM_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && timeLivedInUkr(candidate.getPeriodsInUkr()) >= YEARS_IN_UKRAINE;
    }

    private int timeLivedInUkr(String fromTo) {
        String[] years = fromTo.split(SEPARATOR);
        int fromYear = Integer.parseInt(years[START_DATE]);
        int toYear = Integer.parseInt(years[END_DATE]);
        return toYear - fromYear;
    }
}
