package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private final String slashSeparator = "-";

    @Override
    public boolean test(Candidate candidate) {
        if (validCandidateAge(candidate) && validNationality(candidate)
                && validPeriodInUkr(candidate) && candidate.isAllowedToVote()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Candidate fred = new Candidate(39, "German", true, "2000-2019");
        fred.setName("Fred");
        CandidateValidator candidateValidator = new CandidateValidator();
        System.out.println(candidateValidator.test(fred));
    }

    private boolean validCandidateAge(Candidate candidate) {
        return candidate.getAge() >= 35;
    }

    private boolean validNationality(Candidate candidate) {
        return candidate.getNationality().equals("Ukrainian");
    }

    private boolean validPeriodInUkr(Candidate candidate) {
        int lastTimeInUkr = Integer.parseInt(candidate.getPeriodsInUkr()
                .split(slashSeparator)[1]);
        int startYearInUkr = Integer.parseInt(candidate.getPeriodsInUkr()
                .split(slashSeparator)[0]);
        if (lastTimeInUkr - startYearInUkr > 10) {
            return true;
        }
        return false;
    }
}
