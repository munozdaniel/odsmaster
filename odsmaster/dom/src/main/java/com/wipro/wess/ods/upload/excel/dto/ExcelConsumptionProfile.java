package com.wipro.wess.ods.upload.excel.dto;

import java.util.Map;
import java.util.Properties;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.query.QueryDefault;
import org.apache.poi.ss.usermodel.Cell;

import com.wipro.wess.ods.exceptions.ConstraintViolatedException;
import com.wipro.wess.ods.exceptions.constraints.MandatoryConstraint;
import com.wipro.wess.ods.log.Error;
import com.wipro.wess.ods.log.ErrorMinorCode;
import com.wipro.wess.ods.msa.OmModeOfOperationConfig;
import com.wipro.wess.ods.organisation.MOrganisation;
import com.wipro.wess.ods.upload.ProvisioningConstants;

public class ExcelConsumptionProfile extends ExcelSheet {

    String modeName;

    String description;

    String customer;

    String siteId; // it is same as customer code.

    public ExcelConsumptionProfile(String modeName, String description, String customer, String siteId) {
        super();
        this.modeName = modeName;
        this.description = description;
        this.customer = customer;
        this.siteId = siteId;
    }

    public ExcelConsumptionProfile() {
        super();
    }

    public String getModeName() {
        return modeName;
    }

    public void setModeName(String modeName) {
        this.modeName = modeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    @Override
    public void populateExcelSheetData(Cell currRowCell, Integer headerCellNum, Map<Integer, Cell> headerColumns,
            Properties odsMasterProps) throws ConstraintViolatedException{

        Cell headerCell = headerColumns.get(headerCellNum);
        if (headerCell != null) {
            String headerVal = headerCell.getStringCellValue();
            Object valObj = this.getCellValue(currRowCell);
            CPHeaders cpHeaders = CPHeaders.getCPHeaders(headerVal, odsMasterProps);
            if (cpHeaders != null) {
                switch (cpHeaders) {
                    case MODENAME:
                        if (valObj != null && valObj instanceof String) {
                            String modeName = (String) valObj;
                            this.setSheetRowId(modeName);
                            this.setModeName(modeName);
                        }
                        break;
                    case DESCRIPTION:
                        if (valObj != null && valObj instanceof String) {
                            String description = (String) valObj;
                            this.setDescription(description);
                        }
                        break;
                    case CUSTOMER:
                        if (valObj != null && valObj instanceof String) {
                            String customer = (String) valObj;
                            this.setCustomer(customer);
                        }
                        break;
                    case SITEID:
                        if (valObj != null && valObj instanceof String) {
                            String siteId = (String) valObj;
                            this.setSiteId(siteId);
                        }
                        break;

                }
            }

        }

    }



    @Override
    public String toString() {
        return "ExcelConsumptionProfile [modeName=" + modeName + ", description=" + description + ", customer="
                + customer + ", siteId=" + siteId + ", getSheetId()=" + getSheetRowId() + "]";
    }

    @Override
    public void process(Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap, Properties odsMasterProps,
            DomainObjectContainer isisJdocontainer) throws ConstraintViolatedException {
        this.validate(odsMasterProps);
        MOrganisation organisation = this.lookupOrganisation(isisJdocontainer, locationMap, this.getSiteId(),
                odsMasterProps.getProperty(ProvisioningConstants.CONSUMPTION_PROFILE_SHEET));

        OmModeOfOperationConfig modeOfOperationConfig = isisJdocontainer
                .firstMatch(new QueryDefault<OmModeOfOperationConfig>(OmModeOfOperationConfig.class,
                        "fetch_OmModeOfOperationConfig_by_pk", "modeName", this.getModeName(), "organisation",
                        organisation));
        if (modeOfOperationConfig == null) {
            modeOfOperationConfig = isisJdocontainer.newTransientInstance(OmModeOfOperationConfig.class);
            modeOfOperationConfig.setModeName(this.getModeName());
            modeOfOperationConfig.setOrganisation(organisation);
        }
        modeOfOperationConfig.setModeDescription(this.getDescription());
        isisJdocontainer.persistIfNotAlready(modeOfOperationConfig);

    }

    private void validate(Properties odsMasterProps) throws ConstraintViolatedException {
        if (this.getSiteId() == null) {
            StringBuffer fieldName = new StringBuffer();
            fieldName.append(odsMasterProps.getProperty(ProvisioningConstants.CONSUMPTION_PROFILE_SHEET));
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
    }

}
