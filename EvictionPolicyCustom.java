import java.util.*;

/*
* EvictionPolicyCustom class is used to provide an implementation of various caching eviction policies.
* It provides a method 'getEvictionPolicy(String policyType)' which returns an instance of the 
* requested eviction policy, based on the input provided.
*/

// this use helps use to identify custom Eviction Policies 
// this is an class which is used by "Cache class futher to process the information"

public class EvictionPolicyCustom {
    public static EvicitionPolicy getEvictionPolicy(String policyType){
        if(policyType.equalsIgnoreCase("FIFO")){
            return new FIFO();
        }
        else if(policyType.equalsIgnoreCase("LIFO")){
            return new LIFO();
        }
        else if(policyType.equalsIgnoreCase("LRU")){
            return new LRU();
        }
        else{
            // not found / Invalid
            throw new IllegalArgumentException("Invalid eviction policy name provided");
        }
    }
}