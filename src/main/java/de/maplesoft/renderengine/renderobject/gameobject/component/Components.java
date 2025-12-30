package de.maplesoft.renderengine.renderobject.gameobject.component;

import de.maplesoft.renderengine.renderobject.gameobject.component.impl.IDComponent;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Components extends TreeSet<Component> {
    public Components() {
        super();
    }

    public Components(Comparator<? super Component> comparator) {
        super(comparator);
    }

    public Components(Collection<? extends Component> c) {
        this();
        addAll(c);
    }


    public static Components of(Component... components) {
        Set<Component> componentSet = Set.of(components);

        return new Components(componentSet);
    }

    public static Components ofID(String id) {
        return Components.of(new IDComponent(id));
    }

    public static Components ofName(String name) {
        return Components.of(IDComponent.ofName(name));
    }
}
