package com.renovation.manage.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "archives")
public class Archive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long projectId;

    @Column(nullable = false)
    private String archiveName;

    @Column(nullable = false)
    private String archiveType;

    @Column(nullable = false)
    private String filePath;

    @Column(length = 1000)
    private String description;

    private LocalDate archiveDate;

    private String uploader;

    private Long fileSize;

    public Archive() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getProjectId() { return projectId; }
    public void setProjectId(Long projectId) { this.projectId = projectId; }
    public String getArchiveName() { return archiveName; }
    public void setArchiveName(String archiveName) { this.archiveName = archiveName; }
    public String getArchiveType() { return archiveType; }
    public void setArchiveType(String archiveType) { this.archiveType = archiveType; }
    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDate getArchiveDate() { return archiveDate; }
    public void setArchiveDate(LocalDate archiveDate) { this.archiveDate = archiveDate; }
    public String getUploader() { return uploader; }
    public void setUploader(String uploader) { this.uploader = uploader; }
    public Long getFileSize() { return fileSize; }
    public void setFileSize(Long fileSize) { this.fileSize = fileSize; }
}
