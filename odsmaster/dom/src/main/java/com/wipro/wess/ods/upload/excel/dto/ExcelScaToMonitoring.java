package com.wipro.wess.ods.upload.excel.dto;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.poi.ss.usermodel.Cell;

import com.wipro.wess.ods.asset.OmAsset;
import com.wipro.wess.ods.exceptions.ConstraintViolatedException;
import com.wipro.wess.ods.exceptions.constraints.MandatoryConstraint;
import com.wipro.wess.ods.log.Error;
import com.wipro.wess.ods.log.ErrorMinorCode;
import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.sca.OmScaConfig;
import com.wipro.wess.ods.sca.OmScaMonitorassetMap;
import com.wipro.wess.ods.upload.ProvisioningConstants;

public class ExcelScaToMonitoring extends ExcelSheet {

    private String scaSet;

    private String monitoringAsset;

    private String siteId;

    private String customer;

    public ExcelScaToMonitoring() {
        super();
    }

    public ExcelScaToMonitoring(String scaSet, String monitoringAsset, String siteId, String customer) {
        super();
        this.scaSet = scaSet;
        this.monitoringAsset = monitoringAsset;
        this.siteId = siteId;
        this.customer = customer;
    }

    public String getScaSet() {
        return scaSet;
    }

    public void setScaSet(String scaSet) {
        this.scaSet = scaSet;
    }

    public String getMonitoringAsset() {
        return monitoringAsset;
    }

    public void setMonitoringAsset(String monitoringAsset) {
        this.monitoringAsset = monitoringAsset;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    @Override
    public void populateExcelSheetData(Cell currRowCell, Integer headerCellNum, Map<Integer, Cell> headerColumns,
            Properties odsMasterProps) throws ConstraintViolatedException {
        Cell headerCell = headerColumns.get(headerCellNum);
        if (headerCell != null) {
            String headerVal = headerCell.getStringCellValue();
            Object valObj = this.getCellValue(currRowCell);
            ScaToMonitoringHeaders scaToMonitoringHeaders = ScaToMonitoringHeaders.getScaToMonitoringHeaders(headerVal,
                    odsMasterProps);
            if (scaToMonitoringHeaders != null) {
                switch (scaToMonitoringHeaders) {
                    case SCAASSET:
                        if (valObj != null && valObj instanceof String) {
                            String scaSet = (String) valObj;
                            this.setSheetRowId(scaSet);
                            this.setScaSet(scaSet);
                        }
                        break;
                    case MONITORINGASSET:
                        if (valObj != null && valObj instanceof String) {
                            String monitoringAsset = (String) valObj;
                            this.setMonitoringAsset(monitoringAsset);
                        }
                        break;
                    case SITEID:
                        if (valObj != null && valObj instanceof String) {
                            String siteId = (String) valObj;
                            this.setSiteId(siteId);
                        }
                        break;
                    case CUSTOMER:
                        if (valObj != null && valObj instanceof String) {
                            String customer = (String) valObj;
                            this.setCustomer(customer);
                        }
                        break;
                }
            }
        }
    }

    @Override
    public void process(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap, Properties odsMasterProps,
            DomainObjectContainer isisJdocontainer) throws ConstraintViolatedException {
        this.validate(odsMasterProps);
        OmScaConfig scaUid = this.validateScaExistence(odsMasterProps, isisJdocontainer, this.getScaSet(),
                ProvisioningConstants.SCA_TO_MONITORING_SHEET);
        MOrganisation orgId = this.lookupOrganisation(isisJdocontainer, locationMap, this.getSiteId(),
                ProvisioningConstants.SCA_TO_MONITORING_SHEET);
        OmAsset monitorAssetUid = this.validateAssetExistence(odsMasterProps, isisJdocontainer,
                this.getMonitoringAsset(), orgId, ProvisioningConstants.SCA_TO_MONITORING_SHEET,
                ProvisioningConstants.ASSETNUM);

        OmScaMonitorassetMap scaMonitorassetMap = isisJdocontainer.firstMatch(new QueryDefault<OmScaMonitorassetMap>(
                OmScaMonitorassetMap.class, "fetch_OmScaMonitorassetMap_by_sca_asset_map", "scaUid", scaUid,
                "monitorAssetUid", monitorAssetUid));
        if (scaMonitorassetMap == null) {
            scaMonitorassetMap = isisJdocontainer.newTransientInstance(OmScaMonitorassetMap.class);
            scaMonitorassetMap.setScaUid(scaUid);
            scaMonitorassetMap.setMonitorAssetUid(monitorAssetUid);
            scaMonitorassetMap.setChangeBy(isisJdocontainer.getUser().getName());
            scaMonitorassetMap.setChangeDt(new Date());
        }
        isisJdocontainer.persistIfNotAlready(scaMonitorassetMap);
    }

    private void validate(Properties odsMasterProps) throws ConstraintViolatedException {
        if (this.getSiteId() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.SCA_TO_MONITORING_SHEET));
            fieldName.append(ProvisioningConstants.DOT_CHAR);
            fieldName.append(ProvisioningConstants.SITEID);
            StringBuffer errorMessage = new StringBuffer();
            errorMessage.append(ProvisioningConstants.SITEID);
            errorMessage.append(ProvisioningConstants.MANDATORY_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            Error.PDM_ORGID_MANDATORY.format(ErrorMinorCode.PDMError001, errorMessage.toString());
            exception.addConstraint(new MandatoryConstraint(fieldName.toString(), Error.PDM_ORGID_MANDATORY.name(),
                    errorMessage.toString(), this.getSheetRowId()));
            throw exception;
        }
        if (this.getMonitoringAsset() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.SCA_TO_MONITORING_SHEET));
            fieldName.append(ProvisioningConstants.DOT_CHAR);
            fieldName.append(ProvisioningConstants.MONITORINGASSET);
            StringBuffer errorMessage = new StringBuffer();
            errorMessage.append(ProvisioningConstants.MONITORINGASSET);
            errorMessage.append(ProvisioningConstants.MANDATORY_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            Error.PDM_MONITORINGASSET_MANDATORY.format(ErrorMinorCode.PDMError001, errorMessage.toString());
            exception.addConstraint(new MandatoryConstraint(fieldName.toString(), Error.PDM_MONITORINGASSET_MANDATORY
                    .name(), errorMessage.toString(), this.getSheetRowId()));
            throw exception;
        }
    }

    @Override
    public String toString() {
        return "ExcelScaToMonitoring [scaSet=" + scaSet + ", monitoringAsset=" + monitoringAsset + ", siteId=" + siteId
                + ", customer=" + customer + ", getSheetId()=" + getSheetRowId() + "]";
    }

}
