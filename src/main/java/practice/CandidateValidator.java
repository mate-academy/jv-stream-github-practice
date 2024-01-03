package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_ACCEPTED_AGE = 35;
    private static final int COUNTRY_LIVING_PERIOD = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate != null
            && candidate.isAllowedToVote()
            && verifyCandidateAgeIsOk(candidate)
            && verifyCandidateNationalityIsOk(candidate)
            && verifyCandidateCountryLivingPeriodIsOk(candidate);
    }

    private boolean verifyCandidateNationalityIsOk(Candidate candidate) {
        return candidate.getNationality() != null
            && candidate.getNationality().equals(NATIONALITY);
    }

    private boolean verifyCandidateCountryLivingPeriodIsOk(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(years[0]);
        int endYear = Integer.parseInt(years[1]);
        return (endYear - startYear) >= COUNTRY_LIVING_PERIOD;
    }

    private boolean verifyCandidateAgeIsOk(Candidate candidate) {
        return candidate.getAge() >= MIN_ACCEPTED_AGE;
    }
}
