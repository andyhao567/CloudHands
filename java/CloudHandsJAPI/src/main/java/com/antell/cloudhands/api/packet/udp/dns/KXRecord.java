package com.antell.cloudhands.api.packet.udp.dns;

/**
 * Key Exchange - delegation of authority
 */

public class KXRecord extends U16NameBase {

    private static final long serialVersionUID = 7448568832769757809L;

    public KXRecord() {
    }

    @Override
    public Record getObject() {
        return new KXRecord();
    }

    /**
     * Creates a KX Record from the given data
     *
     * @param preference The preference of this KX.  Records with lower priority
     *                   are preferred.
     * @param target     The host that authority is delegated to
     */
    public KXRecord(Name name, int dclass, long ttl, int preference, Name target) {
        super(name, Type.KX, dclass, ttl, preference, "preference",
                target, "target");
    }

    /**
     * Returns the target of the KX record
     */
    public Name
    getTarget() {
        return getNameField();
    }

    /**
     * Returns the preference of this KX record
     */
    public int
    getPreference() {
        return getU16Field();
    }

    @Override
    public Name getAdditionalName() {
        return getNameField();
    }

}
