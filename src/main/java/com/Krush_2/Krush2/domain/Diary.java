package com.Krush_2.Krush2.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Diary extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String memo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private SubGoal subGoal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Member member;
}