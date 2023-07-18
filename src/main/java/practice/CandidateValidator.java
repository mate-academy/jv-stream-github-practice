package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitPeriod = candidate.getPeriodsInUkr().split("-");
        int yearsInCountry = Integer.parseInt(splitPeriod[END_INDEX])
                - Integer.parseInt(splitPeriod[START_INDEX]);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= 35
                && candidate.getNationality().equals(NATIONALITY)
                && yearsInCountry >= 10;
    }
}
