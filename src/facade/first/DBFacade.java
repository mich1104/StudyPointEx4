/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facade.first;

import entity.first.Project;
import entity.first.ProjectUser;
import entity.first.Task;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author Michael
 */
public class DBFacade {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("StudyPointEx4PU");
    private EntityManager em = emf.createEntityManager();

    public void createUser(String userName, String email) {
        ProjectUser pu = new ProjectUser(userName, email);

        em.getTransaction().begin();
        em.persist(pu);
        em.getTransaction().commit();

    }

    public ProjectUser findUser(String userName) {

        ProjectUser found = em.find(ProjectUser.class, userName);
        return found;
    }

    public List<ProjectUser> getAllUsers() {
        List<ProjectUser> allUsers = new ArrayList();
        Query query = em.createQuery("SELECT e FROM ProjectUser e");
        allUsers = query.getResultList();
        
        return allUsers;
    }
    
    public List<Project> getAllProjects() {
        List<Project> allProjects = new ArrayList();
        Query query = em.createQuery("SELECT e FROM Project e");
        allProjects = query.getResultList();
        
        return allProjects;
    }

    public int createProject(String name, String description) {
        Project p = new Project(name, description);
        
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        
        return p.getId();
    }

    public Project findProject(int id) {
        Project found = em.find(Project.class, id);
        return found;
    }

    public void assignUserToProject(String userName, int projectId) {
        
        ProjectUser user = em.find(ProjectUser.class, userName);
        Project project = em.find(Project.class, projectId);
        
        user.addProject(project);
        
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
    }

    public void createTaskAndAssignToProject(String taskName, String taskDescription, int hoursAssigned, int projectId) {
        Task t = new Task(taskName, taskDescription, hoursAssigned);
        Project p = em.find(Project.class, projectId);
        p.addTask(t);
        
        em.getTransaction().begin();
        em.persist(p);
//        em.persist(t);
        em.getTransaction().commit();
    }

}
