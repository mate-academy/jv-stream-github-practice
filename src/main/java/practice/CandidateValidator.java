package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_PERIODS = 10;
    private static final int MIN_AGE_CANDIDATE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SPLITER = "-";

    @Override
    public boolean test(Candidate k) {
        return k.getAge() > MIN_AGE_CANDIDATE
                && k.isAllowedToVote()
                && k.getNationality().equals(NATIONALITY)
                && (Integer.parseInt(k.getPeriodsInUkr()
                .substring(k.getPeriodsInUkr().indexOf(SPLITER) + 1))
                - Integer.parseInt(k.getPeriodsInUkr()
                .substring(0, k.getPeriodsInUkr().indexOf(SPLITER)))) > MIN_PERIODS;
    }
}
