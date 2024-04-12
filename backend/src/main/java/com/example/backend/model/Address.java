    package com.example.backend.model;

    import com.fasterxml.jackson.annotation.JsonBackReference;

    import jakarta.persistence.Entity;
    import jakarta.persistence.Id;
    import jakarta.persistence.OneToOne;

    @Entity
    public class Address {
        
        @Id
        int userId;
        String address;

        @OneToOne
        @JsonBackReference
        Signup signup;

        public Address() {
        }

        public Address(int userId, String address, Signup signup) {
            this.userId = userId;
            this.address = address;
            this.signup = signup;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public Signup getSignup() {
            return signup;
        }

        public void setSignup(Signup signup) {
            this.signup = signup;
        }

        
    }
