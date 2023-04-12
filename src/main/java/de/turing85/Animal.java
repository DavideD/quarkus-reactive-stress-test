package de.turing85;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "animals")
public class Animal {
  @Id
  @SequenceGenerator(name = "animalSequenceGenerator", sequenceName = "animals__seq__id")
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "animalSequenceGenerator")
  @Column(name = "id")
  public Long id;

  @Column(name = "name", unique = true)
  public String name = "";

  @Column(name = "species")
  public String species = "";
}