package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_OF_THE_CANDIDATE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_CANDIDATE_LIVE_PERIOD = 10;
    private static final String PERIOD_DATA_SEPARATOR = "-";
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return isCandidateOlderThanMinAge(candidate)
                && isCandidateHasUkrainianNationality(candidate)
                && isCandidateLivedMinPeriod(candidate)
                && candidate.isAllowedToVote();
    }

    private boolean isCandidateOlderThanMinAge(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_OF_THE_CANDIDATE;
    }

    private boolean isCandidateHasUkrainianNationality(Candidate candidate) {
        return candidate
                .getNationality()
                .strip()
                .equals(NATIONALITY);
    }

    private boolean isCandidateLivedMinPeriod(Candidate candidate) {
        return getYearFromPeriod(candidate.getPeriodsInUkr()) >= MIN_CANDIDATE_LIVE_PERIOD;
    }

    private int getYearFromPeriod(String period) {
        String[] splitPeriod = period.split(PERIOD_DATA_SEPARATOR);
        int toYear = Integer.parseInt(splitPeriod[TO_YEAR_INDEX]);
        int fromYear = Integer.parseInt(splitPeriod[FROM_YEAR_INDEX]);
        return toYear - fromYear;
    }
}
