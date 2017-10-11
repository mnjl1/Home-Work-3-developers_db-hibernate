package Entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "it_company")
public class ItCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "companyID")
    private int companyId;

    @Column(name = "company_name")
    private String companyName;

    @Column(name = "developer_id_fk")
    private int developerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "developer_id")
    private Developers developer;

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public int getDeveloperId() {
        return developerId;
    }

    public void setDeveloperId(int developerId) {
        this.developerId = developerId;
    }

    public Developers getDeveloper() {
        return developer;
    }

    public void setDeveloper(Developers developer) {
        this.developer = developer;
    }

    @Override
    public String toString() {
        return "ItCompany{" +
                "companyId=" + companyId +
                ", companyName='" + companyName + '\'' +
                ", developerId=" + developerId +
                '}';
    }
}
