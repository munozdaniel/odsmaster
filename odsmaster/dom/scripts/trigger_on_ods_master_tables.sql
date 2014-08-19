-- Trigger: ods_master_audit_trigger on om_sca_config

-- DROP TRIGGER ods_master_audit_trigger ON om_sca_config;

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_sca_config
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();
  
CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_asset
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_asset_extended_attr
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_asset_info_element
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_assetspec
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_supplier_asset_config
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_supplier_asset_service_map
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_asset_inputservice
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_asset_outputservice
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON m_assetclass
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON m_pointlist
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON m_sourcetype_config
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_geo_location
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_pointpath
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_meter_config
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_mode_of_operation_config
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_msa_config
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_msa_cons_fr
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_msa_cons_st_fr
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_msa_cons_stsubt_fr
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_msa_modeop_def
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_msa_sca_map
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_msa_service_map
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON m_unit
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON m_unit_family
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON m_organisation
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_org_extended_attr
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_org_sref_name
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_location_hierarchy
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_sca_config_ext_attr
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_sca_monitorasset_map
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_sca_service_map
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON m_sector
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_service_config
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_address
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_msa_site_map
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_site
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_site_data_agg_map
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_site_extended_attr
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_site_info_element
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_site_sref_formula
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON m_sourcecat_config
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON m_sourcegen_config
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_utility_supplier
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON m_ext_data_source_info
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON m_measurement
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON m_measurement_entity
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON m_unit_conversion
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON m_uom_defaults
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_pointlist_country_except
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_pointlist_country_except_audit
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_pointlist_country_policy
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_pointlist_country_policy_audit
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_pointlist_org_policy
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_pointlist_org_policy_audit
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_pointlist_site_except
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_pointlist_site_except_audit
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_uom_country_except
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_uom_country_except_audit
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_uom_country_policy
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_uom_country_policy_audit
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_uom_ext_data_source_except
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_uom_org_policy
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_uom_org_policy_audit
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_uom_site_except
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON om_uom_site_except_audit
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON permissions
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON roles
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON roles_permissions
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON users
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();

CREATE TRIGGER ods_master_audit_trigger
AFTER INSERT OR UPDATE OR DELETE
ON user_roles
FOR EACH ROW
EXECUTE PROCEDURE audit_ods_master_changes_func();
