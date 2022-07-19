package com.accenture.appsyncpoc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.TABLE)
  private Long id;
  private String name;
  @Column(unique = true)
  private String email;
  private String mobno;
  private String city;
  private String state;
  private String addressline;
  private String pincode;
}
