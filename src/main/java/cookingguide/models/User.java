package cookingguide.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="customers")
public class User implements UserDetails {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name="full_name")
    private String fullName;

    @Column(name="email")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="location")
    private String location;

    @Column(name="gender")
    private String gender;

    @Column(name="badge")
    private Badge badge;

    @Column(name="profileImage")
    private String imagePath;

    public User(String fullName, String username, String password, String location, String gender) {
        this.fullName = fullName;
        this.username = username;
        this.password = password;
        this.location = location;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.isEnlabled = true;
        this.gender = gender;
        this.badge = Badge.NEWBIE;
        if(this.gender.equalsIgnoreCase("male")){
           this.imagePath = "/images/male-profile.png";
        }else{
            this.imagePath = "/images/female-profile.png";
        }
    }

    public User(){
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.isEnlabled = true;
        this.badge = Badge.NEWBIE;
    }

    @Transient
    private boolean accountNonExpired;

    @Transient
    private boolean accountNonLocked;

    @Transient
    private boolean credentialsNonExpired;

    @Transient
    private boolean isEnlabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(new SimpleGrantedAuthority("USER"));
    }

    @OneToMany(
            targetEntity = Recipe.class, mappedBy = "user",
            fetch = FetchType.LAZY)
    private List<Recipe> recipes = new ArrayList<>();

    public String getFullName() {
        return fullName;
    }

    public String getBadge() {
        return badge.getBadgeWording();
    }

    public String getGender() {
        return gender;
    }

    public void setBadge(Badge badge) {
        this.badge = badge;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnlabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && username.equals(user.username) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", location='" + location + '\'' +
                ", gender='" + gender + '\'' +
                ", badge='" + badge + '\'' +
                ", accountNonExpired=" + accountNonExpired +
                ", accountNonLocked=" + accountNonLocked +
                ", credentialsNonExpired=" + credentialsNonExpired +
                ", isEnlabled=" + isEnlabled +
                '}';
    }
}
