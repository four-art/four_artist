package com.example.fourart.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@Getter @Setter
public class WantedPosting extends Posting {

    @Column(name = "hashtag", nullable = true)
    private HashTag hashtag;

    @ElementCollection(targetClass = HashTag.class)
    @Column(name = "hashtag", nullable = true)
    @Enumerated(EnumType.STRING)
    private Set<HashTag> wantedPostingHashtag;
}
