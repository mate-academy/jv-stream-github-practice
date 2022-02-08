package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

  @Override
  public boolean test(Candidate candidate) {
    String[] splittedPeriodInUkr = candidate.getPeriodsInUkr().split("-");
    int dateFrom = Integer.parseInt(splittedPeriodInUkr[0]);
    int dateTo = Integer.parseInt(splittedPeriodInUkr[1]);
    return candidate.getAge() >= 35
        && candidate.isAllowedToVote()
        && candidate.getNationality().equals("Ukrainian")
        && (dateTo - dateFrom) >= 10;
  }
}
