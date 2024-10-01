package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int INCLUDE_START_AND_END_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && calculateYearsOfResidence(candidate.getPeriodsInUkr()) >= 10;
    }

    private int calculateYearsOfResidence(String period) {
        String[] periods = period.split("-");
        int fromYear = Integer.parseInt(periods[0]);
        int toYear = Integer.parseInt(periods[1]);
        return toYear - fromYear + INCLUDE_START_AND_END_YEAR;
    }
}
