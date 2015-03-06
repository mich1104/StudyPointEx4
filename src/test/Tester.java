/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import entity.first.ProjectUser;
import facade.first.DBFacade;

/**
 *
 * @author Michael
 */
public class Tester {
    
    static DBFacade dbf = new DBFacade();
    
    public static void main(String[] args) {
        dbf.createUser("firstUser", "firstUser@mail.dk");
        
        int projectId = dbf.createProject("My Very First Project", "project description");
        
        dbf.assignUserToProject("firstUser", projectId);
        dbf.createTaskAndAssignToProject("New Task", "Task desc", 48, projectId);
        
    }
}
