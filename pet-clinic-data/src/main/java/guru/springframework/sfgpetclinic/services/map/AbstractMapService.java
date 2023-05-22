package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends  BaseEntity,ID extends Long> {

    protected Map<Long,T> map=new HashMap<>();

    Set<T> findAll(){return new HashSet<>(map.values());
    }

    T findById(ID id){return map.get(id);}
    T save(T object){
       if (object!=null){
           if(object.getId()==null){
               object.setId(getNextId());
           }
           map.put(object.getId(), object);
       }
       else
           throw new RuntimeException("object cannot be null");
        return object;
    }
    void  delete(T object){

        map.entrySet().removeIf(entry->entry.getValue().equals(object));
    }

    void deleteById(ID id){
        map.remove(id);
    }

    private Long getNextId(){

        Long next_Id=null;

        try {
            next_Id=Collections.max(map.keySet())+1;
        }catch (NoSuchElementException e){
            next_Id=1L;
        }
        return next_Id;
    }


}
