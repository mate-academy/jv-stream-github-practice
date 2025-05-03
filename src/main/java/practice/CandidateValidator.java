package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_AGE_FOR_CANDIDATE = 35;
    private static final int MINIMAL_PERIOD_OF_CONTINUOUS_STAY_FOR_CANDIDATE = 10;
    private static final int NUMBER_FROM_THE_YEAR = 0;
    private static final int NUMBER_UP_TO_A_YEAR = 1;
    private static final String SPLIT_CHARACTER = "-";
    private static final String NATIONALITY_FOR_THE_CANDIDATE = "Ukrainian";

    private int startYearLivingInCountry;
    private int finishYearLivingInCountry;
    private String[] yearsLivingInCountry;
    private int periodLivingInCountry;

    @Override
    public boolean test(Candidate candidate) {
        yearsLivingInCountry = candidate.getPeriodsInUkr().split(SPLIT_CHARACTER);
        startYearLivingInCountry = Integer.parseInt(yearsLivingInCountry[NUMBER_FROM_THE_YEAR]);
        finishYearLivingInCountry = Integer.parseInt(yearsLivingInCountry[NUMBER_UP_TO_A_YEAR]);
        periodLivingInCountry = finishYearLivingInCountry - startYearLivingInCountry;
        return candidate.getNationality().equals(NATIONALITY_FOR_THE_CANDIDATE)
                && candidate.isAllowedToVote()
                && periodLivingInCountry >= MINIMAL_PERIOD_OF_CONTINUOUS_STAY_FOR_CANDIDATE
                && candidate.getAge() >= MINIMAL_AGE_FOR_CANDIDATE;
    }
}
