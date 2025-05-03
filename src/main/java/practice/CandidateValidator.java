package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEARS_OF_RESIDENCY = 10;
    private static final int MIN_AGE = 35;
    private static final int INDEX_BECAME_RESIDENT = 0;
    private static final int INDEX_LAST_YEAR = 1;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] livedInUkraine = candidate.getPeriodsInUkr().split(SEPARATOR);
        int yearsOfResidency = Integer.parseInt(livedInUkraine[INDEX_LAST_YEAR])
                - Integer.parseInt(livedInUkraine[INDEX_BECAME_RESIDENT]);
        boolean isResidentEnough = yearsOfResidency >= MIN_YEARS_OF_RESIDENCY;
        boolean isOldEnough = candidate.getAge() >= MIN_AGE;
        boolean isUkrainian = candidate.getNationality().equals(NATIONALITY);
        return isOldEnough && isResidentEnough && isUkrainian && candidate.isAllowedToVote();
    }
}
