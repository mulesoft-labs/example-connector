package org.mule.docs.example.connection;

import org.mule.api.ConnectionException;
import org.mule.api.annotations.*;
import org.mule.api.annotations.components.ConnectionManagement;
import org.mule.api.annotations.display.Password;
import org.mule.api.annotations.param.ConnectionKey;

/**
 * @author Mulesoft, Inc
 */
@ConnectionManagement(friendlyName = "dummy-strategy")
public class DummyConnectionStrategy {

    /**
     * Connect
     *
     * @param username A username
     * @param password A password
     * @throws org.mule.api.ConnectionException
     */
    @Connect
    @TestConnectivity
    public void connect(@ConnectionKey String username, @Password String password)
            throws ConnectionException {
        /*
         * CODE FOR ESTABLISHING A CONNECTION GOES HERE
         */
    }

    /**
     * Disconnect
     */
    @Disconnect
    public void disconnect() {
        /*
         * CODE FOR CLOSING A CONNECTION GOES HERE
         */
    }

    /**
     * Are we connected
     */
    @ValidateConnection
    public boolean isConnected() {
        return true;
    }

    /**
     * Connection identifier
     */
    @ConnectionIdentifier
    public String connectionId() {
        return "001";
    }
}
