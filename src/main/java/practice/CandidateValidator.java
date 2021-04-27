package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final String SPLITTER = "-";
    private static final int RESIDENCE = 10;
    private static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodResidence = candidate.getPeriodsInUkr().split(SPLITTER);
        int yearsResidence = Integer.parseInt(periodResidence[1])
                - Integer.parseInt(periodResidence[0]);
        return candidate.getNationality().equals(NATIONALITY)
                && candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && yearsResidence >= RESIDENCE;
    }
}
