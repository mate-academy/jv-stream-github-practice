package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public  boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                && livedInUkraineEnough(candidate.getPeriodsInUkr());
    }

    private boolean livedInUkraineEnough(String period) {
        String[] years = period.split("-");
        int from = Integer.parseInt(years[0]);
        int to = Integer.parseInt(years[1]);
        return to - from >= MIN_YEARS_IN_UKRAINE;
    }
}
