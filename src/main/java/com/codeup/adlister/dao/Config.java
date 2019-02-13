package com.codeup.adlister.dao;

public class Config
    {
        private String url = "jdbc:mysql://localhost/adlister_db";

        private String username = "adUser";

        private String password = "supersecret";


        public String getUrl() {
            return url;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }

