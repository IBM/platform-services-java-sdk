/*
 * (C) Copyright IBM Corp. 2026.
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

package com.ibm.cloud.platform_services.platform_notifications.v1.model;

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * A pagination link object with a page token. Used for next, previous, and last page links.
 */
public class PaginationLinkWithToken extends GenericModel {

  protected String href;
  protected String start;

  protected PaginationLinkWithToken() { }

  /**
   * Gets the href.
   *
   * Complete URL to the page.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }

  /**
   * Gets the start.
   *
   * Opaque page token that can be used to retrieve the page.
   *
   * @return the start
   */
  public String getStart() {
    return start;
  }
}

