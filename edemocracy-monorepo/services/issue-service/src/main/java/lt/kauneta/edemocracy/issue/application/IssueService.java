package lt.kauneta.edemocracy.issue.application;

import lt.kauneta.edemocracy.issue.domain.Issue;
import lt.kauneta.edemocracy.issue.domain.IssueRelevance;
import lt.kauneta.edemocracy.issue.domain.IssueRelevanceRepository;
import lt.kauneta.edemocracy.issue.domain.IssueRepository;
import lt.kauneta.edemocracy.issue.dto.CreateIssueRequest;
import lt.kauneta.edemocracy.issue.dto.IssueDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class IssueService {

    private final IssueRepository issueRepository;
	private final IssueRelevanceRepository issueRelevanceRepository;

    public IssueService(IssueRepository issueRepository, IssueRelevanceRepository issueRelevanceRepository) {
        this.issueRepository = issueRepository;
		this.issueRelevanceRepository = issueRelevanceRepository;
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
    
    public void markAsRelevant(UUID userId, UUID issueId) {
        if (issueRelevanceRepository.findByUserIdAndIssueId(userId, issueId).isPresent()) {
            // Jau pažymėta – ignoruojam
            return;
        }
        IssueRelevance relevance = new IssueRelevance(userId, issueId);
        issueRelevanceRepository.save(relevance);
    }
}
