package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String DEFIES_REGEX = "-";
    private static final String UKRAINIAN = "Ukrainian";
    private static final int ALLOWED_TO_VOID = 35;
    private static final int NEEDED_PERIOD_IN_UKRAINE = 10;
    private static final int INDEX_OF_FROM_YEAR = 0;
    private static final int INDEX_OF_TO_YEAR = 1;

    public int getPeriodsInUkraine(String period) {
        String[] years = period.split(DEFIES_REGEX);
        return Integer.parseInt(years[INDEX_OF_TO_YEAR])
                - Integer.parseInt(years[INDEX_OF_FROM_YEAR]);
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= ALLOWED_TO_VOID
                && candidate.getNationality().equals(UKRAINIAN)
                && getPeriodsInUkraine(candidate.getPeriodsInUkr()) >= NEEDED_PERIOD_IN_UKRAINE;
    }
}
