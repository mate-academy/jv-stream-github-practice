package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ACCEPTABLE_AGE = 35;
    private static final String UKRAINIAN = "Ukrainian";
    private static final String LINE = "-";
    private static final int FROM_YEAR = 0;
    private static final int TO_YEAR = 1;
    private static final int IS_LIVED_FOR_TEN_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= ACCEPTABLE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN)
                && isTenYearResident(candidate.getPeriodsInUkr());
    }

    private boolean isTenYearResident(String fromToYear) {
        String[] year = fromToYear.split(LINE);
        int yearFrom = Integer.parseInt(year[FROM_YEAR]);
        int yearTo = Integer.parseInt(year[TO_YEAR]);
        return (yearTo - yearFrom) >= IS_LIVED_FOR_TEN_YEARS;
    }
}
