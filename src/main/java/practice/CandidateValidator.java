package practice;

import model.Candidate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate>{
  public List<String> selectEligibleCandidates(List<Candidate> candidates) {
    if (candidates == null){
      throw new RuntimeException("Input list is null");
    }
    return candidates.stream().filter(this::test)
            .map(Candidate::getName)
            .sorted()
            .collect(Collectors.toList());
  }
  private boolean isValidFields(Candidate candidate) {
    return candidate.getNationality() != null && candidate.getPeriodsInUkr() != null
            && candidate.getName() != null;
  }

  private static int countYearsInUkraine(String period) {
    return Integer.parseInt(period.split("-")[1]) - Integer.parseInt(period.split("-")[0]);
  }

  @Override
  public  boolean test(Candidate candidate) {
    return isValidFields(candidate) && candidate.getAge() >= 35
            && candidate.isAllowedToVote() && candidate.getNationality().equals("Ukrainian")
            && countYearsInUkraine(candidate.getPeriodsInUkr()) > 10;
  }
}
