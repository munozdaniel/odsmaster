/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */
package com.wipro.wess.ods.welcome;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.isis.applib.AbstractViewModel;
import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.value.Blob;

import com.wipro.wess.ods.exceptions.ConstraintViolatedException;
import com.wipro.wess.ods.exceptions.constraints.Constraint;
import com.wipro.wess.ods.log.Error;
import com.wipro.wess.ods.log.ErrorMinorCode;
import com.wipro.wess.ods.log.Info;
import com.wipro.wess.ods.site.OmSite;
import com.wipro.wess.ods.site.OmSiteService;
import com.wipro.wess.ods.upload.ProvisionSheetProcessor;
import com.wipro.wess.ods.upload.ProvisionSheetUpload;
import com.wipro.wess.ods.upload.excel.dto.LocationHierarchyLookup;

public class ODSProvisioning extends AbstractViewModel {
    
    //private static Logger log = LoggerFactory.getLogger(ODSProvisioning.class);

    Map<LocationHierarchyLookup, LocationHierarchyLookup> locationMap = new HashMap<LocationHierarchyLookup, LocationHierarchyLookup>();

    public String title() {
        return "Provisioning";
    }

/*    public String iconName() {
        return "Provisioning";
    }*/

    // //////////////////////////////////////
    // ViewModel contract
    // //////////////////////////////////////

    private String memento;

    @Override
    public String viewModelMemento() {
        return memento;
    }

    @Override
    public void viewModelInit(String memento) {
        this.memento = memento;
    }

    private DomainObjectContainer container;

    public void injectDomainObjectContainer(final DomainObjectContainer container) {
        this.container = container;
    }

/*    @Named("Sheet Upload")
    @Render(Type.EAGERLY)
    public ODSProvisioning upload(@Named("Browse sheet")Blob provSheet) throws Exception {
        try {
            log.info("START UPLOAD");
            ProvisionSheetUpload provisionSheetUpload = new ProvisionSheetUpload();
            boolean uploaded = provisionSheetUpload.upload(provSheet, this.locationMap, this.container);           
            if(uploaded){
                this.container.informUser("File uploaded " + provSheet.getName());
            } else {
                this.container.warnUser("Nothing to upload OR Wrong Provisioning sheet format");
            }
            
            log.info("END UPLOAD");
        } catch (ConstraintViolatedException e) {
            for (Constraint constraint : e.getConstraints()) {
                this.container.warnUser(constraint.toString());
            }
        } catch (FileNotFoundException e) {
            this.container.warnUser(e.getMessage());
        } catch (IOException e) {
            this.container.warnUser(e.getMessage());
        }
        return this;
    }*/

    private OmSiteService siteService;
    public void injectOmSiteService(OmSiteService siteService){
        this.siteService = siteService;
    }

    public List<OmSite> upload(@Named("Browse sheet")Blob provSheet) throws Exception {
        try {
            
            Info.PDMINFO.format("START UPLOAD");
            
            ProvisionSheetUpload provisionSheetUpload = new ProvisionSheetUpload();
            String file = ProvisionSheetUpload.ODSMASTER_PROPS.getProperty("uploadPath");
            provSheet.writeBytesTo(new FileOutputStream(file));
            
            provisionSheetUpload.upload(file);
            boolean uploaded = ProvisionSheetProcessor.process(provisionSheetUpload, this.locationMap, this.container);
            
            if(uploaded){
                this.container.informUser("File uploaded " + provSheet.getName());
            } else {
                Error.PDM_NODATA_OR_WRONG_FORMAT_ERROR.format(ErrorMinorCode.PDMError003, "Nothing to upload OR Wrong Provisioning sheet format");
                this.container.warnUser("Nothing to upload OR Wrong Provisioning sheet format");
            }
            
            Info.PDMINFO.format("END UPLOAD");
        } catch (ConstraintViolatedException e) {
            for (Constraint constraint : e.getConstraints()) {
                this.container.warnUser(constraint.toString());
            }
        } catch (FileNotFoundException e) {
            this.container.warnUser(e.getMessage());
        } catch (IOException e) {
            this.container.warnUser(e.getMessage());
        }
        catch (Exception e) {
            e.printStackTrace();
            Error.PDM_TECHNICAL_ERROR.format(ErrorMinorCode.PDMError004, e);
            this.container.warnUser(e.getMessage());
        }
        return this.siteService.listAllSites();
        //return newViewModelInstance(ODSProvisioning.class, ID);
        
    }


}
