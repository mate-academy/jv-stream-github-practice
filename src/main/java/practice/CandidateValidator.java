package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY_FOR_ELECTION = "Ukrainian";
    private static final int INDEX_FOR_FIRST_DATE = 0;
    private static final int INDEX_FOR_SECOND_DATE = 1;
    private static final int MIN_NUMBER_OF_LIVING_IN_UKR = 10;

    public CandidateValidator() {
    }

    @Override
    public boolean test(Candidate candidate) {
        int firstDate = Integer.parseInt(candidate.getPeriodsInUkr()
                .split("-")[INDEX_FOR_FIRST_DATE]);
        int secondDate = Integer.parseInt(candidate.getPeriodsInUkr()
                .split("-")[INDEX_FOR_SECOND_DATE]);
        return candidate.isAllowedToVote() && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY_FOR_ELECTION)
                && (secondDate - firstDate) >= MIN_NUMBER_OF_LIVING_IN_UKR;
    }
}
