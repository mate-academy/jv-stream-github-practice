package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_AGE = 35;
    public static final String NATIONALITY = "Ukrainian";
    public static final int MIN_YEARS_LIVING_IN_UKR = 10;
    public static final int START_INDEX = 0;
    public static final int END_INDEX = 1;
    public static final String SPLIT_PATTERN = "-";

    @Override
    public boolean test(Candidate candidate) {
        int startLivingInUkr = Integer.parseInt(candidate.getPeriodsInUkr()
                .split(SPLIT_PATTERN)[START_INDEX]);
        int endLivingInUkr = Integer.parseInt(candidate.getPeriodsInUkr()
                .split(SPLIT_PATTERN)[END_INDEX]);
        return (endLivingInUkr - startLivingInUkr >= MIN_YEARS_LIVING_IN_UKR)
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote();
    }
}
