package Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    @Column(name = "customer_id")
    private int id;

    @Column(name = "customerName")
    private String customerName;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Project> projects = new HashSet <Project>(0);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Set <Project> getProjects() {
        return projects;
    }

    public void setProjects(Set <Project> projects) {
        this.projects = projects;
    }

    public  void addProject(Project project){
        projects.add(project);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                '}';
    }
}
