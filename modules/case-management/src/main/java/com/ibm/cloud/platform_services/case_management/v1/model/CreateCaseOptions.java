/*
 * (C) Copyright IBM Corp. 2022.
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

import java.util.ArrayList;
import java.util.List;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * The createCase options.
 */
public class CreateCaseOptions extends GenericModel {

  /**
   * Case type.
   */
  public interface Type {
    /** technical. */
    String TECHNICAL = "technical";
    /** account_and_access. */
    String ACCOUNT_AND_ACCESS = "account_and_access";
    /** billing_and_invoice. */
    String BILLING_AND_INVOICE = "billing_and_invoice";
    /** sales. */
    String SALES = "sales";
  }

  protected String type;
  protected String subject;
  protected String description;
  protected Long severity;
  protected CasePayloadEu eu;
  protected Offering offering;
  protected List<ResourcePayload> resources;
  protected List<User> watchlist;
  protected String invoiceNumber;
  protected Boolean slaCreditRequest;

  /**
   * Builder.
   */
  public static class Builder {
    private String type;
    private String subject;
    private String description;
    private Long severity;
    private CasePayloadEu eu;
    private Offering offering;
    private List<ResourcePayload> resources;
    private List<User> watchlist;
    private String invoiceNumber;
    private Boolean slaCreditRequest;

    /**
     * Instantiates a new Builder from an existing CreateCaseOptions instance.
     *
     * @param createCaseOptions the instance to initialize the Builder with
     */
    private Builder(CreateCaseOptions createCaseOptions) {
      this.type = createCaseOptions.type;
      this.subject = createCaseOptions.subject;
      this.description = createCaseOptions.description;
      this.severity = createCaseOptions.severity;
      this.eu = createCaseOptions.eu;
      this.offering = createCaseOptions.offering;
      this.resources = createCaseOptions.resources;
      this.watchlist = createCaseOptions.watchlist;
      this.invoiceNumber = createCaseOptions.invoiceNumber;
      this.slaCreditRequest = createCaseOptions.slaCreditRequest;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Instantiates a new builder with required properties.
     *
     * @param type the type
     * @param subject the subject
     * @param description the description
     */
    public Builder(String type, String subject, String description) {
      this.type = type;
      this.subject = subject;
      this.description = description;
    }

    /**
     * Builds a CreateCaseOptions.
     *
     * @return the new CreateCaseOptions instance
     */
    public CreateCaseOptions build() {
      return new CreateCaseOptions(this);
    }

    /**
     * Adds an resources to resources.
     *
     * @param resources the new resources
     * @return the CreateCaseOptions builder
     */
    public Builder addResources(ResourcePayload resources) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(resources,
        "resources cannot be null");
      if (this.resources == null) {
        this.resources = new ArrayList<ResourcePayload>();
      }
      this.resources.add(resources);
      return this;
    }

    /**
     * Adds an watchlist to watchlist.
     *
     * @param watchlist the new watchlist
     * @return the CreateCaseOptions builder
     */
    public Builder addWatchlist(User watchlist) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(watchlist,
        "watchlist cannot be null");
      if (this.watchlist == null) {
        this.watchlist = new ArrayList<User>();
      }
      this.watchlist.add(watchlist);
      return this;
    }

    /**
     * Set the type.
     *
     * @param type the type
     * @return the CreateCaseOptions builder
     */
    public Builder type(String type) {
      this.type = type;
      return this;
    }

    /**
     * Set the subject.
     *
     * @param subject the subject
     * @return the CreateCaseOptions builder
     */
    public Builder subject(String subject) {
      this.subject = subject;
      return this;
    }

    /**
     * Set the description.
     *
     * @param description the description
     * @return the CreateCaseOptions builder
     */
    public Builder description(String description) {
      this.description = description;
      return this;
    }

    /**
     * Set the severity.
     *
     * @param severity the severity
     * @return the CreateCaseOptions builder
     */
    public Builder severity(long severity) {
      this.severity = severity;
      return this;
    }

    /**
     * Set the eu.
     *
     * @param eu the eu
     * @return the CreateCaseOptions builder
     */
    public Builder eu(CasePayloadEu eu) {
      this.eu = eu;
      return this;
    }

    /**
     * Set the offering.
     *
     * @param offering the offering
     * @return the CreateCaseOptions builder
     */
    public Builder offering(Offering offering) {
      this.offering = offering;
      return this;
    }

    /**
     * Set the resources.
     * Existing resources will be replaced.
     *
     * @param resources the resources
     * @return the CreateCaseOptions builder
     */
    public Builder resources(List<ResourcePayload> resources) {
      this.resources = resources;
      return this;
    }

    /**
     * Set the watchlist.
     * Existing watchlist will be replaced.
     *
     * @param watchlist the watchlist
     * @return the CreateCaseOptions builder
     */
    public Builder watchlist(List<User> watchlist) {
      this.watchlist = watchlist;
      return this;
    }

    /**
     * Set the invoiceNumber.
     *
     * @param invoiceNumber the invoiceNumber
     * @return the CreateCaseOptions builder
     */
    public Builder invoiceNumber(String invoiceNumber) {
      this.invoiceNumber = invoiceNumber;
      return this;
    }

    /**
     * Set the slaCreditRequest.
     *
     * @param slaCreditRequest the slaCreditRequest
     * @return the CreateCaseOptions builder
     */
    public Builder slaCreditRequest(Boolean slaCreditRequest) {
      this.slaCreditRequest = slaCreditRequest;
      return this;
    }
  }

  protected CreateCaseOptions() { }

  protected CreateCaseOptions(Builder builder) {
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.type,
      "type cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.subject,
      "subject cannot be null");
    com.ibm.cloud.sdk.core.util.Validator.notNull(builder.description,
      "description cannot be null");
    type = builder.type;
    subject = builder.subject;
    description = builder.description;
    severity = builder.severity;
    eu = builder.eu;
    offering = builder.offering;
    resources = builder.resources;
    watchlist = builder.watchlist;
    invoiceNumber = builder.invoiceNumber;
    slaCreditRequest = builder.slaCreditRequest;
  }

  /**
   * New builder.
   *
   * @return a CreateCaseOptions builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the type.
   *
   * Case type.
   *
   * @return the type
   */
  public String type() {
    return type;
  }

  /**
   * Gets the subject.
   *
   * Short description used to identify the case.
   *
   * @return the subject
   */
  public String subject() {
    return subject;
  }

  /**
   * Gets the description.
   *
   * Detailed description of the issue.
   *
   * @return the description
   */
  public String description() {
    return description;
  }

  /**
   * Gets the severity.
   *
   * Severity of the case. Smaller values mean higher severity.
   *
   * @return the severity
   */
  public Long severity() {
    return severity;
  }

  /**
   * Gets the eu.
   *
   * Specify if the case should be treated as EU regulated. Only one of the following properties is required. Call EU
   * support utility endpoint to determine which property must be specified for your account.
   *
   * @return the eu
   */
  public CasePayloadEu eu() {
    return eu;
  }

  /**
   * Gets the offering.
   *
   * Offering details.
   *
   * @return the offering
   */
  public Offering offering() {
    return offering;
  }

  /**
   * Gets the resources.
   *
   * List of resources to attach to case. If you attach Classic IaaS devices, use the type and id fields if the Cloud
   * Resource Name (CRN) is unavailable. Otherwise, pass the resource CRN. The resource list must be consistent with the
   * value that is selected for the resource offering.
   *
   * @return the resources
   */
  public List<ResourcePayload> resources() {
    return resources;
  }

  /**
   * Gets the watchlist.
   *
   * Array of user IDs to add to the watchlist.
   *
   * @return the watchlist
   */
  public List<User> watchlist() {
    return watchlist;
  }

  /**
   * Gets the invoiceNumber.
   *
   * Invoice number of "Billing and Invoice" case type.
   *
   * @return the invoiceNumber
   */
  public String invoiceNumber() {
    return invoiceNumber;
  }

  /**
   * Gets the slaCreditRequest.
   *
   * Flag to indicate if case is for an Service Level Agreement (SLA) credit request.
   *
   * @return the slaCreditRequest
   */
  public Boolean slaCreditRequest() {
    return slaCreditRequest;
  }
}

