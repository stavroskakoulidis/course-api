package com.example.courseapi.models;


import com.example.courseapi.validation.DateOrderConstraint;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;


@Entity
@Table(name = "courses")
@DateOrderConstraint
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title must not be empty")
    private String title;
    private String description;

    @Pattern(regexp = "Published|Pending", message = "Status should be either 'Published' or 'Pending'")
    @NotBlank(message = "Status must not be empty")
    private String status;

    @NotNull(message = "isPremium field must not be null")
    private boolean isPremium;

    @NotNull(message = "createdAt field must not be empty")
    @PastOrPresent(message = "Creation date of the course must be a past or present date")
    private LocalDateTime createdAt;

    @PastOrPresent(message = "Deletion date of the course must be a past or present date")
    private LocalDateTime deletedAt;


    public Course(Long id, String title, String description, String status, boolean isPremium, LocalDateTime createdAt, LocalDateTime deletedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.isPremium = isPremium;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
    }

    public Course() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public void setPremium(boolean premium) {
        isPremium = premium;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }
}
