package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final String NATIONALITY = "Ukrainian";
    private static final int AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < AGE
                || (!candidate.isAllowedToVote())
                || (!(candidate.getNationality().equals(NATIONALITY)))) {
            return false;
        }

        String[] periods = candidate.getPeriodsInUkr().split(SEPARATOR);
        if (periods.length != 2) {
            return false;
        }
        return (Integer.parseInt(periods[1]) - Integer.parseInt(periods[0]))
                >= MIN_YEARS_IN_UKRAINE;
    }
}
