/*
 * Copyright (c) 2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.carbon.ml.test.internal.ds;

import org.wso2.carbon.ml.database.DatabaseService;
import org.wso2.carbon.ml.dataset.DatasetService;
import org.wso2.carbon.ml.model.ModelService;
import org.wso2.carbon.ml.project.mgt.ProjectManagementService;

public class MLTestServiceValueHolder {
    private static ModelService modelService;
    private static DatasetService datasetService;
    private static DatabaseService databaseService;
    private static ProjectManagementService projectMgtService;

    public static void registerModelService(ModelService model) {
        modelService = model;
    }

    public static ModelService getModelService() {
        return modelService;
    }

    public static void registerDatabaseService(DatabaseService service) {
        MLTestServiceValueHolder.databaseService = service;
    }

    public static DatabaseService getDatabaseService() {
        return databaseService;
    }

    public static void registerDatasetService(DatasetService datasetService) {
        MLTestServiceValueHolder.datasetService = datasetService;
    }

    public static void registerProjectMgtService(ProjectManagementService projectMgtService) {

        MLTestServiceValueHolder.projectMgtService = projectMgtService;
    }

    public static DatasetService getDatasetService() {
        return datasetService;
    }

    public static ProjectManagementService getProjectMgtService() {
        return projectMgtService;
    }
}
