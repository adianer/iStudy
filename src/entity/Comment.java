package entity;


public class Comment {

  private int commentId;
  private int commentUserId;
  private int commentVideoId;
  private String commentDataTime;
  private String commentContent;


  public int getCommentId() {
    return commentId;
  }

  public void setCommentId(int commentId) {
    this.commentId = commentId;
  }


  public int getCommentUserId() {
    return commentUserId;
  }

  public void setCommentUserId(int commentUserId) {
    this.commentUserId = commentUserId;
  }


  public int getCommentVideoId() {
    return commentVideoId;
  }

  public void setCommentVideoId(int commentVideoId) {
    this.commentVideoId = commentVideoId;
  }


  public String getCommentDataTime() {
    return commentDataTime;
  }

  public void setCommentDataTime(String commentDataTime) {
    this.commentDataTime = commentDataTime;
  }


  public String getCommentContent() {
    return commentContent;
  }

  public void setCommentContent(String commentContent) {
    this.commentContent = commentContent;
  }

}
