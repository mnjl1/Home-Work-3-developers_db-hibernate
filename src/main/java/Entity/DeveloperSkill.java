package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "developer_skill")
public class DeveloperSkill {

    @Column(name = "developer_id")
    private int developerID;

    @Column(name = "skill_id")
    private int skillID;

}
