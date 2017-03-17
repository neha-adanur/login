package com.example.adanur.login1;

/**
 * Created by Adanur on 3/12/2016.
 */
public class contact {
    //int id;
    String name,email,password;

    public String get_pass()
    {
       return password;
    }
    public void set_pass(String password)
    {
        this.password=password;
    }
   /* public int get_id()
    {
          return id;
    }
    public void set_id(int id)
    {
        this.id=id;
    }*/
    public String get_name()
    {
        return name;
    }
    public void set_name(String name)
    {
        this.name=name;
    }
    public String get_email()
    {
        return email;
    }
    public void set_email(String email)
    {
        this.email=email;
    }
}
