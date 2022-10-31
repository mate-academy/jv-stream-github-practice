package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALTY = "Ukrainian";
    private static final int REQUIRED_MIN_PERIOD_LIVING = 10;
    private static final int INDEX_START_LIVING_YEAR = 0;
    private static final int INDEX_END_LIVING_YEAR = 1;
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALTY)
                && getLivingPariodInUkraine(candidate.getPeriodsInUkr())
                > REQUIRED_MIN_PERIOD_LIVING;
    }

    public int getLivingPariodInUkraine(String period) {
        String[] years = period.split(SEPARATOR);
        return Integer.parseInt(years[INDEX_END_LIVING_YEAR])
                - Integer.parseInt(years[INDEX_START_LIVING_YEAR]);
    }
}
