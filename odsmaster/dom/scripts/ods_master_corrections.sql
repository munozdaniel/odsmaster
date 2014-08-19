-- Addititon of extra columns to avoid re-use of same column in multiple foreign keys begin
---om_site modifications begin
ALTER TABLE gemsods.om_site DROP CONSTRAINT om_site_factility_org_fk;

ALTER TABLE gemsods.om_site ADD COLUMN loc_org_id character varying(18);

UPDATE gemsods.om_site SET loc_org_id = org_id WHERE location_id IS NOT NULL;

ALTER TABLE gemsods.om_site ADD CONSTRAINT om_site_factility_org_fk FOREIGN KEY (location_id, loc_org_id)
REFERENCES gemsods.om_geo_location (location_id, org_id);

ALTER TABLE gemsods.om_site DROP CONSTRAINT om_site_address_id;

ALTER TABLE gemsods.om_site ADD COLUMN addr_org_id character varying(18);

UPDATE gemsods.om_site SET addr_org_id = org_id WHERE address_id IS NOT NULL;

ALTER TABLE gemsods.om_site ADD CONSTRAINT om_site_address_id FOREIGN KEY (address_id, addr_org_id)
REFERENCES gemsods.om_address (address_id, org_id);

ALTER TABLE gemsods.om_site DROP CONSTRAINT om_site_parent_site_id;

ALTER TABLE gemsods.om_site ADD COLUMN site_org_id character varying(18);

UPDATE gemsods.om_site SET site_org_id = org_id WHERE parent_site_id IS NOT NULL;

ALTER TABLE gemsods.om_site ADD CONSTRAINT om_site_parent_site_id FOREIGN KEY (parent_site_id, site_org_id)
REFERENCES gemsods.om_site (site_id, org_id);

---om_site modifications end

---om_pointpath modifcations begin
ALTER TABLE gemsods.om_pointpath ADD COLUMN asset_org_id character varying(18);

UPDATE gemsods.om_pointpath SET asset_org_id = org_id;

ALTER TABLE gemsods.om_pointpath ALTER COLUMN asset_org_id SET NOT NULL;

ALTER TABLE gemsods.om_pointpath ADD CONSTRAINT om_pointpath_om_asset_fk FOREIGN KEY (asset_uid, asset_org_id)
REFERENCES gemsods.om_asset (asset_uid , org_id );

---om_pointpath modifcations end


--om_utility_account modifications begin

ALTER TABLE gemsods.om_utility_account DROP CONSTRAINT utility_acccount_fk1;

ALTER TABLE gemsods.om_utility_account ADD COLUMN addr_org_id character varying(18);

UPDATE gemsods.om_utility_account SET addr_org_id = org_id;

ALTER TABLE gemsods.om_utility_account ALTER COLUMN addr_org_id SET NOT NULL;

ALTER TABLE gemsods.om_utility_account ADD CONSTRAINT utility_acccount_fk1 FOREIGN KEY (bill_address_id, addr_org_id)
REFERENCES gemsods.om_address (address_id, org_id);

--om_utility_account modifications end

--om_asset modifications begin

ALTER TABLE gemsods.om_asset DROP CONSTRAINT om_asset_fk1;

ALTER TABLE gemsods.om_asset ADD COLUMN loc_org_id character varying(18);

ALTER TABLE gemsods.om_asset ADD CONSTRAINT om_asset_loc_hierarchy_fk1 FOREIGN KEY (location_uid, loc_org_id)
      REFERENCES gemsods.om_location_hierarchy (location_uid, org_id);

UPDATE gemsods.om_asset SET loc_org_id=org_id WHERE location_uid IS NOT NULL;

--om_asset modifications end

--om_geo_location modifications begin

ALTER TABLE gemsods.om_geo_location
  DROP CONSTRAINT om_geo_location_parent_location_id;

ALTER TABLE gemsods.om_geo_location ADD COLUMN parent_geo_loc_org_id character varying(18);

UPDATE gemsods.om_geo_location SET parent_geo_loc_org_id = org_id WHERE parent_location_id IS NOT NULL;

ALTER TABLE gemsods.om_geo_location
  ADD CONSTRAINT om_geo_location_parent_location_id FOREIGN KEY (parent_location_id, parent_geo_loc_org_id)
      REFERENCES gemsods.om_geo_location (location_id, org_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
	  
--om_geo_location modifications end

-- Addititon of extra columns to avoid re-use of same column in multiple foreign keys end

-- Foreign key relationships added to make sure data consistency for site begin



ALTER TABLE gemsods.om_sca_monitorasset_map
  ADD CONSTRAINT om_sca_monitorasset_map_fk FOREIGN KEY(sca_uid) REFERENCES gemsods.om_sca_config(sca_uid);


ALTER TABLE gemsods.om_asset_inputservice ADD COLUMN asset_org_id character varying(18);
UPDATE gemsods.om_asset_inputservice SET asset_org_id = org_id;
ALTER TABLE gemsods.om_asset_inputservice ALTER COLUMN asset_org_id SET NOT NULL;

ALTER TABLE gemsods.om_asset_outputservice ADD COLUMN asset_org_id character varying(18);
UPDATE gemsods.om_asset_outputservice SET asset_org_id = org_id;
ALTER TABLE gemsods.om_asset_outputservice ALTER COLUMN asset_org_id SET NOT NULL;



ALTER TABLE gemsods.om_supplier_asset_service_map
  ADD CONSTRAINT om_supl_srvc_map_service_fk FOREIGN KEY(service_uid) REFERENCES gemsods.om_service_config(service_uid);


ALTER TABLE gemsods.om_supplier_asset_config
  ADD CONSTRAINT om_supplier_asset_config_site_fk FOREIGN KEY(site_id, org_id) REFERENCES gemsods.om_site(site_id, org_id);





ALTER TABLE gemsods.om_location_hierarchy ADD COLUMN site_org_id character varying(18);

ALTER TABLE gemsods.om_location_hierarchy
  ADD CONSTRAINT om_location_hierarchy_site_fk FOREIGN KEY(site, site_org_id) REFERENCES gemsods.om_site(site_id, org_id);

UPDATE gemsods.om_location_hierarchy SET site_org_id = org_id WHERE site IS NOT NULL;

-- required only if data not consistent between om_site and m_organisation
--delete from om_site where org_id not in(select org_id from m_organisation);
ALTER TABLE gemsods.om_site ADD CONSTRAINT om_site_m_organisation_fk FOREIGN KEY (org_id)
REFERENCES gemsods.m_organisation (org_id);

ALTER TABLE gemsods.om_asset_extended_attr ADD COLUMN site_org_id character varying(18);
ALTER TABLE gemsods.om_asset_extended_attr ADD CONSTRAINT 
om_asset_extended_attr_site_fk FOREIGN KEY(site_id, site_org_id) REFERENCES gemsods.om_site(site_id, org_id);
ALTER TABLE gemsods.om_asset_extended_attr ADD CONSTRAINT 
om_asset_extended_attr_asset_fk FOREIGN KEY(asset_id, org_id) REFERENCES gemsods.om_asset(asset_uid, org_id);



  ALTER TABLE gemsods."om_sca_config_ext_attr" ADD CONSTRAINT "om_sca_config_ext_attr_FK1" FOREIGN KEY ("sca_uid")
 REFERENCES gemsods."om_sca_config" ("sca_uid")  ;
  ALTER TABLE gemsods."om_uom_country_except_audit" ADD CONSTRAINT "om_uom_country_except_audit_FK5" FOREIGN KEY ("measure_id")
   REFERENCES gemsods."m_measurement" ("measure_id")  ;

   ALTER TABLE gemsods."om_uom_country_except_audit" ADD CONSTRAINT "om_uom_country_except_audit_FK3" FOREIGN KEY ("unit_id")
    REFERENCES gemsods."m_unit" ("unit_id")  ;
	
	ALTER TABLE gemsods."om_uom_country_except_audit" ADD CONSTRAINT "om_uom_country_except_audit_FK4" FOREIGN KEY ("unit_family_id") 
REFERENCES gemsods."m_unit_family" ("unit_family_id")  ;

ALTER TABLE gemsods."om_supplier_asset_config" ADD CONSTRAINT "om_supplier_asset_config_FK1" FOREIGN KEY ("org_id","site_id") REFERENCES 
gemsods."om_site" ("org_id","site_id")  ;

 ALTER TABLE gemsods."om_meter_config" ADD CONSTRAINT "om_meter_config_FK1" FOREIGN KEY ("org_id","site_id")
  REFERENCES gemsods."om_site" ("org_id","site_id")  ;
  
  ALTER TABLE gemsods."om_sca_service_map" ADD CONSTRAINT "om_sca_service_map_FK1" FOREIGN KEY ("org_id") 
REFERENCES gemsods."m_organisation" ("org_id")  ;

ALTER TABLE gemsods."om_asset_outputservice" ADD CONSTRAINT "om_asset_outputservice_FK1" FOREIGN KEY ("outputservice_asset_uid") 
REFERENCES gemsods."om_service_config" ("service_uid")  ;

ALTER TABLE gemsods."om_asset_outputservice" ADD CONSTRAINT "om_asset_outputservice_FK2" FOREIGN KEY ("org_id") REFERENCES 
gemsods."m_organisation" ("org_id")  ;

ALTER TABLE gemsods."om_asset_outputservice" ADD CONSTRAINT "om_asset_outputservice_FK3" FOREIGN KEY ("asset_uid","asset_org_id") 
REFERENCES gemsods."om_asset" ("asset_uid","org_id")  ;

ALTER TABLE gemsods."om_msa_cons_fr" ADD CONSTRAINT "om_msa_cons_fr_FK1" 
FOREIGN KEY ("org_id") REFERENCES gemsods."m_organisation" ("org_id")  ;

 ALTER TABLE gemsods."om_asset_inputservice" ADD CONSTRAINT "om_asset_inputservice_FK2" 
 FOREIGN KEY ("org_id") REFERENCES gemsods."m_organisation" ("org_id")  ;
 
 ALTER TABLE gemsods."om_asset_inputservice" ADD CONSTRAINT "om_asset_inputservice_FK1" FOREIGN KEY ("inputservice_asset_uid") 
REFERENCES gemsods."om_service_config" ("service_uid")  ;

ALTER TABLE gemsods."om_asset_inputservice" ADD CONSTRAINT "om_asset_inputservice_FK3" FOREIGN KEY ("asset_uid","asset_org_id") 
REFERENCES gemsods."om_asset" ("asset_uid","org_id")  ;


ALTER TABLE gemsods."om_msa_cons_st_fr" ADD CONSTRAINT "om_msa_cons_st_fr_FK1" FOREIGN KEY ("org_id") 
REFERENCES gemsods."m_organisation" ("org_id")  ;

ALTER TABLE gemsods."om_sca_monitorasset_map" ADD CONSTRAINT "om_sca_monitorasset_map_FK2" FOREIGN KEY ("sca_uid") REFERENCES 
gemsods."om_sca_config" ("sca_uid")  ;

ALTER TABLE gemsods."om_sca_monitorasset_map" ADD CONSTRAINT "om_sca_monitorasset_map_FK1" FOREIGN KEY ("monitor_asset_uid","org_id") 
REFERENCES gemsods."om_asset" ("asset_uid","org_id")  ;

ALTER TABLE gemsods."om_uom_site_except_audit" ADD CONSTRAINT "om_uom_site_except_audit_FK4" FOREIGN KEY ("unit_id") REFERENCES 
gemsods."m_unit" ("unit_id")  ;

ALTER TABLE gemsods."om_uom_site_except_audit" ADD CONSTRAINT "om_uom_site_except_audit_FK5" FOREIGN KEY ("unit_family_id")
 REFERENCES gemsods."m_unit_family" ("unit_family_id")  ;
 
 ALTER TABLE gemsods."om_uom_site_except_audit" ADD CONSTRAINT "om_uom_site_except_audit_FK3" FOREIGN KEY ("measure_entity_id") 
REFERENCES gemsods."m_measurement_entity" ("measure_entity_id")  ;

ALTER TABLE gemsods."om_uom_site_except_audit" ADD CONSTRAINT "om_uom_site_except_audit_FK2" FOREIGN KEY ("measure_id") 
REFERENCES gemsods."m_measurement" ("measure_id")  ;

ALTER TABLE gemsods."om_uom_site_except_audit" ADD CONSTRAINT "om_uom_site_except_audit_FK1" FOREIGN KEY ("org_id") 
REFERENCES gemsods."m_organisation" ("org_id")  ;

ALTER TABLE gemsods."om_uom_site_except" ADD CONSTRAINT "om_uom_site_except_FK1" FOREIGN KEY 
("org_id") REFERENCES gemsods."m_organisation" ("org_id")  ;

ALTER TABLE gemsods."om_site" ADD CONSTRAINT "om_site_FK1" FOREIGN KEY ("site_org_id","parent_site_id") REFERENCES gemsods."om_site" 
("org_id","site_id")  ;

ALTER TABLE gemsods."om_pointlist_country_except" ADD CONSTRAINT "om_pointlist_country_except_FK1" FOREIGN KEY ("assetclass_code","point") REFERENCES gemsods."m_pointlist" 
("assetclass_code","point")  ;

ALTER TABLE gemsods."om_pointlist_country_except" ADD CONSTRAINT "om_pointlist_country_except_FK2" FOREIGN KEY ("org_id") 
REFERENCES gemsods."m_organisation" ("org_id")  ;

ALTER TABLE gemsods."om_pointlist_org_policy_audit" ADD CONSTRAINT "om_pointlist_org_policy_audit_FK2" FOREIGN KEY ("assetclass_code","point")
 REFERENCES gemsods."m_pointlist" ("assetclass_code","point")  ;
 
  ALTER TABLE gemsods."om_pointlist_org_policy_audit" ADD CONSTRAINT "om_pointlist_org_policy_audit_FK1" FOREIGN KEY ("org_id") 
 REFERENCES gemsods."m_organisation" ("org_id")  ;
 
 
 ALTER TABLE gemsods."om_uom_country_policy_audit" ADD CONSTRAINT "om_uom_country_policy_audit_FK1" FOREIGN KEY ("measure_id") 
 REFERENCES gemsods."m_measurement" ("measure_id")  ;
 
 ALTER TABLE gemsods."om_uom_country_policy_audit" ADD CONSTRAINT "om_uom_country_policy_audit_FK2" FOREIGN KEY ("unit_family_id") REFERENCES 
gemsods."m_unit_family" ("unit_family_id")  ;

ALTER TABLE gemsods."om_uom_country_policy_audit" ADD CONSTRAINT "om_uom_country_policy_audit_FK3" FOREIGN KEY ("measure_entity_id") REFERENCES 
gemsods."m_measurement_entity" ("measure_entity_id")  ;

 ALTER TABLE gemsods."om_uom_country_policy_audit" ADD CONSTRAINT "om_uom_country_policy_audit_FK4" FOREIGN KEY ("org_id") REFERENCES 
 gemsods."m_organisation" ("org_id")  ;
 
 ALTER TABLE gemsods."om_uom_country_policy_audit" ADD CONSTRAINT "om_uom_country_policy_audit_FK5" FOREIGN KEY ("unit_id") 
REFERENCES gemsods."m_unit" ("unit_id")  ;

 ALTER TABLE gemsods."om_uom_org_policy" ADD CONSTRAINT "om_uom_org_policy_FK1" FOREIGN KEY ("org_id") 
 REFERENCES gemsods."m_organisation" ("org_id")  ;
 
  ALTER TABLE gemsods."om_site_extended_attr" ADD CONSTRAINT "om_site_extended_attr_FK1" FOREIGN KEY ("orgid","location") REFERENCES gemsods."om_site" 
 ("org_id","site_id")  ;
 
  ALTER TABLE gemsods."om_uom_country_except" ADD CONSTRAINT "om_uom_country_except_FK1" FOREIGN KEY ("org_id")
  REFERENCES gemsods."m_organisation" ("org_id")  ;
  
   ALTER TABLE gemsods."om_msa_service_map" ADD CONSTRAINT "om_msa_service_map_FK1" FOREIGN KEY ("org_id")
  REFERENCES gemsods."m_organisation" ("org_id")  ;
  
  ALTER TABLE gemsods."om_pointlist_country_policy_audit" ADD CONSTRAINT "om_pointlist_country_policy_audit_FK1" FOREIGN KEY ("org_id") 
REFERENCES gemsods."m_organisation" ("org_id")  ;


ALTER TABLE gemsods."om_pointlist_country_policy_audit" ADD CONSTRAINT "om_pointlist_country_policy_audit_FK2" FOREIGN KEY ("assetclass_code","point") 
REFERENCES gemsods."m_pointlist" ("assetclass_code","point")  ;

 ALTER TABLE gemsods."om_asset" ADD CONSTRAINT "om_asset_FK1" FOREIGN KEY ("org_id")
  REFERENCES gemsods."m_organisation" ("org_id")  ;
  
  ALTER TABLE gemsods."om_msa_cons_stsubt_fr" ADD CONSTRAINT "om_msa_cons_stsubt_fr_FK1" FOREIGN KEY ("org_id") 
REFERENCES gemsods."m_organisation" ("org_id")  ;


ALTER TABLE gemsods."om_msa_modeop_def" ADD CONSTRAINT "om_msa_modeop_def_FK1" FOREIGN KEY ("mode_name","org_id")
 REFERENCES gemsods."om_mode_of_operation_config" ("mode_name","org_id")  ;
 
 ALTER TABLE gemsods."om_site_data_agg_map" ADD CONSTRAINT "om_site_data_agg_map_FK1" FOREIGN KEY ("org_id","site_id") REFERENCES
 gemsods."om_site" ("org_id","site_id")  ;


-- Foreign key relationships added to make sure data consistency for site end

-- Missing columns from provisioning sheet begin

ALTER TABLE gemsods.om_sca_service_map ADD COLUMN org_id character varying(18);
UPDATE gemsods.om_sca_service_map map SET org_id = (SELECT org_id FROM om_sca_config sca WHERE map.sca_uid = sca.sca_uid);
ALTER TABLE gemsods.om_sca_service_map ALTER COLUMN org_id SET NOT NULL;

ALTER TABLE gemsods.om_msa_service_map ADD COLUMN org_id character varying(18);
UPDATE gemsods.om_msa_service_map map SET org_id = (SELECT org_id FROM om_msa_config msa WHERE map.msa_uid = msa.msa_uid);
ALTER TABLE gemsods.om_msa_service_map ALTER COLUMN org_id SET NOT NULL;

ALTER TABLE gemsods.om_msa_sca_map ADD COLUMN org_id character varying(18);
UPDATE gemsods.om_msa_sca_map map SET org_id = (SELECT org_id FROM om_msa_config msa WHERE map.msa_uid = msa.msa_uid);
ALTER TABLE gemsods.om_msa_sca_map ALTER COLUMN org_id SET NOT NULL;

ALTER TABLE gemsods.om_asset ADD COLUMN serial_num character varying(200);
ALTER TABLE gemsods.om_asset ADD COLUMN ip_address character varying(25);
ALTER TABLE gemsods.om_asset ADD COLUMN year_purchased timestamp without time zone;
ALTER TABLE gemsods.om_asset ADD COLUMN meter_type character varying(240);
ALTER TABLE gemsods.om_asset ADD COLUMN parent_meter character varying(240);
ALTER TABLE gemsods.om_asset ADD COLUMN assettag character varying(100);


-- Missing columns from provisioning sheet end

--site_id column missing in important tables
--om_meter_config modifications begin
ALTER TABLE gemsods.om_meter_config ADD COLUMN site_id character varying(255);
UPDATE gemsods.om_meter_config SET site_id=
SUBSTRING( SUBSTRING(meter_uid FROM POSITION('L_' IN meter_uid)+2 for LENGTH(meter_uid)-POSITION('L_' IN meter_uid)+2) 
FROM 1 FOR POSITION ('x' IN 
SUBSTRING(meter_uid FROM POSITION('L_' IN meter_uid)+2 for LENGTH(meter_uid)-POSITION('L_' IN meter_uid)+2)
)-1
)
WHERE POSITION ('x' IN 
SUBSTRING(meter_uid FROM POSITION('L_' IN meter_uid)+2 for LENGTH(meter_uid)-POSITION('L_' IN meter_uid)+2)
) > 1
--om_meter_config modifications end

--config_user column in every ods_master table begin
ALTER TABLE om_asset ADD COLUMN config_user character varying(60);
ALTER TABLE om_asset_extended_attr ADD COLUMN config_user character varying(60);
ALTER TABLE om_asset_info_element ADD COLUMN config_user character varying(60);
ALTER TABLE om_assetspec ADD COLUMN config_user character varying(60);
ALTER TABLE om_supplier_asset_config ADD COLUMN config_user character varying(60);
ALTER TABLE om_supplier_asset_service_map ADD COLUMN config_user character varying(60);
ALTER TABLE om_asset_inputservice ADD COLUMN config_user character varying(60);
ALTER TABLE om_asset_outputservice ADD COLUMN config_user character varying(60);
ALTER TABLE m_assetclass ADD COLUMN config_user character varying(60);
ALTER TABLE m_pointlist ADD COLUMN config_user character varying(60);
ALTER TABLE m_sourcetype_config ADD COLUMN config_user character varying(60);
ALTER TABLE om_geo_location ADD COLUMN config_user character varying(60);
ALTER TABLE om_pointpath ADD COLUMN config_user character varying(60);
ALTER TABLE om_meter_config ADD COLUMN config_user character varying(60);
ALTER TABLE om_mode_of_operation_config ADD COLUMN config_user character varying(60);
ALTER TABLE om_msa_config ADD COLUMN config_user character varying(60);
ALTER TABLE om_msa_cons_fr ADD COLUMN config_user character varying(60);
ALTER TABLE om_msa_cons_st_fr ADD COLUMN config_user character varying(60);
ALTER TABLE om_msa_cons_stsubt_fr ADD COLUMN config_user character varying(60);
ALTER TABLE om_msa_modeop_def ADD COLUMN config_user character varying(60);
ALTER TABLE om_msa_sca_map ADD COLUMN config_user character varying(60);
ALTER TABLE om_msa_service_map ADD COLUMN config_user character varying(60);
ALTER TABLE m_unit ADD COLUMN config_user character varying(60);
ALTER TABLE m_unit_family ADD COLUMN config_user character varying(60);
ALTER TABLE m_organisation ADD COLUMN config_user character varying(60);
ALTER TABLE om_org_extended_attr ADD COLUMN config_user character varying(60);
ALTER TABLE om_org_sref_name ADD COLUMN config_user character varying(60);
ALTER TABLE om_location_hierarchy ADD COLUMN config_user character varying(60);
ALTER TABLE om_sca_config ADD COLUMN config_user character varying(60);
ALTER TABLE om_sca_config_ext_attr ADD COLUMN config_user character varying(60);
ALTER TABLE om_sca_monitorasset_map ADD COLUMN config_user character varying(60);
ALTER TABLE om_sca_service_map ADD COLUMN config_user character varying(60);
ALTER TABLE m_sector ADD COLUMN config_user character varying(60);
ALTER TABLE om_service_config ADD COLUMN config_user character varying(60);
ALTER TABLE om_address ADD COLUMN config_user character varying(60);
ALTER TABLE om_msa_site_map ADD COLUMN config_user character varying(60);
ALTER TABLE om_site ADD COLUMN config_user character varying(60);
ALTER TABLE om_site_data_agg_map ADD COLUMN config_user character varying(60);
ALTER TABLE om_site_extended_attr ADD COLUMN config_user character varying(60);
ALTER TABLE om_site_info_element ADD COLUMN config_user character varying(60);
ALTER TABLE om_site_sref_formula ADD COLUMN config_user character varying(60);
ALTER TABLE m_sourcecat_config ADD COLUMN config_user character varying(60);
ALTER TABLE m_sourcegen_config ADD COLUMN config_user character varying(60);
ALTER TABLE om_utility_supplier ADD COLUMN config_user character varying(60);
ALTER TABLE m_ext_data_source_info ADD COLUMN config_user character varying(60);
ALTER TABLE m_measurement ADD COLUMN config_user character varying(60);
ALTER TABLE m_measurement_entity ADD COLUMN config_user character varying(60);
ALTER TABLE m_unit_conversion ADD COLUMN config_user character varying(60);
ALTER TABLE m_uom_defaults ADD COLUMN config_user character varying(60);
ALTER TABLE om_pointlist_country_except ADD COLUMN config_user character varying(60);
ALTER TABLE om_pointlist_country_except_audit ADD COLUMN config_user character varying(60);
ALTER TABLE om_pointlist_country_policy ADD COLUMN config_user character varying(60);
ALTER TABLE om_pointlist_country_policy_audit ADD COLUMN config_user character varying(60);
ALTER TABLE om_pointlist_org_policy ADD COLUMN config_user character varying(60);
ALTER TABLE om_pointlist_org_policy_audit ADD COLUMN config_user character varying(60);
ALTER TABLE om_pointlist_site_except ADD COLUMN config_user character varying(60);
ALTER TABLE om_pointlist_site_except_audit ADD COLUMN config_user character varying(60);
ALTER TABLE om_uom_country_except ADD COLUMN config_user character varying(60);
ALTER TABLE om_uom_country_except_audit ADD COLUMN config_user character varying(60);
ALTER TABLE om_uom_country_policy ADD COLUMN config_user character varying(60);
ALTER TABLE om_uom_country_policy_audit ADD COLUMN config_user character varying(60);
ALTER TABLE om_uom_ext_data_source_except ADD COLUMN config_user character varying(60);
ALTER TABLE om_uom_org_policy ADD COLUMN config_user character varying(60);
ALTER TABLE om_uom_org_policy_audit ADD COLUMN config_user character varying(60);
ALTER TABLE om_uom_site_except ADD COLUMN config_user character varying(60);
ALTER TABLE om_uom_site_except_audit ADD COLUMN config_user character varying(60);
ALTER TABLE permissions ADD COLUMN config_user character varying(60);
ALTER TABLE roles ADD COLUMN config_user character varying(60);
ALTER TABLE roles_permissions ADD COLUMN config_user character varying(60);
ALTER TABLE users ADD COLUMN config_user character varying(60);
ALTER TABLE user_roles ADD COLUMN config_user character varying(60);
--config_user column in every ods_master table end


