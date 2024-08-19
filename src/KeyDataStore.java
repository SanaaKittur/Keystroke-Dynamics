import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class KeyDataStore {

    LinkedHashMap<Integer, TypedKeyObject> store;

    KeyDataStore(){

        this.store = new LinkedHashMap<Integer, TypedKeyObject>();
    }

    public void initialize(){
        this.store = new LinkedHashMap<Integer, TypedKeyObject>();
    }

    public void storeTypedObject(Integer e, TypedKeyObject typedKeyObject){
        this.store.put(e,typedKeyObject);
    }

    public TypedKeyObject getKey(Integer e){
        if(this.store.size()>0){
            return this.store.get(e);
        }
        return null;
    }

    public void removeContainsOfMap(){

        this.store.clear();
    }

    public void removeLastEntry(){
        if (!this.store.isEmpty()) {
            // Get the last key in the map
            Integer lastKey = null;
            for (Integer key : this.store.keySet()) {
                lastKey = key;
                System.out.println(lastKey);           
                }

            // Remove the last entry
            if (lastKey != null) {
                this.store.remove(lastKey);
            }
        }
    }
    

    
    public List<Double> process(){
        /**
         * Key1 , Key2
         * Key1.HOLDTIME => Key1 releasetime - Key1 presstime.
         * Key1.DOWNDOWNTIME => KEY2 presstime - Key1 presstime
         * Key1.UPDOWNTIME => KEY2 presstime - key1 releasetime.
         */
        if(this.store.size()<2){
            System.out.print("number of keys pressed should be atleast 2"+this.store.toString());
            return null;
        }
        List<Double> strokes = new ArrayList<Double>();

        TypedKeyObject current = null;
        Long lastKeysHoldTime = null;
        for(Map.Entry<Integer, TypedKeyObject> entry: this.store.entrySet()){
            if(current == null){
                current = entry.getValue();
                //System.out.println(current);
            }else{
                TypedKeyObject next = entry.getValue();
                Long key1HoldTime = current.releaseTime - current.pressTime;
                Long key1Key2DownTime = next.pressTime - current.pressTime;
                Long key1Key2UPDownTime = next.pressTime - current.releaseTime;
                strokes.add(key1HoldTime/1000.0);
                strokes.add(key1Key2DownTime/1000.0);
                strokes.add(key1Key2UPDownTime/1000.0);



                current = entry.getValue();
                lastKeysHoldTime = current.releaseTime-current.pressTime;
            }
        }
        strokes.add(lastKeysHoldTime/1000.0);

        return strokes;
    }

    //public List<TypedKeyObject> generateHeaders(){
        /**
         * Key1 , Key2
         * Key1.HOLDTIME => Key1 releasetime - Key1 presstime.
         * Key1.DOWNDOWNTIME => KEY2 presstime - Key1 presstime
         * Key1.UPDOWNTIME => KEY2 presstime - key1 releasetime.
         */
        /*
        if(this.store.size()<2){
            System.out.print("number of keys pressed should be atleast 2"+this.store.toString());
            return null;
        }
        List<TypedKeyObject> headers = new ArrayList<TypedKeyObject>();

        TypedKeyObject current = null;
        Long lastKeysHoldTime = null;
        for(Map.Entry<Integer, TypedKeyObject> entry: this.store.entrySet()){
            if(current == null){
                current = entry.getValue();
                //System.out.println(current);
            }else{
                TypedKeyObject next = entry.getValue();
                headers.add(current);
                headers.add(next);



                current = entry.getValue();
                
            }
        }
        headers.add(current);

        return headers;
    }

    */
    public List<Long> processInNano(){
        /**
         * Key1 , Key2
         * Key1.HOLDTIME => Key1 releasetime - Key1 presstime.
         * Key1.DOWNDOWNTIME => KEY2 presstime - Key1 presstime
         * Key1.UPDOWNTIME => KEY2 presstime - key1 releasetime.
         */
        if(this.store.size()<2){
            System.out.print("number of keys pressed should be atleast 2"+this.store.toString());
            return null;
        }
        List<Long> strokes = new ArrayList<Long>();

        TypedKeyObject current = null;
        Long lastKeysHoldTime = null;
        for(Map.Entry<Integer, TypedKeyObject> entry: this.store.entrySet()){
            if(current == null){
                current = entry.getValue();
            }else{
                TypedKeyObject next = entry.getValue();
                Long key1HoldTime = current.releaseTimeinNano - current.pressTimeinNano;
                Long key1Key2DownTime = next.pressTimeinNano - current.pressTimeinNano;
                Long key1Key2UPDownTime = next.pressTimeinNano - current.releaseTimeinNano;
                strokes.add(key1HoldTime);
                strokes.add(key1Key2DownTime);
                strokes.add(key1Key2UPDownTime);
                current = entry.getValue();
                lastKeysHoldTime = current.releaseTimeinNano-current.pressTimeinNano;
            }
        }
        strokes.add(lastKeysHoldTime);
        return strokes;
    }

}

