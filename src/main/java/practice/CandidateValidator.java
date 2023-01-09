package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int INDEX_FIRST_YEAR = 0;
    private static final int INDEX_SECOND_YEAR = 1;
    private static final int MIN_LIVE_YEAR = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && checkLiveInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean checkLiveInUkraine(String period) {
        String[] array = period.split("-");
        int firstYear = Integer.parseInt(array[INDEX_FIRST_YEAR]);
        int lastYear = Integer.parseInt(array[INDEX_SECOND_YEAR]);
        return lastYear - firstYear >= MIN_LIVE_YEAR;
    }
}
