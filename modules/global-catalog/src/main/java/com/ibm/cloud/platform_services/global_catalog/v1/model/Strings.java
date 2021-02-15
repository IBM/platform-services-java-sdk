/*
 * (C) Copyright IBM Corp. 2021.
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
package com.ibm.cloud.platform_services.global_catalog.v1.model;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;
import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Information related to a translated text message.
 */
public class Strings extends GenericModel {

  protected List<Bullets> bullets;
  protected List<UIMetaMedia> media;
  @SerializedName("not_creatable_msg")
  protected String notCreatableMsg;
  @SerializedName("not_creatable__robot_msg")
  protected String notCreatableRobotMsg;
  @SerializedName("deprecation_warning")
  protected String deprecationWarning;
  @SerializedName("popup_warning_message")
  protected String popupWarningMessage;
  protected String instruction;

  /**
   * Builder.
   */
  public static class Builder {
    private List<Bullets> bullets;
    private List<UIMetaMedia> media;
    private String notCreatableMsg;
    private String notCreatableRobotMsg;
    private String deprecationWarning;
    private String popupWarningMessage;
    private String instruction;

    private Builder(Strings strings) {
      this.bullets = strings.bullets;
      this.media = strings.media;
      this.notCreatableMsg = strings.notCreatableMsg;
      this.notCreatableRobotMsg = strings.notCreatableRobotMsg;
      this.deprecationWarning = strings.deprecationWarning;
      this.popupWarningMessage = strings.popupWarningMessage;
      this.instruction = strings.instruction;
    }

    /**
     * Instantiates a new builder.
     */
    public Builder() {
    }

    /**
     * Builds a Strings.
     *
     * @return the new Strings instance
     */
    public Strings build() {
      return new Strings(this);
    }

    /**
     * Adds an bullets to bullets.
     *
     * @param bullets the new bullets
     * @return the Strings builder
     */
    public Builder addBullets(Bullets bullets) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(bullets,
        "bullets cannot be null");
      if (this.bullets == null) {
        this.bullets = new ArrayList<Bullets>();
      }
      this.bullets.add(bullets);
      return this;
    }

    /**
     * Adds an media to media.
     *
     * @param media the new media
     * @return the Strings builder
     */
    public Builder addMedia(UIMetaMedia media) {
      com.ibm.cloud.sdk.core.util.Validator.notNull(media,
        "media cannot be null");
      if (this.media == null) {
        this.media = new ArrayList<UIMetaMedia>();
      }
      this.media.add(media);
      return this;
    }

    /**
     * Set the bullets.
     * Existing bullets will be replaced.
     *
     * @param bullets the bullets
     * @return the Strings builder
     */
    public Builder bullets(List<Bullets> bullets) {
      this.bullets = bullets;
      return this;
    }

    /**
     * Set the media.
     * Existing media will be replaced.
     *
     * @param media the media
     * @return the Strings builder
     */
    public Builder media(List<UIMetaMedia> media) {
      this.media = media;
      return this;
    }

    /**
     * Set the notCreatableMsg.
     *
     * @param notCreatableMsg the notCreatableMsg
     * @return the Strings builder
     */
    public Builder notCreatableMsg(String notCreatableMsg) {
      this.notCreatableMsg = notCreatableMsg;
      return this;
    }

    /**
     * Set the notCreatableRobotMsg.
     *
     * @param notCreatableRobotMsg the notCreatableRobotMsg
     * @return the Strings builder
     */
    public Builder notCreatableRobotMsg(String notCreatableRobotMsg) {
      this.notCreatableRobotMsg = notCreatableRobotMsg;
      return this;
    }

    /**
     * Set the deprecationWarning.
     *
     * @param deprecationWarning the deprecationWarning
     * @return the Strings builder
     */
    public Builder deprecationWarning(String deprecationWarning) {
      this.deprecationWarning = deprecationWarning;
      return this;
    }

    /**
     * Set the popupWarningMessage.
     *
     * @param popupWarningMessage the popupWarningMessage
     * @return the Strings builder
     */
    public Builder popupWarningMessage(String popupWarningMessage) {
      this.popupWarningMessage = popupWarningMessage;
      return this;
    }

    /**
     * Set the instruction.
     *
     * @param instruction the instruction
     * @return the Strings builder
     */
    public Builder instruction(String instruction) {
      this.instruction = instruction;
      return this;
    }
  }

  protected Strings(Builder builder) {
    bullets = builder.bullets;
    media = builder.media;
    notCreatableMsg = builder.notCreatableMsg;
    notCreatableRobotMsg = builder.notCreatableRobotMsg;
    deprecationWarning = builder.deprecationWarning;
    popupWarningMessage = builder.popupWarningMessage;
    instruction = builder.instruction;
  }

  /**
   * New builder.
   *
   * @return a Strings builder
   */
  public Builder newBuilder() {
    return new Builder(this);
  }

  /**
   * Gets the bullets.
   *
   * Presentation information related to list delimiters.
   *
   * @return the bullets
   */
  public List<Bullets> bullets() {
    return bullets;
  }

  /**
   * Gets the media.
   *
   * Media-related metadata.
   *
   * @return the media
   */
  public List<UIMetaMedia> media() {
    return media;
  }

  /**
   * Gets the notCreatableMsg.
   *
   * Warning that a message is not creatable.
   *
   * @return the notCreatableMsg
   */
  public String notCreatableMsg() {
    return notCreatableMsg;
  }

  /**
   * Gets the notCreatableRobotMsg.
   *
   * Warning that a robot message is not creatable.
   *
   * @return the notCreatableRobotMsg
   */
  public String notCreatableRobotMsg() {
    return notCreatableRobotMsg;
  }

  /**
   * Gets the deprecationWarning.
   *
   * Warning for deprecation.
   *
   * @return the deprecationWarning
   */
  public String deprecationWarning() {
    return deprecationWarning;
  }

  /**
   * Gets the popupWarningMessage.
   *
   * Popup warning message.
   *
   * @return the popupWarningMessage
   */
  public String popupWarningMessage() {
    return popupWarningMessage;
  }

  /**
   * Gets the instruction.
   *
   * Instructions for UI strings.
   *
   * @return the instruction
   */
  public String instruction() {
    return instruction;
  }
}

