package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "developer_project")
public class DeveloperProjects {
    @Column(name = "developer_id")
    private int developerId;

    @Column(name = "project_id")
    private int projectId;
}
