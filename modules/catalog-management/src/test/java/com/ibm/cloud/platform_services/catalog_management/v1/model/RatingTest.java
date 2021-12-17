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

package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.ibm.cloud.platform_services.catalog_management.v1.model.Rating;
import com.ibm.cloud.platform_services.catalog_management.v1.utils.TestUtilities;
import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Rating model.
 */
public class RatingTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testRating() throws Throwable {
    Rating ratingModel = new Rating.Builder()
      .oneStarCount(Long.valueOf("26"))
      .twoStarCount(Long.valueOf("26"))
      .threeStarCount(Long.valueOf("26"))
      .fourStarCount(Long.valueOf("26"))
      .build();
    assertEquals(ratingModel.oneStarCount(), Long.valueOf("26"));
    assertEquals(ratingModel.twoStarCount(), Long.valueOf("26"));
    assertEquals(ratingModel.threeStarCount(), Long.valueOf("26"));
    assertEquals(ratingModel.fourStarCount(), Long.valueOf("26"));

    String json = TestUtilities.serialize(ratingModel);

    Rating ratingModelNew = TestUtilities.deserialize(json, Rating.class);
    assertTrue(ratingModelNew instanceof Rating);
    assertEquals(ratingModelNew.oneStarCount(), Long.valueOf("26"));
    assertEquals(ratingModelNew.twoStarCount(), Long.valueOf("26"));
    assertEquals(ratingModelNew.threeStarCount(), Long.valueOf("26"));
    assertEquals(ratingModelNew.fourStarCount(), Long.valueOf("26"));
  }
}