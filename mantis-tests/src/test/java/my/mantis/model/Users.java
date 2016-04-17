package my.mantis.model;

import com.google.common.collect.ForwardingSet;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tirex on 17.04.2016.
 */
public class Users extends ForwardingSet<UserData> {

    private Set<UserData> delegated;

    public Users() {
        this.delegated = new HashSet<UserData>();
    }

    public Users(Users users) {
        this.delegated = new HashSet<UserData>(users.delegated);
    }

    public Users(Collection<UserData> users) {
        this.delegated = new HashSet<UserData>(users);
    }

    public Users withAdded(UserData user) {
        Users users = new Users(this);
        users.add(user);
        return users;
    }

    public Users without(UserData user) {
        Users users = new Users(this);
        users.remove(user);
        return users;
    }

    @Override
    protected Set<UserData> delegate() {
        return delegated;
    }
}
