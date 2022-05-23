package com.example.androidproject;

public class Car
{
    private String id;
    private String type;
    private String name;
    private String company;
    private String category;
public Car()
{
    this.category="";
    this.id="";
    this.company="";
    this.name="";
    this.type="";
}

    public Car(String id, String type, String name, String company, String category)
    {
        this.id = id;
        this.type = type;
        this.name = name;
        this.company = company;
        this.category = category;
    }

    public String getId()
    {
        return id;
    }

    public String getType()
    {
        return type;
    }

    public String getName()
    {
        return name;
    }

    public String getCompany()
    {
        return company;
    }

    public String getCategory()
    {
        return category;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setCompany(String company)
    {
        this.company = company;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }
}
