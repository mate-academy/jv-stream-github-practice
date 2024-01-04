package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_ACCEPTED_AGE = 35;
    private static final int COUNTRY_LIVING_PERIOD = 10;
    private static final int COUNTRY_LIVING_START_INDEX = 0;
    private static final int COUNTRY_LIVING_END_INDEX = 1;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SPLIT_START_END_YEARS_SYMBOL = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate != null
            && candidate.isAllowedToVote()
            && verifyCandidateAgeIsOk(candidate)
            && verifyCandidateNationalityIsOk(candidate)
            && verifyCandidateCountryLivingPeriodIsOk(candidate);
    }

    private boolean verifyCandidateNationalityIsOk(Candidate candidate) {
        return NATIONALITY.equals(candidate.getNationality());
    }

    private boolean verifyCandidateCountryLivingPeriodIsOk(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SPLIT_START_END_YEARS_SYMBOL);
        int startYear = Integer.parseInt(years[COUNTRY_LIVING_START_INDEX]);
        int endYear = Integer.parseInt(years[COUNTRY_LIVING_END_INDEX]);
        return (endYear - startYear) >= COUNTRY_LIVING_PERIOD;
    }

    private boolean verifyCandidateAgeIsOk(Candidate candidate) {
        return candidate.getAge() >= MIN_ACCEPTED_AGE;
    }
}
