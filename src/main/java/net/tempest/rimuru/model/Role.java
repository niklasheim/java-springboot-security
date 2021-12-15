package net.tempest.rimuru.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
    
    @Id
    @Column(name = "role_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int role_id;

    @Column(name = "name", nullable = false)
    private String name;


    public Role(Role role) {
        this.role_id = role.getId();
        this.name = role.getName();
    }

    public Role(){
        
    }

    public int getId() {
        return this.role_id;
    }

    public void setId(int id) {
        this.role_id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRole_id() {
        return this.role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

}
