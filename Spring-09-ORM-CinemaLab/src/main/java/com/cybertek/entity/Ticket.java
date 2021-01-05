package com.cybertek.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ticket extends BaseEntity{

    @Column(name = "seat_number")
    private Integer seatNumber;

    @Column(name = "row_number")
    private Integer rowNumber;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalTime localDateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_cinema_id")
    private MovieCinema movieCinema;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_account_id")
    private User user;

    public Ticket(Integer seatNumber, Integer rowNumber, LocalTime localDateTime) {
        this.seatNumber = seatNumber;
        this.rowNumber = rowNumber;
        this.localDateTime = localDateTime;
    }
}
