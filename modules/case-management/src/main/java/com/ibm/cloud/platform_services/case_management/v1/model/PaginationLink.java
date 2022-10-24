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

import com.ibm.cloud.sdk.core.service.model.GenericModel;

/**
 * Container for URL pointer to related pages of cases.
 */
public class PaginationLink extends GenericModel {

  protected String href;

  protected PaginationLink() { }

  /**
   * Gets the href.
   *
   * URL to related pages of cases.
   *
   * @return the href
   */
  public String getHref() {
    return href;
  }
}

