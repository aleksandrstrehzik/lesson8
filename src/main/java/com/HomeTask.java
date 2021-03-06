package com;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HomeTask extends Task {

    @Column
    private LocalDate startDate;
    @Column
    private LocalDate endDate;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "Executor_name")),
            @AttributeOverride(name = "surname", column = @Column(name = "Executor_surname"))
    })
    Person executor;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "name", column = @Column(name = "Caretaker_name")),
            @AttributeOverride(name = "surname", column = @Column(name = "Caretaker_surname"))
    })
    Person caretaker;
}
