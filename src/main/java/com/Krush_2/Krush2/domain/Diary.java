package com.Krush_2.Krush2.domain;

import java.time.LocalDate;
<<<<<<< HEAD
import java.time.LocalDateTime;
=======
>>>>>>> 87b3a05a88b3a4d0b2e3cab94afe625da8e89958
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "Diary")
public class Diary extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diary_id")
    private Long diaryId;

    @Column(name = "contents", length = 6)
    private String contents;

    @Column(name = "date", nullable = false)
    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sub_goal_id", nullable = false)
    private SubGoal subGoal;

    @ManyToOne(fetch = FetchType.LAZY)
<<<<<<< HEAD
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

=======
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
>>>>>>> 87b3a05a88b3a4d0b2e3cab94afe625da8e89958

}