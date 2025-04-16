package lt.kauneta.edemocracy.issue.presentation;

import lt.kauneta.edemocracy.issue.application.IssueService;
import lt.kauneta.edemocracy.issue.dto.CreateIssueRequest;
import lt.kauneta.edemocracy.issue.dto.IssueDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/issues")
public class IssueController {

    private final IssueService issueService;

    public IssueController(IssueService issueService) {
        this.issueService = issueService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateIssueRequest request) {
        issueService.create(request);
        return ResponseEntity.status(201).build();
    }

    @GetMapping("/by-eldership/{eldershipId}")
    public ResponseEntity<List<IssueDto>> getByEldership(@PathVariable UUID eldershipId) {
        return ResponseEntity.ok(issueService.findByEldership(eldershipId));
    }
    
    @PostMapping("/{issueId}/relevant")
    public ResponseEntity<Void> markRelevant(@PathVariable UUID issueId) {
        UUID userId = (UUID) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        issueService.markAsRelevant(userId, issueId);
        return ResponseEntity.ok().build();
    }

}
