package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int PERIODS = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final int FROM = 1;
    private static final int TO = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && (Integer.parseInt(years[FROM]) - Integer.parseInt(years[TO]) >= PERIODS);
    }
}
