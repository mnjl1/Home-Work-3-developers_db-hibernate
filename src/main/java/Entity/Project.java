package Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int project_id;

    @Column(name = "project_name")
    private String projectName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "developer_project", joinColumns =
            @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "developer_id")
    )
    Set<Developers> developers = new HashSet <Developers>(0);

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Set <Developers> getDevelopers() {
        return developers;
    }

    public void setDevelopers(Set <Developers> developers) {
        this.developers = developers;
    }
}
