 ALTER TABLE om_operation
  DROP CONSTRAINT lob_id;

  ALTER TABLE om_operation
  ADD CONSTRAINT om_operation_lob_id FOREIGN KEY (lob_id)
      REFERENCES m_line_of_business (lob_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
	  

  ALTER TABLE om_address
  DROP CONSTRAINT org_id;


ALTER TABLE om_address
  ADD CONSTRAINT om_address_org_id FOREIGN KEY (org_id)
      REFERENCES m_organisation (org_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
	  
	        ALTER TABLE om_country
  DROP CONSTRAINT org_id;

ALTER TABLE om_country
  ADD CONSTRAINT om_country_org_id FOREIGN KEY (org_id)
      REFERENCES m_organisation (org_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
	  
	  ALTER TABLE om_emission_scope_map
  DROP CONSTRAINT org_id;

ALTER TABLE om_emission_scope_map
  ADD CONSTRAINT om_emission_scope_map_org_id FOREIGN KEY (org_id)
      REFERENCES m_organisation (org_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
	  
	        
      ALTER TABLE om_meter_config
  DROP CONSTRAINT meter_config_fk1;

ALTER TABLE om_meter_config
  ADD CONSTRAINT om_meter_config_meter_config_fk1 FOREIGN KEY (org_id)
      REFERENCES m_organisation (org_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
	  
	           ALTER TABLE om_operation
  DROP CONSTRAINT org_id;

ALTER TABLE om_operation
  ADD CONSTRAINT om_operation_org_id FOREIGN KEY (org_id)
      REFERENCES m_organisation (org_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
	  
	  
	  ALTER TABLE om_org_extended_attr
  DROP CONSTRAINT om_org_extended_attr_fk1;


ALTER TABLE om_org_extended_attr
  ADD CONSTRAINT om_org_extended_attr_om_org_extended_attr_fk1 FOREIGN KEY (org_id)
      REFERENCES m_organisation (org_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
	  
	  ALTER TABLE om_emission_subcategory_map
  DROP CONSTRAINT org_id;


ALTER TABLE om_emission_subcategory_map
  ADD CONSTRAINT om_emission_subcategory_map_org_id FOREIGN KEY (org_id)
      REFERENCES m_organisation (org_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
            
			ALTER TABLE om_sector_lob_map
  DROP CONSTRAINT org_id;
  
  ALTER TABLE om_sector_lob_map
  ADD CONSTRAINT om_sector_lob_map_org_id FOREIGN KEY (org_id)
      REFERENCES m_organisation (org_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
	  
	          ALTER TABLE om_source_description
  DROP CONSTRAINT org_id;



ALTER TABLE om_source_description
  ADD CONSTRAINT om_source_description_org_id FOREIGN KEY (org_id)
      REFERENCES m_organisation (org_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
	  
	  ALTER TABLE om_operation
  DROP CONSTRAINT sector_id;



ALTER TABLE om_operation
  ADD CONSTRAINT om_operation_sector_id FOREIGN KEY (sector_id)
      REFERENCES m_sector (sector_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
	  
	  ALTER TABLE om_sector_lob_map
  DROP CONSTRAINT sector_id;



ALTER TABLE om_sector_lob_map
  ADD CONSTRAINT om_sector_lob_map_sector_id FOREIGN KEY (sector_id)
      REFERENCES m_sector (sector_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;
	  
	  ALTER TABLE om_site
  DROP CONSTRAINT sector_id;



ALTER TABLE om_site
  ADD CONSTRAINT om_site_sector_id FOREIGN KEY (sector_id)
      REFERENCES m_sector (sector_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

      

      ALTER TABLE om_operation
  DROP CONSTRAINT address_id;




ALTER TABLE om_operation
  ADD CONSTRAINT om_operation_address_id FOREIGN KEY (address_id, org_id)
      REFERENCES om_address (address_id, org_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

         ALTER TABLE om_site
  DROP CONSTRAINT address_id;

ALTER TABLE om_site
  ADD CONSTRAINT om_site_address_id FOREIGN KEY (address_id, org_id)
      REFERENCES om_address (address_id, org_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

   ALTER TABLE om_geo_location
  DROP CONSTRAINT parent_location_id;

ALTER TABLE om_geo_location
  ADD CONSTRAINT om_geo_location_parent_location_id FOREIGN KEY (org_id, parent_location_id)
      REFERENCES om_geo_location (org_id, location_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

	  
	   ALTER TABLE om_site
  DROP CONSTRAINT factility_org_fk;

ALTER TABLE om_site
  ADD CONSTRAINT om_site_factility_org_fk FOREIGN KEY (location_id, org_id)
      REFERENCES om_geo_location (location_id, org_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

	  
	   ALTER TABLE om_site
  DROP CONSTRAINT parent_site_id;

ALTER TABLE om_site
  ADD CONSTRAINT om_site_parent_site_id FOREIGN KEY (parent_site_id, org_id)
      REFERENCES om_site (site_id, org_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

   ALTER TABLE om_meter_config
  DROP CONSTRAINT meter_config_fk2;

ALTER TABLE om_meter_config
  ADD CONSTRAINT om_meter_config_meter_config_fk2 FOREIGN KEY (supplier_id)
      REFERENCES om_utility_supplier (supplier_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION;

   ALTER TABLE tt_site_weather_info_1hr
  DROP CONSTRAINT tt_site_weather_info_current_fk_1;

ALTER TABLE tt_site_weather_info_1hr
  ADD CONSTRAINT tt_site_weather_info_1hr_fk_1 FOREIGN KEY (weather_info_raw_id)
      REFERENCES tt_weather_info_raw (weather_info_raw_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE CASCADE;
