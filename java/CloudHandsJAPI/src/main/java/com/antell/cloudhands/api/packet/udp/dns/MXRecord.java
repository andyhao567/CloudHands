package com.antell.cloudhands.api.packet.udp.dns;

/**
 * Mail Exchange - specifies where mail to a domain is sent
 */

public class MXRecord extends U16NameBase {

    private static final long serialVersionUID = 2914841027584208546L;

    public MXRecord() {
    }

    @Override
    public Record getObject() {
        return new MXRecord();
    }

    /**
     * Creates an MX Record from the given data
     *
     * @param priority The priority of this MX.  Records with lower priority
     *                 are preferred.
     * @param target   The host that mail is sent to
     */
    public MXRecord(Name name, int dclass, long ttl, int priority, Name target) {
        super(name, Type.MX, dclass, ttl, priority, "priority",
                target, "target");
    }

    /**
     * Returns the target of the MX record
     */
    public Name getTarget() {
        return getNameField();
    }

    /**
     * Returns the priority of this MX record
     */
    public int
    getPriority() {
        return getU16Field();
    }

    @Override
    public void rrToWire(DNSOutput out, Compression c, boolean canonical) {
        out.writeU16(u16Field);
        nameField.toWire(out, c, canonical);
    }

    @Override
    public Name getAdditionalName() {
        return getNameField();
    }

}
