package com.luster.fistIdeaItem.secondary.entity;

import javax.persistence.*;

@Entity(name = "YAL01")
public class Yal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "YAL01_GETTIME")
    private String time;

    @Column(name = "YAL01_JINGID")
    private String jingId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getJingId() {
        return jingId;
    }

    public void setJingId(String jingId) {
        this.jingId = jingId;
    }
}
