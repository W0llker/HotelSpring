package itAcadamy.scope;

import org.hibernate.Session;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ClosedScopeConfig implements Scope {
    private Map<String, Object> scopedObjects
            = Collections.synchronizedMap(new HashMap<String, Object>());

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        if (!scopedObjects.containsKey(name)) {
            scopedObjects.put(name, objectFactory.getObject());
        } else {
            Session session = (Session) scopedObjects.get(name);
            if (!session.isOpen()) {
                scopedObjects.put(name, objectFactory.getObject());
            }
        }
        return scopedObjects.get(name);
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
