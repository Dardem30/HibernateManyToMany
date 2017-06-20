package by.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by УВД on 20.06.2017.
 */
public class Example {

    public static void main(String[] args) {
        Set<User> name=new HashSet<User>();
        User user=new User();
        user.setPassword("098");
        user.setUsername("Ghul");
        Role role=new Role();
        role.setName("ROLE_ADMIN");
        Set<Role> roles=new HashSet<Role>();
        roles.add(role);
        user.setRoles(roles);
        name.add(user);
for(User s: name){
//    String s1=s.getUsername();
//    System.out.println(s.getUsername());
    Set<Role> roles1=s.getRoles();
    for(Role r: s.getRoles()){
        System.out.println(r.getName());
    }
}
    }
}
