package com.wefind.companion.candidates;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Entity
public class Location {

    @Id
    private  Long id;

    private double x;
    private double y;


}
