package org.dc.apilogbook.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private LocalDateTime timestamp;
    @Column(length=10000)
    private String content;

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public  String getSummary(){
        if (getContent().length()<15){
            return getContent();
        }else{
            return getContent().substring(0,15);
        }
    }

    public Note clone(){
        Note noteCopia = new Note();
        noteCopia.setTitle(this.getTitle());
        noteCopia.setContent(this.getContent());
        return noteCopia;
    }
}