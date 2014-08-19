package com.wipro.wess.ods.site;

/**
 * Inner class representing Primary Key
 */
public class SiteSRefeFormulaPK implements java.io.Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = -7777390197993009932L;

    public long siteSrefFormulaId;

    public SiteSRefeFormulaPK() {
    }

    public SiteSRefeFormulaPK(String key) {
        this.siteSrefFormulaId = Long.parseLong(key);
    }
    public SiteSRefeFormulaPK(long siteSrefFormulaId) {
        this.siteSrefFormulaId = siteSrefFormulaId;
    }

    public String toString() {
        return "" + siteSrefFormulaId;
    }

    
    public long getSiteSrefFormulaId() {
        return siteSrefFormulaId;
    }

    
    public void setSiteSrefFormulaId(long siteSrefFormulaId) {
        this.siteSrefFormulaId = siteSrefFormulaId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (siteSrefFormulaId ^ (siteSrefFormulaId >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SiteSRefeFormulaPK other = (SiteSRefeFormulaPK) obj;
        if (siteSrefFormulaId != other.siteSrefFormulaId)
            return false;
        return true;
    }

   

}
