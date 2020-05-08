/*
 * (C) Copyright IBM Corp. 2020.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.ibm.cloud.platform_services.case_management.v1.model;

import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Case.
 */
public class Case extends GenericModel {

  /**
   * Name of the console to interact with the contact.
   */
  public interface ContactType {
    /** Cloud Support Center. */
    String CLOUD_SUPPORT_CENTER = "Cloud Support Center";
    /** IMS Console. */
    String IMS_CONSOLE = "IMS Console";
  }

  /**
   * Support tier of the account.
   */
  public interface SupportTier {
    /** Free. */
    String FREE = "Free";
    /** Basic. */
    String BASIC = "Basic";
    /** Standard. */
    String STANDARD = "Standard";
    /** Premium. */
    String PREMIUM = "Premium";
  }

  protected String number;
  @SerializedName("short_description")
  protected String shortDescription;
  protected String description;
  @SerializedName("created_at")
  protected String createdAt;
  @SerializedName("created_by")
  protected User createdBy;
  @SerializedName("updated_at")
  protected String updatedAt;
  @SerializedName("updated_by")
  protected User updatedBy;
  @SerializedName("contact_type")
  protected String contactType;
  protected User contact;
  protected String status;
  protected Double severity;
  @SerializedName("support_tier")
  protected String supportTier;
  protected String resolution;
  @SerializedName("close_notes")
  protected String closeNotes;
  protected CaseEu eu;
  protected List<User> watchlist;
  protected List<Attachment> attachments;
  protected Offering offering;
  protected List<Resource> resources;
  protected List<Comment> comments;

  /**
   * Gets the number.
   *
   * Number/ID of the case.
   *
   * @return the number
   */
  public String getNumber() {
    return number;
  }

  /**
   * Gets the shortDescription.
   *
   * A short description of what the case is about.
   *
   * @return the shortDescription
   */
  public String getShortDescription() {
    return shortDescription;
  }

  /**
   * Gets the description.
   *
   * A full description of what the case is about.
   *
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * Gets the createdAt.
   *
   * Date time of case creation in UTC.
   *
   * @return the createdAt
   */
  public String getCreatedAt() {
    return createdAt;
  }

  /**
   * Gets the createdBy.
   *
   * @return the createdBy
   */
  public User getCreatedBy() {
    return createdBy;
  }

  /**
   * Gets the updatedAt.
   *
   * Date time of the last update on the case in UTC.
   *
   * @return the updatedAt
   */
  public String getUpdatedAt() {
    return updatedAt;
  }

  /**
   * Gets the updatedBy.
   *
   * @return the updatedBy
   */
  public User getUpdatedBy() {
    return updatedBy;
  }

  /**
   * Gets the contactType.
   *
   * Name of the console to interact with the contact.
   *
   * @return the contactType
   */
  public String getContactType() {
    return contactType;
  }

  /**
   * Gets the contact.
   *
   * @return the contact
   */
  public User getContact() {
    return contact;
  }

  /**
   * Gets the status.
   *
   * Status of the case.
   *
   * @return the status
   */
  public String getStatus() {
    return status;
  }

  /**
   * Gets the severity.
   *
   * The severity of the case.
   *
   * @return the severity
   */
  public Double getSeverity() {
    return severity;
  }

  /**
   * Gets the supportTier.
   *
   * Support tier of the account.
   *
   * @return the supportTier
   */
  public String getSupportTier() {
    return supportTier;
  }

  /**
   * Gets the resolution.
   *
   * Standard reasons of resolving case.
   *
   * @return the resolution
   */
  public String getResolution() {
    return resolution;
  }

  /**
   * Gets the closeNotes.
   *
   * Notes of case closing.
   *
   * @return the closeNotes
   */
  public String getCloseNotes() {
    return closeNotes;
  }

  /**
   * Gets the eu.
   *
   * @return the eu
   */
  public CaseEu getEu() {
    return eu;
  }

  /**
   * Gets the watchlist.
   *
   * User IDs in the watchlist.
   *
   * @return the watchlist
   */
  public List<User> getWatchlist() {
    return watchlist;
  }

  /**
   * Gets the attachments.
   *
   * List of attachments/files of the case.
   *
   * @return the attachments
   */
  public List<Attachment> getAttachments() {
    return attachments;
  }

  /**
   * Gets the offering.
   *
   * @return the offering
   */
  public Offering getOffering() {
    return offering;
  }

  /**
   * Gets the resources.
   *
   * List of attached resources.
   *
   * @return the resources
   */
  public List<Resource> getResources() {
    return resources;
  }

  /**
   * Gets the comments.
   *
   * List of comments/updates sorted in chronological order.
   *
   * @return the comments
   */
  public List<Comment> getComments() {
    return comments;
  }
}

