package org.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShortedLink {
  @Id
  private String publicId;

  private String originalLink;

  public ShortedLink() {

  }

  public ShortedLink(String publicId, String originalLink) {
    this.publicId = publicId;
    this.originalLink = originalLink;
  }

  public String getOriginalLink() {
    return originalLink;
  }

  public void setPublicId(String publicIp) {
    this.publicId = publicIp;
  }

  public void setOriginalLink(String originalIp) {
    this.originalLink = originalIp;
  }
}
