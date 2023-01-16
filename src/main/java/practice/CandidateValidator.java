package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int CANDIDATE_MIN_AGE = 35;
    public static final String CANDIDATE_DEFAULT_NATIONALITY = "Ukrainian";
    public static final int MIN_PERIOD_SPEND_IN_UKRAINE = 10;
    private final Predicate<Candidate> candidatePredicate = candidate -> {
        String[] candidateYears = candidate.getPeriodsInUkr().split("-");
        int yearTill = Integer.parseInt(candidateYears[1]);
        int yearFrom = Integer.parseInt(candidateYears[0]);
        return candidate.getClass().equals(Candidate.class)
                && candidate.getAge() >= CANDIDATE_MIN_AGE
                && candidate.getNationality().equals(CANDIDATE_DEFAULT_NATIONALITY)
                && candidate.isAllowedToVote()
                && yearTill - yearFrom >= MIN_PERIOD_SPEND_IN_UKRAINE;
    };

    public Predicate<Candidate> getCandidatePredicate() {
        return candidatePredicate;
    }

    @Override
    public boolean test(Candidate candidate) {
        return false;
    }
}