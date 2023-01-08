package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static String NATIONALITY = "Ukrainian";
    private static final int PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        return checkAge(candidate)
                && checkNationality(candidate)
                && checkPeriod(candidate);
    }

    public boolean checkAge(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE;
    }

    public boolean checkNationality(Candidate candidate) {
        return candidate.getNationality().equals(NATIONALITY);
    }

    public boolean checkPeriod(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split("-");
        int diff = Integer.parseInt(split[1]) - Integer.parseInt(split[0]);
        return diff >= PERIOD;
    }
}

