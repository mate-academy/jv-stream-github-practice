package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_PERIOD_OF_LIVING_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String SEPARATOR_FOR_PERIOD = "-";
    private static final int indexDateFrom = 0;
    private static final int indexDateTo = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] datesOfLiving = candidate.getPeriodsInUkr().split(SEPARATOR_FOR_PERIOD);
        int periodOfLiving =
                Integer.parseInt(datesOfLiving[indexDateTo]) - Integer.parseInt(datesOfLiving[indexDateFrom]);
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && periodOfLiving >= MIN_PERIOD_OF_LIVING_UKRAINE;
    }
}
