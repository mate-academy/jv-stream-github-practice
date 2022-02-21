package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final String NATIONAL = "Ukrainian";
    private static final String DELIMITER = "-";
    private static final int MIN_YEAR_TO_LIVE = 10;
    private static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(DELIMITER);
        int parseYears = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONAL)
                && parseYears >= MIN_YEAR_TO_LIVE;
    }
}
