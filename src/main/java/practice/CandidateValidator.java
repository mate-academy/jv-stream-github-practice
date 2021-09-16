package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate {
    private final int minimalAge = 35;
    private final int firstYearIndex = 0;
    private final int secondYearIndex = 1;
    private final int minimalYearInCountry = 10;
    private final String nationality = "Ukrainian";

    @Override
    public boolean test(Object object) {
        Candidate candidate = (Candidate) object;
        return candidate.getAge() >= minimalAge
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(nationality)
                && isTruePeriodInUkraine(candidate);
    }

    private boolean isTruePeriodInUkraine(Candidate candidate) {
        String[] arrayOfYears = candidate.getPeriodsInUkr().split("-");
        int distinct = Integer.parseInt(arrayOfYears[secondYearIndex])
                - Integer.parseInt(arrayOfYears[firstYearIndex]);
        return distinct >= minimalYearInCountry;
    }
    //write your code here
}
