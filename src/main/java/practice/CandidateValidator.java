package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REGEX = "-";
    private static final int INDEX_ZERO = 0;
    private static final int INDEX_ONE = 1;
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY_UKRAINIAN = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] dataSplit = candidate.getPeriodsInUkr().split(REGEX);
        int periodInUkr = Integer.parseInt(dataSplit[INDEX_ONE])
                - Integer.parseInt(dataSplit[INDEX_ZERO]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_UKRAINIAN)
                && periodInUkr >= MIN_PERIOD_IN_UKR;
    }
}
