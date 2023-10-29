package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String SPLIT_REGEX = "-";
    private static final int MIN_PERIOD_OF_LIVING = 10;

    @Override
    public boolean test(Candidate candidate) {
        boolean isAgeAllowed = candidate.getAge() >= MIN_AGE;
        boolean isAllowedToVote = candidate.isAllowedToVote();
        boolean isNationalityAllowed = candidate.getNationality().equals(REQUIRED_NATIONALITY);
        boolean isLivingTenYearsInUkraine
                = hasTenYearsPeriodOfLivingInUkraine(candidate.getPeriodsInUkr());

        return isAgeAllowed && isNationalityAllowed && isAllowedToVote && isLivingTenYearsInUkraine;
    }

    private boolean hasTenYearsPeriodOfLivingInUkraine(String period) {
        String[] periodLength = period.split(SPLIT_REGEX);
        return Integer.parseInt(periodLength[1])
                - Integer.parseInt(periodLength[0]) >= MIN_PERIOD_OF_LIVING;
    }
}
