package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REGEX = "-";
    private static final int YEAR_BEFORE_INDEX = 0;
    private static final int YEAR_AFTER_INDEX = 1;
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY_UKRAINIAN = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] dataSplit = candidate.getPeriodsInUkr().split(REGEX);
        int periodInUkr = Integer.parseInt(dataSplit[YEAR_AFTER_INDEX])
                - Integer.parseInt(dataSplit[YEAR_BEFORE_INDEX]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_UKRAINIAN)
                && periodInUkr >= MIN_PERIOD_IN_UKR;
    }
}
