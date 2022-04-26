package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static int LOWEST_AGE = 35;
    private static String NATIONALITY = "Ukrainian";
    private static int PERIOD = 10;
    private static final String SPLIT = "-";
    private static final int START_YEAR = 0;
    private static final int END_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SPLIT);
        return candidate.getAge() >= LOWEST_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && Integer.parseInt(years[END_YEAR])
                - Integer.parseInt(years[START_YEAR]) >= PERIOD;
    }
}
