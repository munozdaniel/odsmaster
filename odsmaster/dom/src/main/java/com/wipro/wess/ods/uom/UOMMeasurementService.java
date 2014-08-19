package com.wipro.wess.ods.uom;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.isis.applib.AbstractFactoryAndRepository;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.ActionSemantics.Of;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;

import com.wipro.wess.ods.munit.MUnit;
import com.wipro.wess.ods.munit.MUnitFamily;

@Named("UOM - Measurement")
public class UOMMeasurementService extends AbstractFactoryAndRepository {

    // //////////////////////////////////////
    // Identification in the UI
    // //////////////////////////////////////

    @Override
    public String getId() {
        return "MeasurementService";
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "1")
    public List<MMeasurement> listAllMeasurements() {
        return allInstances(MMeasurement.class);
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "2")
    @Named("Create Measurement")
    public MMeasurement createMeasurement(final @Named("MeasureId") String measureId,
            final @Named("MeasureDesc") String measureDesc, final @Named("UnitFamily") MUnitFamily unitFamily) {
        MMeasurement measurement = newTransientInstance(MMeasurement.class);
        measurement.setMeasureId(measureId);
        measurement.setMeasureDesc(measureDesc);
        measurement.setMUnitFamily(unitFamily);
        measurement.setChangeDate(new Date());
        persistIfNotAlready(measurement);
        return measurement;
    }

    public List<MUnitFamily> choices2CreateMeasurement() {
        return allInstances(MUnitFamily.class);
    }

    // //////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "3")
    public List<MMeasurementEntity> listAllMeasurementEntities() {
        return allInstances(MMeasurementEntity.class);
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "2")
    @Named("Create Measurement Entity")
    public MMeasurementEntity createMeasurementEntity(final @Named("MeasureEntityId") String measureEntityId,
            final @Named("MeasureEntityDesc") String measureEntityDesc) {
        MMeasurementEntity measurementEntity = newTransientInstance(MMeasurementEntity.class);
        measurementEntity.setMeasureEntityId(measureEntityId);
        measurementEntity.setMeasureEntityDesc(measureEntityDesc);
        measurementEntity.setChangeDate(new Date());
        persistIfNotAlready(measurementEntity);
        return measurementEntity;
    }

    // ////////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "5")
    public List<MUnit> listAllMeasurementUnits() {
        return allInstances(MUnit.class);
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "6")
    @Named("Create Measurement Unit")
    public MUnit createMeasurementUnit(final @Named("UnitId") String unitId,
            final @Named("UnitSymbol") String unitSymbol, final @Named("UnitFamily") MUnitFamily unitFamily) {
        MUnit unit = newTransientInstance(MUnit.class);
        unit.setUnitId(unitId);
        unit.setUnitSymbol(unitSymbol);
        unit.setMUnitFamily(unitFamily);
        unit.setChangeDate(new Date());
        persistIfNotAlready(unit);
        return unit;
    }

    public List<MUnitFamily> choices2CreateMeasurementUnit() {
        return allInstances(MUnitFamily.class);
    }

    // ////////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "7")
    public List<MUnitConversion> listAllMeasurementUnitConversion() {
        return allInstances(MUnitConversion.class);
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "8")
    @Named("Create Measurement Unit Conversion")
    public MUnitConversion createMeasurementUnitConversion(final @Named("UnitFamilyId") MUnitFamily unitFamilyId,
            final @Named("FromUnitId") MUnit fromUnitId, final @Named("ToUnitId") MUnit toUnitId,
            final @Named("ConvFactor") BigDecimal convFactor, final @Named("OffsetValue") BigDecimal offsetValue,
            final @Named("ConversionType") String conversionType) {
        MUnitConversion unitConversion = newTransientInstance(MUnitConversion.class);
        unitConversion.setUnitFamilyId(unitFamilyId);
        unitConversion.setFromUnitId(fromUnitId);
        unitConversion.setToUnitId(toUnitId);
        unitConversion.setConvFactor(convFactor);
        unitConversion.setOffsetValue(offsetValue);
        unitConversion.setConversionType(conversionType);
        unitConversion.setChangeDate(new Date());
        persistIfNotAlready(unitConversion);
        return unitConversion;
    }

    public List<MUnitFamily> choices0CreateMeasurementUnitConversion() {
        return allInstances(MUnitFamily.class);
    }

    public List<MUnit> choices1CreateMeasurementUnitConversion() {
        return allInstances(MUnit.class);
    }

    public List<MUnit> choices2CreateMeasurementUnitConversion() {
        return allInstances(MUnit.class);
    }

    // ////////////////////////////////////////
    // List (action)
    // //////////////////////////////////////

    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "9")
    public List<MUnitFamily> listAllMeasurementUnitFamily() {
        return allInstances(MUnitFamily.class);
    }

    // //////////////////////////////////////
    // Create (action)
    // //////////////////////////////////////

    @MemberOrder(sequence = "10")
    @Named("Create Measurement Unit Family")
    public MUnitFamily createMeasurementUnitFormula(final @Named("UnitFamilyId") String unitFamilyId,
            final @Named("DefaultUnitId") String defaultUnitId) {
        MUnitFamily unitFamily = newTransientInstance(MUnitFamily.class);
        unitFamily.setUnitFamilyId(unitFamilyId);
        unitFamily.setDefaultUnitId(defaultUnitId);
        unitFamily.setChangeDate(new Date());
        persistIfNotAlready(unitFamily);
        return unitFamily;
    }
}
