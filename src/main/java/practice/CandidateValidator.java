package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static int MIN_AGE = 35;
    private static int PERIOD_IN_UKRAINE = 35;
    private static final int MIN_COUNTRY_LIVE_PERIOD = 10;
    private static String NATIONALITY_ALLOWED = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_ALLOWED)
                && periodInCountry(candidate);
    }

    private boolean periodInCountry(Candidate candidate) {
        String[] yearsIn = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(yearsIn[1]) - Integer.parseInt(yearsIn[0])
                >= MIN_COUNTRY_LIVE_PERIOD;
    }
}
