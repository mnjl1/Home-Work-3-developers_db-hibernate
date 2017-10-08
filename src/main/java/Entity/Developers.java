package Entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Developers")
public class Developers implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "developer_id")
    private int developer_id;

    @Column(name = "firstName")
    String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "companyID")
    private int itcompany_id;

    @Column(name = "salary")
    private int salary;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "developer_skill", joinColumns = {
            @JoinColumn(name = "developer_id")}, inverseJoinColumns = {@JoinColumn(name = "skill_id")})
    private Set<Skill> skills = new HashSet<Skill>(0);

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "developer_project", joinColumns = {
            @JoinColumn(name = "developer_id")
    }, inverseJoinColumns = {@JoinColumn(name = "project_id")})
    private Set<Project> projects = new HashSet <Project>(0);

    public int getDeveloper_id() {
        return developer_id;
    }

    public void setDeveloper_id(int developer_id) {
        this.developer_id = developer_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getItcompany_id() {
        return itcompany_id;
    }

    public void setItcompany_id(int itcompany_id) {
        this.itcompany_id = itcompany_id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Set <Skill> getSkills() {
        return skills;
    }

    public void setSkills(Set <Skill> skills) {
        this.skills = skills;
    }

    public void addSkill(Skill skill ){
        skills.add(skill);
    }
    public void addProject(Project project){
        projects.add(project);
    }

    public Set <Project> getProject() {
        return projects;
    }

    public void setProject(Set <Project> projects) {
        this.projects = projects;
    }

    @Override
    public String toString() {
        return "Developers{" +
                "developer_id=" + developer_id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", itcompany_id=" + itcompany_id +
                ", salary=" + salary +
                '}';
    }
}
