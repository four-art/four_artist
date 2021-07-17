package com.example.fourart.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Getter @Setter
public class wantedPosting extends Posting {
    @Id @GeneratedValue
    public Long id;

    @ElementCollection(targetClass = HashTag.class)
    @Column(name = "hashtag", nullable = true)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "wanted_posting_hashtag")
    private Collection<HashTag> wantedPostingHashtag;

}
