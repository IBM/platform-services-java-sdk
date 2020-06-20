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

package com.ibm.cloud.platform_services.catalog_management.v1.model;

import com.ibm.cloud.platform_services.catalog_management.v1.model.Catalog;
import com.ibm.cloud.platform_services.catalog_management.v1.model.CategoryFilter;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Feature;
import com.ibm.cloud.platform_services.catalog_management.v1.model.FilterTerms;
import com.ibm.cloud.platform_services.catalog_management.v1.model.Filters;
import com.ibm.cloud.platform_services.catalog_management.v1.model.IDFilter;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SyndicationAuthorization;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SyndicationCluster;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SyndicationHistory;
import com.ibm.cloud.platform_services.catalog_management.v1.model.SyndicationResource;
import com.ibm.cloud.platform_services.catalog_management.v1.utils.TestUtilities;

import com.ibm.cloud.sdk.core.service.model.FileWithMetadata;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.Test;
import static org.testng.Assert.*;

/**
 * Unit test class for the Catalog model.
 */
public class CatalogTest {
  final HashMap<String, InputStream> mockStreamMap = TestUtilities.createMockStreamMap();
  final List<FileWithMetadata> mockListFileWithMetadata = TestUtilities.creatMockListFileWithMetadata();

  @Test
  public void testCatalog() throws Throwable {
    FilterTerms filterTermsModel = new FilterTerms.Builder()
      .filterTerms(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .build();
    assertEquals(filterTermsModel.filterTerms(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));

    SyndicationCluster syndicationClusterModel = new SyndicationCluster.Builder()
      .region("testString")
      .id("testString")
      .name("testString")
      .resourceGroupName("testString")
      .type("testString")
      .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .allNamespaces(true)
      .build();
    assertEquals(syndicationClusterModel.region(), "testString");
    assertEquals(syndicationClusterModel.id(), "testString");
    assertEquals(syndicationClusterModel.name(), "testString");
    assertEquals(syndicationClusterModel.resourceGroupName(), "testString");
    assertEquals(syndicationClusterModel.type(), "testString");
    assertEquals(syndicationClusterModel.namespaces(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(syndicationClusterModel.allNamespaces(), Boolean.valueOf(true));

    CategoryFilter categoryFilterModel = new CategoryFilter.Builder()
      .include(true)
      .filter(filterTermsModel)
      .build();
    assertEquals(categoryFilterModel.include(), Boolean.valueOf(true));
    assertEquals(categoryFilterModel.filter(), filterTermsModel);

    IDFilter idFilterModel = new IDFilter.Builder()
      .include(filterTermsModel)
      .exclude(filterTermsModel)
      .build();
    assertEquals(idFilterModel.include(), filterTermsModel);
    assertEquals(idFilterModel.exclude(), filterTermsModel);

    SyndicationAuthorization syndicationAuthorizationModel = new SyndicationAuthorization.Builder()
      .token("testString")
      .lastRun(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
      .build();
    assertEquals(syndicationAuthorizationModel.token(), "testString");
    assertEquals(syndicationAuthorizationModel.lastRun(), TestUtilities.createMockDateTime("2019-01-01T12:00:00"));

    SyndicationHistory syndicationHistoryModel = new SyndicationHistory.Builder()
      .namespaces(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .clusters(new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)))
      .lastRun(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
      .build();
    assertEquals(syndicationHistoryModel.namespaces(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(syndicationHistoryModel.clusters(), new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)));
    assertEquals(syndicationHistoryModel.lastRun(), TestUtilities.createMockDateTime("2019-01-01T12:00:00"));

    Feature featureModel = new Feature.Builder()
      .title("testString")
      .description("testString")
      .build();
    assertEquals(featureModel.title(), "testString");
    assertEquals(featureModel.description(), "testString");

    Filters filtersModel = new Filters.Builder()
      .includeAll(true)
      .categoryFilters(new java.util.HashMap<String,CategoryFilter>(){{put("foo", categoryFilterModel); }})
      .idFilters(idFilterModel)
      .build();
    assertEquals(filtersModel.includeAll(), Boolean.valueOf(true));
    assertEquals(filtersModel.categoryFilters(), new java.util.HashMap<String,CategoryFilter>(){{put("foo", categoryFilterModel); }});
    assertEquals(filtersModel.idFilters(), idFilterModel);

    SyndicationResource syndicationResourceModel = new SyndicationResource.Builder()
      .removeRelatedComponents(true)
      .clusters(new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)))
      .history(syndicationHistoryModel)
      .authorization(syndicationAuthorizationModel)
      .build();
    assertEquals(syndicationResourceModel.removeRelatedComponents(), Boolean.valueOf(true));
    assertEquals(syndicationResourceModel.clusters(), new java.util.ArrayList<SyndicationCluster>(java.util.Arrays.asList(syndicationClusterModel)));
    assertEquals(syndicationResourceModel.history(), syndicationHistoryModel);
    assertEquals(syndicationResourceModel.authorization(), syndicationAuthorizationModel);

    Catalog catalogModel = new Catalog.Builder()
      .id("testString")
      .rev("testString")
      .label("testString")
      .shortDescription("testString")
      .catalogIconUrl("testString")
      .tags(new java.util.ArrayList<String>(java.util.Arrays.asList("testString")))
      .url("testString")
      .crn("testString")
      .offeringsUrl("testString")
      .features(new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)))
      .disabled(true)
      .created(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
      .updated(TestUtilities.createMockDateTime("2019-01-01T12:00:00"))
      .resourceGroupId("testString")
      .owningAccount("testString")
      .catalogFilters(filtersModel)
      .syndicationSettings(syndicationResourceModel)
      .build();
    assertEquals(catalogModel.id(), "testString");
    assertEquals(catalogModel.rev(), "testString");
    assertEquals(catalogModel.label(), "testString");
    assertEquals(catalogModel.shortDescription(), "testString");
    assertEquals(catalogModel.catalogIconUrl(), "testString");
    assertEquals(catalogModel.tags(), new java.util.ArrayList<String>(java.util.Arrays.asList("testString")));
    assertEquals(catalogModel.url(), "testString");
    assertEquals(catalogModel.crn(), "testString");
    assertEquals(catalogModel.offeringsUrl(), "testString");
    assertEquals(catalogModel.features(), new java.util.ArrayList<Feature>(java.util.Arrays.asList(featureModel)));
    assertEquals(catalogModel.disabled(), Boolean.valueOf(true));
    assertEquals(catalogModel.created(), TestUtilities.createMockDateTime("2019-01-01T12:00:00"));
    assertEquals(catalogModel.updated(), TestUtilities.createMockDateTime("2019-01-01T12:00:00"));
    assertEquals(catalogModel.resourceGroupId(), "testString");
    assertEquals(catalogModel.owningAccount(), "testString");
    assertEquals(catalogModel.catalogFilters(), filtersModel);
    assertEquals(catalogModel.syndicationSettings(), syndicationResourceModel);

    String json = TestUtilities.serialize(catalogModel);

    Catalog catalogModelNew = TestUtilities.deserialize(json, Catalog.class);
    assertTrue(catalogModelNew instanceof Catalog);
    assertEquals(catalogModelNew.id(), "testString");
    assertEquals(catalogModelNew.rev(), "testString");
    assertEquals(catalogModelNew.label(), "testString");
    assertEquals(catalogModelNew.shortDescription(), "testString");
    assertEquals(catalogModelNew.catalogIconUrl(), "testString");
    assertEquals(catalogModelNew.url(), "testString");
    assertEquals(catalogModelNew.crn(), "testString");
    assertEquals(catalogModelNew.offeringsUrl(), "testString");
    assertEquals(catalogModelNew.disabled(), Boolean.valueOf(true));
    assertEquals(catalogModelNew.created().toString(), TestUtilities.createMockDateTime("2019-01-01T12:00:00").toString());
    assertEquals(catalogModelNew.updated().toString(), TestUtilities.createMockDateTime("2019-01-01T12:00:00").toString());
    assertEquals(catalogModelNew.resourceGroupId(), "testString");
    assertEquals(catalogModelNew.owningAccount(), "testString");
    assertEquals(catalogModelNew.catalogFilters().toString(), filtersModel.toString());
    assertEquals(catalogModelNew.syndicationSettings().toString(), syndicationResourceModel.toString());
  }
}