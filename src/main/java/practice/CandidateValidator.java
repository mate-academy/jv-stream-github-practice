package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRIANE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SPLITERATOR = "-";
    private static final int FROM = 0;
    private static final int TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && periodInUkr(candidate) >= MIN_YEARS_IN_UKRIANE
                && candidate.isAllowedToVote();
    }

    public int periodInUkr(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SPLITERATOR);
        return Integer.parseInt(years[TO]) - Integer.parseInt(years[FROM]);
    }

}
