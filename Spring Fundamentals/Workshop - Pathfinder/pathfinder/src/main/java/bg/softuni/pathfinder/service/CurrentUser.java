//package bg.softuni.pathfinder.service;
//
//import bg.softuni.pathfinder.model.entity.User;
//import org.springframework.stereotype.Component;
//import org.springframework.web.context.annotation.SessionScope;
//
//@Component
//@SessionScope
//public class CurrentUser {
//
//    private User user;
//
//    public boolean isLoggedIn() {
//        return this.user != null;
//    }
//
//    public boolean isAdmin() {
//        return this.user.getRoles()
//                .stream()
//                .anyMatch(r -> r.getName().equals("ADMIN"));
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//}
