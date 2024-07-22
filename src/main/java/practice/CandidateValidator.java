package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MIN_AGE = 35;
    private static final int COUNT_YEARS_RESIDENCE = 10;
    private static final int START_DATA = 0;
    private static final int END_DATA = 1;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIN_AGE || !candidate.isAllowedToVote()
                || !REQUIRED_NATIONALITY.equals(candidate.getNationality())) {
            return false;
        }

        String[] periods = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(periods[START_DATA]);
        int endYear = Integer.parseInt(periods[END_DATA]);
        return (endYear - startYear) >= COUNT_YEARS_RESIDENCE;
    }
}
