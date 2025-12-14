package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_RESIDANCE_AGE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        boolean isOldEnough = candidate.getAge() >= MIN_AGE;
        boolean isAllowedToVote = candidate.isAllowedToVote();
        boolean isUkrainian = candidate.getNationality().equals(NATIONALITY);
        boolean isLivedEnough = getPeriodsInUkr(candidate.getPeriodsInUkr()) >= MIN_RESIDANCE_AGE;
        return isOldEnough && isAllowedToVote && isUkrainian && isLivedEnough;
    }

    private int getPeriodsInUkr(String periodsInUkr) {
        String[] years = periodsInUkr.split("-");

        int startYear = Integer.parseInt(years[0]);
        int endYear = Integer.parseInt(years[1]);

        return endYear - startYear;
    }
}
