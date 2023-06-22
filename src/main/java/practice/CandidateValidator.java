package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int POSITION_FROM_YEAR = 1;
    private static final int POSITION_TO_YEAR = 0;
    private static final int MIN_LIVED_YEAR = 10;
    private static final String REGEX_SPLIT_YEARS = "-";
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(REGEX_SPLIT_YEARS);
        int livedInUkraine = Integer.parseInt(years[POSITION_FROM_YEAR])
                - Integer.parseInt(years[POSITION_TO_YEAR]);
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && livedInUkraine >= MIN_LIVED_YEAR;
    }
}
