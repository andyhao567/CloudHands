package com.antell.cloudhands.api.packet.udp.dns;

import org.elasticsearch.common.xcontent.XContentBuilder;

import java.io.IOException;

/**
 * Next SECure name - this record contains the following name in an
 * ordered list of names in the zone, and a set of types for which
 * records exist for this name.  The presence of this record in a response
 * signifies a negative response from a DNSSEC-signed zone.
 * <p>
 * This replaces the NXT record.
 *
 */

public class NSECRecord extends Record {

    private static final long serialVersionUID = -5165065768816265385L;

    private Name next;
    private TypeBitmap types;

    public NSECRecord() {
    }

    @Override
    public Record getObject() {
        return new NSECRecord();
    }

    /**
     * Creates an NSEC Record from the given data.
     *
     * @param next  The following name in an ordered list of the zone
     * @param types An array containing the types present.
     */
    public NSECRecord(Name name, int dclass, long ttl, Name next, int[] types) {
        super(name, Type.NSEC, dclass, ttl);
        this.next = checkName("next", next);
        for (int i = 0; i < types.length; i++) {
            Type.check(types[i]);
        }
        this.types = new TypeBitmap(types);
    }

    @Override
    public void rrFromWire(DNSInput in) throws IOException {
        next = new Name(in);
        types = new TypeBitmap(in);
    }

    @Override
    public void rrToWire(DNSOutput out, Compression c, boolean canonical) {
        // Note: The next name is not lowercased.
        next.toWire(out, null, false);
        types.toWire(out);
    }

    @Override
    public void rdataFromString(Tokenizer st, Name origin) throws IOException {
        next = st.getName(origin);
        types = new TypeBitmap(st);
    }

    /**
     * Converts rdata to a String
     */
    @Override
    public String rrToString() {
        StringBuffer sb = new StringBuffer();
        sb.append(next);
        if (!types.empty()) {
            sb.append(' ');
            sb.append(types.toString());
        }
        return sb.toString();
    }

    @Override
    public XContentBuilder rdataToJson(XContentBuilder cb) throws IOException {

        cb.field("next",next);
        cb.field("types",types.empty()?"":types.toString());
        return cb;
    }

    /**
     * Returns the next name
     */
    public Name getNext() {
        return next;
    }

    /**
     * Returns the set of types defined for this name
     */
    public int[] getTypes() {
        return types.toArray();
    }

    /**
     * Returns whether a specific type is in the set of types.
     */
    public boolean hasType(int type) {
        return types.contains(type);
    }

}
