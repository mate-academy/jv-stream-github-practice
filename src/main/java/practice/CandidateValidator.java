package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN__AGE = 35;
    private static final int MIN_PERIODS_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkraine = candidate.getPeriodsInUkr().split("-");
        int startDateOfResidence = Integer.parseInt(periodsInUkraine[0]);
        int endDateOfResidence = Integer.parseInt(periodsInUkraine[1]);
        boolean result = candidate.getAge() >= MIN__AGE
                && candidate.getNationality().equals(NATIONALITY)
                && (endDateOfResidence - startDateOfResidence) >= MIN_PERIODS_IN_UKRAINE
                && candidate.isAllowedToVote() == true;
        return result;
    }

}
