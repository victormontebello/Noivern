package com.montebello.noivern.core.models;

import com.montebello.noivern.core.Enums.Complexity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigInteger;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Algorithm {

    @Id
    public BigInteger Id;

    @Column
    public String Name;

    @Column
    public String Description;

    @Column
    public Complexity TimeComplexity;

    @Column
    public Complexity MemoryComplexity;

    @Column(unique = true)
    public String ImageUrl;

    public byte[] ImageContent;
}
