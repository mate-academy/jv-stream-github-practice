package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final int MIN_YEARS_UKR = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsHere = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MINIMUM_AGE
                        && candidate.getNationality().equals(NATIONALITY)
                        && candidate.isAllowedToVote()
                        && Integer.parseInt(yearsHere[1]) - Integer.parseInt(yearsHere[0]) >= MIN_YEARS_UKR;
    }
}
