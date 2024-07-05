package com.Krush_2.Krush2.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
<<<<<<< HEAD

=======
>>>>>>> 87b3a05a88b3a4d0b2e3cab94afe625da8e89958
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "SubGoal")
public class SubGoal extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_goal_id")
    private Long subGoalId;

    @Column(name = "contents", length = 10)
    private String contents;

    @Column(name = "is_intensity_changeable")
    private Boolean isIntensityChangeable;

    @Column(name = "emoji", nullable = false, length = 10)
    private String emoji;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goal_id", nullable = false)
    private Goal goal;

    @OneToMany(mappedBy = "subGoal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Diary> diaries;
<<<<<<< HEAD
}
=======
}
>>>>>>> 87b3a05a88b3a4d0b2e3cab94afe625da8e89958
