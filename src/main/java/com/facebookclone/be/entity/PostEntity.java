package com.facebookclone.be.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "post")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String post;
    private String name;
    private String email;

    @Column(columnDefinition = "MEDIUMTEXT")
    private String image;
    private String profilePic;
    private String timeStamp;
}
