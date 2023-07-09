package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    public static final int MIN_AGE_FOR_PRESIDENT_POSITION = 35;
    public static final int MIN_LIVING_YEARS_FOR_PRESIDENT_POSITION = 10;
    public static final int INDEX_OF_START_LIVING = 0;
    public static final int INDEX_OF_END_LIVING = 1;
    public static final String PRESIDENT_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_FOR_PRESIDENT_POSITION
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(PRESIDENT_NATIONALITY)
                && getLivingYearsInUkraine(candidate) >= MIN_LIVING_YEARS_FOR_PRESIDENT_POSITION;
    }

    private int getLivingYearsInUkraine(Candidate candidate) {
        String[] stringYears = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(stringYears[INDEX_OF_END_LIVING])
                - Integer.parseInt(stringYears[INDEX_OF_START_LIVING]);
    }
}
