package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private final static int REQUIRED_AGE = 35;
    private final static int PERIODS_IN_UKR = 10;
    private final static String NATIONALITY_UKRAINIAN = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(periods[0]);
        int endYear = Integer.parseInt(periods[1]);
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.getNationality().equals(NATIONALITY_UKRAINIAN)
                && candidate.isAllowedToVote()
                && (endYear - startYear) >= PERIODS_IN_UKR; }
}
