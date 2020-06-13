package lk.lakshan.staffmanagement.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "role")
public class Role {

    @Id
    private int id;
    private String nicNo;
    private String firstName;
    private String lastName;
    private String roleType;
    private String organization;

    public Role() {
    }

    public Role(int id, String nicNo, String firstName, String lastName, String roleType, String organization) {
        this.id = id;
        this.nicNo = nicNo;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roleType = roleType;
        this.organization = organization;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNicNo() {
        return this.nicNo;
    }

    public void setNicNo(String nicNo) {
        this.nicNo = nicNo;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRoleType() {
        return this.roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }

    public String getOrganization() {
        return this.organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", nicNo='" + nicNo + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", roleType='" + roleType + '\'' +
                ", organization='" + organization + '\'' +
                '}';
    }
}
