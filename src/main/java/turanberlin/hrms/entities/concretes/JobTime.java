package turanberlin.hrms.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "job_time")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvert"})
public class JobTime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="job_time_id")
    private int id;

    @Column(name="job_time_name")
    private String jobTimeName;

    @OneToMany(mappedBy = "jobTime")
    private List<JobAdvert> jobAdvert;
}
