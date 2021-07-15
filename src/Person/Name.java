package Person;

public final class Name {
    private String firstName;
    private String lastName;
    private char firstLetter;
    private char secondLetter;

    /**
     * Construct a name from the given first and last
     * names.
     *
     * @param firstName the first name (part) of the name
     * @param lastName the last name (part) of the name
     * @throws NullPointerException if either
     * <code>firstName</code> or <code>lastName</code> is
     * null
     * @throws IllegalArgumentException if either
     * <code>firstName</code> or <code>lastName</code> is
     * empty
     */

    public Name(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);

    }

    /**
     * Return the first letter of the first name.
     *
     * @return the first letter
     */
    public char getFirstLetter(Name name){
        this.firstLetter = name.getFirstName().charAt(0);
        return firstLetter;
    }

    /**
     * Return the first letter of the last name.
     *
     * @return the second letter
     */
    public char getSecondLetter(Name name){
        this.secondLetter = name.getLastName().charAt(0);
        return secondLetter;
    }

    /**
     * Return the first part of the name.
     *
     * @return the first name
     */
    public String getFirstName() { return firstName; }

    /**
     * Return the last part of the name.
     *
     * @return the last name
     */
    public String getLastName() { return lastName; }

    /**
     * Set the first part of the name.
     *
     * @param firstName the first name
     * @throws NullPointerException if
     * <code>firstName</code> is null
     * @throws IllegalArgumentException if
     * <code>firstName</code> is empty
     */
    public void setFirstName(String firstName) {
        if (firstName.length() == 0)
            throw new IllegalArgumentException("Empty first name");

        this.firstName = firstName;
    }

    /**
     * Set the last part of the name.
     *
     * @param lastName the last name
     * @throws NullPointerException if
     * <code>lastName</code> is null
     * @throws IllegalArgumentException if
     * <code>lastName</code> is empty
     */
    public void setLastName(String lastName) {
        if (lastName.length() == 0)
            throw new IllegalArgumentException("Empty last name");

        this.lastName = lastName;
    }


    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Name))
            return false;

        final Name name = (Name) obj;

        // note: firstName and lastName are guaranteed
        // non-null at construction, no need to check here
        return firstName.equals(name.firstName)
                && lastName.equals(lastName);
    }


    /**
     * override method from code sample
     */
    @Override
    public int hashCode() {
        int hc = 17;

        hc = 37 * hc + firstName.hashCode();

        return 37 * hc + lastName.hashCode();
    }


    /**
     * Returns a string representation of a name. The string
     * representation is a first name and last name separated
     * by a space character.
     */
    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    /**
     * Constructs an instance of Name from its
     * string representation. The string representation
     * of a Name is a first name and last name separated
     * by a space character. It is assumed that first and last
     * names do not themselves contain spaces.
     */
    public static Name valueOf(String name) {
        final String[] parts = name.split(" ");

        return new Name(parts[0], parts[1]);
    }



}
