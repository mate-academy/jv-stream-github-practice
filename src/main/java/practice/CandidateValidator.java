package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String SPLIT_REGEX = "-";
    private static final int MIN_PERIOD_OF_LIVING = 10;
    private static final int LIVE_FROM = 0;
    private static final int LIVE_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        boolean isAgeAllowed = candidate.getAge() >= MIN_AGE;
        boolean isAllowedToVote = candidate.isAllowedToVote();
        boolean isNationalityAllowed = candidate.getNationality().equals(REQUIRED_NATIONALITY);
        boolean hasTenYearsInUkraine = getYearsInUkraine(candidate.getPeriodsInUkr());

        return isAgeAllowed && isNationalityAllowed && isAllowedToVote && hasTenYearsInUkraine;
    }

    private boolean getYearsInUkraine(String period) {
        String[] periodLength = period.split(SPLIT_REGEX);
        int yearsInUkraine = Integer.parseInt(periodLength[LIVE_TO])
                - Integer.parseInt(periodLength[LIVE_FROM]);
        return yearsInUkraine >= MIN_PERIOD_OF_LIVING;
    }
}
