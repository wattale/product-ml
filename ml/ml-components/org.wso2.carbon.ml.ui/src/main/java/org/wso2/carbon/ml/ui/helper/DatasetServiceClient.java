/*
 *  Copyright (c) 2005-2014, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.wso2.carbon.ml.ui.helper;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.ConfigurationContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.wso2.carbon.ml.dataset.stub.DatasetServiceStub;
import org.wso2.carbon.ml.dataset.xsd.DatasetConfig;
import org.wso2.carbon.ml.dataset.xsd.Feature;
import org.wso2.carbon.ml.dataset.xsd.ImputeOption;

public class DatasetServiceClient {
	private static final Log logger = LogFactory
			.getLog(DatasetServiceClient.class);

	private DatasetServiceStub stub;

	public DatasetServiceClient(ConfigurationContext configCtx,
			String backendServerURL, String cookie)
			throws DatasetServiceClientException {

		try {
			String serviceURL = backendServerURL + "DatasetService";
			stub = new DatasetServiceStub(configCtx, serviceURL);
			ServiceClient client = stub._getServiceClient();
			Options options = client.getOptions();
			options.setManageSession(true);
			options.setProperty(
					org.apache.axis2.transport.http.HTTPConstants.COOKIE_STRING,
					cookie);
		} catch (AxisFault ex) {
			String msg = "An error has occurred while initilizing the DatasetServiceStub, error message: "
					+ ex.getMessage();
			logger.error(msg, ex);
			throw new DatasetServiceClientException(msg);
		}
	}

	/**
	 * 
	 * @param datasetName
	 * @return
	 * @throws DatasetServiceClientException
	 */
	public String importDataset(String datasetName)
			throws DatasetServiceClientException {
		try {
			return stub.registerDataset(datasetName);
		} catch (Exception ex) {
			String msg = "An error has occurred while calling importData() error message: "
					+ ex.getMessage();
			logger.error(msg, ex);
			throw new DatasetServiceClientException(msg);
		}
	}

	/**
	 * 
	 * @return
	 * @throws DatasetServiceClientException
	 */
	public DatasetConfig getDatasetConfig()
			throws DatasetServiceClientException {
		try {
			return stub.getDatasetConfig();
		} catch (Exception ex) {
			String msg = "An error has occurred while calling getDatasetConfig(), error message: "
					+ ex.getMessage();
			logger.error(msg, ex);
			throw new DatasetServiceClientException(msg);
		}
	}

	/**
	 * 
	 * @param datsetId
	 * @param start
	 * @param numberOfFeatures
	 * @return
	 * @throws DatasetServiceClientException
	 */
	public Feature[] getFeatures(String datsetId, int start,
			int numberOfFeatures) throws DatasetServiceClientException {
		try {
			return stub.getFeatures(datsetId, start, numberOfFeatures);
		} catch (Exception ex) {
			String msg = "An error has occurred while calling getFeatures() error message: "
					+ ex.getMessage();
			logger.error(msg, ex);
			throw new DatasetServiceClientException(msg);
		}
	}

	/**
	 * 
	 * @param dataSrcId
	 * @param numOfRecords
	 * @return
	 * @throws DatasetServiceClientException
	 */
	public int generateSummaryStatistics(String dataSrcId, int numOfRecords)
			throws DatasetServiceClientException {
		try {
			return stub.generateSummaryStats(dataSrcId, numOfRecords);
		} catch (Exception ex) {
			String msg = "An error has occurred while calling generateSummaryStatistics() error message: "
					+ ex.getMessage();
			logger.error(msg, ex);
			throw new DatasetServiceClientException(msg);
		}
	}

	// TODO: instead of "String type", use should use "FeatureType type"
	/**
	 * 
	 * @param featureName
	 * @param datasetId
	 * @param dataType
	 * @param imputeOption
	 * @param isFeatureIncludedInTheModel
	 * @return
	 * @throws DatasetServiceClientException
	 */
	public void updateFeature(String featureName, String datasetId,
			String dataType, ImputeOption imputeOption,
			boolean isFeatureIncludedInTheModel)
			throws DatasetServiceClientException {
		try {
			stub.updateFeature(featureName, datasetId, dataType,
					imputeOption, isFeatureIncludedInTheModel);
		} catch (Exception ex) {
			String msg = "An error has occurred while calling updateFeature() error message: "
					+ ex.getMessage();
			logger.error(msg, ex);
			throw new DatasetServiceClientException(msg);
		}
	}

	/**
	 * 
	 * @param featureName
	 * @param datasetId
	 * @param featureType
	 * @return
	 * @throws DatasetServiceClientException
	 */
	public void updateDataType(String featureName, String datasetId,
			String featureType) throws DatasetServiceClientException {
		try {
			stub.updateDataType(featureName, datasetId, featureType);
		} catch (Exception ex) {
			String msg = "An error has occurred while calling updateDataType() error message: "
					+ ex.getMessage();
			logger.error(msg, ex);
			throw new DatasetServiceClientException(msg);
		}
	}

	/**
	 * 
	 * @param featureName
	 * @param datasetId
	 * @param imputeOption
	 * @return
	 * @throws DatasetServiceClientException
	 */
	public void updateImputeOption(String featureName, String datasetId,
			String imputeOption) throws DatasetServiceClientException {
		try {
			stub.updateImputeOption(featureName, datasetId, imputeOption);
		} catch (Exception ex) {
			String msg = "An error has occurred while calling updateImputeOption() error message: "
					+ ex.getMessage();
			logger.error(msg, ex);
			throw new DatasetServiceClientException(msg);
		}
	}

	/**
	 * 
	 * @param featureName
	 * @param datasetId
	 * @param isInput
	 * @return
	 * @throws DatasetServiceClientException
	 */
	public void updateIsIncludedFeature(String featureName,
			String datasetId, boolean isInput)
			throws DatasetServiceClientException {
		try {
			stub.updateIsIncludedFeature(featureName, datasetId, isInput);
		} catch (Exception ex) {
			String msg = "An error has occurred while calling updateIsIncludedFeature() error message: "
					+ ex.getMessage();
			logger.error(msg, ex);
			throw new DatasetServiceClientException(msg);
		}
	}
}
