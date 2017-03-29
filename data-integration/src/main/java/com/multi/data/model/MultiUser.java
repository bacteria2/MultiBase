package com.multi.data.model;

public class MultiUser {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column multi_user.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column multi_user.name
     *
     * @mbg.generated
     */
    private String name="";

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column multi_user.phone
     *
     * @mbg.generated
     */
    private Integer phone=0;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column multi_user.male
     *
     * @mbg.generated
     */
    private Byte male=0;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column multi_user.password
     *
     * @mbg.generated
     */
    private String password="";

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column multi_user.salt
     *
     * @mbg.generated
     */
    private String salt="";

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column multi_user.ref
     *
     * @mbg.generated
     */
    private String ref="";

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table multi_user
     *
     * @mbg.generated
     */
    public MultiUser(Long id, String name, Integer phone, Byte male, String password, String salt, String ref) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.male = male;
        this.password = password;
        this.salt = salt;
        this.ref = ref;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table multi_user
     *
     * @mbg.generated
     */
    public MultiUser() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column multi_user.id
     *
     * @return the value of multi_user.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column multi_user.id
     *
     * @param id the value for multi_user.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column multi_user.name
     *
     * @return the value of multi_user.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column multi_user.name
     *
     * @param name the value for multi_user.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column multi_user.phone
     *
     * @return the value of multi_user.phone
     *
     * @mbg.generated
     */
    public Integer getPhone() {
        return phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column multi_user.phone
     *
     * @param phone the value for multi_user.phone
     *
     * @mbg.generated
     */
    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column multi_user.male
     *
     * @return the value of multi_user.male
     *
     * @mbg.generated
     */
    public Byte getMale() {
        return male;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column multi_user.male
     *
     * @param male the value for multi_user.male
     *
     * @mbg.generated
     */
    public void setMale(Byte male) {
        this.male = male;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column multi_user.password
     *
     * @return the value of multi_user.password
     *
     * @mbg.generated
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column multi_user.password
     *
     * @param password the value for multi_user.password
     *
     * @mbg.generated
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column multi_user.salt
     *
     * @return the value of multi_user.salt
     *
     * @mbg.generated
     */
    public String getSalt() {
        return salt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column multi_user.salt
     *
     * @param salt the value for multi_user.salt
     *
     * @mbg.generated
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column multi_user.ref
     *
     * @return the value of multi_user.ref
     *
     * @mbg.generated
     */
    public String getRef() {
        return ref;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column multi_user.ref
     *
     * @param ref the value for multi_user.ref
     *
     * @mbg.generated
     */
    public void setRef(String ref) {
        this.ref = ref == null ? null : ref.trim();
    }
}