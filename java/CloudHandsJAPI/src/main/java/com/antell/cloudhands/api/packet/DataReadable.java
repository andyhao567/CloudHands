package com.antell.cloudhands.api.packet;

import java.io.DataInput;
import java.io.IOException;

/**
 * Created by dell on 2018/6/9.
 */
public interface DataReadable {

    void read(DataInput in) throws IOException;

}
