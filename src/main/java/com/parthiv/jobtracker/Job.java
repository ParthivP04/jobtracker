package com.parthiv.jobtracker;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String company;
    private String location;
    @Column(unique = true)
    private String url;
    private String source;
    @Column(columnDefinition = "text")
    private String description;
    @Enumerated(EnumType.STRING)
    private ApplicationStatus status = ApplicationStatus.SAVED;
    private Integer matchScore;
    @Column(columnDefinition = "text")
    private String notes;
    private LocalDate appliedAt;
    private LocalDate followUpAt;
    private LocalDateTime createdAt = LocalDateTime.now();
}