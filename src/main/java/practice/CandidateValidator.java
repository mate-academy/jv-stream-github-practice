package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int PERIODSINUKR = 10;
    private static final String SEPARATOR = "-";
    private static final int END_PERIOD = 1;
    private static final int START_PERIOD = 0;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= AGE
                && candidate.getNationality().equals(NATIONALITY)
                && getYearsOfLiving(candidate) >= PERIODSINUKR
                && candidate.isAllowedToVote();
    }

    private int getYearsOfLiving(Candidate candidate) {
        String [] years = candidate.getPeriodsInUkr().split(SEPARATOR);
        return Integer.parseInt(years[END_PERIOD])
                - Integer.parseInt(years[START_PERIOD]);
    }
}
