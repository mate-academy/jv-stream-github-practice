package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int REQUIRED_AGE_TO_VOTE = 35;
    private static final String REQUIRED_NATIONALITY_TO_VOTE = "Ukrainian";
    private static final String REGEX_FOR_SPLIT = "-";
    private static final int FIRST_ELEMENT_FOR_CALCULATING = 0;
    private static final int SECOND_ELEMENT_FOR_CALCULATING = 1;
    private static final int YEARS_THRESHOLD = 5;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split(REGEX_FOR_SPLIT);

        return candidate.getAge() >= REQUIRED_AGE_TO_VOTE
                && candidate.isAllowedToVote()
                && REQUIRED_NATIONALITY_TO_VOTE.equals(candidate.getNationality())
                && (Integer.parseInt(periodsInUkr[SECOND_ELEMENT_FOR_CALCULATING])
                - Integer.parseInt(periodsInUkr[FIRST_ELEMENT_FOR_CALCULATING])) > YEARS_THRESHOLD;
    }
}
