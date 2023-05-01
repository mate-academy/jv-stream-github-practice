package practice;

import model.Candidate;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int LIVE_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkr = candidate.getPeriodsInUkr().split("-");
        int startPeriodInUkr = Integer.parseInt(periodInUkr[0]);
        int finishPeriodInUkr = Integer.parseInt(periodInUkr[1]);

        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && finishPeriodInUkr - startPeriodInUkr >= LIVE_IN_UKRAINE;
    }}
