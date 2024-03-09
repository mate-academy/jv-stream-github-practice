package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String PERIODS_SEPARATOR = "-";

    private enum Nationality {
        UKR("Ukrainian");

        private final String name;
        
        Nationality(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split(PERIODS_SEPARATOR);
        int yearsInUkraine = Integer.parseInt(periods[1]) - Integer.parseInt(periods[0]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && Nationality.UKR.getName().equals(candidate.getNationality())
                && yearsInUkraine >= MIN_YEARS_IN_UKRAINE;
    }
}
