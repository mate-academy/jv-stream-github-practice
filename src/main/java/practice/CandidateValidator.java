package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final String YEARS_SPLITERATOR = "-";
    private static final int INDEX_START_OF_LIVING = 0;
    private static final int INDEX_END_OF_LIVING = 1;
    private static final int YEARS_OF_LIVING = 10;
    private static final int AGE_ALLOWED = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodOfLiving = candidate.getPeriodsInUkr().split(YEARS_SPLITERATOR);
        return candidate.getAge() >= AGE_ALLOWED
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && (Integer.parseInt(periodOfLiving[INDEX_END_OF_LIVING])
                - Integer.parseInt(periodOfLiving[INDEX_START_OF_LIVING]) >= YEARS_OF_LIVING);
    }
}
