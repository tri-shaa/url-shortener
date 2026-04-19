


package org.example.urlshortener.model;

import jakarta.persistence.*;
        import lombok.Data;

@Entity
@Data
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String shortCode;
    private String originalUrl;

    private int clickCount;
}