package my.test.solution.model;

import com.google.common.collect.ForwardingSet;

import java.util.Set;

/**
 * Created by Tirex on 21.03.2016.
 */
public class Contacts  extends ForwardingSet {

    @Override
    protected Set delegate() {
        return null;
    }
}
