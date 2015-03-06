/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.first;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Michael
 */
@Entity
public class ProjectUser implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    private String userName;
    private String email;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date created;
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @ElementCollection()
    private List<Project> projects = new ArrayList();
    
    public ProjectUser(String userName, String email){
        this.userName = userName;
        this.email = email;
        this.created = new Date();
    }
    public ProjectUser(){}
    
    public void addProject(Project p){
        projects.add(p);
        p.addUserToProject(this);
    }
    
    public void removeProject(Project p){
        projects.remove(p);
    }
    
    public String getId() {
        return userName;
    }

    public void setId(String useName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

}
