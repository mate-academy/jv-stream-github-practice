package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private final int validCandidateAge = 35;
    private final int validPeriodsInUkr = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= validCandidateAge && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && getPeriodsInUkr(candidate.getPeriodsInUkr()) >= validPeriodsInUkr;
    }

    private static int getPeriodsInUkr(String period) {
        int index = period.indexOf('-');
        int startYear = Integer.parseInt(period.substring(0, index));
        int endYear = Integer.parseInt(period.substring(index + 1));
        return endYear - startYear;
    }
}
