package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private final String slashSeparator = "-";

    @Override
    public boolean test(Candidate candidate) {
        return validCandidateAge(candidate) && validNationality(candidate)
                && validPeriodInUkr(candidate) && candidate.isAllowedToVote();
    }

    private boolean validCandidateAge(Candidate candidate) {
        return candidate.getAge() >= 35;
    }

    private boolean validNationality(Candidate candidate) {
        return candidate.getNationality().equals("Ukrainian");
    }

    private boolean validPeriodInUkr(Candidate candidate) {
        int lastTimeInUkr = Integer.parseInt(candidate.getPeriodsInUkr()
                .split(slashSeparator)[1]);
        int startYearInUkr = Integer.parseInt(candidate.getPeriodsInUkr()
                .split(slashSeparator)[0]);
        return lastTimeInUkr - startYearInUkr > 10;
    }
}
