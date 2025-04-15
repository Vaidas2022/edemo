package lt.kauneta.edemocracy.issue.application;

import lt.kauneta.edemocracy.issue.domain.Issue;
import lt.kauneta.edemocracy.issue.domain.IssueRepository;
import lt.kauneta.edemocracy.issue.dto.CreateIssueRequest;
import lt.kauneta.edemocracy.issue.dto.IssueDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class IssueService {

    private final IssueRepository issueRepository;

    public IssueService(IssueRepository issueRepository) {
        this.issueRepository = issueRepository;
    }

    public void create(CreateIssueRequest request) {
        Issue issue = new Issue(request.title(), request.description(), request.eldershipId());
        issueRepository.save(issue);
    }

    public List<IssueDto> findByEldership(UUID eldershipId) {
        return issueRepository.findByEldershipIdAndActiveTrue(eldershipId)
                .stream()
                .map(i -> new IssueDto(i.getId(), i.getTitle(), i.getDescription()))
                .toList();
    }
}
