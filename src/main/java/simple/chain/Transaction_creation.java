
package simple.chain;

        import helpers.SHA256;

        import java.util.*;

public class Transaction_creation implements Tx {

    private String hash; //Pub_Key
    private String value;
    private String type_transaction;
    private String name;
    private String descr;
    private Date begin;
    private Date end;
    private Date end_subscription;
    private Map<String, Date> date = new HashMap<String, Date>();
    private String location;
    private Integer min;
    private Integer max;
    private Map<String, Integer> limits = new HashMap<String, Integer>();
    private Map<String, Object> payload = new HashMap<String, Object>();


    public Transaction_creation(String value, Map<String, Object> payload) {
        this.hash = SHA256.generateHash(value);
        this.setValue(value);
    }


    public String hash() { return hash; }

    /*public Transaction_creation(List<Object> payload) {
        this.setPayload(payload);
    }*/


    public String getValue() {
        return value;
    }
    public void setValue(String value) {

        // new value need to recalc hash
        this.hash = SHA256.generateHash(value);
        this.value = value;
    }
    public void setPayload( Map<String, Object>  payload) {
        this.payload.put("name",this.name);
        this.payload.put("descr",this.descr);
        this.date.put("begin",this.begin);
        this.date.put("end",this.end);
        this.date.put("end_subscription",this.end_subscription);
        this.payload.put("date",this.date);
        this.payload.put("location",this.location);
        this.limits.put("min",this.min);
        this.limits.put("max",this.max);
        this.payload.put("limits",this.limits);
    }

    public String toString() {
        return this.hash + " : "+this.getValue();
    }


}
