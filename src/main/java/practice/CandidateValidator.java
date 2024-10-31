package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String TARGET_NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        boolean isValidAge = candidate.getAge() >= MIN_AGE;
        boolean isValidVoteAllow = candidate.isAllowedToVote();
        boolean isValidNationality = candidate.getNationality().equals(TARGET_NATIONALITY);
        boolean isValidYearsPeriod = Integer.parseInt(years[1]) - Integer.parseInt(years[0])
                >= MIN_YEARS_PERIOD;
        return isValidAge && isValidNationality && isValidYearsPeriod && isValidVoteAllow;
    }

    //write your code here
}
