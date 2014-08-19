package com.wipro.wess.ods.site;


// Generated Dec 19, 2013 5:56:26 PM by Hibernate Tools 3.2.2.GA

/**
 * OmSiteId generated by hbm2java
 */
public class OmSiteDataAggMapPK implements java.io.Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 2652996297371236714L;

    public OmSitePK omSite;
    
    public OmSiteDataAggMapPK(){}

    public OmSiteDataAggMapPK(String key) {
        this.omSite = new OmSitePK(key);
    }

    public OmSitePK getOmSite() {
        return omSite;
    }

    public void setOmSite(OmSitePK omSite) {
        this.omSite = omSite;
    }
    

    @Override
    public String toString() {
        return "" + this.omSite.toString();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((omSite == null) ? 0 : omSite.hashCode());
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
        OmSiteDataAggMapPK other = (OmSiteDataAggMapPK) obj;
        if (omSite == null) {
            if (other.omSite != null)
                return false;
        } else if (!omSite.equals(other.omSite))
            return false;
        return true;
    }

   

}