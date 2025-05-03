package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static int MIN_AGE = 35;
    private static String REQUIRED_NATIONALITY = "Ukrainian";
    private static String REGEX = "-";
    private static int MIN_DURATION_IN_UK = 10;
    private static int FROM_YEAR_OF_LIVE_IN_UK = 0;
    private static int TO_YEAR_OF_LIVE_IN_UK = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUk = candidate.getPeriodsInUkr().split(REGEX);
        int durationLivingInUK = Integer.parseInt(periodsInUk[TO_YEAR_OF_LIVE_IN_UK])
                - Integer.parseInt(periodsInUk[FROM_YEAR_OF_LIVE_IN_UK]);
        boolean durationTrue = durationLivingInUK >= MIN_DURATION_IN_UK;
        return durationTrue
                && candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY);
    }
}
