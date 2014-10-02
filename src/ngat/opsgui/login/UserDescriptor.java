/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ngat.opsgui.login;

/**
 *
 * @author eng
 */
public class UserDescriptor {
     
    private String id;
    
    private String title;
    
    private String firstName;

    private String lastName;
    
    private String iconPath;
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }
    
    
    
    public String getFullName() { return title+" "+firstName+" "+lastName; }
    
    public UserDescriptor(String id, String title, String firstName, String lastName) {
        this.id = id;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;   
    }

    @Override
    public String toString() {
        return "UserDescriptor{" + "id=" + id + ", title=" + title + ", firstName=" + firstName + ", lastName=" + lastName + '}';
    }

}
