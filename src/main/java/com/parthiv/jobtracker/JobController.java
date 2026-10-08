package com.parthiv.jobtracker;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/jobs")
public class JobController {
    private final JobRepository repo;

    public JobController(JobRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Job> all(@RequestParam(required = false) ApplicationStatus status) {
        return status == null ? repo.findAll() : repo.findByStatus(status);
    }

    @PostMapping
    public Job create(@RequestBody Job job) {
        return repo.save(job);
    }

    @PatchMapping("/{id}/status")
    public Job updateStatus(@PathVariable Long id, @RequestParam ApplicationStatus status) {
        Job job = repo.findById(id).orElseThrow();
        job.setStatus(status);
        if (status == ApplicationStatus.APPLIED) {
            job.setAppliedAt(LocalDate.now());
            job.setFollowUpAt(LocalDate.now().plusDays(10));
        }
        return repo.save(job);
    }
}