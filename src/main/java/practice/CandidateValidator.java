package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_YEAR_IN_UA = 10;
    private static final String SPLIT_REGEX = "-";
    private static final int INDEX_OF_THE_FIRST_YEAR_OF_WORK = 0;
    private static final int INDEX_OF_THE_LAST_YEAR_OF_WORK = 1;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIN_AGE
                || !candidate.isAllowedToVote()
                || !candidate.getNationality().equals(REQUIRED_NATIONALITY)) {
            return false;
        }
        String[] candidatePeriodsOfUA = candidate.getPeriodsInUkr().split(SPLIT_REGEX);
        return (Integer.parseInt(candidatePeriodsOfUA[INDEX_OF_THE_LAST_YEAR_OF_WORK])
                - Integer.parseInt(candidatePeriodsOfUA[INDEX_OF_THE_FIRST_YEAR_OF_WORK]))
                >= MIN_YEAR_IN_UA;
    }
}
