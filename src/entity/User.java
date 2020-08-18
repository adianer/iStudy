package entity;


public class User {

  private int userId;
  private String userLoginname;
  private String userName;
  private String userPassword;
  private String userType;
  private int userMoney;


  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }


  public String getUserLoginname() {
    return userLoginname;
  }

  public void setUserLoginname(String userLoginname) {
    this.userLoginname = userLoginname;
  }


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getUserPassword() {
    return userPassword;
  }

  public void setUserPassword(String userPassword) {
    this.userPassword = userPassword;
  }


  public String getUserType() {
    return userType;
  }

  public void setUserType(String userType) {
    this.userType = userType;
  }


  public int getUserMoney() {
    return userMoney;
  }

  public void setUserMoney(int userMoney) {
    this.userMoney = userMoney;
  }

}
