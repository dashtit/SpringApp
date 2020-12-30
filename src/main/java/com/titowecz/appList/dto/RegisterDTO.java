package com.titowecz.appList.dto;

import lombok.Data;

@Data
public class RegisterDTO {
  private String username;
  private String firstName;
  private String lastName;
  private String email;
  private String password;
}