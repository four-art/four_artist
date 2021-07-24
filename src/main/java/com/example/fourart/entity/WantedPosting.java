package com.example.fourart.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter @Setter
public class WantedPosting extends Posting {

    @Column(name = "hashtag", nullable = true)
    private HashTag hashtag;

}
