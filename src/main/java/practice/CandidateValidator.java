package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int PERIOD_FROM = 0;
    private static final int PERIOD_TO = 1;
    private static final String DASH = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && livedInUkraineForTenYears(candidate) >= 10;

    }

    private int livedInUkraineForTenYears(Candidate candidate) {
        String periodInUkr = candidate.getPeriodsInUkr();
        String[] allPeriod = periodInUkr.split(DASH);
        Integer yearFrom = Integer.parseInt(allPeriod[PERIOD_FROM]);
        Integer yearTo = Integer.parseInt(allPeriod[PERIOD_TO]);
        return yearTo - yearFrom;
    }
}
