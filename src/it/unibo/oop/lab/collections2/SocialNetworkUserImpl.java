package it.unibo.oop.lab.collections2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 
 * Instructions
 * 
 * This will be an implementation of
 * {@link it.unibo.oop.lab.collections2.SocialNetworkUser}:
 * 
 * 1) complete the definition of the methods by following the suggestions
 * included in the comments below.
 * 
 * @param <U>
 *            Specific user type
 */
public class SocialNetworkUserImpl<U extends User> extends UserImpl implements SocialNetworkUser<U> {

    /*
     * 
     * [FIELDS]
     * 
     * Define any necessary field
     * 
     * In order to save the people followed by a user organized in groups, adopt
     * a generic-type Map:
     * 
     * think of what type of keys and values would best suit the requirements
     */
	
	private Map<String, Set<U>> followers;

    /*
     * [CONSTRUCTORS]
     * 
     * 1) Complete the definition of the constructor below, for building a user
     * participating in a social network, with 4 parameters, initializing:
     * 
     * - firstName - lastName - username - age and every other necessary field
     * 
     * 2) Define a further constructor where age is defaulted to -1
     */
	
	public SocialNetworkUserImpl(final String firstName, final String lastName, final String username) {
        this(firstName, lastName, username, -1);
    }
	
    /**
     * Builds a new {@link SocialNetworkUserImpl}.
     * 
     * @param name
     *            the user firstname
     * @param surname
     *            the user lastname
     * @param userAge
     *            user's age
     * @param user
     *            alias of the user, i.e. the way a user is identified on an
     *            application
     */

	public SocialNetworkUserImpl(final String firstName, final String lastName, final String username, int age) {
		super(firstName, lastName, username, age);
		this.followers = new HashMap<>();
	}	
	
    /*
     * [METHODS]
     * 
     * Implements the methods below
     */

    @Override
    public boolean addFollowedUser(final String circle, final U user) {
        Set<U> circleFollowers = this.followers.get(circle);
        if(circleFollowers == null) { 
        	circleFollowers = new HashSet();
        	this.followers.put(circle, circleFollowers);
        }
        return circleFollowers.add(user);
    }

    @Override
    public Collection<U> getFollowedUsersInGroup(final String groupName) {
        Set<U> circleFollowers = this.followers.get(groupName);
        if(circleFollowers == null) {
        	circleFollowers = new HashSet();
        	this.followers.put(groupName, circleFollowers);
        }
    	return new HashSet(circleFollowers);
    }

    @Override
    public List<U> getFollowedUsers() {
    	List<U> l = new ArrayList();
    	for(Set<U> e : followers.values()) {
	        	l.addAll(e);
	    }
    	return l;
    }

}
