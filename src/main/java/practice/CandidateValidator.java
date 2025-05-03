package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final String YEAR_SEPARATOR = "-";
    private static final int VALID_AGE = 35;
    private static final int YEARS_OF_LIVING = 10;
    private static final int FIRST_YEAR_INDEX = 0;
    private static final int LAST_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String [] years = candidate.getPeriodsInUkr().split(YEAR_SEPARATOR);
        int firstYear = Integer.parseInt(years[FIRST_YEAR_INDEX]);
        int lastYear = Integer.parseInt(years[LAST_YEAR_INDEX]);
        int periodOfLivingInUkraine = lastYear - firstYear;
        return periodOfLivingInUkraine >= YEARS_OF_LIVING && candidate.getAge() >= VALID_AGE
                && candidate.getNationality().equals(NATIONALITY) && candidate.isAllowedToVote();
    }
}
