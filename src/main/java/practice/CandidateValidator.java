package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String DIVIDED = "-";
    private static final int MIN_YEAR_LIVE_IN_UKRAINE = 10;
    private static final int MIN_AGE_PRESIDENT = 35;
    private static final int INDEX_BIG_DATE = 1;
    private static final int INDEX_SMALL_DATE = 0;

    @Override
    public boolean test(Candidate o) {
        if (o.getAge() >= MIN_AGE_PRESIDENT
                && o.isAllowedToVote()
                && o.getNationality().equals("Ukrainian")) {
            String[] years = o.getPeriodsInUkr().split(DIVIDED);
            int[] yearsInt = new int[] {Integer.parseInt(years[INDEX_SMALL_DATE]),
                    Integer.parseInt(years[INDEX_BIG_DATE])};
            return yearsInt[INDEX_BIG_DATE] - yearsInt[INDEX_SMALL_DATE]
                    >= MIN_YEAR_LIVE_IN_UKRAINE;
        }
        return false;
    }
}
