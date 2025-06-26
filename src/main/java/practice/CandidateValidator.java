package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private final int minYearIn = 10;
    private final int minYearOld = 35;
    private final String splitPer = "-";
    private final String country = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split(splitPer);
        int from = Integer.parseInt(period[0].trim());
        int currentYear = Integer.parseInt(period[1].trim());
        boolean validPeriod = currentYear - from >= minYearIn;

        return candidate.getAge() >= minYearOld
                && validPeriod
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(country);
    }
}
