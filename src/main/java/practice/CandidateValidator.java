package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKR = 10;
    private static final int FIRST_NUMBER_INDEX = 1;
    private static final int SECOND_NUMBER_INDEX = 0;
    private static final String NATIONALITY = "Ukrainian";
    private static final String REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        int periodInUkr = Integer.parseInt(
                candidate.getPeriodsInUkr().split(REGEX)[FIRST_NUMBER_INDEX])
                - Integer.parseInt(
                        candidate.getPeriodsInUkr().split(REGEX)[SECOND_NUMBER_INDEX]);
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && periodInUkr >= MIN_PERIOD_IN_UKR;
    }
}
