package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String YEARS_SEPARATOR = "-";
    private static final int START_YEAR_INDEX = 0;
    private static final int FINISH_YEAR_INDEX = 1;
    private static final int MIN_AMOUNT_YEARS_IN_UKRAINE = 10;
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraineFromTo = candidate.getPeriodsInUkr().split(YEARS_SEPARATOR);
        int period = Integer.parseInt(periodInUkraineFromTo[START_YEAR_INDEX])
                - Integer.parseInt(periodInUkraineFromTo[FINISH_YEAR_INDEX]);

        return candidate.getAge() >= MIN_AGE
                && period >= MIN_AMOUNT_YEARS_IN_UKRAINE
                && candidate.getNationality().equals(NATIONALITY);
    }
    //write your code here
}
