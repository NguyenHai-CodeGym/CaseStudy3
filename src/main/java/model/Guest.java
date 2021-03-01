package model;

import java.time.LocalDateTime;

public class Guest {
    private int id;
    private String nameGuest;
    private String email;
    private String message;
    private LocalDateTime publishDate;

    public Guest(){}

    public Guest(String nameGuest, String email, String message) {
        this.nameGuest = nameGuest;
        this.email = email;
        this.message = message;
    }

    public Guest(String nameGuest, String email, String message, LocalDateTime publishDate) {
        this.nameGuest = nameGuest;
        this.email = email;
        this.message = message;
        this.publishDate = publishDate;
    }

    public Guest(int id, String nameGuest, String email, String message, LocalDateTime publishDate) {
        this.id = id;
        this.nameGuest = nameGuest;
        this.email = email;
        this.message = message;
        this.publishDate = publishDate;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameGuest() {
        return nameGuest;
    }

    public void setNameGuest(String nameGuest) {
        this.nameGuest = nameGuest;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
