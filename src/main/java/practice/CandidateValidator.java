package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final Predicate<Candidate> VALIDATE = new CandidateValidator();
    private static final String SEPARATE = "\\p{Punct}";
    private static final int YEARS_TO = 1;
    private static final int YEARS_FROM = 0;
    private static final int VALID_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int VALID_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsFromTo = candidate.getPeriodsInUkr().split(SEPARATE);
        int period = Integer.parseInt(yearsFromTo[YEARS_TO])
                - Integer.parseInt(yearsFromTo[YEARS_FROM]);

        return candidate.getAge() >= VALID_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && period >= VALID_PERIOD;
    }
}
