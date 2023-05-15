package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String YEAR_SPLITTER = "-";
    private static final String NATIONALITY = "Ukrainian";
    private static final int INDEX_FROM = 1;
    private static final int INDEX_TO = 0;
    private static final int MIN_LIVING_TERM = 10;
    private static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(YEAR_SPLITTER);
        int candidateLivingTerm =
                Integer.parseInt(years[INDEX_FROM]) - Integer.parseInt(years[INDEX_TO]);
        return candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.getAge() >= MIN_AGE
                && candidateLivingTerm >= MIN_LIVING_TERM;
    }
}
