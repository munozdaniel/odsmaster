package com.wipro.wess.ods.upload.excel.dto;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.poi.ss.usermodel.Cell;

import com.wipro.wess.ods.asset.OmAsset;
import com.wipro.wess.ods.asset.servicemapping.OmAssetOutputservice;
import com.wipro.wess.ods.exceptions.ConstraintViolatedException;
import com.wipro.wess.ods.exceptions.constraints.MandatoryConstraint;
import com.wipro.wess.ods.log.Error;
import com.wipro.wess.ods.log.ErrorMinorCode;
import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.service.OmServiceConfig;
import com.wipro.wess.ods.upload.ProvisioningConstants;

public class ExcelSupplSysOutputService extends ExcelSheet {

    private String assetNum;

    private String outputService;

    private String monitoringAsset;

    private String siteId;

    private String customer;

    public ExcelSupplSysOutputService() {
        super();
    }

    public ExcelSupplSysOutputService(String assetNum, String outputService, String monitoringAsset, String siteId,
            String customer) {
        super();
        this.assetNum = assetNum;
        this.outputService = outputService;
        this.monitoringAsset = monitoringAsset;
        this.siteId = siteId;
        this.customer = customer;
    }

    public String getAssetNum() {
        return assetNum;
    }

    public void setAssetNum(String assetNum) {
        this.assetNum = assetNum;
    }

    public String getOutputService() {
        return outputService;
    }

    public void setOutputService(String outputService) {
        this.outputService = outputService;
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
            Properties odsMasterProps) throws ConstraintViolatedException{
        Cell headerCell = headerColumns.get(headerCellNum);
        if (headerCell != null) {
            String headerVal = headerCell.getStringCellValue();
            Object valObj = this.getCellValue(currRowCell);
            SupplSysOutputServiceHeaders supplSysOutputServiceHeaders = SupplSysOutputServiceHeaders
                    .getSupplSysOutputServiceHeaders(headerVal, odsMasterProps);
            if (supplSysOutputServiceHeaders != null) {
                switch (supplSysOutputServiceHeaders) {
                    case ASSETNUM:
                        if (valObj != null && valObj instanceof String) {
                            String assetNum = (String) valObj;
                            this.setSheetRowId(assetNum);
                            this.setAssetNum(assetNum);
                        }
                        break;
                    case OUTPUTSERVICE:
                        if (valObj != null && valObj instanceof String) {
                            String outputService = (String) valObj;
                            this.setOutputService(outputService);
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
        MOrganisation orgId = this.lookupOrganisation(isisJdocontainer, locationMap, this.getSiteId(),
                ProvisioningConstants.SUPPL_SYS_OUTPUT_SERVICES_SHEET);
        OmAsset assetUid = this.validateAssetExistence(odsMasterProps, isisJdocontainer, this.getAssetNum(), orgId,
                ProvisioningConstants.SUPPL_SYS_OUTPUT_SERVICES_SHEET, ProvisioningConstants.ASSETNUM);
        OmServiceConfig outputserviceAssetUid = this.validateServiceUidExistence(odsMasterProps, isisJdocontainer,
                this.getOutputService(), ProvisioningConstants.SUPPL_SYS_OUTPUT_SERVICES_SHEET, ProvisioningConstants.OUTPUTSERVICE);
        String monitoringAsset = this.getMonitoringAsset();
        if(monitoringAsset != null){
            this.validateAssetExistence(odsMasterProps, isisJdocontainer, monitoringAsset, orgId,
                    ProvisioningConstants.SUPPL_SYS_OUTPUT_SERVICES_SHEET, ProvisioningConstants.MONITORINGASSET);
        }        
        OmAssetOutputservice assetOutputservice = isisJdocontainer.firstMatch(new QueryDefault<OmAssetOutputservice>(OmAssetOutputservice.class,
                "fetch_OmAssetOutputservice_by_pk", "orgId", orgId, "assetUid", assetUid, "outputserviceAssetUid", outputserviceAssetUid));
        if(assetOutputservice == null){
            assetOutputservice = isisJdocontainer.newTransientInstance(OmAssetOutputservice.class);
            assetOutputservice.setOrgId(orgId);
            assetOutputservice.setAssetUid(assetUid);
            assetOutputservice.setOutputserviceAssetUid(outputserviceAssetUid);
            assetOutputservice.setChangeby(isisJdocontainer.getUser().getName());
            assetOutputservice.setChangedt(new Date());
        }
        if(monitoringAsset != null){
            assetOutputservice.setMonitoringAssetUid(monitoringAsset);
        }
        
        isisJdocontainer.persistIfNotAlready(assetOutputservice);
    }

    private void validate(Properties odsMasterProps) throws ConstraintViolatedException {
        if (this.getSiteId() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.SUPPL_SYS_OUTPUT_SERVICES_SHEET));
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
        if (this.getOutputService() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.SUPPL_SYS_OUTPUT_SERVICES_SHEET));
            fieldName.append(ProvisioningConstants.DOT_CHAR);
            fieldName.append(ProvisioningConstants.OUTPUTSERVICE);
            StringBuffer errorMessage = new StringBuffer();
            errorMessage.append(ProvisioningConstants.OUTPUTSERVICE);
            errorMessage.append(ProvisioningConstants.MANDATORY_ERROR_MESSAGE);
            ConstraintViolatedException exception = new ConstraintViolatedException();
            Error.PDM_OUTPUTSERVICE_MANDATORY.format(ErrorMinorCode.PDMError001, errorMessage.toString());
            exception.addConstraint(new MandatoryConstraint(fieldName.toString(), Error.PDM_OUTPUTSERVICE_MANDATORY.name(),
                    errorMessage.toString(), this.getSheetRowId()));
            throw exception;
        }
    }
    
    @Override
    public String toString() {
        return "ExcelSupplSysOutputService [assetNum=" + assetNum + ", outputService=" + outputService
                + ", monitoringAsset=" + monitoringAsset + ", siteId=" + siteId + ", customer=" + customer
                + ", getSheetId()=" + getSheetRowId() + "]";
    }

}
