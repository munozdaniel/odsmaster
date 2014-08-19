package com.wipro.wess.ods.masterconfig;

public class MSourcetypeConfigPK implements java.io.Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -2989301268120666040L;
    
    public Long sourcetypeId;
    
    public MSourcetypeConfigPK(){}
    
    public MSourcetypeConfigPK(String key){
        if(key != null){
         try{
             this.sourcetypeId = Long.parseLong(key);
         } catch(NumberFormatException e){
             
         }
        }
        
    }
    public MSourcetypeConfigPK(Long sourcetypeId){
        this.sourcetypeId = sourcetypeId;
    }

    
    @Override
    public String toString() {
        return "" + sourcetypeId;
    }


    public Long getSourcetypeId() {
        return sourcetypeId;
    }

    
    public void setSourcetypeId(Long sourcetypeId) {
        this.sourcetypeId = sourcetypeId;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((sourcetypeId == null) ? 0 : sourcetypeId.hashCode());
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
        MSourcetypeConfigPK other = (MSourcetypeConfigPK) obj;
        if (sourcetypeId == null) {
            if (other.sourcetypeId != null)
                return false;
        } else if (!sourcetypeId.equals(other.sourcetypeId))
            return false;
        return true;
    }
    

}
