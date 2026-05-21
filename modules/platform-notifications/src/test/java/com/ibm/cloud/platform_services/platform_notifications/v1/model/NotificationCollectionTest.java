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

import com.ibm.cloud.platform_services.platform_notifications.v1.model.Notification;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.NotificationCollection;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.PaginationLink;
import com.ibm.cloud.platform_services.platform_notifications.v1.model.PaginationLinkWithToken;
import com.ibm.cloud.platform_services.platform_notifications.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the NotificationCollection model.
 */
public class NotificationCollectionTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testNotificationCollection() throws Throwable {
    NotificationCollection notificationCollectionModel = new NotificationCollection();
    assertNull(notificationCollectionModel.getLimit());
    assertNull(notificationCollectionModel.getTotalCount());
    assertNull(notificationCollectionModel.getFirst());
    assertNull(notificationCollectionModel.getPrevious());
    assertNull(notificationCollectionModel.getNext());
    assertNull(notificationCollectionModel.getLast());
    assertNull(notificationCollectionModel.getNotifications());
  }
}