package com.Krush_2.Krush2.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "alarm")
public class Alarm extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "alarm_id")
    private Long alarmId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diary_id", nullable = false)
    private Diary diary;

    @Column(name = "day", nullable = false)
    private Integer day;

    @Column(name = "Field", length = 255)
    private String field;
}