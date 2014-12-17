package fr.valtech.bet.domain.model.user.dto;

import fr.valtech.bet.domain.model.user.Role;

public class UserDto {

    private Long id;

    private String username;

    private String name;

    private String firstName;

    private Role role;

    private String currentPassword;

    private String newPassword;

    private String confirmation;

    private Boolean isEmailGood;

    private Boolean modifyPwd;

    private Boolean isNotified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }

    public Boolean getIsEmailGood() {
        return isEmailGood;
    }

    public void setIsEmailGood(Boolean isEmailGood) {
        this.isEmailGood = isEmailGood;
    }

    public Boolean getModifyPwd() {
        return modifyPwd;
    }

    public void setModifyPwd(Boolean modifyPwd) {
        this.modifyPwd = modifyPwd;
    }

    public Boolean getIsNotified() {
        return isNotified;
    }

    public void setIsNotified(Boolean isNotified) {
        this.isNotified = isNotified;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDto{");
        sb.append("id=").append(id);
        sb.append(", username='").append(username).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", role=").append(role);
        sb.append(", currentPassword='").append(currentPassword).append('\'');
        sb.append(", newPassword='").append(newPassword).append('\'');
        sb.append(", confirmation='").append(confirmation).append('\'');
        sb.append(", isEmailGood=").append(isEmailGood);
        sb.append(", modifyPwd=").append(modifyPwd);
        sb.append(", isNotified=").append(isNotified);
        sb.append('}');
        return sb.toString();
    }
}
