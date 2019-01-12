/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;
import java.io.Serializable;
import java.time.LocalDate;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

/**
 *
 * @author ief
 */
public class Contact implements Serializable{

    public Contact() {
    }

    
    public Contact(Long id, int version, String firstName, String lastName, String description, LocalDate birthDate) {
        this.id = id;
        this.version = version;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthDate;
        this.description = description;
    }
    private Long id;
    private int version;

    @NotEmpty(message = "{validation.firstname.NotEmpty.message}")
    @Size(min = 3, max = 60, message = "{validation.Size.message}")
    private String firstName;
   
    @NotEmpty(message = "{validation.lastname.NotEmpty.message}")
    @Size(min = 3, max = 60, message = "{validation.Size.message}")
    private String lastName;
    
    private String description;    
    
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate birthday;
    
    public int getVersion() {
            return version;
        }
    public void setVersion(int version) {
            this.version = version;
        }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
}
