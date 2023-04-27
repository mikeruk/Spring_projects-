package cv.opencv5.models.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "work experience")
public class WorkExp extends BaseEntity{



    private String jobTitle;
    private String employerName;
    private LocalDate startDate;
    private LocalDate endDate;
    private boolean stillPresent;
    private String jobDescription;
    private String responsibilities;

    public WorkExp() {
    }

    @Column(name = "job_title", nullable = false)
    @Size(min = 2, max = 30)
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Column(name = "employer_name", nullable = false)
    @Size(min = 2, max = 30)
    public String getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String employerName) {
        this.employerName = employerName;
    }

    @Column(name = "start_date", nullable = false)
    @PastOrPresent
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Column(name = "end_date")
    @PastOrPresent
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Column(name = "still_present", nullable = true)
    public boolean isStillPresent() {
        return stillPresent;
    }

    public void setStillPresent(boolean stillPresent) {
        this.stillPresent = stillPresent;
    }

    @Column(name = "job_description", nullable = false, columnDefinition = "LONGTEXT")
    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }



}
